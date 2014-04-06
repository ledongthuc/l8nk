/**
 * 
 */
package net.l8nk.monitor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.l8nk.entity.SharedObject;

/**
 * @author thuc.le
 *
 */
@WebServlet(name="LinkMonitor", urlPatterns="/LinkMonitor")
public class LinkMonitor extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9210481140935735921L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter output = response.getWriter();
		
		int linksSize = SharedObject.CachedLinks.size();
		output.println(linksSize);
	}
	
}
