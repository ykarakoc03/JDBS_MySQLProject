import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionManagement {

	public TransactionManagement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]){

		try {
			// db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Meryem03";

			// Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);

			con.setAutoCommit(false);

			PreparedStatement stmt = con.prepareStatement("insert into ogrenciler values(?,?,?,?)");

			int id;
			String isim;
			String adres;
			int sinav_notu;
			
			int i;

			id = 320;
			isim = "Ali Can";
			adres = "Ankara";
			sinav_notu = 75;	

			stmt.setInt(1,id); //1 specifies the first parameter in the query
			stmt.setString(2,isim);
			stmt.setString(3,adres);
			stmt.setInt(4,sinav_notu);

			i=stmt.executeUpdate();

			System.out.println(i+" records affected");


			id = 321;
			isim = "Veli Mert";
			adres = "Trabzon";
			sinav_notu = 85;

			stmt.setInt(1,id); //1 specifies the first parameter in the query
			stmt.setString(2,isim);
			stmt.setString(3,adres);
			stmt.setInt(4,sinav_notu);

			i=stmt.executeUpdate();

			System.out.println(i+" records affected");

			con.commit();
			// con.rollback();					

			con.close();


		}catch(Exception e){ System.out.println(e);}

	}

}