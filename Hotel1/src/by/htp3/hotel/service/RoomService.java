package by.htp3.hotel.service;

import java.util.ArrayList;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.service.exeption.ServiceException;

public interface RoomService {
	Room addNewRoom(String roomID, String typeName) throws ServiceException;
	ArrayList<Room> showAllRooms() throws ServiceException;
	void deleteRoom(String roomID) throws ServiceException;
}
