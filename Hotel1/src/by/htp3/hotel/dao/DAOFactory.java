package by.htp3.hotel.dao;

import by.htp3.hotel.dao.impl.SQLRoomDAO;
import by.htp3.hotel.dao.impl.SQLUserDAO;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	private UserDAO userDAO = new SQLUserDAO();
	
	private RoomDAO roomDAO = new SQLRoomDAO();
	
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return instance;
	}
	public RoomDAO getRoomDAO() {
		return roomDAO;
	}
	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}

}
