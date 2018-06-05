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

 Date: 06/06/2018 00:08:01
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
INSERT INTO `Department` VALUES (13, 1, '2018-05-26 23:30:27', NULL, NULL, 'X-ray department', 3, '放射科', '', 0, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (14, 1, '2018-05-26 23:30:59', NULL, NULL, 'Registration office', 3, '挂号处', '', 0, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (15, 1, '2018-05-26 23:31:16', NULL, NULL, 'Laboratory', 4, '化验室', 'Kai', 14, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (16, 1, '2018-05-26 23:31:48', NULL, NULL, 'Blood bank', 4, '血库', '', 0, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (17, 1, '2018-05-26 23:32:29', NULL, NULL, 'Pharmacy', 3, '药房', '', 0, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
INSERT INTO `Department` VALUES (18, 1, '2018-05-26 23:39:35', NULL, NULL, 'Nursing department', 5, '护理部', 'Harper', 17, 'The hospital is a kind of organization helping people recover or get information of keeping health. We can see a hospital everywhere in our life, because hospitals are so important to us. Patients, or the one who has some mental or bodily discomfort should go to hospital for curing.');
COMMIT;

-- ----------------------------
-- Table structure for Device
-- ----------------------------
DROP TABLE IF EXISTS `Device`;
CREATE TABLE `Device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `avator` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `deviceName` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `unitPrice` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Drug
-- ----------------------------
DROP TABLE IF EXISTS `Drug`;
CREATE TABLE `Drug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `drugName` varchar(255) NOT NULL,
  `effect` varchar(255) NOT NULL,
  `qty` int(11) NOT NULL,
  `unitPrice` decimal(19,2) NOT NULL,
  `avator` varchar(255) NOT NULL,
  `instrument` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Drug
-- ----------------------------
BEGIN;
INSERT INTO `Drug` VALUES (1, 1, '2018-05-28 08:47:55', NULL, NULL, 'Temporarily relieves nasal congestion: due to common cold; due to hay fever or other upper respiratory allergies. Temporarily relieves stuffy nose. Helps clear nasal passages; shrinks swollen membranes. Temporarily restores freer breathing through the nose. Helps decongest sinus openings and passages; temporarily relieves sinus congestion and pressure. Easy to use and dispense. Gluten free.', 'Sunmark Nose Drops Extra Strength', 'Cough Cold & Flu', 300, 3.32, '/static/img/drug/d1.jpg', 'Use only as directed. Adults and children 12 years and over: 2 or 3 drops in each nostril not more often than every 4 hours. Children under 12 years: Ask a doctor. Store at 20-25 degrees C (68-77 degrees F). Protect from light.');
INSERT INTO `Drug` VALUES (2, 1, '2018-05-28 08:47:55', NULL, NULL, 'Temporarily relieves nasal congestion: due to common cold; due to hay fever or other upper respiratory allergies. Temporarily relieves stuffy nose. Helps clear nasal passages; shrinks swollen membranes. Temporarily restores freer breathing through the nose. Helps decongest sinus openings and passages; temporarily relieves sinus congestion and pressure. Easy to use and dispense. Gluten free.', 'Vicks DayQuil', 'Cough Cold & Flu', 300, 7.50, '/static/img/drug/d2.jpg', 'Use only as directed. Adults and children 12 years and over: 2 or 3 drops in each nostril not more often than every 4 hours. Children under 12 years: Ask a doctor. Store at 20-25 degrees C (68-77 degrees F). Protect from light.');
COMMIT;

-- ----------------------------
-- Table structure for DrugFee
-- ----------------------------
DROP TABLE IF EXISTS `DrugFee`;
CREATE TABLE `DrugFee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `drugId` int(11) NOT NULL,
  `drugNum` int(11) NOT NULL,
  `medicalRecordId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of DrugFee
-- ----------------------------
BEGIN;
INSERT INTO `DrugFee` VALUES (2, 1, '2018-05-28 08:47:55', NULL, NULL, 1, 1, 1, 21);
INSERT INTO `DrugFee` VALUES (3, 1, '2018-05-30 12:55:55', NULL, NULL, 2, 2, 1, 21);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of EmployeeInfo
-- ----------------------------
BEGIN;
INSERT INTO `EmployeeInfo` VALUES (1, 1, '2018-05-28 23:29:43', 1, '2018-06-04 16:50:38', 1, 0, 1, 1, 'Chief Doctor', 'fasfsafas');
INSERT INTO `EmployeeInfo` VALUES (2, 1, '2018-05-28 23:31:45', NULL, NULL, 2, 0, 2, 1, 'Chief Doctor', 'fasfasf');
INSERT INTO `EmployeeInfo` VALUES (3, 1, '2018-05-28 23:32:54', NULL, NULL, 3, 0, 3, 1, 'Chief Doctor', 'asfdasf');
INSERT INTO `EmployeeInfo` VALUES (4, 1, '2018-05-28 23:33:47', NULL, NULL, 4, 0, 4, 1, 'Chief Doctor', 'asfasf');
INSERT INTO `EmployeeInfo` VALUES (5, 1, '2018-05-28 23:34:26', NULL, NULL, 5, 0, 5, 1, 'Chief Doctor', 'asfaf');
INSERT INTO `EmployeeInfo` VALUES (6, 1, '2018-05-28 23:35:02', NULL, NULL, 6, 0, 6, 1, 'Chief Doctor', 'asfasf');
INSERT INTO `EmployeeInfo` VALUES (7, 1, '2018-05-28 23:36:06', NULL, NULL, 8, 0, 7, 1, 'Chief Doctor', 'asf');
INSERT INTO `EmployeeInfo` VALUES (8, 1, '2018-05-28 23:36:53', NULL, NULL, 9, 0, 8, 1, 'Chief Doctor', 'fasf');
INSERT INTO `EmployeeInfo` VALUES (9, 1, '2018-05-28 23:37:23', NULL, NULL, 10, 0, 9, 1, 'Chief Doctor', 'fasf');
INSERT INTO `EmployeeInfo` VALUES (10, 1, '2018-05-28 23:38:02', NULL, NULL, 11, 0, 10, 1, 'Chief Doctor', 'asf');
INSERT INTO `EmployeeInfo` VALUES (11, 1, '2018-05-28 23:40:21', NULL, NULL, 12, 0, 11, 1, 'Chief Doctor', 'asfsaf');
INSERT INTO `EmployeeInfo` VALUES (12, 1, '2018-05-28 23:41:00', NULL, NULL, 13, 0, 12, 1, 'Staff', 'asfasf');
INSERT INTO `EmployeeInfo` VALUES (13, 1, '2018-05-28 23:41:22', NULL, NULL, 14, 0, 13, 0, 'Staff', 'fasf');
INSERT INTO `EmployeeInfo` VALUES (14, 1, '2018-05-28 23:41:54', NULL, NULL, 15, 0, 14, 1, 'Chief Doctor', 'asf');
INSERT INTO `EmployeeInfo` VALUES (15, 1, '2018-05-28 23:42:19', NULL, NULL, 16, 0, 15, 0, 'Staff', 'fasf');
INSERT INTO `EmployeeInfo` VALUES (16, 1, '2018-05-28 23:42:47', NULL, NULL, 17, 0, 16, 0, 'Staff', 'fasfas');
INSERT INTO `EmployeeInfo` VALUES (17, 1, '2018-05-28 23:43:22', NULL, NULL, 18, 0, 17, 1, 'Staff', 'sad');
INSERT INTO `EmployeeInfo` VALUES (18, 1, '2018-05-28 23:35:31', NULL, NULL, 7, 0, 18, 1, 'Chief Doctor', 'das');
INSERT INTO `EmployeeInfo` VALUES (19, 1, '2018-05-30 08:00:43', NULL, NULL, 1, 0, 19, 0, 'Interne', 'dsa');
INSERT INTO `EmployeeInfo` VALUES (20, 1, '2018-06-03 09:49:08', NULL, NULL, 1, 0, 20, 0, 'Chief Doctor', NULL);
COMMIT;

-- ----------------------------
-- Table structure for EmployeeLog
-- ----------------------------
DROP TABLE IF EXISTS `EmployeeLog`;
CREATE TABLE `EmployeeLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `who` int(11) NOT NULL,
  `what` varchar(255) NOT NULL,
  `happenTime` datetime NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

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
INSERT INTO `EmployeeLog` VALUES (39, 1, 'modifying at Fri Jun 01 23:48:16 CST 2018, by Tony', '2018-06-01 23:48:16', 'modifying');
INSERT INTO `EmployeeLog` VALUES (40, 1, 'modifying at Fri Jun 01 23:50:14 CST 2018, by Tony', '2018-06-01 23:50:14', 'modifying');
INSERT INTO `EmployeeLog` VALUES (41, 1, 'modifying at Fri Jun 01 23:50:38 CST 2018, by Tony', '2018-06-01 23:50:38', 'modifying');
INSERT INTO `EmployeeLog` VALUES (42, 1, 'modifying at Fri Jun 01 23:52:49 CST 2018, by Tony', '2018-06-01 23:52:50', 'modifying');
INSERT INTO `EmployeeLog` VALUES (43, 1, 'modifying at Sat Jun 02 00:28:05 CST 2018, by Tony', '2018-06-02 00:28:05', 'modifying');
INSERT INTO `EmployeeLog` VALUES (44, 1, 'modifying at Sat Jun 02 00:28:14 CST 2018, by Tony', '2018-06-02 00:28:14', 'modifying');
INSERT INTO `EmployeeLog` VALUES (45, 20, 'joining at Sun Jun 03 09:49:08 CST 2018, by test', '2018-06-03 09:49:08', 'joining');
INSERT INTO `EmployeeLog` VALUES (46, 1, 'modifying at Mon Jun 04 16:50:37 CST 2018, by Tony', '2018-06-04 16:50:38', 'modifying');
COMMIT;

-- ----------------------------
-- Table structure for InHospitalInfo
-- ----------------------------
DROP TABLE IF EXISTS `InHospitalInfo`;
CREATE TABLE `InHospitalInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endTime` datetime DEFAULT NULL,
  `fee` decimal(19,2) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `wardNum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of InHospitalInfo
-- ----------------------------
BEGIN;
INSERT INTO `InHospitalInfo` VALUES (2, NULL, 599.00, '2018-05-28 08:47:55', 21, 2);
INSERT INTO `InHospitalInfo` VALUES (3, NULL, 555.00, '2018-05-28 08:47:55', 22, 2);
INSERT INTO `InHospitalInfo` VALUES (4, NULL, 121.00, '2018-05-28 08:47:55', 23, 3);
INSERT INTO `InHospitalInfo` VALUES (5, NULL, 323.00, '2018-05-28 08:47:55', 24, 3);
INSERT INTO `InHospitalInfo` VALUES (6, NULL, 21212.90, '2018-05-28 08:47:55', 25, 4);
INSERT INTO `InHospitalInfo` VALUES (7, NULL, 23232.10, '2018-05-28 08:47:55', 26, 4);
COMMIT;

-- ----------------------------
-- Table structure for MedicalRecord
-- ----------------------------
DROP TABLE IF EXISTS `MedicalRecord`;
CREATE TABLE `MedicalRecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `diseaseName` varchar(255) DEFAULT NULL,
  `doctorId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  `recommend` varchar(255) DEFAULT NULL,
  `medHis` varchar(50) DEFAULT NULL,
  `diseaseDetail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of MedicalRecord
-- ----------------------------
BEGIN;
INSERT INTO `MedicalRecord` VALUES (1, 1, '2018-06-05 10:30:56', NULL, NULL, 'Cough', 1, 21, 'Should be mainly light food, do not eat spicy food and poor digestion of food, so as to avoid catching cold, drink plenty of water to add fluids.', 'abcsddsf', 'Infection caused by cold or inflammation');
COMMIT;

-- ----------------------------
-- Table structure for PatientInfo
-- ----------------------------
DROP TABLE IF EXISTS `PatientInfo`;
CREATE TABLE `PatientInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `inpatient` tinyint(1) NOT NULL DEFAULT '0',
  `alleHis` varchar(255) DEFAULT NULL,
  `inHospitalId` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of PatientInfo
-- ----------------------------
BEGIN;
INSERT INTO `PatientInfo` VALUES (2, 1, '2018-05-28 08:47:55', NULL, NULL, 1, 'cereals', 2, 21);
INSERT INTO `PatientInfo` VALUES (3, 1, '2018-05-28 08:47:55', NULL, NULL, 1, 'cigarette', 3, 22);
INSERT INTO `PatientInfo` VALUES (4, 1, '2018-05-28 08:47:55', NULL, NULL, 1, 'meat', 4, 23);
INSERT INTO `PatientInfo` VALUES (5, 1, '2018-05-28 08:47:55', NULL, NULL, 1, 'nut seeds', 5, 24);
INSERT INTO `PatientInfo` VALUES (6, 1, '2018-05-28 08:47:55', NULL, NULL, 1, 'alcohol', 6, 25);
INSERT INTO `PatientInfo` VALUES (7, 1, '2018-05-28 08:47:55', NULL, NULL, 1, 'salt', 7, 26);
INSERT INTO `PatientInfo` VALUES (8, 1, '2018-05-28 08:47:55', NULL, NULL, 0, 'spices', 0, 27);
INSERT INTO `PatientInfo` VALUES (9, 1, '2018-05-28 08:47:55', NULL, NULL, 0, 'butter', 0, 28);
COMMIT;

-- ----------------------------
-- Table structure for PatientLog
-- ----------------------------
DROP TABLE IF EXISTS `PatientLog`;
CREATE TABLE `PatientLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  `what` varchar(255) NOT NULL,
  `happen_time` datetime NOT NULL,
  `type` varchar(40) NOT NULL,
  `employeeId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of PatientLog
-- ----------------------------
BEGIN;
INSERT INTO `PatientLog` VALUES (2, 1, 21, 'Patient registered by Tony', '2018-05-28 08:47:55', 'registered', 0);
INSERT INTO `PatientLog` VALUES (3, 1, 22, 'Patient registered by Tony', '2018-05-28 08:47:55', 'registered', 0);
INSERT INTO `PatientLog` VALUES (4, 1, 23, 'Patient registered by Tony', '2018-05-28 08:47:55', 'registered', 0);
INSERT INTO `PatientLog` VALUES (5, 1, 24, 'Patient registered by Tony', '2018-05-28 08:47:55', 'registered', 0);
INSERT INTO `PatientLog` VALUES (6, 1, 25, 'Patient registered by Tony', '2018-05-28 08:47:55', 'registered', 0);
INSERT INTO `PatientLog` VALUES (7, 1, 26, 'Patient registered by Tony', '2018-05-28 08:47:55', 'registered', 0);
INSERT INTO `PatientLog` VALUES (8, 1, 27, 'Patient registered by Tony', '2018-05-28 08:47:55', 'registered', 0);
INSERT INTO `PatientLog` VALUES (9, 1, 28, 'Patient registered by Tony', '2018-05-28 08:47:55', 'registered', 0);
INSERT INTO `PatientLog` VALUES (10, 1, 21, 'Apply for hospitalization', '2018-05-28 08:47:55', 'hospitalized', 0);
INSERT INTO `PatientLog` VALUES (11, 1, 22, 'Apply for hospitalization', '2018-05-28 08:47:55', 'hospitalized', 0);
INSERT INTO `PatientLog` VALUES (12, 1, 23, 'Apply for hospitalization', '2018-05-28 08:47:55', 'hospitalized', 0);
INSERT INTO `PatientLog` VALUES (13, 1, 24, 'Apply for hospitalization', '2018-05-28 08:47:55', 'hospitalized', 0);
INSERT INTO `PatientLog` VALUES (14, 1, 25, 'Apply for hospitalization', '2018-05-28 08:47:55', 'hospitalized', 0);
INSERT INTO `PatientLog` VALUES (15, 1, 26, 'Apply for hospitalization', '2018-05-28 08:47:55', 'hospitalized', 0);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES (1, 1, '2018-05-28 08:47:55', 1, '2018-06-04 16:50:38', 20, '/static/img/avator/Tony_1.png', 'lintong@gmail.com', 1, '13958932004', '123456', 'Tony', 'Tony', 1);
INSERT INTO `User` VALUES (2, 1, '2018-05-28 08:47:55', 1, '2018-06-03 00:12:50', 20, '/static/img/avator/Andy_2.png', 'lintong@gmail.com', 1, '13944422256', '123457', 'Andy', 'andy', 1);
INSERT INTO `User` VALUES (3, 1, '2018-05-28 08:47:55', 1, '2018-06-04 08:43:50', 20, '/static/img/avator/Kate_3.png', 'lintong@gmail.com', 0, '13944422257', '123456', 'Kate', 'kate', 1);
INSERT INTO `User` VALUES (4, 1, '2018-05-28 08:47:55', 1, '2018-06-03 00:09:13', 20, '/static/img/avator/Charlotter_4.png', 'lintong@gmail.com', 1, '13944422258', '123456', 'Charlotter', 'charlo', 1);
INSERT INTO `User` VALUES (5, 1, '2018-05-28 08:47:55', 1, '2018-06-03 00:11:08', 20, '/static/img/avator/Catherine_5.png', 'lintong@gmail.com', 0, '13944422259', '123456', 'Catherine', 'cathy', 1);
INSERT INTO `User` VALUES (6, 1, '2018-05-28 08:47:55', 1, '2018-06-03 08:29:35', 20, '/static/img/avator/George_6.png', 'lintong@gmail.com', 1, '13944422260', '123456', 'George', 'geogeo', 1);
INSERT INTO `User` VALUES (7, 1, '2018-05-28 08:47:55', 1, '2018-06-03 00:23:24', 20, '/static/img/avator/Alice_7.png', 'lintong@gmail.com', 0, '13944422261', '123456', 'Alice', 'alice111', 1);
INSERT INTO `User` VALUES (8, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422262', '123456', 'Quinn', 'quinn232', 1);
INSERT INTO `User` VALUES (9, 1, '2018-05-28 08:47:55', 1, '2018-06-03 00:29:24', 20, '/static/img/avator/Jenson_9.png', 'lintong@gmail.com', 1, '13944422263', '123456', 'Jenson', 'jjeson11', 1);
INSERT INTO `User` VALUES (10, 1, '2018-05-28 08:47:55', 1, '2018-06-03 00:32:18', 20, '/static/img/avator/Finn_10.png', 'lintong@gmail.com', 1, '13944422264', '123456', 'Finn', 'finn65434', 1);
INSERT INTO `User` VALUES (11, 1, '2018-05-28 08:47:55', 1, '2018-06-03 00:34:45', 20, '/static/img/avator/Eden_11.png', 'lintong@gmail.com', 1, '13944422265', '123456', 'Eden', 'edenSuper', 1);
INSERT INTO `User` VALUES (12, 1, '2018-05-28 08:47:55', 1, '2018-06-03 08:30:35', 20, '/static/img/avator/Maple_12.png', 'lintong@gmail.com', 0, '13944422266', '123456', 'Maple', 'maplelily', 1);
INSERT INTO `User` VALUES (13, 1, '2018-05-28 08:47:55', 1, '2018-06-03 09:05:21', 20, '/static/img/avator/Tobby_13.png', 'lintong@gmail.com', 1, '13944422267', '123456', 'Tobby', 'Tobbbby', 1);
INSERT INTO `User` VALUES (14, 1, '2018-05-28 08:47:55', 1, '2018-06-03 09:05:43', 20, '/static/img/avator/Kai_14.png', 'lintong@gmail.com', 1, '13944422268', '123456', 'Kai', 'kaikai', 1);
INSERT INTO `User` VALUES (15, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422255', '123456', 'Stanley', 'stan', 1);
INSERT INTO `User` VALUES (16, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 1, '13944422255', '123456', 'Muhammed', 'muharm', 1);
INSERT INTO `User` VALUES (17, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422255', '123456', 'Harper', 'harper', 1);
INSERT INTO `User` VALUES (18, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Grace', 'grace', 1);
INSERT INTO `User` VALUES (19, 1, '2018-05-30 07:57:38', NULL, NULL, 22, '/static/img/a8.jpg', 'ffsfd@gmail.com', 0, '1313331111111', '123456', 'Paul', 'paulWin', 1);
INSERT INTO `User` VALUES (20, 1, '2018-06-03 09:49:08', NULL, NULL, 20, '/static/img/a5.jpg', 'test@test', 1, '13958932001', 'test', 'test', 'test', 1);
INSERT INTO `User` VALUES (21, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Gray', 'grace', 0);
INSERT INTO `User` VALUES (22, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Ada', 'Ada', 0);
INSERT INTO `User` VALUES (23, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Billy', 'Billy', 0);
INSERT INTO `User` VALUES (24, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Mark', 'Mark', 0);
INSERT INTO `User` VALUES (25, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Steven', 'Steven', 0);
INSERT INTO `User` VALUES (26, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Strange', 'Strange', 0);
INSERT INTO `User` VALUES (27, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Peter', 'Peter', 0);
INSERT INTO `User` VALUES (28, 1, '2018-05-28 08:47:55', NULL, NULL, 20, '/static/img/a1.jpg', 'lintong@gmail.com', 0, '13944422270', '123456', 'Oliver', 'Oliver', 0);
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
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `totalNum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Ward
-- ----------------------------
BEGIN;
INSERT INTO `Ward` VALUES (1, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 1, Unit 3, Building No.2.', 0, 4);
INSERT INTO `Ward` VALUES (2, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 2, Unit 3, Building No.2.', 2, 4);
INSERT INTO `Ward` VALUES (3, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 3, Unit 3, Building No.2.', 2, 4);
INSERT INTO `Ward` VALUES (4, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 4, Unit 3, Building No.2.', 2, 4);
INSERT INTO `Ward` VALUES (5, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 5, Unit 3, Building No.2.', 0, 4);
INSERT INTO `Ward` VALUES (6, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 1, Unit 2, Building No.2.', 0, 4);
INSERT INTO `Ward` VALUES (7, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 2, Unit 2, Building No.2.', 0, 4);
INSERT INTO `Ward` VALUES (8, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 3, Unit 2, Building No.2.', 0, 4);
INSERT INTO `Ward` VALUES (9, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 4, Unit 2, Building No.2.', 0, 4);
INSERT INTO `Ward` VALUES (10, 1, '2018-05-28 08:47:55', NULL, NULL, 'Room 5, Unit 2, Building No.2.', 0, 4);
COMMIT;

-- ----------------------------
-- Table structure for physicalExamination
-- ----------------------------
DROP TABLE IF EXISTS `physicalExamination`;
CREATE TABLE `physicalExamination` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createBy` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `checkBy` int(11) NOT NULL,
  `checkName` varchar(255) DEFAULT NULL,
  `checkResult` varchar(255) DEFAULT NULL,
  `fee` decimal(19,2) DEFAULT NULL,
  `medicalRecordId` int(11) NOT NULL,
  `patientId` int(11) NOT NULL,
  `picture` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of physicalExamination
-- ----------------------------
BEGIN;
INSERT INTO `physicalExamination` VALUES (1, 1, '2018-05-30 12:55:55', NULL, NULL, 12, 'Lung CT', 'Things are quite normal', 300.40, 1, 21, '/static/img/check/lungCT.jpg');
INSERT INTO `physicalExamination` VALUES (2, 1, '2018-06-01 18:23:55', NULL, NULL, 14, 'Blood test', 'Things are quite normal', 300.40, 1, 21, '/static/img/check/BloodTest.png');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
