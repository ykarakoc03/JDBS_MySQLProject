import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

class Rsmd{
	
	public static void main(String args[]){
		try{
			// db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Meryem03";

			// Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);

			PreparedStatement stmt=con.prepareStatement("select * from ogrenciler");		
			ResultSet rs = stmt.executeQuery();
						
			/*
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ogrenciler");
			*/

			ResultSetMetaData rsmd = rs.getMetaData();

			System.out.println("Toplam Kolon Sayisi: " + rsmd.getColumnCount());
			System.out.println("Ilk Kolonun Adi: " + rsmd.getColumnName(1));
			System.out.println("Ilk Kolonun Veri Tipi: " + rsmd.getColumnTypeName(1));

			con.close();

		}catch(Exception e){ System.out.println(e);}

	}
}