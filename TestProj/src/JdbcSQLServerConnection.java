import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.jdbc.Statement;
 
public class JdbcSQLServerConnection {
    public static void main(String[] argv) throws Exception {
    	
        try
        {
        	Properties props= new Properties();
        	FileInputStream input = null;
        	input = new FileInputStream("db.properties");
        	props.load(input );
        	
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = null;
            connection = DriverManager
                    .getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USERNAME"),props.getProperty("DB_PASSWORD"));
            Statement st = (Statement) connection.createStatement();
        	String sql = ("SELECT * FROM variable where name = 'Mac Address'");
        	ResultSet rs = st.executeQuery(sql);
        	        if (rs.next()) {//get first result
        	            System.out.println("Fetched Results:"+rs.getString(2));
        	        }

        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
       
       
              
    
}
}