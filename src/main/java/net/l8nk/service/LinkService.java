package net.l8nk.service;

import java.sql.Date;

import net.l8nk.data.DataRepository;
import net.l8nk.entity.Domain;
import net.l8nk.entity.Link;

public class LinkService {
	
	public static Link CreateLink(String longLink, String hashLink) {
		Link link = new Link();
		
		link.setLongLink(longLink);
		Domain domain = DomainService.createDomainFromLink(longLink);
		link.setDomainId(domain.getDomainId());
		link.setClicks(0);
		Date currentDate = new Date(System.currentTimeMillis());
		link.setCreatedDate(currentDate);
		link.setDescription("");
		link.setHashLink(hashLink);
		link = DataRepository.getLinkData().insertIfNotExist(link);
		return link;
	}
}
