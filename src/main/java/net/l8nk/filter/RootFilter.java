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

import org.apache.log4j.Logger;

/**
 * @author thuc.le
 *
 */
@WebFilter(urlPatterns="/*")
public class RootFilter implements Filter {

	static Logger logger = Logger.getLogger(RootFilter.class);
	
	public final String[] resources = new String[]{
			".css", ".js", ".ico",
			".png", ".jpg", ".gif",
			".jsp"
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
		logger.info("RootFilter.doFilter, begin filter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String servletPath = httpRequest.getServletPath();
		logger.info("RootFilter.doFilter, servlet path:" + servletPath);
		
		for (String resource : resources) {
			if(servletPath.endsWith(resource)) {
				logger.info("RootFilter.doFilter, is resource: true" + resource);
				chain.doFilter(httpRequest, response);
				return;
			}
		}
		
		if(servletPath.startsWith("/App/")) {
			logger.info("RootFilter.doFilter, App");
			chain.doFilter(httpRequest, response);
			return;
		}
		
		String newPath = null;
		if(servletPath.equals("/")) {
			logger.info("RootFilter.doFilter, home page");
			newPath = "/App/Home";
		} else {
			logger.info("RootFilter.doFilter, short link page");
			newPath = "/ShortLink" + servletPath;
		}

		logger.info("RootFilter.doFilter, new path:" + newPath);
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
