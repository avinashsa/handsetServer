package handsetServer;

import java.sql.*;
import java.util.ArrayList;

public class DBHandle {

	private Connection conn;

	public void connect( String connectionString, String username, String passwd ) {
		System.out.println("connecting");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("class not found dude");
		}
		
		try {
			conn = DriverManager.getConnection(connectionString, username, passwd);
		}
		catch (SQLException ex ){
			System.out.println("SQL exception dude");
		}

	}

	public void disConnect() {
		System.out.println("disconnecting");
	}
	
	
	
	public void runSql( String sqlText ) {
		
		Statement stmt ;
		CallableStatement cstmt;  
		try {
		
			String collSqlText = "select count(*) no_recs from collection_files where repaymentdate = hfs_date(0) ";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(collSqlText);
			while (rs.next()) {
				System.out.println("number of recs = " + rs.getInt("no_recs"));
			}
			
			String collReadSqlText = "{call hsfin_collection.readcollectionfiles(hfs_date(0))}";
			cstmt = conn.prepareCall(collReadSqlText);
            cstmt.execute();
            cstmt.close();
            
            rs = stmt.executeQuery(collSqlText);
			while (rs.next()) {
				System.out.println("number of recs = " + rs.getInt("no_recs"));
			}
			
		} 
		catch (SQLException ex ) {
			System.out.println("SQL exception connection dude");
		}

	}
	
}
