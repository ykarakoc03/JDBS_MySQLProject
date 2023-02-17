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

			PreparedStatement ps=con.prepareStatement(
					"insert into ogrenciler values(?,?)");

			File f=new File("c:\\myfile.txt");
			FileReader fr=new FileReader(f);

			ps.setInt(1,101);
			ps.setCharacterStream(2,fr,(int)f.length());
			int i=ps.executeUpdate();
			System.out.println(i+" records affected");

			con.close();

		}catch (Exception e) {e.printStackTrace();}

	}
}