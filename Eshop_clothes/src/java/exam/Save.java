/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package exam;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

/**
 *
 * @author fileg
 */
public class Save extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        Eshop es = new Eshop();
        es.setProduct(request.getParameter("product"));
        es.setColor(request.getParameter("color"));
        es.setSize(request.getParameter("size"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        es.setQuantity(quantity);

        int status = EshopDao.save(es);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sign Up Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Order Saved!</h1>");
        out.println("<a href='./Searchpage.html'> Search </a>");
        out.println("</body></html>");
        out.close();
    }

}
