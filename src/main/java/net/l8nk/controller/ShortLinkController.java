/**
 * 
 */
package net.l8nk.controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.l8nk.common.L8nkEncoding;
import net.l8nk.entity.Link;
import net.l8nk.service.LinkService;

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
		
		String encodedPart = request.getPathInfo().substring(1);
		System.out.println("ShortLinkController - servletPath: " + encodedPart);
		long linkId = L8nkEncoding.decode(encodedPart);
		
		Link link = LinkService.GetLinkById(linkId);
		if(link != null && link.getLongLink() != null && !link.getLongLink().isEmpty()) {
			String longLink = link.getLongLink();
			System.out.println("ShortLinkController - long link: " + longLink);
			response.setHeader("Location", longLink);
			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			return;
		}
		
		// Process 404 page
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
}
