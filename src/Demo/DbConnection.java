package Demo;
import java.sql.*;
public class DbConnection {
    private static Connection con=null;
    private DbConnection() {}
    static {
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
    	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shivam");
    }catch(Exception e) {e.printStackTrace();}
    }
    public static Connection getCon() {
    	return con;
    }
	
}
