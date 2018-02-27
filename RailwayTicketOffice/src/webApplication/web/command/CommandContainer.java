package webApplication.web.command;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;


public class CommandContainer {
	
	private static final Logger LOG = Logger.getLogger(CommandContainer.class);
	
	private static Map<String, Command> commands = new TreeMap<String, Command>();

	static {
		//admin commands
		commands.put("Show train route", new AdminOrderShow());
		commands.put("Delete train route", new AdminOrderShowDeleteRoute());
		commands.put("Correct train route", new AdminOrderShowCorrectTrainRoute());
		commands.put("Add a new route", new AdminOrderShowAddRoute());
		commands.put("Add route", new AdminOrderAddRoute());
		commands.put("Add station", new AdminOrderAddStation());
		commands.put("Delete route", new AdminOrderDeleteRoute());
		commands.put("Delete station", new AdminOrderDeleteStation());
		commands.put("Update route", new AdminOrderUpdateRoute());
		commands.put("Update station", new AdminOrderUpdateStation());
		//common
		commands.put("logout", new Logout());
		commands.put("Sign in", new SignIn());
		commands.put("Register", new Registration());
		commands.put("noCommand", new NoCommand());
		commands.put("Find route", new UserOrderFindRoute());
		commands.put("regUser", new AddUserToDB());
		//client command
		commands.put("searchRequest", new UserSearchRequest());
		commands.put("main_page", new GoToMain());
		commands.put("login_page", new GoToLogin());
		commands.put("register_page", new GoToRegistration());
		commands.put("Buy ticket", new UserBuyTicket());
		commands.put("remove", new UserRemoveOrder());
		
		LOG.debug("Command container was successfully initialized");
		LOG.trace("Number of commands --> " + commands.size());
	}

	/**
	 * Returns command object with the given name.
	 * 
	 * @param commandName
	 *            Name of the command.
	 * @return Command object.
	 */
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			LOG.trace("Command not found, name --> " + commandName);
			return commands.get("noCommand");
		}

		return commands.get(commandName);
	}
}
