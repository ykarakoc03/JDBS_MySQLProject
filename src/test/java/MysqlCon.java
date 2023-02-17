import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class MysqlCon {

	public MysqlCon() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		try{			
        			
			// db parameters
            String url       = "jdbc:mysql://localhost:3306/fsae01";
            String user      = "root";
            String password  = "Meryem03";
			
            // Class.forName("com.mysql.cj.jdbc.Driver");
			
            // create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);
			
			// System.out.println(DriverManager.getDriver(url));
			// System.out.println(DriverManager.getLoginTimeout());
			
			if (con!=null) System.out.println("Connection OK");

			con.close();
			
			}catch(SQLException e){ System.out.println(e);}

	}

}