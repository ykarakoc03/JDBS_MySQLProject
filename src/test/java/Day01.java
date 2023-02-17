import java.sql.*;

public class Day01 {


    public static void main(String[] args) {


        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsae01","root","Meryem03");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ogrenciler");

            while(rs.next()) {  //while !rs.isLast() yazıp rs.next() aşagı yazıncada çalışir

                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
                //System.out.println(rs.getInt("id")+" "+rs.getString("isim")+" "+rs.getString("adres")+" "+rs.getInt("sinav_notu"));

            }
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }








}
