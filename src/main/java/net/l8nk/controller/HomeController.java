/**
 * 
 */
package net.l8nk.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.l8nk.common.Constants;
import net.l8nk.common.Utility;
import net.l8nk.entity.Link;
import net.l8nk.service.LinkService;
import net.l8nk.viewmodel.HomeModel;

/**
 * @author thuc.le
 *
 */
@WebServlet(name="HomeController", urlPatterns="/Home")
public class HomeController extends HttpServlet {

	public static final String VIEW = "/jsp/home.jsp";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2039720090277119601L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		HomeModel model = new HomeModel();
		request.setAttribute(Constants.PARAM_MODEL, model);
		this.handleView(VIEW, request, response);		
	};
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter(Constants.ACTION);
		if(action == null) {
			return;
		}
		
		String userId = this.getUserId(request, response);
		
		switch (action) {
			case Constants.ACTION_CREATE_LINK:
				this.createLink(userId, request, response);
				break;
		}
		
	}
	
	private void handleView(String viewName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
	}
	
	private void handleErrorMessage(String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HomeModel model = new HomeModel();
		model.setErrorMessage(message);
		
		request.setAttribute(Constants.PARAM_MODEL, model);
		this.handleView(VIEW, request, response);
	}
	
	private String getUserId(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equalsIgnoreCase(Constants.USER_ID)) {
				userId = cookie.getValue();
				break;
			}
		}
		
		if(userId == null || userId.isEmpty()) {
			userId = UUID.randomUUID().toString();
			Cookie userCookie = new Cookie(Constants.USER_ID, userId);
			response.addCookie(userCookie);
		}
		
		return userId;
	}
	
	private void createLink(String userId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String longLink = request.getParameter("longLinkInput");
		if(longLink == null || longLink.isEmpty()) {
			this.handleErrorMessage("We don't see your link, could you please check it again ?", request, response);
			return;
		}
		
		try {
			String hashLink = Utility.md5(longLink);
			Link linkModel = LinkService.CreateLink(longLink, hashLink);
			HomeModel model = new HomeModel();
			model.setLink(linkModel);
			
			request.setAttribute(Constants.PARAM_MODEL, model);
			this.handleView(VIEW, request, response);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.handleErrorMessage("An exception occurs, please try again !!!", request, response);
	}
	
}
