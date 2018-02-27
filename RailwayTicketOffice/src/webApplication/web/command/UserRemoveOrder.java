package webApplication.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.dao.TicketDao;
import webApplication.db.dao.impl.TicketDaoImpl;
import webApplication.db.models.UserOrderTicket;
import webApplication.exceprion.AppException;
//User remove ticket
public class UserRemoveOrder extends Command{
	private static final Logger LOG = Logger.getLogger(UserRemoveOrder.class);
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		TicketDao tDao = new TicketDaoImpl();
		int idTicket = Integer.parseInt(request.getParameter("idTicket"));
		HttpSession session = request.getSession();
		//get ticket
		List<UserOrderTicket> orderList = (List<UserOrderTicket>) session.getAttribute("orderList");
		//get id ticket
		int allPlaces = tDao.quanitity(idTicket);
		LOG.trace("Changing the number of available seats");
		//delete ticket
		for(int i = 0; i < orderList.size(); i++){
			if(orderList.get(i).getNumberTicket() == idTicket){
				int quantity = orderList.get(i).getQuantity();
				orderList.remove(i);
				//adding places
				tDao.updateTicketQuantity(idTicket, (allPlaces + quantity));
			}
		}
		LOG.debug("Command finished");
		return Path.PAGE_SHOPPING_CART;
	}

}
