import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

import javax.swing.*;

public class DBHandler {
	
	Connection conn = null;
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Resources\\InventoryDB.sqlite")));
	/**
	 **************************************************************************************************************
	 * Connection to Database
	 **************************************************************************************************************
	 */	
	public static Connection dbConnector()
	
	{
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:Resources\\InventoryDB.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
			
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
		
		
		
	}

}
