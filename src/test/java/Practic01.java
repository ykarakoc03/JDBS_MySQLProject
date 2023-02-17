import java.sql.*;
import java.sql.Statement;
public class Practic01 {


    public static void main(String[] args) {
        try {
            String sorgu="SELECT * FROM ogrenciler WHERE lower(isim) ='Veli Mert' ";

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsae01","root","Meryem03");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sorgu);

            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("isim")+" "+rs.getString("adres")+" "+rs.getInt("sinav_notu"));
            }


            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }













}
