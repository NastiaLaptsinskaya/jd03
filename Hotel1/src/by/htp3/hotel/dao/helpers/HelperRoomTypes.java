package by.htp3.hotel.dao.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import by.htp3.hotel.bean.RoomType;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.dao.impl.pool.ConnectionPool;
import by.htp3.hotel.dao.impl.pool.ConnectionPoolException;

public class HelperRoomTypes {

	public static Map<Integer, RoomType> getRoomsTypeMap() throws DAOException {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		Map<Integer, RoomType> roomsTypeMap = new HashMap<Integer, RoomType>();

		try {
			con = ConnectionPool.getInstance().takeConnection();
			st = con.prepareStatement("SELECT * FROM roomsType");

			rs = st.executeQuery();

			if (!rs.next()) {
				System.out.println("NE OK I didnt't recieve the Rooms_type");
				return null;
			}

			while (rs.next()) {
				RoomType roomType = new RoomType();
				roomType.setTypeName(rs.getString(2));
			    roomType.setPricePerDay(rs.getString("price_per_day"));
				roomType.setBedsNumber(rs.getString("beds_number"));
				roomType.setFloor(rs.getString("floor"));
				roomType.setWindowView(rs.getString("window_view"));
				roomsTypeMap.put(rs.getInt(1), roomType);

			}

			return roomsTypeMap;

		} catch (SQLException e) {
			throw new DAOException("Error in roomsTypeMap!", e);

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
