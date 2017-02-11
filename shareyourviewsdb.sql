-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.17-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table shareyourviewdb.category: ~5 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`CAT_ID`, `CAT_NAME`) VALUES
	(1, 'Entertainment'),
	(2, 'Technology'),
	(3, 'Political'),
	(4, 'Social'),
	(5, 'Other');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping data for table shareyourviewdb.comment: ~5 rows (approximately)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`, `post_id`, `comment`, `image`, `user_id`, `timestamp`) VALUES
	(1, 1, 'Test Comment', 'Test Comment Image', '2', NULL),
	(2, 1, 'Test Comment1234', NULL, '2', NULL),
	(3, 1, 'Test Comment15674', NULL, '2', NULL),
	(4, 1, 'Test Comment324222', NULL, '2', NULL),
	(5, 1, 'Test Comment324222', NULL, '2', NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- Dumping data for table shareyourviewdb.post: ~2 rows (approximately)
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` (`id`, `user_id`, `subject`, `description`, `image`, `timestamp`) VALUES
	(1, '1', 'Test Subject', 'Test Description', 'TestImage', NULL),
	(2, '2', 'Test Subject 2', 'Test Description', NULL, NULL);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;

-- Dumping data for table shareyourviewdb.post_category: ~0 rows (approximately)
/*!40000 ALTER TABLE `post_category` DISABLE KEYS */;
INSERT INTO `post_category` (`id`, `post_id`, `cat_id`) VALUES
	(1, 1, 2);
/*!40000 ALTER TABLE `post_category` ENABLE KEYS */;

-- Dumping data for table shareyourviewdb.user: ~3 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `password`, `enabled`, `role_id`) VALUES
	('1', 'saurabh', 1, 2),
	('2', 'soumya', 0, 1),
	('admin', 'admin', 1, 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping data for table shareyourviewdb.userrole: ~2 rows (approximately)
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` (`id`, `role`) VALUES
	(1, 'ROLE_USER'),
	(2, 'ROLE_ADMIN');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;

-- Dumping data for table shareyourviewdb.user_profile: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`user_id`, `id`, `name`, `address`, `image`, `about_you`) VALUES
	('1', 1, 'saurabh srivastava', '151 first floor sector 2 vaishali', NULL, 'Testing');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
