package jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCTest1 {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void insert() {
		Connection connection = getConnection();
		try {
			String sql = "insert into test_db.tb_user(name,password,email)" + "values ('zl3','123456','zl3@qq.com')";
			Statement st = (Statement) connection.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("" + count);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete() {
		Connection connection = getConnection();
		try {
			String sql = "DELETE FROM test_db.tb_user WHERE name = 'zl1'";
			Statement st = (Statement) connection.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("" + count);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void UpData() {
		Connection connection = getConnection();
		try {
			String sql = "UPDATE test_db.tb_user SET email = '123456@365.com' WHERE id = 4";
			Statement st = (Statement) connection.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("" + count);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		insert();
	}
}
