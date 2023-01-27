/*
 Navicat Premium Data Transfer

 Source Server         : 刘荣沛
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : digital

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 27/01/2023 14:15:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for objects
-- ----------------------------
DROP TABLE IF EXISTS `objects`;
CREATE TABLE `objects`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `value` float(10, 1) NOT NULL DEFAULT 0.0,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `imgurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of objects
-- ----------------------------
INSERT INTO `objects` VALUES (1, 'iphone14', '苹果', '手机', 14.0, '苹果最新一代手机iphone14', '/iphone14.jpg', 6);
INSERT INTO `objects` VALUES (2, 'iphone14pro', '苹果', '手机', 15.0, '苹果最新手机pro版', '/iphone14pro.jpg', 4);
INSERT INTO `objects` VALUES (3, '小米12S', '小米', '手机', 8.0, '小米12s', '/xiaomi12s.jpg', 3);
INSERT INTO `objects` VALUES (4, 'xperia1', '索尼', '手机', 10.0, '索尼手机xperia 1', '/sonyxperia1.jpg', 3);
INSERT INTO `objects` VALUES (5, 'WH1000xm4', '索尼', '耳机', 4.0, '索尼头带降噪耳机xm4', '/sonywh1000xm4.jpg', 3);
INSERT INTO `objects` VALUES (6, 'WH1000xm5', '索尼', '耳机', 6.0, '索尼最新旗舰降噪耳机xm5', '/sonywh1000xm5.jpg', 3);
INSERT INTO `objects` VALUES (7, 'Mate50', '华为', '手机', 10.0, '华为手机Mate50', '/huaweimate50.jpg', 3);
INSERT INTO `objects` VALUES (8, 'Mate50Pro', '华为', '手机', 14.0, '华为手机Mate50Pro', '/huaweimate50pro.jpg', 6);
INSERT INTO `objects` VALUES (9, 'MixFold2', '小米', '手机', 20.0, '小米旗舰折叠屏手机', '/xiaomimixfold2.jpg', 6);
INSERT INTO `objects` VALUES (10, 'PS5', '索尼', '主机', 10.0, '索尼最新一代游戏主机', '/sonyps5.jpg', 6);
INSERT INTO `objects` VALUES (11, 'airpods pro', '苹果', '耳机', 4.0, '苹果降噪入耳式耳机', '/airpodspro.jpg', 14);
INSERT INTO `objects` VALUES (12, 'Switch', '任天堂', '主机', 3.0, '任天堂Switch游戏主机', '/switch.jpg', 10);
INSERT INTO `objects` VALUES (13, 'SwitchOled', '任天堂', '主机', 6.0, '任天堂Switch游戏主机加强版', '/switcholed.jpg', 11);
INSERT INTO `objects` VALUES (14, 'iphone13proMax', '苹果', '手机', 16.0, '苹果手机13代旗舰', '/iphone13promax.jpg', 10);
INSERT INTO `objects` VALUES (15, 'OppoReno8', 'OPPO', '手机', 4.0, 'OPPO Reno8 系列新品', '/opporeno8.jpg', 5);
INSERT INTO `objects` VALUES (16, 'K60', '小米', '手机', 6.0, '还未发售的K60手机', '/k60.jpg', 1);
INSERT INTO `objects` VALUES (17, 'K60Pro', '小米', '手机', 8.0, '小米K60Pro', '/k60pro.jpg', 3);
INSERT INTO `objects` VALUES (18, 'Ge76', '微星', '笔记本', 16.0, '微星17.6寸笔记本', '/ge76.jpg', 3);
INSERT INTO `objects` VALUES (19, '天选3', '华硕', '笔记本', 12.0, '华硕15.6村笔记本', '/tianxuan3.jpg', 5);
INSERT INTO `objects` VALUES (20, 'freebudsPro', '华为', '耳机', 7.0, '华为第一代降噪耳机', '/freebudspro.jpg', 8);
INSERT INTO `objects` VALUES (21, 'freebudsPro2', '华为', '耳机', 10.0, '华为最新一代降噪耳机', '/freebudspro2.jpg', 2);
INSERT INTO `objects` VALUES (22, 'airpods2', '苹果', '耳机', 6.0, '苹果半入耳式无线耳机2代', '/airpods2.jpg', 17);
INSERT INTO `objects` VALUES (23, '红蜘蛛x', '德塔', '校色仪', 8.0, '红蜘蛛x校色仪显示器颜色调色校准屏幕校色器', '/hongzhizhu.jpg', 10);
INSERT INTO `objects` VALUES (24, 'new', 'new', 'new', 10.0, '', NULL, 9);

-- ----------------------------
-- Table structure for rate
-- ----------------------------
DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `evaluate` int NOT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_for`(`user_id`) USING BTREE,
  CONSTRAINT `user_id_for` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rate
-- ----------------------------
INSERT INTO `rate` VALUES (1, 1, 'admin', 5, '...', '2022-11-20 21:58:05');
INSERT INTO `rate` VALUES (2, 2, 'HolyWizard', 5, '很好用的租借网站!', '2022-11-13 12:48:48');
INSERT INTO `rate` VALUES (3, 3, 'test', 5, '不错', '2022-11-13 11:57:38');
INSERT INTO `rate` VALUES (4, 4, 'yyt123', 4, 'emmmmm', '2022-11-16 21:51:25');
INSERT INTO `rate` VALUES (5, 5, '李叶钊', 5, 'ok', '2022-11-16 21:53:04');
INSERT INTO `rate` VALUES (8, 6, 'new', 5, 'pingjia', '2022-11-22 20:17:16');

-- ----------------------------
-- Table structure for rent
-- ----------------------------
DROP TABLE IF EXISTS `rent`;
CREATE TABLE `rent`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `objects_id` int NOT NULL,
  `objects_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `amount` int NULL DEFAULT NULL,
  `value` float NULL DEFAULT NULL,
  `days` int NULL DEFAULT NULL,
  `rent_time` date NULL DEFAULT NULL,
  `return_time` date NULL DEFAULT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rent
-- ----------------------------
INSERT INTO `rent` VALUES (1, 1, 3, '小米12S', 1, 40, 5, '2022-11-17', '2022-11-22', 1);
INSERT INTO `rent` VALUES (2, 1, 2, 'iphone14pro', 1, 30, 2, '2022-11-17', '2022-11-19', 1);
INSERT INTO `rent` VALUES (3, 1, 2, 'iphone14pro', 1, 30, 2, '2022-11-17', '2022-11-19', 1);
INSERT INTO `rent` VALUES (4, 1, 11, 'airpods pro', 1, 40, 10, '2022-11-17', '2022-11-27', 1);
INSERT INTO `rent` VALUES (5, 1, 12, 'Switch', 1, 120, 40, '2022-11-17', '2022-12-27', 1);
INSERT INTO `rent` VALUES (6, 1, 14, 'iphone13proMax', 1, 224, 14, '2022-11-17', '2022-12-01', 1);
INSERT INTO `rent` VALUES (7, 1, 22, 'airpods2', 2, 72, 6, '2022-11-17', '2022-11-23', 1);
INSERT INTO `rent` VALUES (8, 1, 10, 'PS5', 1, 200, 20, '2022-11-17', '2022-12-07', 1);
INSERT INTO `rent` VALUES (9, 1, 1, 'iphone14', 1, 78, 6, '2022-11-17', '2022-11-23', 1);
INSERT INTO `rent` VALUES (10, 1, 1, 'iphone14', 1, 78, 6, '2022-11-17', '2022-11-23', 0);
INSERT INTO `rent` VALUES (11, 1, 22, 'airpods2', 1, 96, 16, '2022-11-17', '2022-12-03', 1);
INSERT INTO `rent` VALUES (12, 1, 22, 'airpods2', 1, 84, 14, '2022-11-17', '2022-12-01', 0);
INSERT INTO `rent` VALUES (13, 1, 14, 'iphone13proMax', 1, 128, 8, '2022-11-17', '2022-11-25', 1);
INSERT INTO `rent` VALUES (14, 1, 13, 'SwitchOled', 1, 36, 6, '2022-11-17', '2022-11-23', 1);
INSERT INTO `rent` VALUES (15, 1, 13, 'SwitchOled', 1, 72, 12, '2022-11-17', '2022-11-29', 0);
INSERT INTO `rent` VALUES (16, 1, 14, 'iphone13proMax', 1, 336, 21, '2022-11-17', '2022-12-08', 1);
INSERT INTO `rent` VALUES (17, 1, 1, 'iphone14', 7, 91, 1, '2022-11-17', '2022-11-18', 0);
INSERT INTO `rent` VALUES (18, 1, 1, 'iphone14', 1, 1, 1, '2022-11-15', '2022-11-16', 1);
INSERT INTO `rent` VALUES (19, 1, 1, 'iphone14', 1, 390, 30, '2022-11-20', '2022-12-20', 1);
INSERT INTO `rent` VALUES (21, 6, 23, '红蜘蛛x', 1, 160, 20, '2022-11-22', '2022-12-12', 0);
INSERT INTO `rent` VALUES (22, 1, 24, 'new', 1, 10, 1, '2022-11-22', '2022-11-23', 1);
INSERT INTO `rent` VALUES (23, 1, 16, 'K60', 1, 6, 1, '2022-11-22', '2022-11-23', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `permission` int NOT NULL,
  `money` float(50, 2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '18888888888', 'admin', 0, 994.00);
INSERT INTO `user` VALUES (2, 'HolyWizard', '12345678', '17616544404', '山东省济宁市曲阜市济宁学院', 1, 700.00);
INSERT INTO `user` VALUES (3, 'test', 'test', '', '', 1, 0.00);
INSERT INTO `user` VALUES (4, 'Ruizu', 'yyt123', '', '', 1, 0.00);
INSERT INTO `user` VALUES (5, '李叶钊', 'liyezhao', '12545366658', '济宁学院', 1, 100.00);
INSERT INTO `user` VALUES (6, 'new', '123456', '17616544404', '济宁学院', 1, 40.00);

SET FOREIGN_KEY_CHECKS = 1;
