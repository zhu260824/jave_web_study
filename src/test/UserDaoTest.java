package test;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.dao.UserDao;
import jdbc.dao.impl.UserDaoImpl;
import jdbc.entity.User;
import jdbc.util.ConnectionFactory;

public class UserDaoTest {

	public static void main(String[] args) {
		Connection connection=null;
		try {
			connection=ConnectionFactory.getInstance().makeConnection();
			connection.setAutoCommit(false);
			UserDao userDao=new UserDaoImpl();
			User user5=new User();
			user5.setName("zl5");
			user5.setPassword("123456");
			user5.setEmail("整理@qq.com");
			userDao.save(connection, user5);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
