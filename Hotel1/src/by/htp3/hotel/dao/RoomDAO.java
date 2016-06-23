package by.htp3.hotel.dao;

import java.util.ArrayList;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.dao.exception.DAOException;


public interface RoomDAO {
	Room addNewRoom(int roomNumber, String typeName) throws DAOException;
	ArrayList<Room> showAllRooms() throws DAOException;
	void deleteRoom(int roomID) throws DAOException;
}
