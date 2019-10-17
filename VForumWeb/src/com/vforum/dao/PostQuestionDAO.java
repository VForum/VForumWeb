package com.vforum.dao;
//dao interface of postQuestion
import java.sql.SQLException;
import com.vforum.entities.Posts;

public interface PostQuestionDAO {

	public boolean storeQuestion(Posts posts)throws ClassNotFoundException, SQLException;
}
