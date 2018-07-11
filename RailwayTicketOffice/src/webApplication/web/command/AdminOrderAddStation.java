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
import webApplication.db.models.IntermediateStations;
import webApplication.exceprion.AppException;
import webApplication.exceprion.Messages;

//Add station to DB
public class AdminOrderAddStation extends Command{
	private static final Logger LOG = Logger.getLogger(AdminOrderAddStation.class);
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		LOG.debug("Command starts");
		
		String numberRout = request.getParameter("numberRout");
		String stationName = request.getParameter("stationName");
		String stationArrivalTime = request.getParameter("stationArrivalTime");
		String parkingTime1 = request.getParameter("parkingTime1");
		String parkingTime2 = request.getParameter("parkingTime2");
		String stationDepartureTime = request.getParameter("stationDepartureTime");
		
		RailwayDao rDao = new RailwayDaoImpl();
		IntermediateStationsDao iDao = new IntermediateStationsDaoImpl();
		HttpSession session = request.getSession();
		Tool tool = new Tool();
		//check to valid parameters
		if (numberRout.equals("") || stationName.equals("") || stationArrivalTime.equals("") || parkingTime1.equals("") || parkingTime2.equals("") || stationDepartureTime.equals("")) {
			session.setAttribute("messageError", Messages.ERROR_EMPTY_FIELDS);
			throw new AppException(Messages.ERROR_EMPTY_FIELDS);
		}
		if (tool.onlyLetters(stationName) != 0) {
			session.setAttribute("messageError", Messages.ERROR_VALID_ADMIN_ORDER_FIELD);
			throw new AppException(Messages.ERROR_VALID_ADMIN_ORDER_FIELD);
		}
		if (tool.onlyDigits(numberRout) != 0 && !numberRout.equals("")) {
			session.setAttribute("messageError", Messages.ERROR_VALID_ID);
			throw new AppException(Messages.ERROR_VALID_ID);
		}
		
		if(rDao.findRouteId(Integer.parseInt(numberRout))==false){
			session.setAttribute("messageError", Messages.ERROR_NOT_FOUND_ROUTE);
			throw new AppException(Messages.ERROR_NOT_FOUND_ROUTE);
		}
		//Create new station
		IntermediateStations stations = new IntermediateStations(stationName, stationArrivalTime, (parkingTime1 + " - " + parkingTime2), stationDepartureTime);
		LOG.trace("Add intermediate station --> "+stations);
		//Add station in DB
		iDao.insertIntermediateStation(stations);
		//connect the path and the stations
		iDao.insertFullWay(Integer.parseInt(numberRout));
		
		LOG.debug("Command finished");
		return Path.PAGE_ADMIN;
	}

	
}
