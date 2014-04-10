DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Link_GetById`(pLinkId bigint)
BEGIN
	SELECT 
		*
	FROM
		link
	WHERE
		linkId = pLinkId
	LIMIT 1;
END$$
DELIMITER ;
