package by.htp3.hotel.bean;

public class Room {
	private int number;
	private String typeName;
	private String pricePerDay;
	private String bedsNumber;
	private String floor;
	private String WindowView;
	
	// ++++ equals ++++ hash code
	public Room(int number, String type){
		this.number = number;
		this.typeName = type;
	}
	
	public Room(){
		
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(String pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getBedsNumber() {
		return bedsNumber;
	}

	public void setBedsNumber(String bedsNumber) {
		this.bedsNumber = bedsNumber;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getWindowView() {
		return WindowView;
	}

	public void setWindowView(String WindowView) {
		this.WindowView = WindowView;
	}


}
