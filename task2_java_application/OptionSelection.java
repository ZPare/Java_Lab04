package task2_java_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

//Zoe - 300972366

public class OptionSelection {
	
	static Connection conn;
	static java.sql.Statement stmt;
	static ResultSet rs;
	
	public static void main(String[] args) {
		try {
//Creating connection to Oracle Database
		Class.forName("oracle.jdbc.OracleDriver");
			
		String connectionUrl = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
		String connectionUser="COMP214F18_001_P_19";
		String connectionPassword = "password";
			
		conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
//User Input
		//Reading from system.in
		Scanner reader = new Scanner(System.in);
		//Asking for user input
		System.out.println("Book or Sales");
		String userinput = reader.next().toUpperCase();
//Selection
		if (userinput.equals("BOOK")) {
			System.out.println("Input Selection \n");
			System.out.println("Add Record = 1");
			System.out.println("View Record = 2");
			System.out.println("Update Record = 3");
			System.out.println("Delete = 4");
			System.out.println("Search = 5");
			System.out.println("Quit = 6");
			String newinput = reader.next();
//Within Selection
			switch(newinput) {
			//Add Record
			case "1":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("INSERT INTO BOOKS_JAVA VALUES(6,'Calypso', 'Sedaris', 15.00, 'Fiction', 'Biography')");
				break;
			//View Record
			case "2":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("SELECT * FROM BOOKS_JAVA");
			//displaying
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
			break;
			//Update Record
			case "3":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("UPDATE BOOKS_JAVA SET AUTHOR ='Jonas' WHERE TITLE = 'Dogs'");
				System.out.println("Update Complete!");
				break;
			//Delete Record
			case "4":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("DELETE FROM BOOKS_JAVA WHERE TITLE = 'Dogs'");
				System.out.println("Deleted");
				break;
			//Search
			case "5":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("SELECT AUTHOR FROM BOOKS_JAVA WHERE TITLE = 'Harry Potter'");
				//displaying search
				while (rs.next()) {
					String author = rs.getString("AUTHOR");
					System.out.println("Author Name: "+author);
				}
				break;
			//Quit
			case "6":
				System.out.println("Goodbye.");
				break;
			}
			//end of switch
		}
		//end of if
		else if (userinput.equals("SALES")) {
			System.out.println("Input Selection \n");
			System.out.println("Add Record = 1");
			System.out.println("View Record = 2");
			System.out.println("Update Record = 3");
			System.out.println("Delete = 4");
			System.out.println("Search = 5");
			System.out.println("Quit = 6");
			String newinput = reader.next();
//Within Selection
			switch(newinput) {
			//Add Record
			case "1":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("INSERT INTO SALES VALUES(6,'11-Sep-2018', 23, 15.85)");
				break;
			//View Record
			case "2":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("SELECT * FROM SALES");
			//displaying 
			while (rs.next()) {
				String salesdate=rs.getString("SALESDATE");
				double quantity=rs.getDouble("QUANTITY");
				double price=rs.getDouble("PRICE");
				
				System.out.println("\nSales Date: "+salesdate);
				System.out.println("Quantity: "+quantity);
				System.out.println("Price of Book: "+price);
			}
			break;
			//Update Record
			case "3":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("UPDATE SALES SET PRICE =20.00 WHERE SALESDATE = '15-NOV-2018'");
				System.out.println("Update Complete!");
				break;
			//Delete Record
			case "4":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("DELETE FROM SALES WHERE SALESDATE = '15-NOV-2018'");
				System.out.println("Deleted");
				break;
			//Search
			case "5":
				stmt = conn.createStatement();
				rs=stmt.executeQuery("SELECT QUANTITY FROM SALES WHERE PRICE = 30.75");
				//displaying search
				while(rs.next()) {
					double quantity=rs.getDouble("QUANTITY");
					
					System.out.println("Quantity: "+quantity);
				}
				break;
			//Quit
			case "6":
				System.out.println("Goodbye.");
				break;
			}
			//end of switch
		}
		//end of else if
		else {
			System.out.println("ERROR! try again.");
		}
	}
		catch (Exception ex){
			System.out.println(ex.toString());
		}
}
}
