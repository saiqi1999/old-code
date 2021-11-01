/*
 Navicat Premium Data Transfer


 Date: 19/08/2021 16:36:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hrm_message
-- ----------------------------
DROP TABLE IF EXISTS `hrm_message`;
CREATE TABLE `hrm_message`  (
  `message_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '站内信ID',
  `user_send` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发出人',
  `user_receive` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收人',
  `message_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息标题',
  `message` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息',
  `read` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态',
  `is_refresh` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否刷新（0刷新 1不刷新）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  `read_time` datetime(0) NULL DEFAULT NULL COMMENT '读取时间',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2126 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '站内信箱' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
