package webApplication.db.dao;

import webApplication.db.models.User;
import webApplication.exceprion.DBException;

public interface UserDao {

	public void addUser(User user) throws DBException;
	
	public User getUserByLoginAndPassword(String login, String password) throws DBException;
	
	public boolean getByLogin(String login) throws DBException;
	
}
