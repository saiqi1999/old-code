/*
 Navicat Premium Data Transfer



 Date: 19/08/2021 16:37:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表');
INSERT INTO `sys_dict_type` VALUES (11, '车辆状态', 'oa_car_status', '0', 'admin', '2019-12-30 13:45:18', 'admin', '2019-12-30 13:45:53', '车辆管理车辆状态');
INSERT INTO `sys_dict_type` VALUES (12, '婚姻状况', 'hr_marital', '0', 'admin', '2020-01-13 14:46:32', '', NULL, '婚姻状况(1未婚2已婚)');
INSERT INTO `sys_dict_type` VALUES (13, '员工状态', 'hr_emp_status', '0', 'admin', '2020-01-13 14:49:33', '', NULL, '状态(1试用 2正式 )');
INSERT INTO `sys_dict_type` VALUES (14, '员工类别', 'hr_emp_type', '0', 'admin', '2020-01-13 14:51:23', '', NULL, '员工类别 1全职 2兼职 3实习 4劳务5派遣 6劳务外包');
INSERT INTO `sys_dict_type` VALUES (15, '计量单位', 'measure_unit', '0', 'admin', '2020-04-27 12:44:22', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (16, '物料采购订单状态', 'purchase_order_status', '0', 'admin', '2020-04-27 13:03:04', 'admin', '2020-05-13 16:07:44', '0未审核 1审核中 2已审核');
INSERT INTO `sys_dict_type` VALUES (17, '物流采购订单周期', 'purchase_order_period', '0', 'admin', '2020-04-27 13:05:44', '', NULL, '每两个月一个周期？');
INSERT INTO `sys_dict_type` VALUES (18, '项目类型', 'project_type', '0', 'admin', '2020-05-13 16:08:42', 'admin', '2020-05-13 16:09:36', '1商业、2住宅、3医疗、4工业、5景区');
INSERT INTO `sys_dict_type` VALUES (19, '服务模块', 'service_module', '0', 'admin', '2020-05-13 16:17:47', 'admin', '2020-05-13 16:18:09', '');
INSERT INTO `sys_dict_type` VALUES (20, '年份', 'years', '0', 'admin', '2020-05-19 12:40:53', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (21, '合同类别', 'contract_type', '0', 'admin', '2020-05-20 10:07:02', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (22, '合同状态', 'contract_status', '0', 'admin', '2020-05-20 10:14:50', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (23, '客户来源', 'custom_source', '0', 'admin', '2020-05-20 10:27:07', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (24, '客户企业类型', 'custom_type', '0', 'admin', '2020-05-20 10:29:33', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (25, '客户状态', 'custom_status', '0', 'admin', '2020-05-20 10:31:59', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (26, '产品状态', 'product_status', '0', 'admin', '2020-05-20 10:35:24', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (27, '商机类型', 'opportunity_type', '0', 'admin', '2020-05-20 10:36:36', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (28, '证件状态', 'credential_status', '0', 'admin', '2020-05-20 11:03:15', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (29, '客户级别', 'custom_level', '0', 'admin', '2020-05-20 11:17:18', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (30, '客户规模', 'custom_scale', '0', 'admin', '2020-05-20 11:21:33', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (31, '联系人类型', 'contact_type', '0', 'admin', '2020-05-20 11:25:53', 'admin', '2020-05-20 11:26:06', '');
INSERT INTO `sys_dict_type` VALUES (32, '地区级别', 'location_level', '0', 'admin', '2020-05-21 17:27:11', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (33, '资产状态', 'asset_type', '0', 'admin', '2020-05-22 16:34:28', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (34, '折旧方式', 'depreciation_way', '0', 'admin', '2020-05-22 16:48:33', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (35, '日程事务类型', 'schedule_type', '0', 'admin', '2020-05-25 19:00:06', 'admin', '2020-05-25 19:01:20', '');
INSERT INTO `sys_dict_type` VALUES (36, '日程状态', 'schedule_status', '0', 'admin', '2020-05-25 19:01:14', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (37, '试用期', 'probation_period_type', '0', 'admin', '2020-06-08 10:16:14', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (38, '户籍类型', 'residence_type', '0', 'admin', '2020-06-08 10:21:51', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (39, '政治面貌', 'political_status', '0', 'admin', '2020-06-08 10:24:05', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (40, '学历', 'highest_edu', '0', 'admin', '2020-06-08 10:25:21', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (41, '合同期限', 'contract_period_type', '0', 'admin', '2020-06-08 10:27:28', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (42, '合同类型', 'dd_contract_type', '0', 'admin', '2020-06-17 13:43:20', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (43, '会计科目类别', 'subject_type', '0', 'admin', '2020-07-09 10:53:46', 'admin', '2020-07-09 10:54:10', '资产类、负债类、共同类、所有者权益类、成本类、损益类');
INSERT INTO `sys_dict_type` VALUES (44, '会计科目级次', 'subject_level', '0', 'admin', '2020-07-09 10:57:36', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (45, '货币种类', 'subject_currency', '0', 'admin', '2020-07-09 11:00:52', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (46, '会计科目性质', 'balance_direction', '0', 'admin', '2020-07-09 11:02:27', 'admin', '2020-07-09 11:03:14', '余额方向');
INSERT INTO `sys_dict_type` VALUES (47, '档案状态', 'archive_status', '0', 'admin', '2020-07-09 11:07:20', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (48, '财务客户分类', 'client_type', '0', 'admin', '2020-07-09 11:09:43', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (49, '财务合同类别', 'cont_type', '0', 'admin', '2020-07-09 11:13:30', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (50, '财务费用类别', 'expense_type', '0', 'admin', '2020-07-09 11:14:23', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (51, '发票类别', 'invoice_type', '0', 'admin', '2020-07-09 11:16:06', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (52, '发票状态', 'invoice_status', '0', 'admin', '2020-07-09 11:16:18', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (53, '辅助类型(会计科目)', 'auxiliary_type', '0', 'admin', '2020-07-28 10:22:22', 'admin', '2020-07-28 10:24:45', '');
INSERT INTO `sys_dict_type` VALUES (54, '凭证类别', 'voucher_type', '0', 'admin', '2020-08-02 11:16:51', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (55, '凭证状态', 'voucher_status', '0', 'admin', '2020-08-02 11:17:04', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (56, '凭证模板类别', 'voucher_template_type', '0', 'admin', '2020-09-25 08:33:36', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (57, '资金管理收支类别', 'revenue_type', '0', 'admin', '2020-09-30 15:06:51', 'admin', '2020-09-30 15:07:02', '');
INSERT INTO `sys_dict_type` VALUES (58, '资金账户类别', 'account_type', '0', 'admin', '2020-10-09 10:54:48', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (59, '发票收支类别', 'receipt_type', '0', 'admin', '2020-10-09 11:01:30', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (60, '发票取值类别', 'value_type', '0', 'admin', '2020-10-09 11:46:37', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (61, '凭证来源', 'voucher_source', '0', 'admin', '2020-10-19 13:08:06', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (62, '增值税类型', 'tax_type', '0', 'admin', '2021-02-18 16:27:49', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (63, '巡更点类型', 'patrol_point_type', '0', 'admin', '2021-03-02 08:41:39', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (64, '巡更检查结果', 'patrol_check_result', '0', 'admin', '2021-03-02 08:51:14', 'admin', '2021-03-02 08:51:27', '');
INSERT INTO `sys_dict_type` VALUES (65, '民族', 'nation_type', '0', 'admin', '2021-03-16 08:54:06', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (66, '关联钉钉流程审核状态', 'ding_status', '0', 'admin', '2021-03-16 09:15:25', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (67, '库房类别', 'storeroom_type', '0', 'admin', '2021-03-16 09:18:40', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (68, '库位类别', 'storeroom_location_type', '0', 'admin', '2021-03-16 09:31:59', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (69, '入库状态', 'stockin_status', '0', 'admin', '2021-04-07 10:25:12', 'admin', '2021-04-07 10:25:53', '');
INSERT INTO `sys_dict_type` VALUES (70, '出库状态', 'stockout_status', '0', 'admin', '2021-04-07 10:25:34', 'admin', '2021-04-07 10:25:58', '');
INSERT INTO `sys_dict_type` VALUES (71, '业主类型', 'ownerType', '0', 'admin', '2021-05-06 09:05:41', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (72, '房屋绑定状态', 'room_bindstatus', '0', 'admin', '2021-05-25 10:40:41', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (73, '投诉类型', 'complaint_suggest_type', '0', 'admin', '2021-05-29 00:08:59', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (74, '婚姻状况', 'hrm_marriage_status', '0', 'admin', '2021-06-09 14:13:22', 'admin', '2021-06-09 15:48:27', '');
INSERT INTO `sys_dict_type` VALUES (75, '政治面貌', 'hrm_political_status', '0', 'admin', '2021-06-09 14:16:01', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (76, '血型', 'hrm_blood_type', '0', 'admin', '2021-06-09 15:51:17', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (77, '工种信息', 'hrm_employee_type', '0', 'admin', '2021-06-09 15:55:49', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (78, '员工状态', 'hrm_employee_status', '0', 'admin', '2021-06-09 15:59:14', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (79, '员工性别', 'hrm_employee_gender', '0', 'admin', '2021-06-09 17:12:27', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (80, '考勤结果', 'hrm_attendance_type', '0', 'admin', '2021-06-29 14:25:29', '', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
