-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.5-10.0.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for l8nk
CREATE DATABASE IF NOT EXISTS `l8nk` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `l8nk`;


-- Dumping structure for table l8nk.domain
CREATE TABLE IF NOT EXISTS `domain` (
  `domainId` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(200) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`domainId`),
  UNIQUE KEY `value` (`value`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table l8nk.domain: ~5 rows (approximately)
/*!40000 ALTER TABLE `domain` DISABLE KEYS */;
INSERT IGNORE INTO `domain` (`domainId`, `value`) VALUES
	(107, 'http://abc'),
	(82, 'http://abc.com'),
	(84, 'http://facebook.com'),
	(80, 'http://mhjkjhb'),
	(86, 'http://thaosin.com.vn'),
	(79, 'http://thuc.com.vn');
/*!40000 ALTER TABLE `domain` ENABLE KEYS */;


-- Dumping structure for procedure l8nk.Domain_InsertIfNotExist
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Domain_InsertIfNotExist`(domainValue VARCHAR(200))
BEGIN

	INSERT IGNORE INTO `domain` SET `value` = domainValue;
	SELECT * FROM `domain` WHERE `value` = domainValue;

END//
DELIMITER ;


-- Dumping structure for table l8nk.feedback
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `email` varchar(200) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `content` varchar(500) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table l8nk.feedback: ~0 rows (approximately)
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT IGNORE INTO `feedback` (`id`, `name`, `email`, `content`) VALUES
	(1, 'ab', '0', '0'),
	(2, 'asdas', 'asd@gmail.com', 'thuc');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;


-- Dumping structure for table l8nk.link
CREATE TABLE IF NOT EXISTS `link` (
  `linkId` int(11) NOT NULL AUTO_INCREMENT,
  `longLink` varchar(2048) COLLATE utf8_unicode_ci DEFAULT NULL,
  `domainId` int(11) DEFAULT NULL,
  `clicks` int(11) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastAccessed` datetime DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hashLink` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`linkId`),
  UNIQUE KEY `hashLink_UNIQUE` (`hashLink`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table l8nk.link: ~7 rows (approximately)
/*!40000 ALTER TABLE `link` DISABLE KEYS */;
INSERT IGNORE INTO `link` (`linkId`, `longLink`, `domainId`, `clicks`, `createdDate`, `lastAccessed`, `description`, `hashLink`) VALUES
	(60, 'http://thuc.com.vn', 79, 0, '2014-04-10 00:00:00', NULL, '', '{��/�{�m{z]�ap�'),
	(61, 'http://mhjkjhb/gkjjhh/kjhj/kjhkhjl', 80, 0, '2014-04-10 00:00:00', NULL, '', 'a����b�z���f'),
	(63, 'http://abc.com', 82, 0, '2014-04-10 00:00:00', NULL, '', '�D3���4Z	��dB$�'),
	(65, 'http://facebook.com/ledongthuc', 84, 0, '2014-04-10 00:00:00', NULL, '', 'ͳ�[Xb���K�!'),
	(67, 'http://thaosin.com.vn', 86, 0, '2014-04-10 00:00:00', NULL, '', '��U�=K�#eq�ˑ�j'),
	(83, 'http://thuc.com.vn/', 79, 0, '2014-04-21 00:00:00', NULL, '', '���ᇳ�A����e'),
	(88, 'http://abc', 107, 0, '2014-04-21 00:00:00', NULL, '', '�Bk��M����t�'),
	(92, 'http://thuc.com.vn/a', 79, 0, '2014-04-22 00:00:00', NULL, '', '_VN��k��ܢ\rP?p');
/*!40000 ALTER TABLE `link` ENABLE KEYS */;


-- Dumping structure for table l8nk.linkowner
CREATE TABLE IF NOT EXISTS `linkowner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkId` int(11) DEFAULT NULL,
  `userAgent` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `linkId_userAgent` (`linkId`,`userAgent`),
  KEY `fk_userContain_link_idx` (`linkId`),
  KEY `index3` (`userAgent`),
  CONSTRAINT `fk_userContain_link` FOREIGN KEY (`linkId`) REFERENCES `link` (`linkId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table l8nk.linkowner: ~5 rows (approximately)
/*!40000 ALTER TABLE `linkowner` DISABLE KEYS */;
INSERT IGNORE INTO `linkowner` (`id`, `linkId`, `userAgent`) VALUES
	(27, 60, '5dc9eb9b-c734-407d-9a6d-cd917baaf626'),
	(26, 60, '725b2c7f-9fde-4030-aa0d-59f57022d9a4'),
	(29, 60, 'b3d2d3f0-aa1d-426c-aded-08991c9afe36'),
	(17, 83, '725b2c7f-9fde-4030-aa0d-59f57022d9a4'),
	(22, 88, '725b2c7f-9fde-4030-aa0d-59f57022d9a4'),
	(30, 92, 'b3d2d3f0-aa1d-426c-aded-08991c9afe36');
/*!40000 ALTER TABLE `linkowner` ENABLE KEYS */;


-- Dumping structure for procedure l8nk.Link_GetById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Link_GetById`(pLinkId bigint)
BEGIN
	SELECT 
		*
	FROM
		link
	WHERE
		linkId = pLinkId
	LIMIT 1;
END//
DELIMITER ;


-- Dumping structure for procedure l8nk.Link_InsertIfNotExist
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Link_InsertIfNotExist`(pLongLink VARCHAR(2048), pDomainId int, pClicks int, pCreatedDate datetime, pDescription VARCHAR(100), pHashLink VARCHAR(32))
BEGIN

	INSERT IGNORE INTO 
		`link` 
	SET 
		`longLink` = pLongLink, 
		`domainId` = pDomainId, 
		`clicks` = pClicks, 
		`createdDate` = pCreatedDate, 
		`description` = pDescription, 
		`hashLink` = pHashLink;
	SELECT * FROM `link` WHERE `hashLink` = pHashLink;

END//
DELIMITER ;


-- Dumping structure for table l8nk.request
CREATE TABLE IF NOT EXISTS `request` (
  `requestId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `linkId` int(11) DEFAULT NULL,
  PRIMARY KEY (`requestId`),
  KEY `FK_request_user` (`userId`),
  KEY `FK_request_link` (`linkId`),
  CONSTRAINT `FK_request_link` FOREIGN KEY (`linkId`) REFERENCES `link` (`linkId`),
  CONSTRAINT `FK_request_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table l8nk.request: ~0 rows (approximately)
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
/*!40000 ALTER TABLE `request` ENABLE KEYS */;


-- Dumping structure for table l8nk.user
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL,
  `cookieId` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `userAgent` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `cookieId_UNIQUE` (`cookieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table l8nk.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Dumping structure for procedure l8nk.User_InsertUser
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `User_InsertUser`(pCookieId varchar(45), pUserAgent varchar(45))
BEGIN
	INSERT IGNORE INTO `user` SET `cookieId` = pCookieId, `UserAgent` = pUserAgent;
	SELECT * FROM `user` WHERE `cookieId` = pCookieId;
END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
