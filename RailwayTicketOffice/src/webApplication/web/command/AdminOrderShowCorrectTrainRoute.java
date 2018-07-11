package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.exceprion.AppException;
//Admin menu show update menu
public class AdminOrderShowCorrectTrainRoute extends Command{
	private static final Logger LOG = Logger.getLogger(AdminOrderShowCorrectTrainRoute.class);
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		LOG.trace("Setting order --> 4");
		request.getSession().setAttribute("order", "4");
		LOG.debug("Command finished");
		return Path.PAGE_ADMIN;
	}

}
