package webApplication.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webApplication.Path;
import webApplication.db.dao.UserDao;
import webApplication.db.dao.impl.UserDaoImpl;
import webApplication.db.models.User;
import webApplication.exceprion.AppException;
import webApplication.exceprion.Messages;
//login
public class SignIn extends Command {
	private static final Logger LOG = Logger.getLogger(SignIn.class);
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AppException {
		LOG.debug("Command starts");
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String forward = null;
		HttpSession session = request.getSession();
//check valid parameters
		if (login.equals("") || password.equals("")) {
			System.out.println(Messages.ERROR_EMPTY_FIELDS);
			session.setAttribute("messageError", Messages.ERROR_EMPTY_FIELDS);
			throw new AppException(Messages.ERROR_EMPTY_FIELDS);
		}
		LOG.trace("Find user to DB --> "+ login);
		//find user in DB
		user = userDao.getUserByLoginAndPassword(login, password);
		if (user.getLogin() == null) {
			session.setAttribute("messageError", Messages.ERROR_VALID_USER);
			throw new AppException(Messages.ERROR_VALID_USER);
		}
		//add info about user
			session.setAttribute("loginIn", user.getLogin());
			session.setAttribute("user", user);
			
			if (user.isRole()) {
				LOG.trace("User role --> admin");
				forward = Path.PAGE_ADMIN;
			} else {
				LOG.trace("User role --> user");
				forward = Path.PAGE_MAIN;
			}
			LOG.debug("Command finished");
			return forward;
		
	}
}
