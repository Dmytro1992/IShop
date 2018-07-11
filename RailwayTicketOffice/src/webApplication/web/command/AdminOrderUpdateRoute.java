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

//Admin order, update route
public class AdminOrderUpdateRoute extends Command {
	private static final Logger LOG = Logger.getLogger(AdminOrderUpdateRoute.class);
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AppException {
		LOG.debug("Command starts");
		
		RailwayDao rDao = new RailwayDaoImpl();
		HttpSession session = request.getSession();
		String tableName;
		String columnName;
		int id;
		String reName = null;
		String numberRout = request.getParameter("id");

		//check exist the route
			if(rDao.findRouteId(Integer.parseInt(numberRout))==false){
				session.setAttribute("messageError", Messages.ERROR_NOT_FOUND_ROUTE);
				throw new AppException(Messages.ERROR_NOT_FOUND_ROUTE);
			}
			//name of table
			tableName = "train_way";
			//name of column when need change
			columnName = request.getParameter("chooseItem");
			//check selected parameters
			if (columnName.equals("starting_station")) {
				reName = request.getParameter("starting_station");
			} else if (columnName.equals("departure_time")) {
				reName = request.getParameter("departure_time");
			} else if (columnName.equals("end_station")) {
				reName = request.getParameter("end_station");
			} else if (columnName.equals("arrival_time")) {
				reName = request.getParameter("arrival_time");
			}
			//check to valid parameters
			if (reName.equals("") || numberRout.equals("")) {
				System.out.println(Messages.ERROR_EMPTY_FIELDS);
				session.setAttribute("messageError", Messages.ERROR_EMPTY_FIELDS);
				throw new AppException(Messages.ERROR_EMPTY_FIELDS);
			}
			if (new Tool().onlyDigits(numberRout) != 0) {
				System.out.println(Messages.ERROR_VALID_ID);
				session.setAttribute("messageError", Messages.ERROR_VALID_ID);
				throw new AppException(Messages.ERROR_VALID_ID);
			}
			
			id = Integer.parseInt(numberRout);
			//Update route
			rDao.updateTrainWay(tableName, id, columnName, reName);
			LOG.trace("Update route "+columnName+" = "+reName);
			LOG.debug("Command finished");
		return Path.PAGE_ADMIN;
	}
}
