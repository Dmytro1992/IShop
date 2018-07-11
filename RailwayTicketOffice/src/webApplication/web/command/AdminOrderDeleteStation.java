package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.dao.IntermediateStationsDao;
import webApplication.db.dao.impl.IntermediateStationsDaoImpl;
import webApplication.exceprion.AppException;
import webApplication.exceprion.Messages;

//Delete station
public class AdminOrderDeleteStation extends Command {
	private static final Logger LOG = Logger.getLogger(AdminOrderDeleteStation.class);
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		IntermediateStationsDao iDao = new IntermediateStationsDaoImpl();
		Tool tool = new Tool();
		HttpSession session = request.getSession();

		// check to valid parameters
		if (request.getParameter("deleteStation").equals("")) {
			session.setAttribute("messageError", Messages.ERROR_EMPTY_FIELDS);
			throw new AppException(Messages.ERROR_EMPTY_FIELDS);

		} else if (tool.onlyDigits(request.getParameter("deleteStation")) != 0) {
			session.setAttribute("messageError", Messages.ERROR_VALID_ID);
			throw new AppException(Messages.ERROR_VALID_ID);

		}
		// check exist the station
		int stationId = Integer.parseInt(request.getParameter("deleteStation"));
		if (iDao.findStationId(stationId) == false) {
			session.setAttribute("messageError", Messages.ERROR_NOT_FOUND_ROUTE);
			throw new AppException(Messages.ERROR_NOT_FOUND_ROUTE);
		}
		LOG.trace("Delete a station by id --> " + stationId);
		//delete station
		iDao.deleteIntermediateStation(stationId);
		LOG.debug("Command finished");
		return Path.PAGE_ADMIN;
	}

}
