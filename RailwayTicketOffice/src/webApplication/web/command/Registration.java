package webApplication.web.command;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
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

//Registration
public class Registration extends Command {
	private static final Logger LOG = Logger.getLogger(Registration.class);
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AppException {
		LOG.debug("Command starts");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm");
		HttpSession session = request.getSession();
		UserDao userDao = new UserDaoImpl();

		// check valid parameters
		if (firstName.equals("") || lastName.equals("") || login.equals("") || password.equals("") || confirmPassword.equals("")) {
			System.out.println(Messages.ERROR_EMPTY_FIELDS);
			session.setAttribute("messageError", Messages.ERROR_EMPTY_FIELDS);
			throw new AppException(Messages.ERROR_EMPTY_FIELDS);
		}

		if (new Tool().valideEmail(email) != 1) {
			System.out.println(Messages.ERROR_VALID_EMAIL);
			session.setAttribute("messageError", Messages.ERROR_VALID_EMAIL);
			throw new AppException(Messages.ERROR_VALID_EMAIL);
		}

		if (!password.equals(confirmPassword) || password.length() < 6) {
			System.out.println(Messages.ERROR_VALID_PASSWORD);
			session.setAttribute("messageError", Messages.ERROR_VALID_PASSWORD);
			throw new AppException(Messages.ERROR_VALID_PASSWORD);
		}
		// check exist user in DB
		if (userDao.getByLogin(login)) {
			System.out.println(Messages.ERROR_VALID_LOGIN + login);
			session.setAttribute("messageError", Messages.ERROR_VALID_LOGIN + login);
			throw new AppException(Messages.ERROR_VALID_LOGIN + login);
		}
		// create user
		User user = new User(firstName, lastName, email, login, password);
		LOG.trace("Create new user --> " + user);
		ServletContext context = request.getServletContext();
		context.setAttribute("user", user);
		context.setAttribute("url", generateString());
		// send letter to email(user)
		try {
			LOG.trace("Send mail to user email --> " + user.getEmail());
			mailSender(email, login, (String) context.getAttribute("url"));
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return Path.PAGE_REGISTRATION_NOTICE;

	}

	// send letter
	private void mailSender(String email, String login, String key) throws IOException, AddressException, MessagingException {
		final Properties properties = new Properties();
		properties.load(Registration.class.getClassLoader().getResourceAsStream("mail.properties"));

		Session mailSession = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(mailSession);
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		message.setSubject("Администрация сайта");
		message.setText("Здраствуйте, вы зарегистрировались на сайте под логином: " + login + ", чтобы успешно пройти регистрацию пройдите по ссылке: " + System.lineSeparator() + 
				new URL("http://localhost:8080/SummaryTask/Controller?command=regUser&key=" + key + "."));
		Transport tr = mailSession.getTransport();
		tr.connect(null, properties.getProperty("password"));
		tr.sendMessage(message, message.getAllRecipients());
		tr.close();
	}
//generate key for register
	public static String generateString() {
		int length = 40;
		String characters = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOASDFGHJKLZXCVBNM";
		Random rnd = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rnd.nextInt(characters.length()));
		}
		String key = new String(text);
		LOG.trace("Generate new key --> " + key);
		return key;
	}

}
