/**
 * 
 */
package net.l8nk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author thuc.le
 *
 */
@WebServlet(name="ShortLinkController", urlPatterns="/ShortLink/*")
public class ShortLinkController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6007239317760557401L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ShortLinkController process");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
}
