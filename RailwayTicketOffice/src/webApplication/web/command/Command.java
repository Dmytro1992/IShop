package webApplication.web.command;

import java.io.IOException;
import java.io.Serializable;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webApplication.exceprion.AppException;



public abstract class Command implements Serializable {
	private static final long serialVersionUID = 8879403039606311780L;

	/**
	 * Execution method for command.
	 * 
	 * @return Address to go once the command is executed.
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws AppException 
	 */
	public abstract String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, AppException;

	@Override
	public final String toString() {
		return getClass().getSimpleName();
	}
}