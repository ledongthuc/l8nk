DELIMITER $$
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

END$$
DELIMITER ;
