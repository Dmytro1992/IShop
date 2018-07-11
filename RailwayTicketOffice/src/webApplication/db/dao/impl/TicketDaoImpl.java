package webApplication.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import webApplication.db.DBManager;
import webApplication.db.dao.TicketDao;
import webApplication.exceprion.DBException;
import webApplication.exceprion.Messages;

public class TicketDaoImpl extends DBManager implements TicketDao {

	private static final String FIND_TRAIN_PLACES = "SELECT ticket.quantity FROM ticket WHERE id = ?";
	private static final String UPDATE_TICKET_QUANTITY = "UPDATE ticket SET quantity = ? WHERE id = ?";
	
	@Override
	public int quanitity(int id) throws DBException {
		Connection c = null;
		int quanitity = 0;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_TRAIN_PLACES);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				quanitity = rs.getInt(1);
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_TICKED_CREATE, e);
		} finally {
			close(c);
		}
		return quanitity;
	}

	@Override
	public void updateTicketQuantity(int id, int quantity) throws DBException {
		try {
			Connection c = getConnection();
			PreparedStatement pr = c.prepareStatement(UPDATE_TICKET_QUANTITY);
			pr.setInt(1, quantity);
			pr.setInt(2, id);
			pr.executeUpdate();

		} catch (Exception e) {
			throw new DBException(Messages.ERROR_CANNOT_WORK_TO_DB, e);
		}
		
	}

}
