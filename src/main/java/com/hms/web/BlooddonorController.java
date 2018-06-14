package com.hms.web;

import com.hms.entity.BloodBank;
import com.hms.entity.BloodDonor;


import com.hms.service.BloodbankService;
import com.hms.service.BlooddonorService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping("/donor")
    public class BlooddonorController {
        protected Logger log = LogManager.getLogger(com.hms.web.BlooddonorController.class);

        @Autowired
        private BlooddonorService blooddonorService;
        @Autowired
        private BloodbankService bloodbankService;

    /**
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "",method = GET)
        public String getDrugLog(ModelMap map){
            List<BloodDonor> donors = blooddonorService.getAll();
           List<BloodBank> BloodBankList=bloodbankService.getAll();
            int count = blooddonorService.count();
            Date LastUpdate = blooddonorService.getLastUpdate();
            map.addAttribute("lastUpdate",LastUpdate);
            map.addAttribute("blooddonorCount",count);
            map.addAttribute("banks",BloodBankList);
            map.addAttribute("donors",donors);
            return "blooddonor";
        }
        /**return value to  data
         */

        @RequestMapping(value = "{id}",method = RequestMethod.GET)
        public @ResponseBody
        BloodDonor getBloodDonorDetail(@PathVariable String id) {
            Integer drugId = Integer.valueOf(id);
            BloodDonor BloodDonorInfo = blooddonorService.get(drugId);
            return BloodDonorInfo;
        }

        /**
         * @param bloodDonorid
         * @param bloodName
         * @param age
         * @param mobile
         * @return
         */
        @RequestMapping(value = "update",method=POST)
        public String updateBlooddonor(
                @RequestParam("id") String bloodDonorid,
                @RequestParam("name") String bloodName,
                @RequestParam("age") String age,
                @RequestParam("gender") String gender,
                @RequestParam("mobile") String mobile
               )
        {
            int bloodId = Integer.valueOf(bloodDonorid.trim());
            BloodDonor bloodDonor =blooddonorService.get(bloodId);
            bloodDonor.setName(bloodName.trim());
            bloodDonor.setAge(Integer.valueOf(age.trim()));
            bloodDonor.setGender(Boolean.valueOf(gender.trim()));
            bloodDonor.setMobile(mobile.trim());
            bloodDonor.setUpdateBy(1);
            Date date = new Date();
            bloodDonor.setUpdateTime(date);
            blooddonorService.update(bloodDonor);
            return "blooddonor";
        }

    /**
     * insert blooddonor
     * @param blooddonorname
     * @param age
     * @param bloodtype
     * @param gender
     * @param mobile
     * @return
     */
        @RequestMapping(value = "insert",method=POST)
        public void insertBlooddonor(
                @RequestParam("blooddonorname") String blooddonorname,
                @RequestParam("age") String age,
                @RequestParam("bloodtype") String bloodtype,
                @RequestParam("gender") String gender,
                @RequestParam("mobile") String mobile
                )
        {
            Date date = new Date();
            BloodDonor bloodDonor = blooddonorService.getBloodDonorByMobile(mobile.trim());
            if(bloodDonor == null) {
                bloodDonor = new BloodDonor();
                bloodDonor.setAvatar("/static/img/a1.jpg");
                bloodDonor.setName(blooddonorname.trim());
                bloodDonor.setGender(Boolean.valueOf(gender.trim()));
                bloodDonor.setAge(Integer.valueOf(age.trim()));
                bloodDonor.setBloodType(bloodtype.trim());
                bloodDonor.setMobile(mobile.trim());
                bloodDonor.setUpdateBy(1);
                bloodDonor.setTimes(1);
                bloodDonor.setUpdateTime(date);
                blooddonorService.save(bloodDonor);
            }
            else {
                int oldTimes = bloodDonor.getTimes();
                bloodDonor.setTimes(oldTimes+1);
                bloodDonor.setUpdateBy(1);
                bloodDonor.setUpdateTime(date);
                blooddonorService.save(bloodDonor);
            }

            /** blood bank **
             *
             */
            BloodBank bloodBank = bloodbankService.getbloodBankByName(bloodtype.trim());
            BigDecimal oldQty = bloodBank.getQty();
            bloodBank.setQty(oldQty.add(new BigDecimal(400)));
            bloodBank.setUpdateBy(1);
            bloodBank.setUpdateTime(date);
            bloodbankService.update(bloodBank);
        }



    @RequestMapping(value = "/update/{id}",method = GET)
        public @ResponseBody BloodDonor getBloodDonorForUpdate(@PathVariable String id) {
            Integer blooddonorId = Integer.valueOf(id);
            BloodDonor BloodDonorInfo = blooddonorService.get(blooddonorId);
            return BloodDonorInfo;
        }
        @RequestMapping(value = "/search/{searchName}",method = RequestMethod.GET)
        public @ResponseBody
        List<BloodDonor> getBloodDonorLike(@PathVariable String searchName) {
            List<BloodDonor> bloodDonors = blooddonorService.getBloodDonorLike(searchName.trim()+"%");
            return bloodDonors;
        }


    }



