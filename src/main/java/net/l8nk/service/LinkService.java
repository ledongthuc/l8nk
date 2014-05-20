package net.l8nk.service;
import java.sql.Date;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import net.l8nk.common.Utility;
import net.l8nk.data.DataRepository;
import net.l8nk.data.LinkData;
import net.l8nk.entity.Domain;
import net.l8nk.entity.Link;

public class LinkService {
	
	static Logger logger = Logger.getLogger(LinkData.class);
	
	public static Link CreateLink(String longLink) {
		try {
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
		} catch(Exception ex) {
			logger.error("LinkService.CreateLink()", ex);
		}
		
		return null;
	}
	
	public static Link GetLinkById(long linkId) {
		try {
			LinkData linkData = DataRepository.getLinkData();
			return linkData.getLinkById(linkId);
		} catch(Exception ex) {
			logger.error("LinkService.CreateLink()", ex);
		}
		
		return null;
	}
	
	public static ArrayList<Link> GetLinksByUserAgent(String userAgent) {
		try {
			return DataRepository.getLinkData().getByUserAgent(userAgent);
		} catch(Exception ex) {
			logger.error("LinkService.CreateLink()", ex);
		}
		
		return null;
	}
	
	public static Link GetLinkByUserAgentAndLinkId(String userAgent, long linkId) {
		try {
			return DataRepository.getLinkData().getByUserAgent(userAgent, linkId);
		} catch(Exception ex) {
			logger.error("LinkService.GetLinkByUserAgentAndLinkId()", ex);
		}
		
		return null;
	}
	
	public static void UpdateUpdatedDateForOwner(String userAgent, long linkId) {
		try {
			DataRepository.getLinkData().UpdateUpdatedDateForOwner(userAgent, linkId);
		} catch(Exception ex) {
			logger.error("LinkService.UpdateUpdatedDateForOwner()", ex);
		}
	}
	
	public static void saveLinkToUser(long linkId, String userAgent) {
		try {
			if(GetLinkByUserAgentAndLinkId(userAgent, linkId) != null) {
				UpdateUpdatedDateForOwner(userAgent, linkId);
			}
			
			DataRepository.getLinkData().saveLinkToUser(linkId, userAgent);
		} catch(Exception ex) {
			logger.error("LinkService.CreateLink()", ex);
		}
	}
	
	public static void increaseCounter(long linkId) {
		try {
			DataRepository.getLinkData().increaseCounter(linkId);
		} catch(Exception ex) {
			logger.error("LinkService.CreateLink()", ex);
		}
	}
	
	public static void logRequest(String userAgent, long linkId) {
		try {
			DataRepository.getLinkData().logRequest(userAgent, linkId);
		} catch(Exception ex) {
			logger.error("LinkService.logRequest()", ex);
		}
	}
}
