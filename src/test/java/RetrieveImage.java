import java.sql.*;
import java.io.*;
public class RetrieveImage {
	public static void main(String[] args) {

		try{
			
			// db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Meryem03";

			// Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);

			PreparedStatement ps=con.prepareStatement("select * from personel");

			ResultSet rs=ps.executeQuery();

			rs.next();//now on 1st row

			Blob b=rs.getBlob(4);

			byte barr[]=new byte[(int)b.length()]; // an array is created but contains no data
			barr=b.getBytes(1,(int)b.length());

			FileOutputStream fout=new FileOutputStream("C:\\Users\\murat\\OneDrive\\Desktop\\fotograf2.jpg");
			fout.write(barr);
			fout.close();

			System.out.println("OK :)");

			con.close();

		}catch (Exception e) {e.printStackTrace();	}
	}
}