package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TransactionTest {
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

	public static void insertUser(Connection connection) throws SQLException {
		String sql = "insert into .tb_user(name,password,email)" + "values ('zl4','123456','zl4@qq.com')";
		Statement st = (Statement) connection.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("用户向user表中插入了" + count + "条数据");
	}

	public static void insertAdress(Connection connection) throws SQLException {
		String sql = "insert into test_db.tb_address (id,city,country,user_id) values ('1','hefei','china','5')";
		Statement st = (Statement) connection.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("用户向adress表中插入了" + count + "条数据");
		connection.close();
	}

	public static void main(String[] args) {
		Connection  connection=null;
		try {
			connection=getConnection();
			connection.setAutoCommit(false);//禁止事物自动提交
			insertUser(connection);
			insertAdress(connection);
			connection.commit();
		} catch (SQLException e) {
			System.out.println("-----------error------------");
			e.printStackTrace();
			try {
				connection.rollback();
				System.out.println("事物回滚成功");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if (connection!=null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
