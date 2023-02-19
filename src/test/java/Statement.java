import java.sql.*;

public class Statement {

	public Statement() {
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

			java.sql.Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs=stmt.executeQuery("select * from ogrenciler");
			
			//getting the record of n rd row  
			rs.absolute(2);
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
			
			rs.last();
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
			
			con.close();  
			}catch(SQLException e){ System.out.println(e);}

	}

}
