package webApplication.db.dao;

import webApplication.exceprion.DBException;

public interface TicketDao {

	public int quanitity(int id) throws DBException;
	
	public void updateTicketQuantity(int id, int quantity) throws DBException;
}
