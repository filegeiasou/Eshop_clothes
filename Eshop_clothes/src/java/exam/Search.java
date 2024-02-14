/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package exam;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author fileg
 */
public class Search extends HttpServlet {
    String product1 , color1 ,size1;
    int quantity1;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String product = (req.getParameter("product"));
        String sql = "Select * FROM products_tbl where product=?" ;
        Connection conn = EshopDao.getConnection();
        try
        {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,product);
            ResultSet rs = statement.executeQuery();
            out.println("<html>");
            out.println("<head><title>Search</title></head>");
            out.println("<body>");
            while (rs.next()) {
                 product1 = (rs.getString(1));
                 color1 =(rs.getString(2));
                 size1 =(rs.getString(3));
                 quantity1= (rs.getInt(4));
                out.println("<p>product: " + product1 + "</p>");
                out.println("<p>color: " + color1 + "</p>");
                out.println("<p>size: " + size1 + "</p>");
                out.println("<p>quantity: " + quantity1 + "</p>");
            }
           statement.close();
           rs.close();
            
        }catch(SQLException e){
                System.out.println(e);
        }
        out.println("<a href='./index.html'> Add </a>");
        out.println("</body>");
        out.println("</html>");
    }

}
