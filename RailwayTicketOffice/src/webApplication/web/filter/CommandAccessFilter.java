package webApplication.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.models.User;



/*
 * Security filter

 */
@WebFilter("/Controller")
public class CommandAccessFilter implements Filter {
	private static final Logger LOG = Logger.getLogger(CommandAccessFilter.class);

	public void destroy() {
		LOG.debug("Filter destruction starts");
		// do nothing
		LOG.debug("Filter destruction finished");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.debug("Filter starts");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if (accessAllowed(request)) {
			LOG.debug("Filter finished");
			chain.doFilter(request, response);
		} else {
			String errorMessasge = "You do not have permission to access the requested resource";
			session.setAttribute("messageError", errorMessasge);
			request.removeAttribute("command");
			LOG.trace("Set the request attribute: errorMessage --> " + errorMessasge);
			request.getRequestDispatcher(Path.PAGE_ERROR).forward(request, response);
		}

	}

	private boolean accessAllowed(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String button = request.getParameter("command");
		if (button == null) {
			return true;
		}
		if (user != null) {
			if (button.equals("register_page") || button.equals("login_page") || button.equals("Sign in") || button.equals("Register")) {
				return false;
			}
		}

		return true;

	}

	public void init(FilterConfig fConfig) throws ServletException {
		LOG.debug("Filter initialization starts");
		// do nothing
		LOG.debug("Filter initialization finished");
	}

}
