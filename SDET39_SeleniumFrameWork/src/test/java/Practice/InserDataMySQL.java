package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InserDataMySQL
{
   public static void main(String[] args) throws SQLException
   {
	  Driver driver=new Driver();
	  DriverManager.registerDriver(driver);

	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");

	   Statement state = conn.createStatement();
	  String details = "insert into students(first_name,last_name,address) values('shivani','ahirwar','gwalior')";
	  int result = state.executeUpdate(details);

	  if(result==1)
	  {
		  System.out.println("user created");
	  }
	  else
	  {
		  System.out.println("user not created");
	  }
	  conn.close();
   }
}
