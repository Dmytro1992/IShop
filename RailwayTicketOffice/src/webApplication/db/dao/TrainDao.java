package webApplication.db.dao;

import java.util.List;

import webApplication.db.models.Train;
import webApplication.exceprion.DBException;



public interface TrainDao {

	public List<Train> findTrain(String startingStation, String endStation) throws DBException;
	
	
}
