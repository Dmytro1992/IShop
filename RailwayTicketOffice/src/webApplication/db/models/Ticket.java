package webApplication.db.models;

import java.io.Serializable;

//// Constructor for ticket
public class Ticket implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String type;
	private int quantity;
	private int price;
	
	public Ticket(){
		
	}
	
	public Ticket(int id, String type, int quantity, int price) {
		super();
		this.id = id;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Ticket id = "+id+", type = "+type+", quantity = "+quantity+", price = "+price;
	}
}
