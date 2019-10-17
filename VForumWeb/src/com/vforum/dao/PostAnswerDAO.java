package com.vforum.dao;
//interface for posting answer dao
import java.sql.SQLException;

import com.vforum.entities.Answers;

public interface PostAnswerDAO {

	public boolean storeAnswer(Answers answers)throws ClassNotFoundException, SQLException;
}
