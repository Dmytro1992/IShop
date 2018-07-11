package webApplication.db.models;

import java.io.Serializable;

public class Train implements Serializable{

	// Constructor train
	private static final long serialVersionUID = 1L;
	
	private int trainNumber;
	private int travel_time;
	private int idRoute;
	private String startingStation;
	private String departureTime;
	private String endStation;
	private String arrivalTime;
	private String type1;
	private String quantity1;
	private String price1;
	private String type2;
	private String quantity2;
	private String price2;
	private String type3;
	private String quantity3;
	private String price3;
	
	public Train(){
		super();
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int numberTrain) {
		this.trainNumber = numberTrain;
	}

	public int getTravel_time() {
		return travel_time;
	}

	public void setTravel_time(int travel_time) {
		this.travel_time = travel_time;
	}

	public int getIdRoute() {
		return idRoute;
	}

	public void setIdRoute(int idRoute) {
		this.idRoute = idRoute;
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

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(String quantity1) {
		this.quantity1 = quantity1;
	}

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getQuantity2() {
		return quantity2;
	}

	public void setQuantity2(String quantity2) {
		this.quantity2 = quantity2;
	}

	public String getPrice2() {
		return price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getType3() {
		return type3;
	}

	public void setType3(String type3) {
		this.type3 = type3;
	}

	public String getQuantity3() {
		return quantity3;
	}

	public void setQuantity3(String quantity3) {
		this.quantity3 = quantity3;
	}

	public String getPrice3() {
		return price3;
	}

	public void setPrice3(String price3) {
		this.price3 = price3;
	}

	@Override
	public String toString() {
		return String.format("Train [trainNumber=%s, travel_time=%s, idRoute=%s, startingStation=%s, departureTime=%s, endStation=%s, arrivalTime=%s, type1=%s, quantity1=%s, price1=%s, type2=%s, quantity2=%s, price2=%s, type3=%s, quantity3=%s, price3=%s]", trainNumber, travel_time, idRoute,
				startingStation, departureTime, endStation, arrivalTime, type1, quantity1, price1, type2, quantity2, price2, type3, quantity3, price3);
	}
	
	
}
