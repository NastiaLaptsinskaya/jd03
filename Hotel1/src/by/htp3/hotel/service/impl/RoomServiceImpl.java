package by.htp3.hotel.service.impl;

import java.util.ArrayList;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.dao.DAOFactory;
import by.htp3.hotel.dao.RoomDAO;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.exeption.ServiceAddNewRoomException;
import by.htp3.hotel.service.exeption.ServiceException;
import by.htp3.hotel.service.exeption.ServiceShowAllRoomsException;

public class RoomServiceImpl implements RoomService {

	@Override
	public Room addNewRoom(String roomIDstring, String typeName) throws ServiceException {

		if (!Validation.validate(roomIDstring, typeName)) {
			throw new ServiceException("Please, check parameters");
		}

		int roomID = Integer.parseInt(roomIDstring);

		DAOFactory daoFactory = DAOFactory.getInstance();
		RoomDAO dao = daoFactory.getRoomDAO();

		Room room;

		try {

			room = dao.addNewRoom(roomID, typeName);

			// user = dao.authorization(login, password);

			if (room == null) {
				throw new ServiceAddNewRoomException("Room wasn't add");
			}

		} catch (DAOException e) {
			throw new ServiceException("Error in source", e);
		}

		return room;

	}

	static class Validation {

		static boolean validate(String roomIDstring, String typeName) {
			if (roomIDstring == null || roomIDstring.isEmpty()) {
				return false;
			}

			if (typeName == null || typeName.isEmpty()) {
				return false;
			}

			return true; // stub
		}

		static boolean validate(String roomIDstring) {
			if (roomIDstring == null || roomIDstring.isEmpty()) {
				return false;
			}

			return true; // stub
		}
	}

	@Override
	public ArrayList<Room> showAllRooms() throws ServiceException {

		DAOFactory daoFactory = DAOFactory.getInstance();
		RoomDAO dao = daoFactory.getRoomDAO();

		ArrayList<Room> roomsList = new ArrayList<Room>();
		try {

			roomsList = dao.showAllRooms();

			if (roomsList == null) {
				throw new ServiceShowAllRoomsException("Rooms weren't received");
			}

		} catch (DAOException e) {
			throw new ServiceException("Error in source", e);
		}

		return roomsList;

	}

	@Override
	public void deleteRoom(String roomIDstring) throws ServiceException {

		if (!Validation.validate(roomIDstring)) {
			throw new ServiceException("Room number couldn't be empty");
		}

		int roomID = Integer.parseInt(roomIDstring);

		DAOFactory daoFactory = DAOFactory.getInstance();
		RoomDAO dao = daoFactory.getRoomDAO();

		try {
			dao.deleteRoom(roomID);

		} catch (DAOException e) {
			throw new ServiceException("Error in source", e);
		}

	}

}
