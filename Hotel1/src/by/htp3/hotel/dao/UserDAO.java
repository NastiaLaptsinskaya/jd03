package by.htp3.hotel.dao;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.exception.DAOException;

public interface UserDAO {
	
	User authorization(String login, String password, Boolean asAdmin) throws DAOException;
	
	User registration(String name, String surname, String login, String password) throws DAOException;

}
