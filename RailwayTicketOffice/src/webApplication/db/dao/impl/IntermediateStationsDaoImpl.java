package webApplication.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webApplication.db.DBManager;
import webApplication.db.dao.IntermediateStationsDao;
import webApplication.db.models.IntermediateStations;
import webApplication.exceprion.DBException;
import webApplication.exceprion.Messages;



public class IntermediateStationsDaoImpl extends DBManager implements IntermediateStationsDao{

	private static final String FIND_INTERMEDIATE_STATION = "SELECT intermediate_stations.* FROM train_way JOIN " + "full_way ON full_way.train_way_id = train_way.id JOIN intermediate_stations ON " + "intermediate_stations.id = full_way.intermediate_stations_id WHERE full_way.train_way_id = ?";
	private static final String FIND_LAST_INTERMEDIATE_STATION = "SELECT MAX(id) FROM intermediate_stations";
	private static final String ADD_INTERMEDIATE_STATION = "INSERT INTO intermediate_stations VALUES(DEFAULT,?,?,?,?)";
	private static final String DELETE_INTERMEDIATE_STATION = "DELETE FROM intermediate_stations WHERE id = ?";
	private static final String FIND_Station_BY_ID = "SELECT * FROM intermediate_stations WHERE id = ?";
	private static final String ADD_FULL_WAY = "INSERT INTO full_way VALUES(?,?)";
	
	@Override
	public List<IntermediateStations> intermediateStation(int id) throws DBException {
		List<IntermediateStations> listStations = new ArrayList<>();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_INTERMEDIATE_STATION);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				IntermediateStations stations = new IntermediateStations();
				stations.setNumberStation(rs.getInt(1));
				stations.setStationName(rs.getString(2));
				stations.setArrivalTime(rs.getString(3));
				stations.setParkingTime(rs.getString(4));
				stations.setDepartureTime(rs.getString(5));
				listStations.add(stations);
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_FIND_STATION, e);
		} finally {
			close(c);
		}
		return listStations;
	}

	@Override
	public int findInsertIntermediateStationId() throws DBException {
		int id = 0;
		Connection c = null;

		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_LAST_INTERMEDIATE_STATION);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_FIND_ADDED_ROUTE, e);
		} finally {
			close(c);
		}
		return id;
	}

	@Override
	public void insertIntermediateStation(IntermediateStations intermediateStation) throws DBException {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement(ADD_INTERMEDIATE_STATION);
			pstmt.setString(1, intermediateStation.getStationName());
			pstmt.setString(2, intermediateStation.getArrivalTime());
			pstmt.setString(3, intermediateStation.getParkingTime());
			pstmt.setString(4, intermediateStation.getDepartureTime());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new DBException(Messages.ERROR_CANNOT_ADD_NEW_DATA, e);
		} finally {
			close(c);
		}
		
	}

	@Override
	public void deleteIntermediateStation(int id) throws DBException {
		Connection c = null;
		try {
			 c = getConnection();
			PreparedStatement pr = c.prepareStatement(DELETE_INTERMEDIATE_STATION);
			pr.setInt(1, id);
			pr.executeUpdate();
		} catch (Exception e) {
			throw new DBException(Messages.ERROR_CANNOT_DELETE_STATION, e);
		}finally {
			close(c);
		}
		
	}

	@Override
	public boolean findStationId(int id) throws DBException {
		Connection c = null;
		boolean routeId = false;
		try {
			c = getConnection();
			PreparedStatement st = c.prepareStatement(FIND_Station_BY_ID);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				routeId = true;
			}
			
		} catch (Exception e) {
			
			throw new DBException(Messages.ERROR_CANNOT_FIND_STATION, e);
		} finally {
			close(c);
		}
		return routeId;
	}

	@Override
	public void insertFullWay(int id) throws DBException {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement(ADD_FULL_WAY);
			pstmt.setInt(1, id);
			pstmt.setInt(2, findInsertIntermediateStationId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new DBException(Messages.ERROR_CANNOT_ADD_NEW_DATA, e);
		} finally {
			close(c);
		}
		
	}

}
