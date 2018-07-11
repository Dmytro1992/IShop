package webApplication.db.models;

import java.io.Serializable;

// Constructor for intermediate stations

public class IntermediateStations implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int numberStation;
	private String stationName;
	private String arrivalTime;
	private String parkingTime;
	private String departureTime;

	public IntermediateStations(){
		
	}
	
	public IntermediateStations(String stationName, String arrivalTime, String parkingTime, String departureTime) {
		super();
		this.stationName = stationName;
		this.arrivalTime = arrivalTime;
		this.parkingTime = parkingTime;
		this.departureTime = departureTime;
	}
	
	public IntermediateStations(int numberStation, String stationName, String arrivalTime, String parkingTime, String departureTime) {
		super();
		this.numberStation = numberStation;
		this.stationName = stationName;
		this.arrivalTime = arrivalTime;
		this.parkingTime = parkingTime;
		this.departureTime = departureTime;
	}

	public int getNumberStation() {
		return numberStation;
	}

	public void setNumberStation(int numberStation) {
		this.numberStation = numberStation;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getParkingTime() {
		return parkingTime;
	}

	public void setParkingTime(String parkingTime) {
		this.parkingTime = parkingTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "station name = " + stationName +
				", arrival time = " + arrivalTime + 
				", parking time = " + parkingTime +
				", departure time = " + departureTime;
	}

}
