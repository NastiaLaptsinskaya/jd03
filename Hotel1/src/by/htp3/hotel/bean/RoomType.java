package by.htp3.hotel.bean;

public class RoomType {
	private String typeName;
	private String pricePerDay;
	private String bedsNumber;
	private String floor;
	private String windowView;
	
	public RoomType(String typeName, String pricePerDay, String bedsNumber, String floor, String windowView){
		this.typeName = typeName;
		this.pricePerDay = pricePerDay;
		this.bedsNumber = bedsNumber;
		this.floor = floor;
		this.windowView = windowView;
		
	}
	
	public RoomType(){}
	
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
	public String getWindowView() {
		return windowView;
	}
	public void setWindowView(String windowView) {
		this.windowView = windowView;
	}
	
	
}
