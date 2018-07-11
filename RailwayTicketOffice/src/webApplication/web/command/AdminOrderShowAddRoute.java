package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.exceprion.AppException;
//Admin menu show add menu
public class AdminOrderShowAddRoute extends Command{
	private static final Logger LOG = Logger.getLogger(AdminOrderShowAddRoute.class);
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		request.getSession().setAttribute("order", "3");
		LOG.trace("Setting order --> 3");
		LOG.debug("Command finished");
		return Path.PAGE_ADMIN;
	}
}
