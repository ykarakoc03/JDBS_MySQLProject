import java.sql.*;

class DeletePrepared{

	public static void main(String args[]){
		try{

			//db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Meryem03";

			//Class.forName("com.mysql.cj.jdbc.Driver");

			//create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);

			PreparedStatement stmt=con.prepareStatement("delete from ogrenciler where id=?");
			stmt.setInt(1,122);

			int i=stmt.executeUpdate();
			System.out.println(i+" records deleted");

			con.close();

		}catch(Exception e){ System.out.println(e);}

	}
}