/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class AuthenticationServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthenticationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthenticationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        
        /**
         * Question 06
         * Write a servlet for user authentication.
         * If the username and password are correct,return a 200-status code.
         * Otherwise,return a 401-status code
         */
        
        
        //Get username and password parameters from the request
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //Check if the username and password are correct (Dummy example, replace with actual authentication logic)
        boolean isAuthenticated = authenticate(username,password);
        
        //Set the content type of the response
        response.setContentType("text/plain");
        
        //Get PrintWriter object to write the response
        PrintWriter out = response.getWriter();
        
        //If authentication successful, return200 status code
        if(isAuthenticated){
            response.setStatus(HttpServletResponse.SC_OK);
            out.println("Authentication successful !");
        }else{
            
            //If authentication failed, return 401 status code
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.println("Authentication failed. Please check username and password ");
        }
        //Close the PrintWriter
        out.close();
        
    }
    
    private boolean authenticate(String username, String password){
        return username.equals("admin")&& password.equals("password");
    }

    /**g
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
