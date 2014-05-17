package net.l8nk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.l8nk.common.Constants;
import net.l8nk.common.Page;

public class HttpBasedController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4147423457590035957L;

	protected synchronized void  handleView(String viewName, HttpServletRequest request, HttpServletResponse response, Page page) throws ServletException, IOException {
		request.setAttribute(Constants.PARAM_PAGE, page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}
	
}
