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

			PreparedStatement ps=con.prepareStatement("insert into personel values(?,?,?,?,?)");

			FileInputStream fin=new FileInputStream("C:\\fotograf.jpg");

			ps.setInt(1,1001);
			ps.setString(2,"Ali Can");
			ps.setInt(3,7000);

			ps.setBinaryStream(4,fin,fin.available());

			ps.setString(5,null);					

			int i=ps.executeUpdate();

			System.out.println(i+" records inserted");

			con.close();

		}catch (Exception e) {e.printStackTrace();}
	}
}
