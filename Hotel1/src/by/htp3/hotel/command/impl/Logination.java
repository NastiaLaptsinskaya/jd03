package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.UserService;
import by.htp3.hotel.service.exeption.ServiceAuthException;
import by.htp3.hotel.service.exeption.ServiceException;

public class Logination implements Command{
	
	private static final String LOGIN = "login"; 
	private static final String PASSWORD = "password";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String login  = request.getParameter(LOGIN);
		String password  = request.getParameter(PASSWORD);
		
		UserService userService = ServiceFactory.getInstance().getUserService();
		
		request.getSession(true).setAttribute("prev_page", "/WEB-INF/jsp/user.jsp");
		
		//System.out.println(request.getQueryString());
		//System.out.println(request.getHeader("login"));
		boolean asAdmin = false;
		
		try {
			if(request.getParameter("action2") != null){
				asAdmin = true;
			}
			
			User user = userService.authorization(login, password, asAdmin);
			request.setAttribute("user", user);
			request.getSession(false).setAttribute("user", user);
		/*	/////////////////
			if(user.getRole()==null){
				request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
			}
			//////////////////  */
			if(user.getRole().equals("user")){
				request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/jsp/adminUser.jsp").forward(request, response);
			}
			
		} catch (ServiceAuthException e) {
			request.setAttribute("errorMessage", "Wrong login or password!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
		
	}
	
}
