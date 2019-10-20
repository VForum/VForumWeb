package com.vforum.dao;
//Implementation class for LoginDao
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vforum.integrate.ConnectionManager;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public String userAuth(String userId, String password)throws ClassNotFoundException,SQLException {
			String role="";
			Connection connection=ConnectionManager.openConnection();
			System.out.println("hlo");
			String query2="select role from user_credentials where username=? and user_password=?";
			PreparedStatement preparedStatement2=connection.prepareStatement(query2);
			preparedStatement2.setString(1, userId);
			preparedStatement2.setString(2, password);
			ResultSet rs2 = preparedStatement2.executeQuery();
			while(rs2.next()) {
			role=rs2.getString("role");}
			return role;	
	}
}
