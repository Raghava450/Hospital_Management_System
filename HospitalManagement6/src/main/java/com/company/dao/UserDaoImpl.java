package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.util.DBUtil;

public class UserDaoImpl implements UserDao {
	 @Override
	    public boolean addUser(User user) {
	        String query = "INSERT INTO appo (name, email, phone,area,city,state,date,time,post_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPhone());
	            preparedStatement.setString(4, user.getArea());
	            preparedStatement.setString(5, user.getCity());
	            preparedStatement.setString(6, user.getState());
	            preparedStatement.setString(7, user.getDate());
	            preparedStatement.setString(8, user.getTime());
	            preparedStatement.setString(9, user.getPost_code());

	            int rowsAffected = preparedStatement.executeUpdate();

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public boolean isValidUser(String name, String email) {
	        String query = "SELECT * FROM appo WHERE name = ? AND email = ?";
	    	 try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, email);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            return resultSet.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

		@Override
		public boolean isValidAdmin(String name, String password) {
			 String query = "SELECT * FROM admin WHERE name = ? AND password = ?";
	    	 try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, password);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            return resultSet.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
		}

		@Override
		public boolean isValidDate(String date,String time) {
			 String query = "SELECT * FROM appo WHERE date = ? AND time = ?";
	    	 try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, date);
	            preparedStatement.setString(2, time);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            return resultSet.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
		}
	   
	
}