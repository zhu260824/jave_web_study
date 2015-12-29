package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.dao.UserDao;
import jdbc.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(Connection connection, User user) throws SQLException {
		String insertsql = "insert into tb_user(name,password,email)" + "values (?,?,?)";
		PreparedStatement ps = connection.prepareCall(insertsql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.execute();
	}

	@Override
	public void updata(Connection connection, Long id, User user) throws SQLException {
		String updatasql = "UPDATE tb_user SET name = ? , password = ? , email = ? , WHERE id = ?";
		PreparedStatement ps = connection.prepareCall(updatasql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setLong(4, id);
		ps.execute();
	}

	@Override
	public void delete(Connection connection, User user) throws SQLException {
		String deletesql = "DELETE FROM tb_user WHERE name = ?";
		PreparedStatement ps = connection.prepareCall(deletesql);
		ps.setLong(1, user.getId());
		ps.execute();
	}

}
