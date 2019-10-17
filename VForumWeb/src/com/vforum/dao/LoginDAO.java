package com.vforum.dao;
//Interface of LoginDao
import java.sql.SQLException;

public interface LoginDAO {

	public String userAuth(String userId,String password)throws ClassNotFoundException,SQLException;
}
