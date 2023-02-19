import java.sql.*;
class UpdatePrepared{
	public static void main(String args[]){
		try{
			// db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Meryem03";

			// Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);

			PreparedStatement stmt=con.prepareStatement("update ogrenciler set isim=? where id=?");
			
			stmt.setString(1,"Martin Parr");//1 specifies the first parameter in the query i.e. name
			stmt.setInt(2,220);

			int i=stmt.executeUpdate();
			
			System.out.println(i+" records updated");

			con.close();

		}catch(Exception e){ System.out.println(e);}

	}
}