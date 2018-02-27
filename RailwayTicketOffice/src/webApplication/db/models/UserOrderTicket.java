package webApplication.db.models;

import java.io.Serializable;
//Constructor train(ticket + route)
public class UserOrderTicket implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int trainNumber;
	private String startingStation;
	private String departureTime;
	private String endStation;
	private String arrivalTime;
	private int numberTicket;
	private String type;
	private int quantity;
	private int cost;
	
	public UserOrderTicket(){
		
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNumberTicket() {
		return numberTicket;
	}

	public void setNumberTicket(int numberTicket) {
		this.numberTicket = numberTicket;
	}
	
	@Override
	public String toString() {
		return "Ticket: train number = "+trainNumber+", staring station = "+startingStation+", departure time = "+departureTime+", end station = "+endStation
				+", arrival time = "+arrivalTime+", type = "+type+", quantity = "+quantity+", cost = "+cost;
	}
}
