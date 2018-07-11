package webApplication.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.dao.TicketDao;
import webApplication.db.dao.UserOrderTicketDao;
import webApplication.db.dao.impl.TicketDaoImpl;
import webApplication.db.dao.impl.UserOrderTicketDaoImpl;
import webApplication.db.models.UserOrderTicket;
import webApplication.exceprion.AppException;
import webApplication.exceprion.Messages;
//User buy ticket
public class UserBuyTicket extends Command{
	private static final Logger LOG = Logger.getLogger(UserBuyTicket.class);
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,  AppException {
		LOG.debug("Command starts");
		//get parameters
		int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
		String type = request.getParameter("type");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		UserOrderTicket ticket = new UserOrderTicket();
		List<UserOrderTicket> orderList;
		UserOrderTicketDao uDao = new UserOrderTicketDaoImpl();
		TicketDao tDao = new TicketDaoImpl();
		LOG.trace("Find ticket in DB by --> "+ trainNumber);
		
		//check type order ticket
		if(type.equals("compartment")){
			ticket = uDao.findTicketCompartment(trainNumber);
		}else if(type.equals("common")){
			ticket = uDao.findTicketCommon(trainNumber);
		}else{
			ticket = uDao.findTicketReservedSeat(trainNumber);
		}
		LOG.trace("Ticket found --> "+ ticket);
		//check availability
		if(ticket.getQuantity() - quantity < 0){
			System.out.println(Messages.ERROR_NO_TICKET);
			session.setAttribute("messageError", Messages.ERROR_NO_TICKET);
			throw new AppException(Messages.ERROR_NO_TICKET);
		}
		LOG.trace("Ñhanging the number of available seats");
		//take away the bought place
		tDao.updateTicketQuantity(ticket.getNumberTicket(), (ticket.getQuantity() - quantity));
		//set number of tickets purchased
		ticket.setQuantity(quantity);
		//set cost tickets
		ticket.setCost(ticket.getCost()*quantity);
		//bought tickets save in servletcontext
		if(session.getAttribute("orderList") == null){
			orderList = new ArrayList<>();
			orderList.add(ticket);
			session.setAttribute("orderList", orderList);
			System.out.println(orderList.toString());
		}else{
			orderList = (List<UserOrderTicket>) session.getAttribute("orderList");
			orderList.add(ticket);
			System.out.println(orderList.toString());
		}
		LOG.debug("Command finished");
		return Path.PAGE_MAIN;
	}
}
