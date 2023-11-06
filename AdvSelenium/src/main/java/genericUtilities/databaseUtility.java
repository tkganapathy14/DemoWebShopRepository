package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.jdbc.Driver;

public class databaseUtility implements Iautoconstants{

	Driver dbdriver;
	Connection connection;
	Statement statement;
	ResultSet result;
	/**
	 * this method is used to connecting the database
	 */
	public void Establishconnection() {
		try {
			dbdriver=new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(Database_URL,Database_UN,Database_Pword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to Read the data from database
	 * @param query
	 * @param ColumnName
	 * @return
	 */
	public ArrayList ReadindDataFromDatabase(String query,String ColumnName)
	{
		ArrayList list=new ArrayList();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(result.next())
			{
				list.add(result.getString(ColumnName));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(list);
		return list;
	}
	/**
	 * this method is used to close the database connection
	 */
	public void closingConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

