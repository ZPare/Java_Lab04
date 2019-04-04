package task2_java_application;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

//Zoe - 300972366

public class SearchCriteria {
	
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
		
//User Input
		Scanner scanner = new Scanner(System.in);
					
		System.out.println("Book or Sales Table?");
		String input = scanner.next().toUpperCase();
		
		//If Book
		if(input.equals("BOOK")) {
			System.out.println("Search for Author");
			stmt = conn.createStatement();
			rs=stmt.executeQuery("SELECT AUTHOR FROM BOOKS_JAVA WHERE TITLE = 'Harry Potter'");
			//displaying search
			while (rs.next()) {
				String author = rs.getString("AUTHOR");
				System.out.println("Author Name: "+author);
			}
		}
		//If Sales
		else if(input.equals("SALES")) {
			stmt = conn.createStatement();
			rs=stmt.executeQuery("SELECT SALESDATE FROM SALES WHERE PRICE = 30.75");
			//displaying search
			while (rs.next()) {
				String salesdate=rs.getString("SALESDATE");
				
				System.out.println("\nSales Date: "+salesdate);
			}
		}
		else {
			System.out.println("Error!");
		}
	}
	catch(Exception ex) {
		System.out.println(ex.toString());
	}
	}

}
