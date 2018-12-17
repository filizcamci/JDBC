package jdbc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class DB_RUN_TryWithResources {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		// String url = "jdbc:oracle:thin:@YOUR-EC2-HOSTNAME-GOES-HERE:1521:xe";
		String url = "jdbc:oracle:thin:@ec2-18-191-82-32.us-east-2.compute.amazonaws.com:1521:xe";
		String user = "hr"; // or your username
		String password = "hr";// or your password
		
		try( Connection conn = DriverManager.getConnection(url, user, password) ; 
			 Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			 ResultSet rs = st.executeQuery("SELECT * FROM job_history")
			) {
			
				rs.next() ; 
				System.out.println( rs.getObject(1) );
			
			System.out.println("connected ");
			
		}catch(Exception e) {
			
			System.out.println("Aaaa");
		}


	}
}
