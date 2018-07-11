package webApplication.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webApplication.Path;
//No command
public class NoCommand extends Command {
	private static final Logger LOG = Logger.getLogger(NoCommand.class);
	private static final long serialVersionUID = -2785976616686657267L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOG.debug("Command starts");
		String errorMessage = "No such command";
		LOG.error("Set the request attribute: errorMessage --> " + errorMessage);
		request.getSession().setAttribute("errorMessage", errorMessage);
		LOG.debug("Command finished");
		return Path.PAGE_ERROR;

	}

}