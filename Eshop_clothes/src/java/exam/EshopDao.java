package exam;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fileg
 */
public class EshopDao {
    static final String SQLITE_DRIVER = "org.sqlite.JDBC";
    static final String SQLITE_SUB = "jdbc:sqlite:";
    static final String DB_SERVER ="C:\\Users\\fileg\\OneDrive\\Υπολογιστής\\";
    static final String DB_NAME = "eshop_db";
    static final String DB_URL = SQLITE_SUB + DB_SERVER + DB_NAME;
    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(SQLITE_DRIVER);
            conn = DriverManager.getConnection(DB_URL);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }

        return conn;
    }
    
    public static int save(Eshop es) {
        int status = 0;
        String sql = "INSERT INTO products_tbl(product, color, size , quantity) VALUES (?, ?, ?, ?)";
        Connection conn = EshopDao.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, es.getProduct());
            ps.setString(2, es.getColor());
            ps.setString(3, es.getSize());
            ps.setInt(4, es.getQuantity());
            status = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }
    
}
