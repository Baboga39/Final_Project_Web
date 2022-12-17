/*
 Navicat Premium Data Transfer

 Source Server         : My Sql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : final_project_web

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 17/12/2022 10:02:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles`  (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `publish_date` date NOT NULL,
  `views` int NOT NULL,
  `abstracts` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL,
  `categories_id` int NOT NULL,
  `premium` tinyint(1) NOT NULL,
  `writer_id` int NOT NULL,
  `status_id` int NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `image_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE,
  INDEX `categories_id`(`categories_id` ASC) USING BTREE,
  INDEX `writer_id`(`writer_id` ASC) USING BTREE,
  INDEX `status_id`(`status_id` ASC) USING BTREE,
  FULLTEXT INDEX `title`(`title`, `content`, `abstracts`),
  CONSTRAINT `articles_ibfk_2` FOREIGN KEY (`writer_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `articles_ibfk_3` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`categories_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES (1, 'Nhà bán lẻ lo \'mất Tết\' vì Apple trễ hẹn', '2022-12-09', 110, 'Kế hoạch kinh doanh, mục tiêu doanh thu, mở rộng của nhiều nhà bán lẻ trong nước có khả năng đổ vỡ nếu Apple tiếp tục trễ hẹn với iPhone 14.', NULL, 3, 0, 4, 101, NULL, NULL);
INSERT INTO `articles` VALUES (2, 'Thị trường nhà ở Trung Quốc sắp đón tin vui?', '2022-12-09', 111, 'Theo nguồn tin của Bloomberg, Bắc Kinh có thể hạ giọng về các chính sách bất động sản tại cuộc họp quan trọng vào tuần tới.', NULL, 2, 1, 4, 104, NULL, NULL);
INSERT INTO `articles` VALUES (3, 'Alexander Dang: Tôi về V.League không phải vì tiền', '2022-12-09', 116, 'Lần đầu tiên cầu thủ Việt kiều Na Uy lên tiếng về quyết định trở lại Việt Nam và nhận lời thi đấu cho CLB Nam Định từ mùa giải 2023.', NULL, 4, 0, 4, 102, NULL, NULL);
INSERT INTO `articles` VALUES (4, '10 nhà mốt xa xỉ có sức ảnh hưởng nhất 2022', '2022-12-09', 110, 'Trong năm 2022, nhiều thương hiệu thời trang trở thành hiện tượng với các thiết kế đình đám. Số khác vướng tranh cãi khi có bê bối.\r\n\r\n', NULL, 5, 0, 4, 101, NULL, NULL);
INSERT INTO `articles` VALUES (5, 'Nhiều người từ chối công việc không được nghỉ thứ 7', '2022-12-09', 114, 'Công ty Minh Huyền làm việc 9 tiếng/ngày để nghỉ thứ 7, chủ nhật. Việc được thư giãn cuối tuần giúp cô nạp lại năng lượng, có thời gian cho bản thân.\r\n\r\n', NULL, 6, 0, 4, 101, NULL, NULL);

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`  (
  `categories_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `parent_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`categories_id`) USING BTREE,
  INDEX `pk_self`(`parent_id` ASC) USING BTREE,
  CONSTRAINT `pk_self` FOREIGN KEY (`parent_id`) REFERENCES `categories` (`categories_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES (1, 'Xuất bản', NULL);
INSERT INTO `categories` VALUES (2, 'Kinh doanh', NULL);
INSERT INTO `categories` VALUES (3, 'Công nghệ', NULL);
INSERT INTO `categories` VALUES (4, 'Thể thao ', NULL);
INSERT INTO `categories` VALUES (5, 'Giải trí', NULL);
INSERT INTO `categories` VALUES (6, 'Đời sống', NULL);
INSERT INTO `categories` VALUES (7, 'Lifestyle', NULL);
INSERT INTO `categories` VALUES (8, 'Nông sản', 2);
INSERT INTO `categories` VALUES (9, 'Hải sản', 2);
INSERT INTO `categories` VALUES (10, 'Chứng khoán', 2);

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `article_id` int NOT NULL,
  `user_id` int NOT NULL,
  `comment` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `article_id`(`article_id` ASC) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `articles` (`article_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (1, 1, 2, 'Bài viết hay', '2022-12-09 11:23:38');
INSERT INTO `comments` VALUES (2, 2, 2, 'Bài viết hay', '2022-12-09 11:23:38');
INSERT INTO `comments` VALUES (3, 2, 2, 'Bài viết hay', '2022-12-09 11:23:38');
INSERT INTO `comments` VALUES (4, 4, 2, 'Bài viết hay', '2022-12-09 11:23:38');
INSERT INTO `comments` VALUES (5, 5, 2, 'Bài viết hay', '2022-12-09 11:23:38');
INSERT INTO `comments` VALUES (6, 1, 2, 'Bài viết hay', '2022-12-09 11:23:38');
INSERT INTO `comments` VALUES (7, 1, 2, 'Bài viết hay', '2022-12-09 11:23:38');
INSERT INTO `comments` VALUES (8, 2, 2, 'Bài viết hay', '2022-12-09 11:23:38');
INSERT INTO `comments` VALUES (9, 3, 2, 'Bài viết hay', '2022-12-09 11:23:38');
INSERT INTO `comments` VALUES (10, 5, 3, 'Bài viết hay', '2022-12-09 11:25:13');

-- ----------------------------
-- Table structure for editor_manage_categories
-- ----------------------------
DROP TABLE IF EXISTS `editor_manage_categories`;
CREATE TABLE `editor_manage_categories`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `editor_id` int NOT NULL,
  `category_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `editor_id`(`editor_id` ASC) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE,
  CONSTRAINT `editor_manage_categories_ibfk_1` FOREIGN KEY (`editor_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `editor_manage_categories_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`categories_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of editor_manage_categories
-- ----------------------------

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags`  (
  `tags_id` int NOT NULL AUTO_INCREMENT,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`tags_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES (1, 'văn hóa toàn cầu hóa');
INSERT INTO `tags` VALUES (2, 'văn hóa');
INSERT INTO `tags` VALUES (3, 'khảo luận về tết');
INSERT INTO `tags` VALUES (4, 'Mất tết vì Iphone 14');
INSERT INTO `tags` VALUES (5, 'Apple');
INSERT INTO `tags` VALUES (6, 'Thế giới di động');

-- ----------------------------
-- Table structure for tags_articles
-- ----------------------------
DROP TABLE IF EXISTS `tags_articles`;
CREATE TABLE `tags_articles`  (
  `tags_id` int NOT NULL,
  `article_id` int NOT NULL,
  INDEX `tags_id`(`tags_id` ASC) USING BTREE,
  INDEX `article_id`(`article_id` ASC) USING BTREE,
  CONSTRAINT `tags_articles_ibfk_1` FOREIGN KEY (`tags_id`) REFERENCES `tags` (`tags_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tags_articles_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `articles` (`article_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tags_articles
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `issue_at` date NOT NULL,
  `expiration` int NOT NULL,
  `role_id` int NOT NULL,
  `second_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `otp` int NOT NULL,
  `otp_exp` int NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'AdminHai', '123456', 'Hải', '2022-12-09', 1, 1, 'Ngọc Hải', '2022-12-13', 'ngochai@gmail', 1, 1);
INSERT INTO `users` VALUES (2, 'PvKhoa', '123456', 'Khoa', '2022-12-09', 1, 3, 'Khoa', '2022-12-13', 'khoa@gmail', 1, 1);
INSERT INTO `users` VALUES (3, 'UserLuong', '123456', 'Phúc', '2022-12-09', 1, 2, 'Lương', '2022-12-13', 'Luong@gmail', 1, 1);
INSERT INTO `users` VALUES (4, 'BTVPhuc', '123456', 'Lương', '2022-12-09', 1, 4, 'Phúc', '2022-12-13', 'Phuc@gmail', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
