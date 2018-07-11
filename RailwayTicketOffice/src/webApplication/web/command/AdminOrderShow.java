package webApplication.web.command;

import java.io.IOException;
import java.util.List;

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
//Admin menu show route with station
public class AdminOrderShow extends Command {
	private static final Logger LOG = Logger.getLogger(AdminOrderShow.class);
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		RailwayDao rDao = new RailwayDaoImpl();
		HttpSession session = request.getSession();
		List<Railway> route = rDao.findTrainRoute();
		session.setAttribute("showRoute", route);
		session.setAttribute("order", "1");
		LOG.trace("Instal --> order = 1");

		LOG.debug("Command finished");
		return Path.PAGE_ADMIN;
	}
}