package by.htp3.hotel;


import java.util.Map;

import by.htp3.hotel.bean.RoomType;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.dao.helpers.HelperRoomTypes;

public class TEST {
	public static void main(String[] args) throws ClassNotFoundException, DAOException{
   	 
		Map<Integer, RoomType> roomsTypeMap = HelperRoomTypes.getRoomsTypeMap();
		System.out.println("ok");
		System.out.println(Class.forName("org.gjt.mm.mysql.Driver"));
    }

}
