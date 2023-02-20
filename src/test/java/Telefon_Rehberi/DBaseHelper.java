package Telefon_Rehberi;


import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.ArrayList;

public class DBaseHelper {
    Connection connection = null;
    Statement statement = null;
    PreparedStatement pStatement = null;

    private void dBaseConnect() {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Meryem03";
        try {
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void useTelefonRehberi() {
        String sql = "USE telefonrehberi;";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void dBaseClose() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createDBase() {
        dBaseConnect();
        try {
            // Veritabanı ve tabloyu oluşturalım
            statement = connection.createStatement();
            String sql = "CREATE DATABASE if not exists telefonrehberi";
            statement.executeUpdate(sql);
            useTelefonRehberi();
            sql = "CREATE TABLE if not exists tel_nolar " +
                    "(id int not null primary key auto_increment, " +
                    " isim VARCHAR(45), " +
                    " tel VARCHAR(20)); ";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Hata CreateDbase" + e.toString());
        } finally {
            dBaseClose();
        }
    }

    public void addData(kayitSinifi kayit) {
        dBaseConnect();
        useTelefonRehberi();

        int result = 0;
        String sql = "Insert into tel_nolar(isim,tel) values(?,?);";
        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, kayit.getIsim());
            pStatement.setString(2, kayit.getTel());
            useTelefonRehberi();
            pStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("result=" + result);
            throw new RuntimeException(e);
        } finally {
            dBaseClose();
        }

    }

    public void deleteData(int id) {
        dBaseConnect();
        useTelefonRehberi();
        String sql = " DELETE FROM tel_nolar WHERE id = ?;";
        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, id);
            int result = pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            dBaseClose();
        }

    }

    public void upDateData(kayitSinifi kayit) {
        dBaseConnect(); //
        useTelefonRehberi();
        String sql = "UPDATE tel_nolar SET isim = ?, tel = ? WHERE id = ?;";
        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, kayit.getIsim());
            pStatement.setString(2, kayit.getTel());
            pStatement.setInt(3, kayit.getId());
            int result = pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            dBaseClose();
        }

    }

    public ArrayList<kayitSinifi> listData() {
        createDBase();
        ArrayList<kayitSinifi> liste = new ArrayList<>();
        dBaseConnect();
        useTelefonRehberi();
        ResultSet resultSet = null;
        String sql="select * from tel_nolar";
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                kayitSinifi kayit = new kayitSinifi();
                kayit.setId(resultSet.getInt(1));
                kayit.setIsim(resultSet.getString(2));
                kayit.setTel(resultSet.getString(3));
                liste.add(kayit);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            dBaseClose();
        }
        return liste;
    }

//    public ArrayList<kayitSinifi> listDataWithRowSet()  {
//        createDBase();
//        ArrayList<kayitSinifi> liste = new ArrayList<>();
//      //  dBaseConnect();
//      //  useTelefonRehberi();
//        String url = "jdbc:mysql://localhost:3306/telefonrehberi";
//        String username = "newuser";
//        String password = "new.1234";
//        String sql="select * from tel_nolar";
//        JdbcRowSet  rowSet = null;
//        try {
//            // Creating a JdbcRowSet object wihout connection
//            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
//            rowSet.setUrl(url);
//            rowSet.setUsername(username);
//            rowSet.setPassword(password);
//            rowSet.setCommand(sql);
//            rowSet.execute();
//            rowSet.setCommand(sql);
//            while( rowSet.next()) {
//                kayitSinifi kayit = new kayitSinifi();
//                kayit.setId(rowSet.getInt(1));
//                kayit.setIsim(rowSet.getString(2));
//                kayit.setTel(rowSet.getString(3));
//                liste.add(kayit);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        } finally {
//            try {
//                assert rowSet != null;
//                rowSet.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            dBaseClose();
//        }
//        return liste;
//    }

    public int getLastIndex() {
        int lastID=0;
        dBaseConnect();
        useTelefonRehberi();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT id FROM tel_nolar ORDER BY id DESC LIMIT 1;");
            if (resultSet.next()) {
                lastID = resultSet.getInt(1);
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            dBaseClose();
        }
        return lastID;
    }
}
