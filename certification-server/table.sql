-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `expression` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', 'ROLE_ADMIN', null);
INSERT INTO `role` VALUES ('2', '模块管理员', 'ROLE_MODEL', null);


-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin', '123');
INSERT INTO `account` VALUES ('2', 'xiaoxin008', '123');


-- ----------------------------
-- Table structure for account_role
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `a_id` int(20) NOT NULL,
  `r_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_role
-- ----------------------------
INSERT INTO `account_role` VALUES ('1', '1', '1');
INSERT INTO `account_role` VALUES ('2', '2', '2');
INSERT INTO `account_role` VALUES ('3', '1', '2');