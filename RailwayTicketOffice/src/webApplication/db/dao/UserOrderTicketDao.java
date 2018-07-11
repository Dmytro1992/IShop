package webApplication.db.dao;

import webApplication.db.models.UserOrderTicket;
import webApplication.exceprion.DBException;

public interface UserOrderTicketDao {

	public UserOrderTicket findTicketCompartment(int idTrain) throws DBException;
	
	public UserOrderTicket findTicketReservedSeat(int idTrain) throws DBException;
	
	public UserOrderTicket findTicketCommon(int idTrain) throws DBException;
	
	
}
