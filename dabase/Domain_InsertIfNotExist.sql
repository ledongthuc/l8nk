DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Domain_InsertIfNotExist`(domainValue VARCHAR(200))
BEGIN

	INSERT IGNORE INTO `domain` SET `value` = domainValue;
	SELECT * FROM `domain` WHERE `value` = domainValue;

END$$
DELIMITER ;
