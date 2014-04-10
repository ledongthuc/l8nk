package net.l8nk.service;

import java.math.BigInteger;
import java.sql.Date;

import net.l8nk.common.Utility;
import net.l8nk.data.DataRepository;
import net.l8nk.data.LinkData;
import net.l8nk.entity.Domain;
import net.l8nk.entity.Link;

public class LinkService {
	
	public static Link CreateLink(String longLink) {
		Link link = new Link();
		
		link.setLongLink(longLink);
		Domain domain = DomainService.createDomainFromLink(link.getLongLink());
		link.setDomainId(domain.getDomainId());
		link.setClicks(0);
		Date currentDate = new Date(System.currentTimeMillis());
		link.setCreatedDate(currentDate);
		link.setDescription("");
		String hashLink = Utility.md5(link.getLongLink());
		link.setHashLink(hashLink);
		link = DataRepository.getLinkData().insertIfNotExist(link);
		
		return link;
	}
	
	public static Link GetLinkById(BigInteger linkId) {
		LinkData linkData = DataRepository.getLinkData();
		return linkData.getLinkById(linkId);
	}
}
