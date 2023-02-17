import java.sql.*;

public class Practic02 {


    public static void main(String[] args) {
        try {
            String sorgu="SELECT * FROM ogrenciler WHERE lower(adres) =? and sinav_notu>?";

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsae01","root","Meryem03");
            PreparedStatement prStmt = conn.prepareStatement(sorgu);
           prStmt.setString(1,"ankara");
           prStmt.setString(2,"75");

           ResultSet rs = prStmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("isim")+" "+rs.getString("adres")+" "+rs.getInt("sinav_notu"));
            }


            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }













}
