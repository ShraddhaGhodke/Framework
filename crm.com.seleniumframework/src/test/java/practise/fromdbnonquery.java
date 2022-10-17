package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class fromdbnonquery {

	public static void main(String[] args) throws Throwable {

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		
	Statement stat = conn.createStatement();
		String query="insert into employee2(first_name,last_name,address,phone_num)values('guru','g','banglore','0')";
			     
		int  result =stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("user is created");
		}
		else
		{
	System.out.println("user is not created");
	
	}
conn.close();

}
}




