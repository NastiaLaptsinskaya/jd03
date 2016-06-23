package by.htp3.hotel.dao.impl;

import java.sql.PreparedStatement;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.UserDAO;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.dao.impl.pool.ConnectionPool;
import by.htp3.hotel.dao.impl.pool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {

	// private static final String AUTH_QUERY = "select * from users where
	// login=\""+login+"\" and password=\""+password+"\"";

	@Override
	public User authorization(String login, String password, Boolean asAdmin) throws DAOException {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//Class.forName("org.gjt.mm.mysql.Driver"); // регистрация драйвера
			con = ConnectionPool.getInstance().takeConnection();
			//con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb2", "root", "12345");

			st = con.prepareStatement("select * from users2 where login=? and password=?");
			st.setString(1, login);
			st.setString(2, password);
			
			rs = st.executeQuery();
			
			// int countRows = st.executeUpdate("select * from users where
			// login=\""+login+"\" and password=\""+password+"\"");
			// int countRows = st.executeUpdate("INSERT INTO users (id, name,
			// surname, login, password) VALUES (\"3\", \"Баба\", \"Яга\",
			// \"aaa\", \"sss\") ");
			// int countRows = st.executeUpdate("INSERT INTO users (id, name,
			// surname, login, password) VALUES (\"4\", \"Кощей\",
			// \"Бессмертный\", \"qqq\", \"www\") ");

			//rs = st.executeQuery("select * from users where login=\"" + login + "\" and password=\"" + password + "\"");
						
			if (!rs.next()) {
				return null;
			}

			User user = new User();
			user.setName(rs.getString("name"));
			user.setSurname(rs.getString("surname"));
			
			if (asAdmin){
				// trying enter in system as administrator
				if(rs.getString("user_role")==null){
						//System.out.println("YOU ARE USER");
						user.setRole("user");
					} else if(rs.getString("user_role").equals("admin")){
					     	//System.out.println("YOU ARE ADMIN");
						user.setRole("admin");
				}				
			} else{
				user.setRole("user");
			}
			System.out.println(user.getRole() + " userROLE");

			return user;
			
			/*
			 * while(rs.next()){ System.out.println(rs.getInt(1)+ " " +
			 * rs.getString(2) + " " + rs.getString(3)); }
			 */

		} catch (SQLException e) {
			throw new DAOException("Error in logination!", e);

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
				//loggin error
			}

		}

	}

	@Override
	public User registration(String name, String surname, String login, String password) throws DAOException {
		
		Connection con2 = null;
		PreparedStatement st2 = null;
		ResultSet rs2 = null;

		try {
			//Class.forName("org.gjt.mm.mysql.Driver"); // регистрация драйвера
			con2 = ConnectionPool.getInstance().takeConnection();
			//con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb2", "root", "12345");

			st2 = con2.prepareStatement("insert into users2 (name, surname, login, password)" + " values (?, ?, ?, ?)");
			
			st2.setString(1, name);
			st2.setString(2, surname);
			st2.setString(3, login);
			st2.setString(4, password);
			
			st2.execute();
			
			User user = new User();
			user.setName(name);
			user.setSurname(surname);
			
			return user;

		} catch (SQLException e) {
			throw new DAOException("Error in registration!", e);

		} catch (ConnectionPoolException e) {
			throw new DAOException("pool exception", e);
		}  finally {

			if (rs2 != null) {

				try {
					rs2.close();
				} catch (SQLException e) {
					// logging
				}
			}
			if (st2 != null) {

				try {
					st2.close();
				} catch (SQLException e) {
					// logging
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con2);
			} catch (ConnectionPoolException e) {
				//loggin error
			}
			/*if (con2 != null) {

				try {
					con2.close();
				} catch (SQLException e) {
					// logging
				}
			}*/

		}

	}
	
	

}
