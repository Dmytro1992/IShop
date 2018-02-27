package webApplication.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.exceprion.AppException;
import webApplication.web.command.Command;
import webApplication.web.command.CommandContainer;
import webApplication.web.command.ListGetCommand;
import webApplication.web.command.UserVerification;

/*
  Main servlet controller.
 */

@WebServlet("/Controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(Controller.class);
	
	private String button;
	private boolean flag = false;
	private String forward;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check get inquiry
		 button = request.getParameter("command");
		 if(button!=null){
			 if(new ListGetCommand().check(button)){
		    forward = process(request, response);
		    }
		 }
		 if (flag == false){
			 forward = process(request, response);
		 }
		    request.getRequestDispatcher(forward).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward = process(request, response);
	    flag=true;
	    response.sendRedirect("Controller");
	}
	
	/**
	 * Main method of this controller.
	 */
	
	private String process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LOG.debug("Controller starts");
		
		// extract command name from the request
		button = request.getParameter("command");
		LOG.trace("Request parameter: command --> " + button);
		
		// obtain command object by its name
			Command command = CommandContainer.get(button);
			LOG.trace("Obtained command --> " + command);
			
			// execute command and get forward address
			 forward = Path.PAGE_ERROR;
			try {
				if(button.equals(request.getSession().getAttribute("loginIn"))){
					forward = 	new UserVerification().execute(request, response);
				}else{
				forward = command.execute(request, response);
				}
				
			}
			catch (AppException e) {
				e.printStackTrace();
			}
			
			LOG.trace("Forward address --> " + forward);

			LOG.debug("Controller finished, now go to forward address --> " + forward);
			
			return forward;
			
	}
	
}