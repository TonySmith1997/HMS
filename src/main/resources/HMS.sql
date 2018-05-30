/*
 Navicat Premium Data Transfer

 Source Server         : HMS
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : hms

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 30/05/2018 16:08:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for BloodBank
-- ----------------------------
DROP TABLE IF EXISTS `BloodBank`;
CREATE TABLE `BloodBank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `bloodType` varchar(255) DEFAULT NULL,
  `qty` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for BloodDonor
-- ----------------------------
DROP TABLE IF EXISTS `BloodDonor`;
CREATE TABLE `BloodDonor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `age` int(11) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `bloodType` varchar(255) DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `times` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Department
-- ----------------------------
DROP TABLE IF EXISTS `Department`;
CREATE TABLE `Department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `departName` varchar(255) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `headName` varchar(255) DEFAULT NULL,
  `headId` int(11) DEFAULT NULL,
  `detail` varchar(500) DEFAULT NULL COMMENT '详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Department
-- ----------------------------
BEGIN;
INSERT INTO `Department` VALUES (1, 1, '2018-05-26 23:23:18', NULL, NULL, 'Medical department ', 3, '内科', 'Tony', 1, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (2, 1, '2018-05-26 23:24:48', NULL, NULL, 'Surgical department', 3, '外科', 'Andy', 2, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (3, 1, '2018-05-26 23:25:19', NULL, NULL, 'Cardiology department ', 3, '心脏病科', 'Kate', 3, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (4, 1, '2018-05-26 23:26:01', NULL, NULL, 'Dental department', 3, '牙科', 'Charlotter', 4, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (5, 1, '2018-05-26 23:26:26', NULL, NULL, 'Skin department ', 3, '皮肤科', 'Catherine', 5, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (6, 1, '2018-05-26 23:26:57', NULL, NULL, 'Neurology department', 3, '神经科', 'George', 6, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (7, 1, '2018-05-26 23:27:27', NULL, NULL, 'Obstetrics and gynecology department', 3, '妇产科', 'Gracie', 18, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (8, 1, '2018-05-26 23:27:40', NULL, NULL, 'Ophthalmology department', 3, '眼科', 'Alice', 7, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (9, 1, '2018-05-26 23:28:40', NULL, NULL, 'Orthopedics department', 3, '骨科', 'Quinn', 8, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (10, 1, '2018-05-26 23:29:04', NULL, NULL, 'Otorhinolaryngological department ', 3, '耳鼻喉科', 'Jenson', 9, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (11, 1, '2018-05-26 23:29:26', NULL, NULL, 'Paediatrics department', 3, '小儿科', 'Finn', 10, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (12, 1, '2018-05-26 23:29:58', NULL, NULL, 'Urology department', 3, '泌尿科', 'Eden', 11, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (13, 1, '2018-05-26 23:30:27', NULL, NULL, 'X-ray department', 3, '放射科', 'Maple', 12, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (14, 1, '2018-05-26 23:30:59', NULL, NULL, 'Registration office', 3, '挂号处', '', 0, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (15, 1, '2018-05-26 23:31:16', NULL, NULL, 'Laboratory', 4, '化验室', 'Kai', 14, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (16, 1, '2018-05-26 23:31:48', NULL, NULL, 'Blood bank', 4, '血库', '', 0, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (17, 1, '2018-05-26 23:32:29', NULL, NULL, 'Pharmacy', 3, '药房', '', 0, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (18, 1, '2018-05-26 23:39:35', NULL, NULL, 'Nursing department', 5, '护理部', 'Harper', 17, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
COMMIT;

-- ----------------------------
-- Table structure for Drug
-- ----------------------------
DROP TABLE IF EXISTS `Drug`;
CREATE TABLE `Drug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `drugName` varchar(255) DEFAULT NULL,
  `effect` varchar(255) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `unitPrice` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for DrugFee
-- ----------------------------
DROP TABLE IF EXISTS `DrugFee`;
CREATE TABLE `DrugFee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `drugId` int(11) NOT NULL,
  `drugNum` int(11) NOT NULL,
  `medicalRecordId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  `totalPrice` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ilr2e14uks9xeim0a5qv1wfqr` (`medicalRecordId`),
  CONSTRAINT `FK_ilr2e14uks9xeim0a5qv1wfqr` FOREIGN KEY (`medicalRecordId`) REFERENCES `MedicalRecord` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for DrugStock
-- ----------------------------
DROP TABLE IF EXISTS `DrugStock`;
CREATE TABLE `DrugStock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `drugId` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for EmployeeInfo
-- ----------------------------
DROP TABLE IF EXISTS `EmployeeInfo`;
CREATE TABLE `EmployeeInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `departId` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `ifHead` tinyint(1) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of EmployeeInfo
-- ----------------------------
BEGIN;
INSERT INTO `EmployeeInfo` VALUES (1, 1, '2018-05-28 23:29:43', NULL, NULL, 1, 0, 1, 1, 'head of the medical department', 'fasfsafas');
INSERT INTO `EmployeeInfo` VALUES (2, 1, '2018-05-28 23:31:45', NULL, NULL, 2, 0, 2, 1, 'head of the surgical department', 'fasfasf');
INSERT INTO `EmployeeInfo` VALUES (3, 1, '2018-05-28 23:32:54', NULL, NULL, 3, 0, 3, 1, 'head of the cardiology department ', 'asfdasf');
INSERT INTO `EmployeeInfo` VALUES (4, 1, '2018-05-28 23:33:47', NULL, NULL, 4, 0, 4, 1, 'head of the dental department', 'asfasf');
INSERT INTO `EmployeeInfo` VALUES (5, 1, '2018-05-28 23:34:26', NULL, NULL, 5, 0, 5, 1, 'head of the skin department ', 'asfaf');
INSERT INTO `EmployeeInfo` VALUES (6, 1, '2018-05-28 23:35:02', NULL, NULL, 6, 0, 6, 1, 'head of the neurology department', 'asfasf');
INSERT INTO `EmployeeInfo` VALUES (7, 1, '2018-05-28 23:36:06', NULL, NULL, 8, 0, 7, 1, 'head of the ophthalmology department', 'asf');
INSERT INTO `EmployeeInfo` VALUES (8, 1, '2018-05-28 23:36:53', NULL, NULL, 9, 0, 8, 1, 'head of the orthopedics department', 'fasf');
INSERT INTO `EmployeeInfo` VALUES (9, 1, '2018-05-28 23:37:23', NULL, NULL, 10, 0, 9, 1, 'head of the otorhinolaryngological department ', 'fasf');
INSERT INTO `EmployeeInfo` VALUES (10, 1, '2018-05-28 23:38:02', NULL, NULL, 11, 0, 10, 1, 'head of the paediatrics department', 'asf');
INSERT INTO `EmployeeInfo` VALUES (11, 1, '2018-05-28 23:40:21', NULL, NULL, 12, 0, 11, 1, 'head of the urology department', 'asfsaf');
INSERT INTO `EmployeeInfo` VALUES (12, 1, '2018-05-28 23:41:00', NULL, NULL, 13, 0, 12, 1, 'head of the X-ray department', 'asfasf');
INSERT INTO `EmployeeInfo` VALUES (13, 1, '2018-05-28 23:41:22', NULL, NULL, 14, 0, 13, 0, 'register staff', 'fasf');
INSERT INTO `EmployeeInfo` VALUES (14, 1, '2018-05-28 23:41:54', NULL, NULL, 15, 0, 14, 1, 'head of the Laboratory', 'asf');
INSERT INTO `EmployeeInfo` VALUES (15, 1, '2018-05-28 23:42:19', NULL, NULL, 16, 0, 15, 0, 'Blood collector', 'fasf');
INSERT INTO `EmployeeInfo` VALUES (16, 1, '2018-05-28 23:42:47', NULL, NULL, 17, 0, 16, 0, 'pharmacist', 'fasfas');
INSERT INTO `EmployeeInfo` VALUES (17, 1, '2018-05-28 23:43:22', NULL, NULL, 18, 0, 17, 1, 'head nurse', 'sad');
INSERT INTO `EmployeeInfo` VALUES (18, 1, '2018-05-28 23:35:31', NULL, NULL, 7, 0, 18, 1, 'head of the obstetrics and gynecology department', 'das');
INSERT INTO `EmployeeInfo` VALUES (19, 1, '2018-05-30 08:00:43', NULL, NULL, 1, 0, 19, 0, 'interne', 'dsa');
COMMIT;

-- ----------------------------
-- Table structure for EmployeeLog
-- ----------------------------
DROP TABLE IF EXISTS `EmployeeLog`;
CREATE TABLE `EmployeeLog` (
  `id` int(11) NOT NULL,
  `who` int(11) NOT NULL,
  `what` varchar(100) NOT NULL,
  `when` datetime NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of EmployeeLog
-- ----------------------------
BEGIN;
INSERT INTO `EmployeeLog` VALUES (1, 1, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (2, 2, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (3, 3, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (4, 4, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (5, 5, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (6, 6, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (7, 7, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (8, 8, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (9, 9, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (10, 10, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (11, 11, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (12, 12, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (13, 13, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (14, 14, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (15, 15, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (16, 16, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (17, 17, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (18, 18, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-28 23:29:43', 'joining');
INSERT INTO `EmployeeLog` VALUES (19, 1, 'promoting to be the head of the medical department', '2018-05-30 14:42:09', 'promoting');
INSERT INTO `EmployeeLog` VALUES (20, 2, 'promoting to be the head of the surgical department', '2018-05-30 14:42:56', 'promoting');
INSERT INTO `EmployeeLog` VALUES (21, 3, 'promoting to be the head of the cardiology department ', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (22, 4, 'promoting to be the head of the dental department', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (23, 5, 'promoting to be the head of the skin department ', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (24, 6, 'promoting to be the head of the neurology department', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (25, 7, 'promoting to be the head of the ophthalmology department', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (26, 8, 'promoting to be the head of the orthopedics department', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (27, 9, 'promoting to be the head of the otorhinolaryngological department ', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (28, 10, 'promoting to be the head of the paediatrics department', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (29, 11, 'promoting to be the head of the urology department', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (30, 12, 'promoting to be the head of the X-ray department', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (32, 14, 'promoting to be the head of the Laboratory', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (33, 19, 'joining the hospital at 2018-05-28 23:29:43,registered by Tony', '2018-05-30 14:43:12', 'joining');
INSERT INTO `EmployeeLog` VALUES (35, 17, 'promoting to be the head nurse', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (36, 18, 'promoting to be the head of the obstetrics and gynecology department', '2018-05-30 14:43:12', 'promoting');
INSERT INTO `EmployeeLog` VALUES (37, 1, 'healing a patient called Andy  at 2018-05-30 14:43:12', '2018-05-30 14:43:12', 'healing');
COMMIT;

-- ----------------------------
-- Table structure for InHospitalInfo
-- ----------------------------
DROP TABLE IF EXISTS `InHospitalInfo`;
CREATE TABLE `InHospitalInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `fee` decimal(19,2) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `wardNum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for MedicalRecord
-- ----------------------------
DROP TABLE IF EXISTS `MedicalRecord`;
CREATE TABLE `MedicalRecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `diseaseName` varchar(255) DEFAULT NULL,
  `doctorId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  `recommend` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for PatientInfo
-- ----------------------------
DROP TABLE IF EXISTS `PatientInfo`;
CREATE TABLE `PatientInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `IsInpatient` int(11) NOT NULL,
  `alleHis` varchar(255) DEFAULT NULL,
  `inHospitalId` int(11) NOT NULL,
  `medHis` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Resources
-- ----------------------------
DROP TABLE IF EXISTS `Resources`;
CREATE TABLE `Resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `decription` varchar(255) DEFAULT NULL,
  `resName` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Role
-- ----------------------------
DROP TABLE IF EXISTS `Role`;
CREATE TABLE `Role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descrption` varchar(255) DEFAULT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for RoleResources
-- ----------------------------
DROP TABLE IF EXISTS `RoleResources`;
CREATE TABLE `RoleResources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resourceId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for TotalFee
-- ----------------------------
DROP TABLE IF EXISTS `TotalFee`;
CREATE TABLE `TotalFee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `checkIds` varchar(255) DEFAULT NULL,
  `drugIds` varchar(255) DEFAULT NULL,
  `patientId` int(11) NOT NULL,
  `totalFee` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `age` int(11) NOT NULL,
  `avator` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` tinyint(11) NOT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `trueName` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `ifEmloyee` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES (1, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422255', '123456', 'Tony', 'tonylin', 1);
INSERT INTO `User` VALUES (2, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a2.jpg', 'lintong@gmail.com', 1, '13944422256', '123457', 'Andy', 'andy', 1);
INSERT INTO `User` VALUES (3, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a3.jpg', 'lintong@gmail.com', 0, '13944422257', '123456', 'Kate', 'kate', 1);
INSERT INTO `User` VALUES (4, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a4.jpg', 'lintong@gmail.com', 1, '13944422258', '123456', 'Charlotter', 'charlo', 1);
INSERT INTO `User` VALUES (5, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422259', '123456', 'Catherine', 'cathy', 1);
INSERT INTO `User` VALUES (6, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422260', '123456', 'George', 'geogeo', 1);
INSERT INTO `User` VALUES (7, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422261', '123456', 'Alice', 'alice111', 1);
INSERT INTO `User` VALUES (8, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422262', '123456', 'Quinn', 'quinn232', 1);
INSERT INTO `User` VALUES (9, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422263', '123456', 'Jenson', 'jjeson11', 1);
INSERT INTO `User` VALUES (10, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422264', '123456', 'Finn', 'finn65434', 1);
INSERT INTO `User` VALUES (11, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422265', '123456', 'Eden', 'edenSuper', 1);
INSERT INTO `User` VALUES (12, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422266', '123456', 'Maple', 'maplelily', 1);
INSERT INTO `User` VALUES (13, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422267', '123456', 'Tobby', 'Tobbbby', 1);
INSERT INTO `User` VALUES (14, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422268', '123456', 'Kai', 'kaikai', 1);
INSERT INTO `User` VALUES (15, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422255', '123456', 'Stanley', 'stan', 1);
INSERT INTO `User` VALUES (16, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422255', '123456', 'Muhammed', 'muharm', 1);
INSERT INTO `User` VALUES (17, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422255', '123456', 'Harper', 'harper', 1);
INSERT INTO `User` VALUES (18, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Grace', 'grace', 1);
INSERT INTO `User` VALUES (19, 1, '2018-05-30 07:57:38', NULL, NULL, 22, '/static/img/a8.jpg', 'ffsfd@gmail.com', 0, '1313331111111', '123456', 'Paul', 'paulWin', 1);
COMMIT;

-- ----------------------------
-- Table structure for UserRole
-- ----------------------------
DROP TABLE IF EXISTS `UserRole`;
CREATE TABLE `UserRole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Ward
-- ----------------------------
DROP TABLE IF EXISTS `Ward`;
CREATE TABLE `Ward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `floorId` int(11) NOT NULL,
  `roomId` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for physicalExamination
-- ----------------------------
DROP TABLE IF EXISTS `physicalExamination`;
CREATE TABLE `physicalExamination` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `checkBy` int(11) NOT NULL,
  `checkName` varchar(255) DEFAULT NULL,
  `checkResult` varchar(255) DEFAULT NULL,
  `fee` decimal(19,2) DEFAULT NULL,
  `medicalRecordId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4yp4a1poye110wjoahp8xacny` (`medicalRecordId`),
  CONSTRAINT `FK_4yp4a1poye110wjoahp8xacny` FOREIGN KEY (`medicalRecordId`) REFERENCES `MedicalRecord` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
