import java.sql.*;
import java.io.*;

public class InsertImage {
	public static void main(String[] args) {
		try{

			// db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Meryem03";

			// Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);

			PreparedStatement ps=con.prepareStatement("insert into imgtable values(?,?)");

			FileInputStream fin=new FileInputStream("d:\\g.jpg");

			ps.setString(1,"sonoo");
			ps.setBinaryStream(2,fin,fin.available());
			int i=ps.executeUpdate();
			System.out.println(i+" records affected");

			con.close();

		}catch (Exception e) {e.printStackTrace();}
	}
}
