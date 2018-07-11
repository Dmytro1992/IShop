package webApplication.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.dao.TrainDao;
import webApplication.db.dao.impl.TrainDaoImpl;
import webApplication.db.models.Train;
import webApplication.exceprion.AppException;
import webApplication.exceprion.Messages;
//User find route
public class UserOrderFindRoute extends Command{
	private static final Logger LOG = Logger.getLogger(UserOrderFindRoute.class);
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,  AppException {
		LOG.debug("Command starts");
		String startingStation = request.getParameter("startingStation");
		String endStation = request.getParameter("endStation");
		HttpSession session = request.getSession();
		TrainDao tDao = new TrainDaoImpl();
		Tool tool = new Tool();
		//check validation parameters
		if(startingStation == "" || endStation == ""){
			System.out.println(Messages.ERROR_EMPTY_FIELDS);
			session.setAttribute("messageError", Messages.ERROR_EMPTY_FIELDS);
			throw new AppException(Messages.ERROR_EMPTY_FIELDS);
		}
		if(tool.onlyLetters(startingStation) != 0 || tool.onlyLetters(endStation)!=0){
			System.out.println(Messages.ERROR_VALID_ADMIN_ORDER_FIELD);
			session.setAttribute("messageError", Messages.ERROR_VALID_ADMIN_ORDER_FIELD);
			throw new AppException(Messages.ERROR_VALID_ADMIN_ORDER_FIELD);
		}
		LOG.trace("Find train route in DB");
		List<Train> train = tDao.findTrain(startingStation, endStation);
		
		if(train.isEmpty()){
			System.out.println(Messages.ERROR_NOT_FOUND_ROUTE);
			session.setAttribute("messageError", Messages.ERROR_NOT_FOUND_ROUTE);
			throw new AppException(Messages.ERROR_NOT_FOUND_ROUTE);
		}
		LOG.trace("Route found --> "+train);
		request.getSession().setAttribute("trainInfo", train);
		LOG.debug("Command finished");
		return Path.PAGE_MAIN;
	}

}
