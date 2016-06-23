package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.exeption.ServiceAddNewRoomException;
import by.htp3.hotel.service.exeption.ServiceException;

public class AddNewRoom implements Command{

	private static final String ROOM_ID = "roomID"; 
	private static final String TYPE_NAME = "typeName"; 
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String roomID  = request.getParameter(ROOM_ID);
		String typeName  = request.getParameter(TYPE_NAME);
		
		RoomService roomService = ServiceFactory.getInstance().getRoomService();
		
		request.getSession(true).setAttribute("prev_page", "/WEB-INF/jsp/adminUser.jsp");
		
		
		try {
				
			Room room = roomService.addNewRoom(roomID, typeName);
			request.setAttribute("room", room);
			
			request.setAttribute("progressMessage", "Room was added");
			request.getRequestDispatcher("/WEB-INF/jsp/adminUser.jsp").forward(request, response);;
			
		} catch (ServiceAddNewRoomException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/adminUser.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			request.setAttribute("errorRoomMessage", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/adminUser.jsp").forward(request, response);
			
		}
		
	}
		
}
