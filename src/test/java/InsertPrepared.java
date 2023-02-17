import java.sql.*;

class InsertPrepared{

	public static void main(String args[]){
		try{
			// db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Meryem03";

			// Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);
			
			// (220, 'Ali Can', 'Ankara', 75);			

			PreparedStatement stmt=con.prepareStatement("insert into ogrenciler values(?,?,?,?)");
			
			stmt.setInt(1,220);//1 specifies the first parameter in the query
			stmt.setString(2,"Ali Can");
			stmt.setString(3,"Ankara");
			stmt.setInt(4,75);

			int i=stmt.executeUpdate();
			
			System.out.println(i+" records inserted");

			con.close();

		}catch(Exception e){ System.out.println(e);}

	}
}