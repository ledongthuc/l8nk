/**
 * 
 */
package net.l8nk.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.l8nk.common.L8nkEncoding;
import net.l8nk.common.Utility;
import net.l8nk.entity.Link;
import net.l8nk.service.LinkService;

/**
 * @author thuc.le
 *
 */
@WebServlet(name="ShortLinkController", urlPatterns="/ShortLink/*")
public class ShortLinkController extends HttpServlet {

	static Logger logger = Logger.getLogger(ShortLinkController.class);
	public String[] partedSocialAgent = new String[] {
			"facebookexternalhit", "LinkedInBot"
	};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6007239317760557401L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("ShortLinkController process");
		String encodedPart = request.getPathInfo().substring(1);
		logger.info("ShortLinkController - servletPath: " + encodedPart);
		long linkId = L8nkEncoding.decode(encodedPart);
		
		Link link = LinkService.GetLinkById(linkId);
		if(link != null && link.getLongLink() != null && !link.getLongLink().isEmpty()) {
			LinkService.increaseCounter(linkId);
			String userAgent = request.getHeader("User-Agent");
			LinkService.logRequest(userAgent, linkId);
			
			String longLink = link.getLongLink();
			logger.info("ShortLinkController - long link: " + longLink);
			
			if(this.IsSocialAgent(request)) {
				String rawResponseData = Utility.getTextFromUrl(longLink);
				response.getWriter().append(rawResponseData);
			} else {
				response.setHeader("Location", longLink);
				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			}
		}
		
		// Process 404 page
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	private boolean IsSocialAgent(HttpServletRequest request) {
		try {
			String userAgent = request.getHeader("User-Agent");
			
			for(String partedSocialAgent : this.partedSocialAgent) {
				if(userAgent.contains(partedSocialAgent)) {
					return true;
				}
			}
		} catch(Exception ex) {
			logger.error("ShortLinkController.IsSocialAgent", ex);
		}
		return false;
	}
}
