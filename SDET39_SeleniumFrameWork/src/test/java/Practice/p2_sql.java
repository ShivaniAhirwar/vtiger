package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class p2_sql
{
   public static void main(String[] args) throws SQLException
   {
	  Driver driver=new Driver();
	  DriverManager.registerDriver(driver);

	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
	 Statement statemt = conn.createStatement();
	  String query = "select * from students";
	  ResultSet ref = statemt.executeQuery(query);
	  while(ref.next())
	  {
		  System.out.println(ref.getInt(1)+"\t"+ref.getString(2)+"\t"+ref.getString(3)+"\t"+ref.getString(4));
	  }
	  conn.close();
   }
}
