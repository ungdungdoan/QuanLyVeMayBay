import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB {

	public static void main(String[] args) {
		    
	      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
	         "databaseName=QUANLYVEMAYBAY;user=sa;password=PMT";  
	    
	      Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;  
	  
	      try {  
	    	  
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	         con = DriverManager.getConnection(connectionUrl);  
	   
	         String SQL = "SELECT TOP 10 * FROM TUYENBAY";  
	         stmt = con.createStatement();  
	         rs = stmt.executeQuery(SQL);  
	  
	         while (rs.next()) {  
	            System.out.println(rs.getString(4) + " " + rs.getString(6));  
	         }  
	      }  
	  
	      // Handle any errors that may have occurred.  
	      catch (Exception e) {  
	         e.printStackTrace();  
	      }  
	      finally {  
	         if (rs != null) try { rs.close(); } catch(Exception e) {}  
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
	         if (con != null) try { con.close(); } catch(Exception e) {}  
	      }  
	   }  
	}


