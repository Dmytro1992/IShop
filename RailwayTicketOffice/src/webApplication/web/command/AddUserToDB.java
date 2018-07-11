package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.dao.UserDao;
import webApplication.db.models.User;
import webApplication.exceprion.AppException;
import webApplication.exceprion.Messages;



public class AddUserToDB extends Command {

	private static final Logger LOG = Logger.getLogger(AddUserToDB.class);
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	// Add user to DB
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
		ServletContext context = request.getServletContext();
		String key = (String) context.getAttribute("url");
		String sendKey = request.getParameter("key");
		if(!key.equals(sendKey)){
			request.getSession().setAttribute("messageError", Messages.ERROR_KEY_IS_NOT_VALID);
			throw new AppException();
		}
		
		User user = (User) context.getAttribute("user");
		request.setAttribute("login", user.getLogin());
		LOG.trace("Add user --> " + user);
		context.removeAttribute("user");
		context.removeAttribute("url");
		
		userDao.addUser(user);	
		//new DBManager().insertUser(user);
		LOG.debug("Command finished");
		return Path.PAGE_WELCOME;

	}

}
