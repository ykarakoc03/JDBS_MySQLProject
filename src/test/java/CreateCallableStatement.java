import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class CreateCallableStatement {

	public CreateCallableStatement() {
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

			CallableStatement stmt = con.prepareCall("{call sp_ogrenci_bilgi(?, ?, ?)}");

			stmt.setInt(1,320);		
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.registerOutParameter(3, Types.INTEGER);  

			stmt.execute(); 

			System.out.println(stmt.getString(2));
			System.out.println(stmt.getInt(3));

			con.close();

		} catch(SQLException e){ System.out.println(e);}

	}

}