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

 Date: 21/12/2022 11:39:54
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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES (1, 'Nhà bán lẻ lo \'mất Tết\' vì Apple trễ hẹn', '2022-12-09', 110, 'Kế hoạch kinh doanh, mục tiêu doanh thu, mở rộng của nhiều nhà bán lẻ trong nước có khả năng đổ vỡ nếu Apple tiếp tục trễ hẹn với iPhone 14.', NULL, 3, 0, 4, 101, 'AApple1', 'CApple1');
INSERT INTO `articles` VALUES (2, 'Thị trường nhà ở Trung Quốc sắp đón tin vui?', '2022-12-09', 111, 'Theo nguồn tin của Bloomberg, Bắc Kinh có thể hạ giọng về các chính sách bất động sản tại cuộc họp quan trọng vào tuần tới.', NULL, 2, 1, 4, 104, 'A2', 'C2');
INSERT INTO `articles` VALUES (3, 'Alexander Dang: Tôi về V.League không phải vì tiền', '2022-12-09', 116, 'Lần đầu tiên cầu thủ Việt kiều Na Uy lên tiếng về quyết định trở lại Việt Nam và nhận lời thi đấu cho CLB Nam Định từ mùa giải 2023.', NULL, 4, 0, 4, 102, 'A3', 'C3');
INSERT INTO `articles` VALUES (4, '10 nhà mốt xa xỉ có sức ảnh hưởng nhất 2022', '2022-12-09', 110, 'Trong năm 2022, nhiều thương hiệu thời trang trở thành hiện tượng với các thiết kế đình đám. Số khác vướng tranh cãi khi có bê bối.\r\n\r\n', NULL, 5, 0, 4, 101, 'A4', 'C4');
INSERT INTO `articles` VALUES (5, 'Nhiều người từ chối công việc không được nghỉ thứ 7', '2022-12-09', 114, 'Công ty Minh Huyền làm việc 9 tiếng/ngày để nghỉ thứ 7, chủ nhật. Việc được thư giãn cuối tuần giúp cô nạp lại năng lượng, có thời gian cho bản thân.\r\n\r\n', NULL, 6, 0, 4, 101, 'A5', 'C5');
INSERT INTO `articles` VALUES (6, 'Sự bất công khiến Messi vĩ đại hơn Pele', '2022-12-17', 118, 'So với Maradona hay Messi, thành tích của \"vua bóng đá\" Pele tại World Cup có phần thua kém do những hạn chế về thông tin và thống kê được ghi chép lại.', NULL, 4, 1, 4, 101, 'Messi', 'AMessi');
INSERT INTO `articles` VALUES (7, 'Đối tác vừa biến mất khỏi áo đấu của Manchester United làm ăn ra sa', '2022-12-17', 256, 'Từng là hãng công nghệ hứa hẹn với vốn hóa đạt đỉnh 10 tỷ euro, sức hút của TeamViewer đã mất dần kể từ khi hợp tác tài trợ với Manchester United.', NULL, 4, 1, 4, 102, 'ARonaldo', 'CRonal');
INSERT INTO `articles` VALUES (8, 'Apple phá kế hoạch của các hãng Android', '2022-12-17', 98, 'Các thương hiệu Android cố tăng giá điện thoại tầm trung để có lời. Tuy nhiên, kế hoạch không thể thực hiện thuận lợi khi tình hình thay đổi.', NULL, 3, 0, 4, 104, 'AApple', 'CApple');
INSERT INTO `articles` VALUES (9, 'Ông chủ sàn FTX lên tiếng', '2022-12-17', 512, 'Tối ngày 10/11 (theo giờ Việt Nam), Sam Bankman-Fried lên tiếng xin lỗi người dùng FTX và cho biết đang tìm cách khắc phục vấn đề thanh khoản của sàn giao dịch.', NULL, 10, 0, 4, 101, 'AFTX', 'CFtx');
INSERT INTO `articles` VALUES (10, 'NSND Công Lý sang Nhật Bản điều trị bệnh lần hai', '2022-12-17', 125, 'Chia sẻ của Ngọc Hà - vợ NSND Công Lý về hành trình sang Nhật Bản điều trị bệnh cho chồng nhận được sự quan tâm của người hâm mộ.', NULL, 5, 1, 4, 102, 'ANsnd', 'CNsnd');
INSERT INTO `articles` VALUES (11, 'Thù lao hai phút xuất hiện của Harry Styles\r\n', '2022-12-21', 156, 'Harry Styles gây bất ngờ khi thu về hơn 300.000 USD tiền cát-xê cho một phút xuất hiện trong bom tấn “Eternals”.', NULL, 5, 1, 4, 102, 'A11', 'C11');
INSERT INTO `articles` VALUES (12, 'Tiết lộ bất ngờ về \'Avatar 3\'\r\n', '2022-12-21', 521, 'Những tiến bộ công nghệ đã giúp Cameron cùng ê-kíp quay gần xong phần 3 và những cảnh đầu tiên của phần 4.', NULL, 5, 1, 4, 101, 'A12', 'C12');
INSERT INTO `articles` VALUES (13, 'Hé lộ thù lao triệu đô của dàn sao \'Avatar 2\'\r\n', '2022-12-21', 251, 'Phần tiếp theo của bom tấn khoa học viễn tưởng do James Cameron đạo diễn quy tụ dàn diễn viên đình đám. Họ nhận được mức thù lao xứng đáng, lên đến hàng chục triệu đô.\r\n', NULL, 5, 0, 4, 101, 'A13', 'C13');
INSERT INTO `articles` VALUES (14, 'Gucci bị chỉ trích\r\n', '2022-12-21', 222, 'Harry Styles và hãng thời trang xa xỉ Gucci đối mặt phản ứng tiêu cực khi tung bộ ảnh quảng bá chiến dịch mới nhất.\r\n', NULL, 7, 0, 4, 102, 'A14', 'C14');
INSERT INTO `articles` VALUES (15, 'Hơn 4 triệu người dự lễ ăn mừng chức vô địch World Cup của Argentina\r\n', '2022-12-21', 242, 'Đêm 20/12 (giờ Hà Nội), Lionel Messi và đồng đội được chào đón như những người hùng sau chiến công giành chức vô địch World Cup trên đất Qatar.\r\n', NULL, 7, 0, 4, 103, 'A15', 'C15');
INSERT INTO `articles` VALUES (16, 'Thái Lan đề nghị mua bản quyền 8 trận AFF Cup 2022 nhưng bị từ chối\r\n', '2022-12-21', 1024, 'Các CĐV Thái Lan vẫn đang hy vọng sẽ có một đài truyền hình trong nước mua bản quyền AFF Cup 2022 sau khi \"Voi chiến\" đá trận ra quân.\r\n', NULL, 4, 0, 4, 104, 'A16', 'C16');
INSERT INTO `articles` VALUES (17, 'Zidane hết kiên nhẫn với tuyển Pháp\r\n', '2022-12-21', 512, 'Zinedine Zidane không muốn chờ đợi thêm và có thể tìm kiếm CLB mới trong bối cảnh HLV Didier Deschamps khả năng tiếp tục công việc dẫn dắt tuyển Pháp.\r\n', NULL, 4, 1, 4, 104, 'A17', 'C17');
INSERT INTO `articles` VALUES (18, 'Ngôi sao gốc Pháp chuẩn bị ra mắt trên đất Lào\r\n', '2022-12-21', 756, 'Chiều 20/12, tuyển Lào có buổi tập làm quen SVĐ Quốc gia Lào. Tiền đạo Billy chuẩn bị có màn ra mắt ngay trên quê nhà ở AFF Cup 2022.\r\n', NULL, 4, 0, 4, 103, 'A18', 'C18');
INSERT INTO `articles` VALUES (19, 'Tư duy của Lionel Messi được các tỷ phú ủng hộ', '2022-12-21', 781, 'Lionel Messi coi việc cố gắng không ngừng là chìa khóa để khuếch đại những tài năng sẵn có. Đó là tư duy được nhiều tỷ phú doanh nhân ủng hộ.\r\n', NULL, 4, 1, 4, 101, 'A19', 'C19');
INSERT INTO `articles` VALUES (20, 'FTX đã khiến thị trường tiền mã hóa đi lùi lại vài năm', '2022-12-22', 12, 'Sự sụp đổ của sàn giao dịch tiền điện tử FTX đã phá vỡ niềm tin của nhiều nhà đầu tư, giờ họ chỉ có thể đánh giá xem thị trường sẽ được định hình lại thế nào trong những năm tới.\r\n', NULL, 4, 1, 4, 102, 'A20', 'C20');
INSERT INTO `articles` VALUES (21, 'Chuyên gia: Tiếp cận gói hỗ trợ lãi suất 2% khó vô cùng', '2022-12-19', 632, 'Tại Diễn đàn Kinh doanh và Pháp luật 2022, các chuyên gia đều chỉ ra nhiều vướng mắc, rủi ro trong quá trình ban hành văn bản lẫn thực thi, ảnh hưởng lớn đến doanh nghiệp.\r\n', NULL, 10, 1, 4, 104, 'A21', 'C21');
INSERT INTO `articles` VALUES (22, 'Doanh nghiệp chật vật làm nhà ở xã hội ngay từ khâu thủ tục', '2022-12-21', 241, 'Nhiều doanh nghiệp phát triển nhà ở xã hội cảm thấy “nản lòng” khi thủ tục hành chính quá rườm rà, trong khi chính quyền địa phương còn thờ ơ.\r\n', NULL, 10, 1, 4, 102, 'A22', 'C22');
INSERT INTO `articles` VALUES (23, 'Nam Long giảm 47% kế hoạch doanh số\r\n', '2022-12-21', 112, 'Nam Long điều chỉnh kế hoạch doanh số hợp đồng từ 23.300 tỷ đồng xuống còn 12.300 tỷ đồng trong năm nay, tương đương giảm 47% so với kế hoạch.\r\n', NULL, 1, 1, 4, 102, 'A23', 'C23');
INSERT INTO `articles` VALUES (24, '39 quỹ đầu tư mạo hiểm cam kết rót 1,5 tỷ USD vào Việt Nam\r\n', '2022-12-21', 126, 'Bất chấp những khó khăn về thị trường vốn, thị trường khởi nghiệp Việt Nam vẫn thu hút dòng vốn khổng lồ từ các quỹ, tổ chức.\r\n', NULL, 1, 1, 4, 102, 'A24', 'C24');
INSERT INTO `articles` VALUES (25, 'Nhiều CĐV Argentina ở Qatar không còn tiền về nước', '2022-12-21', 127, 'Nhiều người Argentina đã trắng tay sau kỳ World Cup đắt đỏ. Một số thậm chí không còn tiền để mua vé về nước.\r\n', NULL, 1, 1, 4, 102, 'A25', 'C25');
INSERT INTO `articles` VALUES (26, 'Chiêu trò của Spotify với tính năng Wrapped', '2022-12-21', 129, 'Thật trớ trêu khi hàng triệu người dùng ăn mừng và khoe khoang “chiến tích” là dữ liệu được Spotify thu thập suốt một năm trời.\r\n', NULL, 6, 1, 4, 103, 'A26', 'C26');
INSERT INTO `articles` VALUES (27, 'TikToker kiếm tiền từ nội dung bẩn như thế nào', '2022-12-23', 2456, 'Từ việc sản xuất nội dung \"bẩn\" để lôi kéo lượt xem, lượt tương tác, các TikToker có thể kiếm về thu nhập lớn nhờ tiếp thị liên kết.\r\n', NULL, 6, 0, 4, 104, 'A27', 'C27');
INSERT INTO `articles` VALUES (28, 'Elon Musk tìm CEO mới cho Twitter\r\n', '2022-12-23', 561, 'Tỷ phú giàu thứ 2 thế giới được cho đang tìm người giữ chức CEO Twitter, trong bối cảnh công chúng muốn ông từ bỏ vị trí này.\r\n', NULL, 3, 0, 4, 101, 'A28', 'C28');
INSERT INTO `articles` VALUES (29, 'Cách đón năm mới độc đáo ở các quốc gia', '2022-12-23', 841, 'Chỉ còn chưa đầy nửa tháng nữa, người dân toàn thế giới sẽ bước sang năm mới 2023. Hoạt động đón giao thừa tại mỗi quốc gia lại có những điểm độc đáo.\r\n', NULL, 3, 0, 4, 101, 'A29', 'C29');
INSERT INTO `articles` VALUES (30, 'Hành trình chế tác thảo dược gói gọn trong mô hình đất nặn thu nhỏ', '2022-12-23', 742, 'Những nghệ nhân trẻ Việt Nam đã tạo nên mô hình đất nặn thu nhỏ độc đáo và tinh xảo, khắc hoạ hành trình chế tác tinh hoa thảo dược chăm sóc tóc dành cho phái đẹp.\r\n', NULL, 3, 0, 4, 103, 'A30', 'C30');

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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

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
INSERT INTO `tags` VALUES (1, 'Văn hóa toàn cầu hóa');
INSERT INTO `tags` VALUES (2, 'Văn hóa');
INSERT INTO `tags` VALUES (3, 'Khảo luận về tết');
INSERT INTO `tags` VALUES (4, 'Mất tết vì Iphone 14');
INSERT INTO `tags` VALUES (5, 'Apple');
INSERT INTO `tags` VALUES (6, 'Thế giới di động');
INSERT INTO `tags` VALUES (7, 'Messi');
INSERT INTO `tags` VALUES (8, 'Trung Quốc');
INSERT INTO `tags` VALUES (9, 'Tài Chính');
INSERT INTO `tags` VALUES (10, 'Spotify');
INSERT INTO `tags` VALUES (11, 'Đầu tư');
INSERT INTO `tags` VALUES (12, 'Công nghệ mới');
INSERT INTO `tags` VALUES (13, 'Thời trang');
INSERT INTO `tags` VALUES (15, 'Gucci');
INSERT INTO `tags` VALUES (16, 'Avatar');
INSERT INTO `tags` VALUES (17, 'World Cup');
INSERT INTO `tags` VALUES (18, 'Tiền ảo');
INSERT INTO `tags` VALUES (19, 'Crypto');
INSERT INTO `tags` VALUES (20, 'Việt Nam');

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'AdminHai', '123456', 'Hải', '2022-12-09', 1, 1, 'Ngọc Hải', '2022-12-13', 'ngochai@gmail.com', 1, 1);
INSERT INTO `users` VALUES (2, 'PvKhoa', '123456', 'Khoa', '2022-12-09', 1, 3, 'Khoa', '2022-12-13', 'khoa@gmail.com', 1, 1);
INSERT INTO `users` VALUES (3, 'UserLuong', '123456', 'Phúc', '2022-12-09', 1, 2, 'Lương', '2022-12-13', 'Luong@gmail.com', 1, 1);
INSERT INTO `users` VALUES (4, 'BTVPhuc', '123456', 'Lương', '2022-12-09', 1, 4, 'Phúc', '2022-12-13', 'Phuc@gmail.com', 1, 1);
INSERT INTO `users` VALUES (5, 'AdminDat', '123456', 'Đạt', '2022-12-21', 1, 1, 'Tiến Đạt', '2022-12-21', 'Dat@gmail.com', 1, 1);
INSERT INTO `users` VALUES (6, 'PvHieu', '123456', 'Hieu', '2022-12-21', 1, 3, 'Hồng Hiệu', '2022-12-22', 'Hieu@gmai.com', 1, 1);
INSERT INTO `users` VALUES (7, 'UserCuong', '123456', 'Cường', '2022-12-22', 1, 1, 'Minh Cường', '2022-12-22', 'Cuong@gmail.com', 1, 1);
INSERT INTO `users` VALUES (8, 'BTVHoang', '123456', 'Hoàng', '2022-12-21', 1, 1, 'Việt Hoàng', '2022-12-22', 'Hoang@gmail.com', 1, 1);
INSERT INTO `users` VALUES (9, 'AdminHieu', '123456', 'Hiếu ', '2022-12-21', 1, 1, 'Bá Hiếu', '2022-12-21', 'Hieu@gmail.com', 1, 1);
INSERT INTO `users` VALUES (10, 'PvTrong', '123456', 'Trọng', '2022-12-21', 1, 1, 'Hữu Trọng', '2022-12-21', 'Trong@gmail.com', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
