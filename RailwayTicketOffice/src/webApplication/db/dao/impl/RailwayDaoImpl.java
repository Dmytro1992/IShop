package webApplication.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import webApplication.db.DBManager;
import webApplication.db.dao.RailwayDao;
import webApplication.db.models.Railway;
import webApplication.exceprion.DBException;
import webApplication.exceprion.Messages;



public class RailwayDaoImpl extends DBManager implements RailwayDao{
	
	private static final String FIND_TRAIN_ROUTE = "SELECT * FROM train_way ORDER BY id";
	private static final String FIND_TRAIN_ROUTE_BY_ID = "SELECT * FROM train_way WHERE id = ?";
	private static final String ADD_TRAIN_ROUTE = "INSERT INTO train_way VALUES(DEFAULT,?,?,?,?)";
	private static final String DELETE_TRAIN_ROUTE = "DELETE FROM train_way WHERE id = ?";
	
	
	@Override
	public List<Railway> findTrainRoute() throws DBException {
		List<Railway> trainWay = new ArrayList<>();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_TRAIN_ROUTE);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Railway railway = new Railway();
				railway.setNumberWay(rs.getInt(1));
				railway.setStartingStation(rs.getString(2));
				railway.setDepartureTime(rs.getString(3));
				railway.setEndStation(rs.getString(4));
				railway.setArrivalTime(rs.getString(5));
				
				//returns the station that belongs to this route
				railway.setIntermediateStations(new IntermediateStationsDaoImpl().intermediateStation(railway.getNumberWay()));
				trainWay.add(railway);
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_FIND_ROUTE, e);
		} finally {
			close(c);
		}
		return trainWay;
	}

	@Override
	public Railway findTrainRouteById(int id) throws DBException {
		Railway railway = new Railway();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_TRAIN_ROUTE_BY_ID);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				railway.setNumberWay(rs.getInt(1));
				railway.setStartingStation(rs.getString(2));
				railway.setDepartureTime(rs.getString(3));
				railway.setEndStation(rs.getString(4));
				railway.setArrivalTime(rs.getString(5));
				
				//returns the station that belongs to this route
				railway.setIntermediateStations(new IntermediateStationsDaoImpl().intermediateStation(railway.getNumberWay()));
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_FIND_ROUTE, e);
		} finally {
			close(c);
		}
		return railway;
	}

	@Override
	public void insertTrainRoute(Railway railway) throws DBException {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement(ADD_TRAIN_ROUTE);
			pstmt.setString(1, railway.getStartingStation());
			pstmt.setString(2, railway.getDepartureTime());
			pstmt.setString(3, railway.getEndStation());
			pstmt.setString(4, railway.getArrivalTime());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new DBException(Messages.ERROR_CANNOT_ADD_NEW_ROUTE, e);
		} finally {
			close(c);
		}
		
	}

	@Override
	public void deleteTrainRoute(int id) throws DBException {
		Connection c=null;
		try {
			c = getConnection();
			PreparedStatement pr = c.prepareStatement(DELETE_TRAIN_ROUTE);
			pr.setInt(1, id);
			pr.executeUpdate();
		} catch (Exception e) {
			throw new DBException(Messages.ERROR_CANNOT_DELETE_ROUTE, e);
		}finally {
			close(c);
		}
		
	}

	@Override
	public boolean findRouteId(int id) throws DBException {
		Connection c = null;
		boolean routeId = false;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_TRAIN_ROUTE_BY_ID);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				routeId = true;
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_FIND_ROUTE, e);
		} finally {
			close(c);
		}
		return routeId;
	}

	@Override
	public void updateTrainWay(String nameTable, int id, String nameColumn, String newValue) throws DBException {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pr = c.prepareStatement(buildingSQLUpdateQuery(nameColumn, nameTable));
			pr.setString(1, newValue);
			pr.setInt(2, id);
			pr.executeUpdate();

		} catch (Exception e) {
			throw new DBException(Messages.ERROR_CANNOT_ADD_NEW_DATA, e);
		} finally {
			close(c);
		}
		
	}
	//modification SQL queries for update DB
		private String buildingSQLUpdateQuery(String nameColumn, String nameTable) {
			return "UPDATE " + nameTable + " SET " + nameColumn + " = ? WHERE id = ?";
		}
}
