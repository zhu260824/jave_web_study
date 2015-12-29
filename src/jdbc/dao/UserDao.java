package jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.entity.User;

public interface UserDao {

	public void save(Connection connection,User user) throws SQLException;
	
	public void updata(Connection connection,Long id,User user)throws SQLException;
	
	public void delete(Connection connection,User user) throws SQLException;
}
