/**
 * 
 */
package net.l8nk.filter;

import java.io.IOException;
import java.net.URI;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @author thuc.le
 *
 */
@WebFilter(urlPatterns="/*")
public class RootFilter implements Filter {

	public final String[] resources = new String[]{
			".css", ".js", ".ico",
			".png", ".jpg", ".gif"
	};
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Root Filter - begin filter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String servletPath = httpRequest.getServletPath();
		System.out.println("Root Filter - servlet path:" + servletPath);
		
		for (String resource : resources) {
			if(servletPath.endsWith(resource)) {
				System.out.println("Root Filter - is resource: true" + resource);
				chain.doFilter(httpRequest, response);
				return;
			}
		}
		
		if(servletPath.startsWith("/App/")) {
			System.out.println("Root Filter - home page");
			chain.doFilter(httpRequest, response);
			return;
		}
		
		String newPath = null;
		if(servletPath.equals("/")) {
			System.out.println("Root Filter - home page");
			newPath = "/App/Home";
		} else {
			System.out.println("Root Filter - short link page");
			newPath = "/ShortLink" + servletPath;
		}

		System.out.println("Root Filter - new path:" + newPath);
		httpRequest.getRequestDispatcher(newPath).forward(httpRequest, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
