/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Customer;
import Model.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class SignupControl extends HttpServlet {

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
        String email = request.getParameter("email");
        String pass1 = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        if (!pass1.equals(re_pass)) {
            request.setAttribute("email", email);
            request.setAttribute("pass", pass1);
            request.setAttribute("mess", "Password and Re_Password don't match..!!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            CustomerDAO dao = new CustomerDAO();
            boolean isExists = dao.customerExists(email);
            if (isExists = false) {// account chưa tồn tại-> signUp
                dao.signupCustomer(email, pass1);
//                request.setAttribute("name", name1);
//                request.setAttribute("pass", pass1);
//                request.getRequestDispatcher("home").forward(request, response);
                response.sendRedirect("home");
            } else {// acount đã tồn tại-> đẩy về SignUp
                request.setAttribute("email", email);
                request.setAttribute("pass", pass1);
                request.setAttribute("re_pass", re_pass);
                request.setAttribute("mess", "Account already exists..!!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }

        }
        //sign up
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
