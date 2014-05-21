-- --------------------------------------------------------
-- Host:                         l8nk.net
-- Server version:               5.5.36-MariaDB-log - MariaDB Server
-- Server OS:                    Linux
-- HeidiSQL Version:             8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for l8nk
CREATE DATABASE IF NOT EXISTS `l8nk` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `l8nk`;


-- Dumping structure for table l8nk.domain
CREATE TABLE IF NOT EXISTS `domain` (
  `domainId` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(200) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`domainId`),
  UNIQUE KEY `value` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.


-- Dumping structure for procedure l8nk.Domain_InsertIfNotExist
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Domain_InsertIfNotExist`(IN `domainValue` VARCHAR(200))
BEGIN

	INSERT IGNORE INTO `domain` SET `value` = domainValue  COLLATE utf8_unicode_ci;
	SELECT * FROM `domain` WHERE `value` = domainValue  COLLATE utf8_unicode_ci;

END//
DELIMITER ;


-- Dumping structure for table l8nk.feedback
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `email` varchar(200) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `content` varchar(500) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.


-- Dumping structure for table l8nk.linkowner
CREATE TABLE IF NOT EXISTS `linkowner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkId` bigint(20) DEFAULT NULL,
  `userAgent` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastUpdatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `linkId_userAgent` (`linkId`,`userAgent`),
  KEY `fk_userContain_link_idx` (`linkId`),
  KEY `index3` (`userAgent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.


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
CREATE DEFINER=`root`@`localhost` PROCEDURE `Link_InsertIfNotExist`(IN `pLongLink` VARCHAR(2048), IN `pDomainId` int, IN `pClicks` int, IN `pCreatedDate` datetime, IN `pDescription` VARCHAR(100), IN `pHashLink` VARCHAR(32))
BEGIN

	INSERT INTO
		`link` 
		(
			`longLink`, 
			`domainId`, 
			`clicks`, 
			`createdDate`, 
			`description`, 
			`hashLink`
		)
	SELECT 
		pLongLink,
		pDomainId,
		pClicks,
		pCreatedDate,
		pDescription,
		pHashLink
	FROM
		`link` 
	WHERE NOT EXISTS (
		SELECT 
			`hashLink`
		FROM 
			`link`
		WHERE 
			`hashLink` = pHashLink COLLATE utf8_unicode_ci
		LIMIT
			1
	) 
	limit 1;

	SELECT * FROM `link` WHERE `hashLink` = pHashLink  COLLATE utf8_unicode_ci;

END//
DELIMITER ;


-- Dumping structure for table l8nk.request
CREATE TABLE IF NOT EXISTS `request` (
  `requestId` int(11) NOT NULL AUTO_INCREMENT,
  `userAgent` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `requestDate` datetime DEFAULT NULL,
  `linkId` int(11) DEFAULT NULL,
  PRIMARY KEY (`requestId`),
  KEY `FK_request_link` (`linkId`),
  CONSTRAINT `FK_request_link` FOREIGN KEY (`linkId`) REFERENCES `link` (`linkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.


-- Dumping structure for table l8nk.user
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL,
  `cookieId` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `userAgent` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `cookieId_UNIQUE` (`cookieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.


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
