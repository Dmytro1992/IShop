package webApplication.db.dao;

import java.util.List;

import webApplication.db.models.IntermediateStations;
import webApplication.exceprion.DBException;



public interface IntermediateStationsDao {

	public List<IntermediateStations> intermediateStation(int id) throws DBException;
	
	public int findInsertIntermediateStationId() throws DBException;
	
	public void insertIntermediateStation(IntermediateStations intermediateStation) throws DBException;
	
	public void deleteIntermediateStation(int id) throws DBException;
	
	public boolean findStationId(int id) throws DBException;
	
	public void insertFullWay(int id) throws DBException;
}
