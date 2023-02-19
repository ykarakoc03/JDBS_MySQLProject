import java.io.*;
import java.sql.*;

public class StoreFile {
	public static void main(String[] args) {
		try{
			// db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Meryem03";

			// Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);


			PreparedStatement ps=con.prepareStatement("insert into personel (id, isim, maas, fotograf, cv) values(?,?,?,?,?)");

			File f = new File("C:\\CV.txt");
			FileReader fr = new FileReader(f);

			ps.setInt(1,1002);
			ps.setString(2,"Veli Mert");
			ps.setInt(3,85000);
			ps.setString(4,null);
			
			ps.setCharacterStream(5,fr,(int)f.length());
			
			int i=ps.executeUpdate();
			
			System.out.println(i+" records inserted");

			con.close();

		}catch (Exception e) {e.printStackTrace();}

	}
}