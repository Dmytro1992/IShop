package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webApplication.Path;

//logout 
public class Logout extends Command {
	private static final Logger LOG = Logger.getLogger(Logout.class);
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//remove parameters about user
		LOG.debug("Command starts");
		LOG.trace("Remove session attribute --> user");
		request.getSession().removeAttribute("user");
		LOG.trace("Remove session attribute --> loginIn");
		request.getSession().removeAttribute("loginIn");
		LOG.trace("Remove session attribute --> orderList");
		request.getSession().removeAttribute("orderList");
		LOG.debug("Command finished");
		return Path.PAGE_MAIN;
	}
}
