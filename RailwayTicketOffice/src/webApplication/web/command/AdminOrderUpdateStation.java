package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.dao.IntermediateStationsDao;
import webApplication.db.dao.RailwayDao;
import webApplication.db.dao.impl.IntermediateStationsDaoImpl;
import webApplication.db.dao.impl.RailwayDaoImpl;
import webApplication.exceprion.AppException;
import webApplication.exceprion.Messages;
//Admin order, update station
public class AdminOrderUpdateStation extends Command{
	private static final Logger LOG = Logger.getLogger(AdminOrderUpdateStation.class);
	private static final long serialVersionUID = -1157974162254523444L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		IntermediateStationsDao iDao = new IntermediateStationsDaoImpl();
		RailwayDao rDao = new RailwayDaoImpl();
		HttpSession session = request.getSession();
		String tableName;
		String columnName;
		String numberRout = request.getParameter("id");
		String reName = null;
		int id;
		//check exist the route
		if(iDao.findStationId(Integer.parseInt(numberRout))==false){
			session.setAttribute("messageError", Messages.ERROR_NOT_FOUND_ROUTE);
			throw new AppException(Messages.ERROR_NOT_FOUND_ROUTE);
		}
		//name of table
		tableName = "intermediate_stations";
		//name of column when need change
		columnName = request.getParameter("chooseItem");
		//check selected parameters
		if (columnName.equals("station")) {
			reName = request.getParameter("station");
		} else if (columnName.equals("arrival_time")) {
			reName = request.getParameter("arrival_time");
		} else if (columnName.equals("parking_time")) {
			reName = request.getParameter("parking_time1") + " - " + request.getParameter("parking_time2");
		} else if (columnName.equals("departure_time")) {
			reName = request.getParameter("departure_time");
		}
		//check to valid parameters
		if (reName.equals("") || numberRout.equals("")) {
			session.setAttribute("messageError", Messages.ERROR_EMPTY_FIELDS);
			throw new AppException(Messages.ERROR_EMPTY_FIELDS);
		}
		id = Integer.parseInt(numberRout);
		//Update route
		rDao.updateTrainWay(tableName, id, columnName, reName);
		LOG.trace("Update station "+columnName+" = "+reName);
		LOG.debug("Command finished");
		return Path.PAGE_ADMIN;
	}

}
