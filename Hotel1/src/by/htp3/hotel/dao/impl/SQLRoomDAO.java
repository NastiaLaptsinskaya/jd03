package by.htp3.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.bean.RoomType;
import by.htp3.hotel.dao.RoomDAO;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.dao.helpers.HelperRoomTypes;
import by.htp3.hotel.dao.impl.pool.ConnectionPool;
import by.htp3.hotel.dao.impl.pool.ConnectionPoolException;

public class SQLRoomDAO implements RoomDAO {

	@Override
	public Room addNewRoom(int roomID, String typeName) throws DAOException {

		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;

		int roomsTypeID;
		Boolean status;

		try {
			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement("SELECT * FROM roomsType where type_name= ? ");
			st.setString(1, typeName);

			rs = st.executeQuery();

			if (!rs.next()) {
				System.out.println("NE OK I didnt't recieve the ID of Rooms_type");
				return null;
			}

			roomsTypeID = rs.getInt(1);
			/////////////////////////////////// insert into ROOMS

			status = true;

			st2 = con.prepareStatement("INSERT INTO rooms (room_ID, roomsType_room_Type_ID, status) values(?, ?, ?)");
			st2.setInt(1, roomID);
			st2.setInt(2, roomsTypeID);
			st2.setBoolean(3, status);

			st2.execute();
			/////////////////////////////////// creating Room object

			Room room = new Room(roomID, typeName);
			return room;

		} catch (SQLException e) {
			throw new DAOException("Error in room adding DAOException!", e);

		} catch (ConnectionPoolException e) {
			throw new DAOException("pool exception", e);
		} finally {

			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					// logging
				}
			}
			if (st != null | st2 != null) {

				try {
					st.close();
					st2.close();
				} catch (SQLException e) {
					// logging
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (ConnectionPoolException e) {
				// loggin error
			}

		}

	}

	@Override
	public ArrayList<Room> showAllRooms() throws DAOException {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		PreparedStatement st2 = null;
		ResultSet rs2 = null;
		
		///////////////////////////
		Map<Integer, RoomType> roomsTypeMap = new HashMap<Integer, RoomType>();

		
			
		///////////////////////////

		ArrayList<Room> roomsList = new ArrayList<Room>();
		
		try {
			con = ConnectionPool.getInstance().takeConnection();
			System.out.println("Connection OK");
			///////////////////// delete
			st = con.prepareStatement("SELECT * FROM roomsType");

			rs = st.executeQuery();

			if (!rs.next()) {
				System.out.println("NE OK I didnt't recieve the Rooms_type");
				return null;
			}

			while (rs.next()) {
				RoomType roomType = new RoomType();
				System.out.println("141 OK");
				roomType.setTypeName(rs.getString(2));
				System.out.println("143 OK");
				roomType.setPricePerDay(rs.getString("price_per_day"));
				System.out.println("145 OK");
				roomType.setBedsNumber(rs.getString("beds_number"));
				System.out.println("147 OK");
				roomType.setFloor(rs.getString("floor"));
				roomType.setWindowView(rs.getString("window_view"));
				System.out.println("150 OK");
				roomsTypeMap.put(rs.getInt(1), roomType);

			}
			System.out.println(roomsTypeMap.isEmpty());
			System.out.println("154 OK");
			///////////////////// delete
			
			st2 = con.prepareStatement("SELECT * FROM rooms");
			rs2 = st2.executeQuery();
			
			//Map<Integer, RoomType> roomsTypeMap = HelperRoomTypes.getRoomsTypeMap();
			
			/*if (!rs2.next()) {
				System.out.println("NE OK I didnt't recieve rooms SQLRoomDAO");
				return null;
			}*/
			
			while (rs2.next()){
			
				Room room = new Room();
				
				room.setNumber(rs2.getInt(1));
				System.out.println("173 OK");
				System.out.println(rs2.getInt(1));
				room.setTypeName( (roomsTypeMap.get(rs2.getInt(2))).getTypeName() );
				System.out.println("175 OK");
				room.setPricePerDay( (roomsTypeMap.get(rs2.getInt(2))).getPricePerDay() );
				System.out.println("177 OK");
				room.setBedsNumber( (roomsTypeMap.get(rs2.getInt(2))).getBedsNumber() );
				System.out.println("179 OK");
				room.setFloor( (roomsTypeMap.get(rs2.getInt(2))).getFloor() );
				System.out.println("181 OK");
				room.setWindowView( (roomsTypeMap.get(rs2.getInt(2))).getWindowView() );
				System.out.println("183 OK");
				roomsList.add(room);
				System.out.println("185 OK");	   
			}
			
			System.out.println("188 SQLRoomDAO OK");
			for (int i = 0; i<1; i++){
				System.out.println(roomsList.isEmpty());
				
			}
			
			return roomsList;
			
		} catch (SQLException e) {
			throw new DAOException("Error in room adding DAOException!", e);

		} catch (ConnectionPoolException e) {
			throw new DAOException("pool exception", e);
		} finally {

			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					// logging
				}
			}
			if (st != null) {

				try {
					st.close();
				} catch (SQLException e) {
					// logging
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (ConnectionPoolException e) {
				// loggin error
			}

		}
			
		
	}

	@Override
	public void deleteRoom(int roomID) throws DAOException {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionPool.getInstance().takeConnection();
			
			st = con.prepareStatement("delete from rooms where room_ID = ?");
			st.setInt(1, roomID);
			
			st.execute();

			
			
		} catch (SQLException e) {
			throw new DAOException("Error in room deletting DAOException!", e);

		} catch (ConnectionPoolException e) {
			throw new DAOException("pool exception", e);
		} finally {

			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					// logging
				}
			}
			if (st != null) {

				try {
					st.close();
				} catch (SQLException e) {
					// logging
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (ConnectionPoolException e) {
				// loggin error
			}

		}
			
		
	}
		
}


	

	