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
		String uri = httpRequest.getRequestURI();
		System.out.println("Root Filter - uri:" + uri);
		
		for (String resource : resources) {
			if(uri.endsWith(resource)) {
				chain.doFilter(httpRequest, response);
			}
		}
		
		if(uri.endsWith("/App/Home")) {
			chain.doFilter(httpRequest, response);
			return;
		}

		httpRequest.getRequestDispatcher(uri).forward(httpRequest, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
