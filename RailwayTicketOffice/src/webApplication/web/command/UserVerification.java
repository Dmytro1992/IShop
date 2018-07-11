package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.models.User;
//check user role
public class UserVerification extends Command {
	private static final Logger LOG = Logger.getLogger(UserVerification.class);
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOG.debug("Command starts");
		String forward = null;
		User user = (User) request.getSession().getAttribute("user");
		LOG.trace("User login --> " + user.getLogin());
		if (user.isRole()) {
			LOG.trace("User role --> admin");
			request.getSession().setAttribute("order", "1");

			forward = Path.PAGE_ADMIN;
		} else {
			LOG.trace("User role --> user");
			forward = Path.PAGE_SHOPPING_CART;
		}
		LOG.debug("Command finished");
		
		return forward;
	}
}
