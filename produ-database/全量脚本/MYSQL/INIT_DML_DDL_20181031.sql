
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键(客户编号)',
  `CUST_NAME` varchar(20) DEFAULT NULL COMMENT '客户名称',
  `CUST_TYPE` int(4) DEFAULT NULL COMMENT '客户类型',
  `CUST_BELONG` int(4) DEFAULT NULL COMMENT '客户属地(所在市）',
  `CUST_ADDR` varchar(100) DEFAULT NULL COMMENT '客户地址',
  `CUST_WEBSITE` varchar(30) DEFAULT NULL COMMENT '客户网站',
  `CREATED` datetime(6) NOT NULL COMMENT '项目启动日期',
  `UPDATED` datetime(6) NOT NULL,
  `SALE_MGR` int(4) DEFAULT NULL COMMENT '销售经理',
  `OPER` int(8) DEFAULT NULL COMMENT '操作人员ID',
  `STATE` int(2) DEFAULT NULL COMMENT '状态（是否合并，0：否；1,：是）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '2', '1', '1', '1', '1', '2017-11-20 15:06:26.000000', '2017-11-20 15:06:31.000000', '1', '1', '1');

-- ----------------------------
-- Table structure for `sup_famliy`
-- ----------------------------
DROP TABLE IF EXISTS `sup_famliy`;
CREATE TABLE `sup_famliy` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `stu_id` bigint(2) DEFAULT NULL COMMENT '学生表关系id',
  `father_name` varchar(50) DEFAULT NULL COMMENT '爸爸名字',
  `father_phone` varchar(50) DEFAULT NULL COMMENT '爸爸电话',
  `father_age` bigint(10) DEFAULT NULL COMMENT '爸爸年龄',
  `father_work` varchar(50) DEFAULT NULL COMMENT '爸爸职业',
  `father_schooling` varchar(50) DEFAULT NULL COMMENT '爸爸受教育程度,0:小学；1：初中；2：高中；3：大学；4：研究生；5博士',
  `mather_name` varchar(50) DEFAULT NULL COMMENT '妈妈名字',
  `mather_phone` varchar(50) DEFAULT NULL COMMENT '妈妈电话',
  `mather_age` bigint(10) DEFAULT NULL COMMENT '妈妈年龄',
  `mather_work` varchar(50) DEFAULT NULL COMMENT '妈妈职业',
  `mather_schooling` varchar(50) DEFAULT NULL COMMENT '妈妈受教育程度,0:小学；1：初中；2：高中；3：大学；4：研究生；5博士',
  `address` varchar(50) DEFAULT NULL COMMENT '家庭地址',
  `emergency_contact_phone` varchar(100) DEFAULT NULL COMMENT '紧急联系人电话',
  `emergency_contact` varchar(50) DEFAULT NULL COMMENT '紧急联系人',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `deleted` bigint(10) DEFAULT NULL COMMENT '删除，0：未删除；1：已删除',
  `version` bigint(50) DEFAULT NULL COMMENT '版本',
  `last_modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_by` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sup_famliy
-- ----------------------------
INSERT INTO `sup_famliy` VALUES ('1', '1', '小米爸', '121311212', '45', '个体', '3', '小米妈', '121311212', '34', '个体', '3', '呼和浩特', null, '隔壁老牛', '2017-12-26', 'admin', '0', '0', null, null);

-- ----------------------------
-- Table structure for `sup_student`
-- ----------------------------
DROP TABLE IF EXISTS `sup_student`;
CREATE TABLE `sup_student` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `name` varchar(20) DEFAULT NULL COMMENT '中文名字',
  `eng_name` varchar(50) DEFAULT NULL COMMENT '英文名字',
  `gender` bigint(2) DEFAULT NULL COMMENT '性别；0：女；1：男',
  `age` bigint(10) DEFAULT NULL COMMENT '年龄',
  `primary_school` varchar(255) DEFAULT NULL COMMENT '小学',
  `middle_school` varchar(255) DEFAULT NULL COMMENT '初中',
  `high_school` varchar(255) DEFAULT NULL COMMENT '高中',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭地址',
  `father_phone` varchar(255) DEFAULT NULL COMMENT '爸爸电话',
  `mather_phone` varchar(255) DEFAULT NULL COMMENT '妈妈电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `deleted` bigint(10) DEFAULT NULL COMMENT '删除，0：未删除；1：已删除',
  `version` bigint(50) DEFAULT NULL COMMENT '版本',
  `last_modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_by` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `is_formal` bigint(10) DEFAULT NULL COMMENT '是否为正式学员，0：正式学员；1：目标招生学员',
  `worker_id` bigint(10) DEFAULT NULL COMMENT '关联工作人员ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sup_student
-- ----------------------------
INSERT INTO `sup_student` VALUES ('0', '巴拉', 'bala', '0', '23', '某某小学', '某某中学', '某某高中', '呼和浩特', '1319891911', '112212212', '102991882@qq.com', '2018-01-08', 'admin', '0', '0', null, null, '1', '1');
INSERT INTO `sup_student` VALUES ('1', '小米', 'Humphrey', '1', '24', '某某小学', '某某中学', '某某高中', '呼和浩特', '1319891911', '112212212', '102991882@qq.com', '2017-12-26', 'admin', '0', '0', null, null, '0', '1');

-- ----------------------------
-- Table structure for `sup_student_mark`
-- ----------------------------
DROP TABLE IF EXISTS `sup_student_mark`;
CREATE TABLE `sup_student_mark` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `stu_id` bigint(2) DEFAULT NULL COMMENT '学生表关系id',
  `math` varchar(50) DEFAULT NULL COMMENT '数学成绩',
  `chinese` varchar(50) DEFAULT NULL COMMENT '语文成绩',
  `english` varchar(50) DEFAULT NULL COMMENT '英语成绩',
  `physics` varchar(50) DEFAULT NULL COMMENT '物理成绩',
  `chemistry` varchar(50) DEFAULT NULL COMMENT '化学成绩',
  `biology` varchar(50) DEFAULT NULL COMMENT '生物成绩',
  `sports` varchar(50) DEFAULT NULL COMMENT '体育成绩',
  `politics` varchar(50) DEFAULT NULL COMMENT '政治成绩',
  `geography` varchar(50) DEFAULT NULL COMMENT '地理成绩',
  `exam_time` date NOT NULL COMMENT '考试时间',
  `exam_type` bigint(10) DEFAULT NULL COMMENT '考试类别,0:周考；1：月考；2：期末考试；3：中考；4高考',
  `exam_rank` varchar(50) DEFAULT NULL COMMENT '考试排名',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `deleted` bigint(10) DEFAULT NULL COMMENT '删除，0：未删除；1：已删除',
  `version` bigint(50) DEFAULT NULL COMMENT '版本',
  `last_modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_by` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sup_student_mark
-- ----------------------------
INSERT INTO `sup_student_mark` VALUES ('1', '1', '90', '90', '90', '90', '90', '90', '90', '90', '90', '2017-12-26', '3', '3', '2017-12-26', 'admin', '0', '0', null, null);

-- ----------------------------
-- Table structure for `sup_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `sup_teacher`;
CREATE TABLE `sup_teacher` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `stu_id` bigint(2) DEFAULT NULL COMMENT '学生表关系id',
  `teacher_name` varchar(50) DEFAULT NULL COMMENT '老师名字',
  `age` bigint(50) DEFAULT NULL COMMENT '老师年龄',
  `teacher_age` bigint(50) DEFAULT NULL COMMENT '教学年龄',
  `gender` bigint(50) DEFAULT NULL COMMENT '性别；0：女；1：男',
  `teacher_res` bigint(50) DEFAULT NULL COMMENT '教师职责；0:任课老师；1：班主任',
  `max_education` varchar(50) DEFAULT NULL COMMENT '最高学历',
  `subject` varchar(50) DEFAULT NULL COMMENT '现教科目',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `is_teach` varchar(50) DEFAULT NULL COMMENT '是否在校教学',
  `school_address` varchar(50) DEFAULT NULL COMMENT '学校地址',
  `address` date NOT NULL COMMENT '家庭地址',
  `max_education_name` varchar(50) DEFAULT NULL COMMENT '最高学历毕业学校',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件',
  `emergency_contact_phone` varchar(100) DEFAULT NULL COMMENT '紧急联系人电话',
  `emergency_contact` varchar(50) DEFAULT NULL COMMENT '紧急联系人',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `deleted` bigint(10) DEFAULT NULL COMMENT '删除，0：未删除；1：已删除',
  `version` bigint(50) DEFAULT NULL COMMENT '版本',
  `last_modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_by` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sup_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `sup_worker`
-- ----------------------------
DROP TABLE IF EXISTS `sup_worker`;
CREATE TABLE `sup_worker` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `age` bigint(50) DEFAULT NULL COMMENT '年龄',
  `worker_age` bigint(50) DEFAULT NULL COMMENT '工作年龄',
  `gender` bigint(50) DEFAULT NULL COMMENT '性别',
  `max_education` varchar(50) DEFAULT NULL COMMENT '最高学历',
  `address` varchar(50) DEFAULT NULL COMMENT '家庭地址',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件',
  `emergency_contact_phone` varchar(100) DEFAULT NULL COMMENT '紧急联系人电话',
  `emergency_contact` varchar(50) DEFAULT NULL COMMENT '紧急联系人',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `deleted` bigint(10) DEFAULT NULL COMMENT '删除，0：未删除；1：已删除',
  `version` bigint(50) DEFAULT NULL COMMENT '版本',
  `last_modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_by` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `work_time` date DEFAULT NULL COMMENT '入职时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sup_worker
-- ----------------------------
INSERT INTO `sup_worker` VALUES ('1', '徐某某', '18', '1', '1', '本科', '呼和浩特', '1213121@qq.com', '13192921823', '李某某', '2018-01-08', 'admin', '0', null, null, null, '121212221', '0', '2018-01-08');

-- ----------------------------
-- Table structure for `u_permission`
-- ----------------------------
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `deleted` bigint(10) DEFAULT NULL COMMENT '删除，0：未删除；1：已删除',
  `version` bigint(50) DEFAULT NULL COMMENT '版本',
  `last_modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_by` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES ('1', 'stu:btn:create', '学生新建按钮', '2018-01-10', 'admin', '0', '0', '2018-01-10', 'admin');
INSERT INTO `u_permission` VALUES ('2', 'stu:btn:edit', '学生修改按钮', '2018-01-10', 'huh', '0', '0', '2018-01-10', 'hyh');

-- ----------------------------
-- Table structure for `u_role`
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  `create_time` date NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `deleted` bigint(10) DEFAULT NULL COMMENT '删除，0：未删除；1：已删除',
  `version` bigint(50) DEFAULT NULL COMMENT '版本',
  `last_modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  `last_modify_by` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES ('1', 'CEO', 'CEO_1', '2018-01-10', 'admin', '0', '0', '2018-01-10', 'admin', '拉拉');
INSERT INTO `u_role` VALUES ('2', 'CTO', 'CTO_1', '2018-01-10', 'admin', '0', '0', '2018-01-10', 'admin', '巴拉');
INSERT INTO `u_role` VALUES ('3', '老师', 'Teacher_1', '2018-01-10', 'hyhh', '0', '0', '2018-01-10', 'hyh', '咔咔');

-- ----------------------------
-- Table structure for `u_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role_permission
-- ----------------------------
INSERT INTO `u_role_permission` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `u_user`
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime(2) DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime(2) DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  `deleted` bigint(1) DEFAULT '0' COMMENT '删除状态；0：未删除，1：已删除',
  `update_time` datetime(2) DEFAULT NULL COMMENT '修改时间',
  `version` bigint(6) DEFAULT '0' COMMENT '版本',
  `last_modify_time` date DEFAULT NULL COMMENT '上一次修改时间',
  `last_modify_by` varchar(20) DEFAULT NULL COMMENT '上一次修改人',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', 'superuser', '102121311@qq.com', '0baea2f0ae20150db78f58cddac442a9', '2017-12-12 19:03:30.00', '2017-12-12 19:03:37.00', '1', '0', null, '0', null, '疾风', 'Admin');
INSERT INTO `u_user` VALUES ('2', '1', '2', '21232f297a57a5a743894a0e4a801fc3', '2017-12-21 15:19:38.00', '2017-12-21 15:19:41.00', '0', '0', null, '0', null, '卡卡', '卡卡');
INSERT INTO `u_user` VALUES ('3', '2', '3', '21232f297a57a5a743894a0e4a801fc3', '2017-12-21 15:20:10.00', '2017-12-21 15:20:14.00', '0', '0', null, '0', null, '巴巴', '巴巴');
INSERT INTO `u_user` VALUES ('4', '3', '4', '21232f297a57a5a743894a0e4a801fc3', '2017-12-21 15:21:04.00', null, '0', '0', null, '0', null, '伊拉哇', '4');
INSERT INTO `u_user` VALUES ('5', '4', '5', '21232f297a57a5a743894a0e4a801fc3', '2017-12-21 15:21:39.00', null, '0', '0', null, '0', null, '啊拉卡', '4');
INSERT INTO `u_user` VALUES ('6', '5', '6', '21232f297a57a5a743894a0e4a801fc3', '2017-12-21 15:22:32.00', null, '0', '0', null, '0', null, '琵琶', 'admin');
INSERT INTO `u_user` VALUES ('7', '6', '2', '21232f297a57a5a743894a0e4a801fc3', '2017-12-21 15:22:52.00', null, '0', '0', null, '0', null, '但是', 'ds');
INSERT INTO `u_user` VALUES ('8', '7', '21', '21232f297a57a5a743894a0e4a801fc3', '2017-12-21 15:23:19.00', null, '0', '0', null, '0', null, '说的', '31');
INSERT INTO `u_user` VALUES ('9', '8', '34', '21232f297a57a5a743894a0e4a801fc3', '2017-12-21 15:26:16.00', null, '0', '0', null, '0', null, '啊倒萨', '大啊撒');
INSERT INTO `u_user` VALUES ('15', 'admin', '102121311@qq.com', '21232f297a57a5a743894a0e4a801fc3', '2017-12-12 19:04:11.00', '2017-12-12 19:04:15.00', '1', '0', null, '0', null, '粥店', 'admin');
INSERT INTO `u_user` VALUES ('16', 'admin1', '102121311@qq.com', '21232f297a57a5a743894a0e4a801fc3', '2017-12-21 15:03:21.00', '2017-12-21 15:03:23.00', '0', '0', null, '0', null, '啦啦啦', '15');

-- ----------------------------
-- Table structure for `u_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user_role
-- ----------------------------
INSERT INTO `u_user_role` VALUES ('1', '1');
INSERT INTO `u_user_role` VALUES ('3', '1');
INSERT INTO `u_user_role` VALUES ('5', '1');
