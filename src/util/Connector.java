package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private final String user = "hr";
	private final String password = "hr";
	Connection con = null;

	public Connector() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Connection open() throws SQLException {
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", user, password);
		return con;
	}

	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
