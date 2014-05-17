package net.l8nk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.l8nk.common.Page;

import org.apache.log4j.Logger;

@WebServlet(name="ResultController", urlPatterns="/App/Result")
public class ResultController extends HttpBasedController {

	static Logger logger = Logger.getLogger(ResultController.class);
	
	public static final String VIEW = "/jsp/donation-result.jsp";
	/**
	 * 
	 */
	private static final long serialVersionUID = 8947437752298525529L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("DonationController GET process");
		this.handleView(VIEW, request, response, Page.donation);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
