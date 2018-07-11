package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.dao.RailwayDao;
import webApplication.db.dao.impl.RailwayDaoImpl;
import webApplication.db.models.Railway;
import webApplication.exceprion.AppException;
import webApplication.exceprion.Messages;

// Add route in DB
public class AdminOrderAddRoute extends Command {
	private static final Logger LOG = Logger.getLogger(AdminOrderAddRoute.class);
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AppException {
		LOG.debug("Command starts");
		String startingStantion = request.getParameter("startingStantion");
		String departureTime = request.getParameter("departureTime");
		String endStation = request.getParameter("endStation");
		String arrivalTime = request.getParameter("arrivalTime");
		RailwayDao rDao = new RailwayDaoImpl();

		HttpSession session = request.getSession();
		Tool tool = new Tool();
		//Check to valid parameters
		if (startingStantion.equals("") || departureTime.equals("") || endStation.equals("") || arrivalTime.equals("")) {
			session.setAttribute("messageError", Messages.ERROR_EMPTY_FIELDS);
			throw new AppException(Messages.ERROR_EMPTY_FIELDS);
		}
		if (tool.onlyLetters(startingStantion) != 0 || tool.onlyLetters(endStation) != 0) {
			session.setAttribute("messageError", Messages.ERROR_VALID_ADMIN_ORDER_FIELD);
			throw new AppException(Messages.ERROR_VALID_ADMIN_ORDER_FIELD);
		}
		
		//Create new route
		Railway railway = new Railway(startingStantion, departureTime, endStation, arrivalTime);
		LOG.trace("Add trainway --> "+ railway);
		//Add route in DB
		rDao.insertTrainRoute(railway);
		LOG.debug("Command finished");
		return Path.PAGE_ADMIN;
	}

}
