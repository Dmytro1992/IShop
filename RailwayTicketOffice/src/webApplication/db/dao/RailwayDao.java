package webApplication.db.dao;

import java.util.List;

import webApplication.db.models.Railway;
import webApplication.exceprion.DBException;



public interface RailwayDao {

	public List<Railway> findTrainRoute() throws DBException;
	
	public Railway findTrainRouteById(int id) throws DBException;
	
	public void insertTrainRoute(Railway railway) throws DBException ;
	
	public void deleteTrainRoute(int id) throws DBException;
	
	public boolean findRouteId(int id) throws DBException;
	
	public void updateTrainWay(String nameTable, int id, String nameColumn, String newValue) throws DBException;
	
}
