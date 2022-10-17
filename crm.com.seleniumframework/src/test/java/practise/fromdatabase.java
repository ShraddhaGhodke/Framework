package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

public class fromdatabase {

	public static void main(String[] args) throws Throwable  {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		
		   java.sql.Statement stat = conn.createStatement();
		
		String selectQuery="select * from employee2";
		
		ResultSet result = stat.executeQuery(selectQuery);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		
		
		conn.close();
	}

}
