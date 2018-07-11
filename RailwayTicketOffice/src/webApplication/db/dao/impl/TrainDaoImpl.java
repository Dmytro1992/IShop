package webApplication.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webApplication.db.DBManager;
import webApplication.db.dao.TrainDao;
import webApplication.db.models.Train;
import webApplication.exceprion.DBException;
import webApplication.exceprion.Messages;



public class TrainDaoImpl extends DBManager implements TrainDao{

	private static final String FIND_TRAIN = "SELECT train.id_rtain, train.travel_time, train_way.*, comp.type,comp.quantity,comp.price, " + "res.type,res.quantity,res.price, com.type,com.quantity,com.price FROM train " + "JOIN train_way ON train.route = train_way.id "
			+ "JOIN ticket AS comp ON train.compartment = comp.id " + "JOIN ticket AS res ON train.reserved_set = res.id " + "JOIN ticket AS com ON train.day_coach = com.id" + " WHERE train_way.starting_station = ? AND train_way.end_station = ?";

	
	@Override
	public List<Train> findTrain(String startingStation, String endStation) throws DBException {
		List<Train> trainList = new ArrayList<>();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_TRAIN);
			st.setString(1, startingStation);
			st.setString(2, endStation);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Train train = new Train();
				train.setTrainNumber(rs.getInt(1));
				train.setTravel_time(rs.getInt(2));
				train.setIdRoute(rs.getInt(3));
				train.setStartingStation(rs.getString(4));
				train.setDepartureTime(rs.getString(5));
				train.setEndStation(rs.getString(6));
				train.setArrivalTime(rs.getString(7));
				train.setType1(rs.getString(8));
				train.setQuantity1(rs.getString(9));
				train.setPrice1(rs.getString(10));
				train.setType2(rs.getString(11));
				train.setQuantity2(rs.getString(12));
				train.setPrice2(rs.getString(13));
				train.setType3(rs.getString(14));
				train.setQuantity3(rs.getString(15));
				train.setPrice3(rs.getString(16));
				trainList.add(train);
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_FIND_ROUTE, e);
		} finally {
			close(c);
		}
		return trainList;
	}

}
