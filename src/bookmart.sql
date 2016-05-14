/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : bookmart

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-05-12 15:04:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `owner_id` int(12) DEFAULT NULL,
  `pic` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `upload_time` int(12) DEFAULT NULL,
  `price` int(12) DEFAULT NULL,
  `type` int(12) DEFAULT NULL,
  `hot` int(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'Introduction to computer algorithms', '1', '1.jpg', '全书选材经典、内容丰富、结构合理、逻辑清晰，对本科生的数据结构课程和研究生的算法课程都是非常实用的教材，在IT专业人员的职业生涯中，本书也是一本案头必备的参考书或工程实践手册。', '1462955709', '80', '1', '20');
INSERT INTO `books` VALUES ('2', '失控', '2', '2.jpg', '这是一部思考人类社会（或更一般意义上的复杂系统）进化的“大部头”著作，对于那些不惧于“头脑体操”的读者来说，必然会开卷有益。', '1462955710', '88', '2', '18');
INSERT INTO `books` VALUES ('3', '创业维艰', '2', '3.jpg', '本·霍洛维茨，硅谷顶级投资人，与网景之父马克·安德森联手合作18年，有着丰富的创业和管理经验。2009年创立风险投资公司A16Z，被外媒誉为“硅谷最牛的50个天使投资人”之一，先后在初期投资了Facebook、Twitter、Groupon、Skype，是诸多硅谷新贵的创业导师。', '1462953333', '49', '2', '16');
INSERT INTO `books` VALUES ('4', '浪潮之巅', '2', '4.jpg', '在极度商业化的今天，科技的进步和商机是分不开的。因此，本书也系统地介绍了影响到科技浪潮的风险投资公司，诸如 KPCB 和红杉资本，以及百年来为科技捧场的投资银行，例如高盛公司，等等。', '1462955733', '55', '2', '14');
INSERT INTO `books` VALUES ('5', '大数据时代', '1', '5.jpg', '本书认为大数据的核心就是预测。大数据将为人类的生活创造前所未有的可量化的维度。大数据已经成为了新发明和新服务的源泉，而更多的改变正蓄势待发。书中展示了谷歌、微软、亚马逊、IBM、苹果、facebook、twitter、VISA等大数据先锋们最具价值的应用案例。', '1462933333', '49', '2', '14');
INSERT INTO `books` VALUES ('6', 'HTTP权威指南', '1', '6.jpg', '超文本传输协议（Hypertext Transfer Protocol，HTTP）是在万维网上进行通信时所使用的协议方案。HTTP有很多应用，但最著名的是用于web浏览器和web服务器之间的双工通信。', '1462955555', '109', '1', '10');
INSERT INTO `books` VALUES ('7', '自控力', '1', '7.jpg', '《自控力》内容简介：作为一名健康心理学家，凯利•麦格尼格尔博士的工作就是帮助人们管理压力，并在生活中做出积极的改变。', '146295890', '39', '3', '7');
INSERT INTO `books` VALUES ('8', '活着为了讲述', '1', '8.jpg', '在本书中，马尔克斯没有采用线性的时间顺序，而是自如地在时间、事件中切换，既有对人生中的难忘事件、重要时刻的讲述，也有对他所珍惜的家人和朋友的回忆，几乎每一段都是一个精彩的故事：\r\n外祖母神奇的鬼怪世界、外祖父的战争故事、挥之不去的老宅记忆、求学经历中的奇遇与机遇、启发并滋养过他的记者生涯……搞不清楚幸福与疯癫区别的亲戚、一起经受过狂风暴雨考验的朋友、萍水相逢却难以忘记的过客……\r\n正如他所言，生活不是我们活过的日子，而是我们记住的日子，我们为了讲述而在记忆中重现的日子。', '1462955222', '55', '4', '8');
INSERT INTO `books` VALUES ('9', '简约至上', '1', '9.jpg', '追求简单易用是人类的本性，无论是互联网产品。还是移动应用。亦或其他交互式设计，简单易用始终都是赢得用户的关键。同时，简单易用的程度也与产品寿命的长短密切相关。', '1462955111', '35', '4', '6');
INSERT INTO `books` VALUES ('10', '耶路撒冷三千年', '1', '10.jpg', '美国前总统克林顿2011年年度选书，基辛格视 若珍宝的经典巨作。读《耶路撒冷三千年》，了解真实的耶路撒冷，更是明白世界为何演变成今天的模样。', '1462955722', '78', '5', '10');
INSERT INTO `books` VALUES ('11', '彼岸花', '2', '11.jpg', '《彼岸花》是安妮宝贝的第一部长篇小说。乔和南生都是刚出道不久，带着浓厚学生味。书中以他们为主线，辗转于上海、杭州、南京、广州等城市，生活、工作、爱情，复杂多变，他们的命运也一样。', '1462955790', '20', '5', '7');
INSERT INTO `books` VALUES ('12', '倾城之恋', '2', '12.jpg', '一对现实庸俗的男女，在战争的兵荒马乱之中被命运掷骰子般地掷到了一起，于“一刹那”体会到了“一对平凡的夫妻”之间的“一点真心”⋯⋯张爱玲是作为中国现代文学史上的一位杰出作家，而不是作为一个怪人、异人而存在的。也许她将不仅仅属于现代文学史。遥想几十年、几百年后，她会像她欣赏的李清照一样，在整个中国文学史上占据一个稳定的位置也说不定，而我们知道，那时候今天为我们所熟知的许多现代作家肯定都将被忽略不计了。', '1462955800', '11', '6', '8');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_id` int(12) DEFAULT NULL,
  `books_id` int(12) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '3', '毫无疑问，《从0到1》与《创业维艰》之所以能有如此大的影响力，与其作者的成功光环离不开。以《创业维艰》的本·霍洛维茨为例，在过去的十五年时间里连续创业三次，从互联网浏览器到Saas云服务再到风险投资，霍洛维茨成为硅谷最具影响力的投资人之一，这本书几乎全景展现了霍洛维茨早年创业期间如何应付来自各方的压力和挑战，大量人物、对话细节堪比一本商业小说。然而在书的下半段，霍洛维茨笔锋一转，开始贩卖鸡汤，从第四章“陷入绝境”开始，基调被调整到大多数商业类鸡汤辅导读物的范畴内，霍洛维茨用一个个疑问句式开始了“授课”过程，类似“大公司高管为何难以胜任小公司的工作”等话题成为霍氏话题的核心。');

-- ----------------------------
-- Table structure for `flow`
-- ----------------------------
DROP TABLE IF EXISTS `flow`;
CREATE TABLE `flow` (
  `user_id` int(12) NOT NULL DEFAULT '0',
  `books_id` int(12) NOT NULL DEFAULT '0',
  `description` varchar(300) DEFAULT NULL,
  `time` int(12) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`books_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of flow
-- ----------------------------
INSERT INTO `flow` VALUES ('1', '2', null, '1462955710');
INSERT INTO `flow` VALUES ('1', '3', null, '1462955710');
INSERT INTO `flow` VALUES ('1', '11', null, '1462955710');

-- ----------------------------
-- Table structure for `hot`
-- ----------------------------
DROP TABLE IF EXISTS `hot`;
CREATE TABLE `hot` (
  `user_id` int(12) NOT NULL DEFAULT '0',
  `books_id` int(12) NOT NULL DEFAULT '0',
  `description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`books_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hot
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` int(12) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '1234', 'admin@pku.edu.cn', '000000000000');
INSERT INTO `user` VALUES ('2', 'xwj', '1234', 'xwj@pku.edu.cn', '000000001234');
INSERT INTO `user` VALUES ('3', '123', '123', '123', '000000000123');
