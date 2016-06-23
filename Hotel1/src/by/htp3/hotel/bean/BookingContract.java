package by.htp3.hotel.bean;

import java.sql.Date;

public class BookingContract {

	private int userID;
	private int roomID;
	private Date startDate;
	private Date endDate;
	private String wishes;

	public BookingContract(int userID, int roomID) {
		this.setUserID(userID);
		this.setRoomID(roomID);
	}

	public BookingContract() {

	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getWishes() {
		return wishes;
	}

	public void setWishes(String wishes) {
		this.wishes = wishes;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	

}
