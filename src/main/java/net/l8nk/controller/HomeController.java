/**
 * 
 */
package net.l8nk.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.l8nk.common.Constants;
import net.l8nk.entity.Link;
import net.l8nk.filter.RootFilter;
import net.l8nk.service.LinkService;
import net.l8nk.viewmodel.HomeModel;

/**
 * @author thuc.le
 *
 */
@WebServlet(name="HomeController", urlPatterns="/App/Home")
public class HomeController extends HttpBasedController {

	static Logger logger = Logger.getLogger(HomeController.class);
	
	public static final String VIEW = "/jsp/home.jsp";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2039720090277119601L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		logger.info("HomeController.doGet, begin process");
		
		String userCookie = getUserCookie(request, response);
		ArrayList<Link> recentLinks = LinkService.GetLinksByUserAgent(userCookie);
		
		HomeModel model = new HomeModel();
		model.setRecentLinks(recentLinks);
		request.setAttribute(Constants.PARAM_MODEL, model);
		
		logger.info("HomeController.doGet, begin return view: " + VIEW);
		this.handleView(VIEW, request, response);
	};
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter(Constants.ACTION);
		if(action == null) {
			return;
		}
		
		String userCookie = this.getUserCookie(request, response);
		
		switch (action) {
			case Constants.ACTION_CREATE_LINK:
				this.createLink(userCookie, request, response);
				break;
		}
	}
	
	private void handleErrorMessage(String message, HttpServletRequest request, HttpServletResponse response, ArrayList<Link> recentLinks) throws ServletException, IOException{
		HomeModel model = new HomeModel();
		model.setErrorMessage(message);
		model.setRecentLinks(recentLinks);
		
		request.setAttribute(Constants.PARAM_MODEL, model);
		this.handleView(VIEW, request, response);
	}
	
	private String getUserCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase(Constants.USER_ID)) {
					userId = cookie.getValue();
					break;
				}
			}
		}		
		
		if(userId == null || userId.isEmpty()) {
			userId = UUID.randomUUID().toString();
			Cookie userCookie = new Cookie(Constants.USER_ID, userId);
			userCookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(userCookie);
		}
		
		logger.info("HomeController.getUserCookie, userId:" + userId);
		
		return userId;
	}
	
	private void createLink(String userCookie, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String longLink = request.getParameter("longLinkInput");
		
		if(longLink == null || longLink.isEmpty()) {
			ArrayList<Link> recentLinks = LinkService.GetLinksByUserAgent(userCookie);
			this.handleErrorMessage("We don't see your link, could you please check it again ?", request, response, recentLinks);
			return;
		}
		
		try {
			Link linkModel = LinkService.CreateLink(longLink);
			LinkService.saveLinkToUser(linkModel.getLinkId(), userCookie);
			
			HomeModel model  = new HomeModel();
			model.setLink(linkModel);
			ArrayList<Link> recentLinks = LinkService.GetLinksByUserAgent(userCookie);
			model.setRecentLinks(recentLinks);
			
			request.setAttribute(Constants.PARAM_MODEL, model);
			this.handleView(VIEW, request, response);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Link> recentLinks = LinkService.GetLinksByUserAgent(userCookie);
		this.handleErrorMessage("An exception occurs, please try again !!!", request, response, recentLinks);
	}
	
	
	
}
