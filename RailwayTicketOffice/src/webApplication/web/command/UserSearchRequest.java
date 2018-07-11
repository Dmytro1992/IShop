package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.dao.RailwayDao;
import webApplication.db.dao.impl.RailwayDaoImpl;
import webApplication.db.models.Railway;
import webApplication.exceprion.AppException;
//find route with station
public class UserSearchRequest extends Command{
	private static final Logger LOG = Logger.getLogger(UserSearchRequest.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		int numberWay = Integer.parseInt(request.getParameter("idRoute"));
		Railway railway = new Railway();
		RailwayDao rDao = new RailwayDaoImpl();
		LOG.trace("Find route by id --> "+ numberWay);
		railway = rDao.findTrainRouteById(numberWay);
		LOG.trace("Route found --> "+ railway);
		request.getSession().setAttribute("railway", railway);
		LOG.debug("Command finished");
		return Path.PAGE_CLIENT_ORDER_FULL_ROUTE;
	}

}
