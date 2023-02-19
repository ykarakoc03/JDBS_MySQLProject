import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetExample {

	public RowSetExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Creating and Executing RowSet  
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();

			rowSet.setUrl("jdbc:mysql://localhost:3306/fsae01");  
			rowSet.setUsername("root");  
			rowSet.setPassword("Meryem03");

			rowSet.setCommand("select * from ogrenciler");

			rowSet.execute();

			// Adding Listener and moving RowSet  
			rowSet.addRowSetListener(new MyListener());

			while (rowSet.next()) {  
				// Generating cursor Moved event  
				System.out.println("Id: " + rowSet.getInt(1));  
				System.out.println("Isim: " + rowSet.getString(2));  
				System.out.println("Adres: " + rowSet.getString(3));
				System.out.println("Not: " + rowSet.getInt(4));
			}		

			rowSet.close();

		} catch(Exception e){ System.out.println(e);}

	}

}
