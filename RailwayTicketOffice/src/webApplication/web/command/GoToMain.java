package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.exceprion.AppException;
//forward to page
public class GoToMain extends Command{
	private static final Logger LOG = Logger.getLogger(GoToMain.class);

	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		LOG.trace("Delete session attribute(trainInfo)");
		request.getSession().removeAttribute("trainInfo");
		LOG.debug("Command finished");
		return Path.PAGE_MAIN;
	}

}
