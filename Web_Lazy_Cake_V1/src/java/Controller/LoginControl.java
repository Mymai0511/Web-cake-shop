/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Admin;
import Entity.Customer;
import Model.AdminDAO;
import Model.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLEncoder;

/**
 *
 * @author DELL
 */
public class LoginControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");// lấy tên người dùng nhập vào
        String password = request.getParameter("password");// lấy mật khẩu người dùng nhập vào
        String isRemember = request.getParameter("remember");
        String isAdmin = request.getParameter("isAdmin");


        if (isAdmin != null) {
            /////////////////Admin Login
            AdminDAO db = new AdminDAO();
            Admin admin = db.loginByEmail(email, password);
            if (admin != null) { // login successful!
                Cookie c_name = new Cookie("username1", URLEncoder.encode(email, "UTF-8"));
                Cookie c_pass = new Cookie("password1", password);
                Cookie c_rem = new Cookie("remember1", isRemember);
                if (isRemember != null) {
                    c_name.setMaxAge(3600 * 24 * 30);
                    c_pass.setMaxAge(3600 * 24 * 30);
                    c_rem.setMaxAge(3600 * 24 * 30);
                } else {
                    c_name.setMaxAge(0);
                    c_pass.setMaxAge(0);
                    c_rem.setMaxAge(0);
                }
                response.addCookie(c_pass);
                response.addCookie(c_name);
                response.addCookie(c_rem);
                //response.sendRedirect("Detal.jsp");

                HttpSession session1 = request.getSession();
                session1.setAttribute("acc", admin);
                session1.setMaxInactiveInterval(60 * 15);//xét thời gian tồn tại của session trong 10 giây

                response.sendRedirect("home_admin.html");

            } else //login fail
            {
                request.setAttribute("mess", "Wrong user or pass");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }

        } else {
            /////////////////Customer Login
            CustomerDAO db = new CustomerDAO();
            Customer customer = db.loginByEmail(email, password);
            if (customer != null) { // login successful!
                Cookie c_name = new Cookie("username1", URLEncoder.encode(email, "UTF-8"));
                Cookie c_pass = new Cookie("password1", password);
                Cookie c_rem = new Cookie("remember1", isRemember);
                if (isRemember != null) {
                    c_name.setMaxAge(3600 * 24 * 30);
                    c_pass.setMaxAge(3600 * 24 * 30);
                    c_rem.setMaxAge(3600 * 24 * 30);
                } else {
                    c_name.setMaxAge(0);
                    c_pass.setMaxAge(0);
                    c_rem.setMaxAge(0);
                }
                response.addCookie(c_pass);
                response.addCookie(c_name);
                response.addCookie(c_rem);
                //response.sendRedirect("Detal.jsp");

                HttpSession session1 = request.getSession();
                session1.setAttribute("acc", customer);
                session1.setMaxInactiveInterval(60 * 15);//xét thời gian tồn tại của session trong 10 giây

                response.sendRedirect("index.html");

            } else //login fail
            {
                request.setAttribute("mess", "Wrong user or pass");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
