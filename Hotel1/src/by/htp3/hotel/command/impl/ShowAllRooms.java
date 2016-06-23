package by.htp3.hotel.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.exeption.ServiceAddNewRoomException;
import by.htp3.hotel.service.exeption.ServiceException;

public class ShowAllRooms implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RoomService roomService = ServiceFactory.getInstance().getRoomService();
		
		request.getSession(true).setAttribute("prev_page", "/WEB-INF/jsp/adminUser.jsp");
		
		
		try {
				
			ArrayList<Room> roomsList = roomService.showAllRooms();
			request.setAttribute("roomsList", roomsList);
			
			request.setAttribute("progressMessage2", "Everything OK");
			request.getRequestDispatcher("/WEB-INF/jsp/adminUser.jsp").forward(request, response);
			//request.getRequestDispatcher("/WEB-INF/jsp/rooms.jsp").forward(request, response);
		} catch (ServiceAddNewRoomException e) {
			request.setAttribute("errorShowAllRoomsMessage", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/adminUser.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			request.setAttribute("errorRoomMessage", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/adminUser.jsp").forward(request, response);
			
		}
		
	}
		
		
}


