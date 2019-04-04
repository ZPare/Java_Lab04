package task2_java_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

//Zoe - 300972366

public class AddUpdateDelete {

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
			
		if(input.equals("BOOK")) {
			System.out.println("Input Selection \n");
			System.out.println("Add Record = 1");
			System.out.println("Update Record = 2");
			System.out.println("Delete = 3");
			String newinput = scanner.next();
			
		switch(newinput) {
		//Insert
		case "1":
			stmt = conn.createStatement();
			rs=stmt.executeQuery("INSERT INTO BOOKS_JAVA VALUES(7,'A Christmas Carol', 'Dickens', 10.00, 'Fiction', 'Holiday')");
			System.out.println("Inserted.");
			break;
		//Update
		case "2":
			stmt = conn.createStatement();
			rs=stmt.executeQuery("UPDATE BOOKS_JAVA SET AUTHOR ='Roberts' WHERE TITLE = 'Dogs'");
			System.out.println("Update Complete!");
			break;
		//Delete
		case "3":
			stmt = conn.createStatement();
			rs=stmt.executeQuery("DELETE FROM BOOKS_JAVA WHERE TITLE = 'Harry Potter'");
			System.out.println("Deleted.");
			break;
			}
		}
		else if (input.equals("SALES")){
			System.out.println("Input Selection \n");
			System.out.println("Add Record = 1");
			System.out.println("Update Record = 2");
			System.out.println("Delete = 3");
			String newinput = scanner.next();
			
		switch(newinput) {
		//Input 
		case "1":
			stmt = conn.createStatement();
			rs=stmt.executeQuery("INSERT INTO SALES VALUES(7,'1-Sep-2017', 3, 13.25)");
			break;
		//Update
		case "2":
			stmt = conn.createStatement();
			rs=stmt.executeQuery("UPDATE SALES SET PRICE =20.00 WHERE SALESDATE = '15-NOV-2018'");
			System.out.println("Update Complete!");
			break;
		//Delete
		case "3":
			stmt = conn.createStatement();
			rs=stmt.executeQuery("DELETE FROM SALES WHERE SALESDATE = '15-NOV-2018'");
			System.out.println("Deleted");
			break;
			}
		}
		else {
			System.out.println("Error!");
		}	
			}
		catch(Exception ex){
			System.out.println(ex.toString());
			}

	}

}
