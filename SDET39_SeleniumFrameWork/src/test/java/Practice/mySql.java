package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class mySql
{
  public static void main(String[] args) throws SQLException
  {
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);

	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
	Statement statmt = conn.createStatement();
	String query = "select* from students";
     ResultSet result = statmt.executeQuery(query);
	while(result.next())
	{
		System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
	}
	conn.close();
  }
}