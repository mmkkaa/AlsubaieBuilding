
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DatabaseConnection.java
 * 
 * This class is used to connect to the database.
 *
 */
public class DatabaseConnection {
	public ResultSet rs;
	protected Connection conn;
	protected PreparedStatement pst;
	protected Statement stmt;

	/*
	 * DatabaseConnection()
	 */
	public DatabaseConnection(String URL, String driver, String user,
			String password) {
		try {
			Class.forName(driver);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * executeQuery()
	 */
	public ResultSet executeQuery(String sql, String value1, String value2) {
		try {
			pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			// to assign the argument passed in the TestConnection class to the
			// "app_num" in SQL Query
			pst.setString(1, value1);
			pst.setString(2, value2);
			return pst.executeQuery();
		} catch (Exception e) {
			System.out.println("Error in Command \n" + e);
			e.printStackTrace();
		}
		return null;
	}
	
	public void executeArchive(String date) throws SQLException
	{
				
		CallableStatement cs = conn.prepareCall("{call archive_history(?)}");
		cs.setString(1,date);
		cs.executeUpdate();	
	}

	public void executeUpdate(String query) throws SQLException {
		try {

			pst.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Error in Command\n" + e);
			e.printStackTrace();
		}
	}

	/*
	 * execute()
	 */
	public ResultSet execute(String sql) {

		try {
			pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			return pst.executeQuery();

		} catch (Exception e) {
			System.out.println("Error in Command\n" + e);
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * closeConnection()
	 */
	public void closeConnection() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

			}
		}
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {

			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
	}
}