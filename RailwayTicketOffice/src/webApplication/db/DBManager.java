package webApplication.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import webApplication.exceprion.DBException;
import webApplication.exceprion.Messages;



public class DBManager {

	private static final String DB_URL = "jdbc:postgresql://localhost:5432/railway_ticket_office";
	private static final String USER = "admin";
	private static final String PASS = "password";
	
	// singleton
		private static DBManager instance;

		public static synchronized DBManager getInstance() {
			if (instance == null) {
				instance = new DBManager();
			}
			return instance;
		}
		
		//Returns a DB connection from the Pool Connections.
		public Connection getConnection() throws DBException{
			Connection c = null;
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				throw new DBException(Messages.ERROR_CANNOT_OBTAIN_CONNECTION, e);
			}catch (Exception e) {
				throw new DBException(Messages.ERROR_NOT_FOUND_DRIVER, e);
			}
			return c;
		}

		//Closed a DB connection
		protected void close(AutoCloseable ac) {
			if (ac != null) {
				try {
					ac.close();
				} catch (Exception ex) {
					throw new IllegalStateException("Cannot close " + ac);
				}
			}
		}
}
