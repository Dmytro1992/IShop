package webApplication.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import webApplication.db.DBManager;
import webApplication.db.dao.UserOrderTicketDao;
import webApplication.db.models.UserOrderTicket;
import webApplication.exceprion.DBException;
import webApplication.exceprion.Messages;

public class UserOrderTicketDaoImpl extends DBManager implements UserOrderTicketDao{

	private static final String FIND_TICKET_COMPARTMENT = "SELECT train.id_rtain, train_way.*, ticket.id, ticket.type, ticket.quantity,ticket.price " + "FROM train JOIN train_way ON train.route = train_way.id JOIN ticket ON train.compartment = ticket.id WHERE train.id_rtain = ?";
	private static final String FIND_TICKET_RESERVED_SEAT = "SELECT train.id_rtain, train_way.*, ticket.id, ticket.type, ticket.quantity,ticket.price " + "FROM train JOIN train_way ON train.route = train_way.id JOIN ticket ON train.reserved_set = ticket.id WHERE train.id_rtain = ?";
	private static final String FIND_TICKET_COMMON = "SELECT train.id_rtain, train_way.*, ticket.id, ticket.type, ticket.quantity,ticket.price " + "FROM train JOIN train_way ON train.route = train_way.id JOIN ticket ON train.day_coach = ticket.id WHERE train.id_rtain = ?";
	
	
	
	@Override
	public UserOrderTicket findTicketCompartment(int idTrain) throws DBException {
		UserOrderTicket orderTicket = new UserOrderTicket();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_TICKET_COMPARTMENT);
			st.setInt(1, idTrain);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				orderTicket.setTrainNumber(rs.getInt(1));
				orderTicket.setStartingStation(rs.getString(3));
				orderTicket.setDepartureTime(rs.getString(4));
				orderTicket.setEndStation(rs.getString(5));
				orderTicket.setArrivalTime(rs.getString(6));
				orderTicket.setNumberTicket(rs.getInt(7));
				orderTicket.setType(rs.getString(8));
				orderTicket.setQuantity(rs.getInt(9));
				orderTicket.setCost(rs.getInt(10));
			}
			
		} catch (Exception e) {
		
			throw new DBException(Messages.ERROR_CANNOT_TICKED_CREATE, e);
		} finally {
			close(c);
		}
		return orderTicket;
	}

	@Override
	public UserOrderTicket findTicketReservedSeat(int idTrain) throws DBException {
		UserOrderTicket orderTicket = new UserOrderTicket();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_TICKET_RESERVED_SEAT);
			st.setInt(1, idTrain);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				orderTicket.setTrainNumber(rs.getInt(1));
				orderTicket.setStartingStation(rs.getString(3));
				orderTicket.setDepartureTime(rs.getString(4));
				orderTicket.setEndStation(rs.getString(5));
				orderTicket.setArrivalTime(rs.getString(6));
				orderTicket.setNumberTicket(rs.getInt(7));
				orderTicket.setType(rs.getString(8));
				orderTicket.setQuantity(rs.getInt(9));
				orderTicket.setCost(rs.getInt(10));
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_TICKED_CREATE, e);
		} finally {
			close(c);
		}
		return orderTicket;
	}

	@Override
	public UserOrderTicket findTicketCommon(int idTrain) throws DBException {
		UserOrderTicket orderTicket = new UserOrderTicket();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_TICKET_COMMON);
			st.setInt(1, idTrain);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				orderTicket.setTrainNumber(rs.getInt(1));
				orderTicket.setStartingStation(rs.getString(3));
				orderTicket.setDepartureTime(rs.getString(4));
				orderTicket.setEndStation(rs.getString(5));
				orderTicket.setArrivalTime(rs.getString(6));
				orderTicket.setNumberTicket(rs.getInt(7));
				orderTicket.setType(rs.getString(8));
				orderTicket.setQuantity(rs.getInt(9));
				orderTicket.setCost(rs.getInt(10));
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_TICKED_CREATE, e);
		} finally {
			close(c);
		}
		return orderTicket;
	}

}
