package task2_java_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

//Zoe - 300972366

public class TotalAmount {

	static Connection conn;
	static java.sql.Statement stmt;
	static ResultSet rs;
	
public static void main(String[] args) {
	try {
//Creating connection to Oracle Database
			Class.forName("oracle.jdbc.OracleDriver");
								
			String connectionUrl = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
			String connectionUser="COMP214F18_001_P_19";
			String connectionPassword = "password";
								
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			
			System.out.println("Total Amount of Price in Sales Table");
			stmt = conn.createStatement();
			rs=stmt.executeQuery("SELECT SUM(PRICE) FROM SALES");
			//displaying sum
			while (rs.next()) {
				double price = rs.getDouble("PRICE");
				System.out.println("Total Sum: "+price);
			}
	}
	catch(Exception ex) {
		System.out.println(ex.toString());
	}

	}

}
