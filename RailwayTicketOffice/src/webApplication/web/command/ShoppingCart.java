package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.models.Ticket;
import webApplication.exceprion.AppException;
//shopping cart
public class ShoppingCart extends Command{
	private static final Logger LOG = Logger.getLogger(ShoppingCart.class);
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		Ticket ticket =	(Ticket) request.getSession().getAttribute("ticket");
		LOG.trace("Get ticket --> "+ ticket);
		LOG.debug("Command finished");
		return Path.PAGE_SHOPPING_CART;
	}

}
