package webApplication.db.models;

import java.io.Serializable;
import java.util.List;

//Constructor for train route

public class Railway implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int numberWay;
	private String startingStation;
	private String departureTime;
	private String endStation;
	private String arrivalTime;
	private List<IntermediateStations> intermediateStations;
	private List<Ticket> ticket;

	public Railway() {

	}

	public Railway(String startingStation, String departureTime, String endStation, String arrivalTime) {
		super();
		this.startingStation = startingStation;
		this.departureTime = departureTime;
		this.endStation = endStation;
		this.arrivalTime = arrivalTime;
	}

	public Railway(int numberWay, String startingStation, String departureTime, String endStation, String arrivalTime, List<IntermediateStations> intermediateStations) {
		super();
		this.numberWay = numberWay;
		this.startingStation = startingStation;
		this.departureTime = departureTime;
		this.endStation = endStation;
		this.arrivalTime = arrivalTime;
		this.intermediateStations = intermediateStations;
	}

	public int getNumberWay() {
		return numberWay;
	}

	public void setNumberWay(int numberWay) {
		this.numberWay = numberWay;
	}

	public String getStartingStation() {
		return startingStation;
	}

	public void setStartingStation(String startingStation) {
		this.startingStation = startingStation;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public List<IntermediateStations> getIntermediateStations() {
		return intermediateStations;
	}

	public void setIntermediateStations(List<IntermediateStations> intermediateStations) {
		this.intermediateStations = intermediateStations;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Railway [ staring station = " + startingStation + ", departure time = " + departureTime + ", end station = " + endStation + ", arrival time = " + arrivalTime;
	}

}
