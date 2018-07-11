package webApplication.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;


public class RequestEncodeFilter implements Filter {
	
	private static final Logger LOG = Logger.getLogger(RequestEncodeFilter.class);
	@SuppressWarnings("unused")
	private FilterConfig filterConfig = null;

	public RequestEncodeFilter() {
		LOG.debug("Request response encoder Filter object has been created");
	}

	public void init(FilterConfig filterConfig) {
		LOG.debug("Filter initialization starts");
		this.filterConfig = filterConfig;
		LOG.debug("Filter initialization finished");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.debug("Filter starts");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		chain.doFilter(request, response);

		LOG.trace("Request encoding  --> " + request.getCharacterEncoding());
		LOG.debug("Filter finished");	
	}

	public void destroy() {
		LOG.debug("Filter destruction starts");
		this.filterConfig = null;
		LOG.debug("Filter destruction finished");
	}
}