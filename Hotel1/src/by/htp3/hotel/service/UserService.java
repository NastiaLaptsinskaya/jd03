package by.htp3.hotel.service;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.exeption.ServiceException;

public interface UserService {
	
	User authorization(String login, String password, Boolean asAdmin) throws ServiceException;
	
	User registration(String name, String surname, String login, String password, String repassword) throws ServiceException; /////////
	
	
	

}
