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
import webApplication.exceprion.AppException;
import webApplication.exceprion.Messages;

//Delete route
public class AdminOrderDeleteRoute extends Command {
	private static final Logger LOG = Logger.getLogger(AdminOrderDeleteRoute.class);
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AppException {
		LOG.debug("Command starts");
		Tool tool = new Tool();
		RailwayDao rDao = new RailwayDaoImpl();
		HttpSession session = request.getSession();
		//check to valid parameters
		if (request.getParameter("deleteRoute").equals("")) {
			session.setAttribute("messageError", Messages.ERROR_EMPTY_FIELDS);
			throw new AppException(Messages.ERROR_EMPTY_FIELDS);

		} else if (tool.onlyDigits(request.getParameter("deleteRoute")) != 0) {
			session.setAttribute("messageError", Messages.ERROR_VALID_ID);
			throw new AppException(Messages.ERROR_VALID_ID);

		}
		//check exist the route
		int routeId = Integer.parseInt(request.getParameter("deleteRoute"));
		if (rDao.findRouteId(routeId) == false) {
			session.setAttribute("messageError", Messages.ERROR_NOT_FOUND_ROUTE);
			throw new AppException(Messages.ERROR_NOT_FOUND_ROUTE);
		}
		//delete route
		LOG.trace("Delete a route by id--> "+ routeId);
		rDao.deleteTrainRoute(routeId);
		
		LOG.debug("Command finished");
		return Path.PAGE_ADMIN;
	}
}
