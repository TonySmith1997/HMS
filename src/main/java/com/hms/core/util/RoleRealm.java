package com.hms.core.util;

import com.hms.entity.*;
import com.hms.service.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("uncheck")
public class RoleRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleResourceService roleResourceService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;

	//验证用
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
		User user = userService.getUser(loginName);
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		Set<Role> roles = new HashSet<>();
		Set<String> roleName = new HashSet<>();
		Set<String> permissionName = new HashSet<>();
		Set<Resources> permission = new HashSet<>();
		if (user != null) {
			List<UserRole> userRoles = userRoleService.findResourcesByRole(user.getId());
			for(UserRole userRole : userRoles) {
				Role role = roleService.get(userRole.getRoleId());
				roles.add(role);
				roleName.add(role.getRolename());
			}
			for(Role role : roles){
				List<RoleResources> roleResource = roleResourceService.findResourcesByRole(role.getId());
				for(RoleResources roleResources : roleResource) {
					Resources resource = resourceService.get(roleResources.getId());
					permissionName.add(resource.getResName());
				}
			}
			info.setStringPermissions(permissionName);
			info.setRoles(roleName);
		}
		return info;
	}

	//登陆用
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String username = (String)authenticationToken.getPrincipal();
		String password = new String((char[]) authenticationToken.getCredentials());
		User user = userService.getUser(username);
		System.out.println(user.getUsername());
		System.out.println(getName());
		if(user == null) {
			throw new UnknownAccountException("Not Found User");//没找到帐号
		}
		if(!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("Password Incorrect");
		}
		WebUtil.saveCurrentUser(user);

		return new SimpleAuthenticationInfo(
				user.getUsername(), //用户名
				user.getPassword(), //密码
				getName()  //realm name
		);
	}
}
