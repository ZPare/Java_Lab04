package task2_java_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

//Zoe - 300972366

public class DisplayAll {
	
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
		System.out.println("View Both Tables?: Yes or No");
		String input = scanner.next().toUpperCase();
		
//If Statement
		if(input.equals("YES")) {
			
	  //Display All Books Table
			System.out.println("        Books Table");
			stmt = conn.createStatement();
			rs=stmt.executeQuery("SELECT * FROM BOOKS_JAVA");
		while (rs.next()) {
			String title=rs.getString("TITLE");
			String author=rs.getString("AUTHOR");
			double price=rs.getDouble("PRICE");
			String type=rs.getString("TYPE");
			String subject=rs.getString("SUBJECT");
			
			System.out.println("\nBook Title: "+title);
			System.out.println("Author Name: "+author);
			System.out.println("Price of Book: "+price);
			System.out.println("Type of Book: "+type);
			System.out.println("Subject: "+subject);
		}
		//Display All Sales Table
		System.out.println("\n           Sales Table");
		stmt = conn.createStatement();
		rs=stmt.executeQuery("SELECT * FROM SALES");
	while (rs.next()) {
		String salesdate=rs.getString("SALESDATE");
		double quantity=rs.getDouble("QUANTITY");
		double price=rs.getDouble("PRICE");
		
		System.out.println("\nSales Date: "+salesdate);
		System.out.println("Quantity: "+quantity);
		System.out.println("Price of Book: "+price);
	}
		}
		
		}
		catch (Exception ex){
			System.out.println(ex.toString());
		}

	}

}
