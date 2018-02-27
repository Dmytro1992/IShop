package webApplication.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import webApplication.db.DBManager;
import webApplication.db.dao.UserDao;
import webApplication.db.models.User;
import webApplication.exceprion.DBException;
import webApplication.exceprion.Messages;



public class UserDaoImpl extends DBManager implements UserDao {
	
	private static final String ADD_NEW_USER = "INSERT INTO users VALUES(DEFAULT,?,?,?,?,?,DEFAULT)";
	private static final String FIND_USER = "SELECT * FROM users WHERE login = ? and password = ?";
	private static final String FIND_USER_LOGIN = "SELECT * FROM users WHERE login = ?";
	
	@Override
	public void addUser(User user) throws DBException {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement(ADD_NEW_USER);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getLogin());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBException(Messages.ERROR_CANNOT_ADD_USER, e);
		} finally {
			close(c);
		}
		
	}

	@Override
	public User getUserByLoginAndPassword(String login, String password) throws DBException {
		User user = new User();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_USER);
			st.setString(1, login);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setLogin(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setRole(rs.getBoolean(7));
				
			}
			
		} catch (Exception e) {
		
			throw new DBException(Messages.ERROR_CANNOT_FIND_USER_BY_ID,e);
		} finally {
			close(c);
		}
		return user;
	}

	@Override
	public boolean getByLogin(String login)  throws DBException{
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_USER_LOGIN);
			st.setString(1, login);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_FIND_USER_BY_LOGIN, e);
		} finally {
			close(c);
		}
		return false;
	}

}
