/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class NewServlet4 extends HttpServlet {

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
            out.println("<title>Servlet NewServlet4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet4 at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        /**Question 5
         * Write a servlet that reads and displays the value of a specific cookie sent by the client's browser.
         * If the cookie doesn't exist,generate, and send a new one
         */
        
        //Set content type of the reponse
        response.setContentType("text/html");
        
        //Get the PrintWriter object to write the response 
        PrintWriter out = response.getWriter();
        
        //Get the cookies sent by the client
        Cookie[] cookies = request.getCookies();
        
        //Flag to check if the specific cookie exists
        Boolean cookieFound = false;
        
        //Name of the specific cookie
        String cookieName = "myCookie";
        
        //Value of the specific cookie
        String cookieValue = null;
        
        //Check if the cookies array is not null
        if (cookies != null){
            //Loop through the cookies to find the specific cookie
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                cookieFound = true;
                cookieValue = cookie.getValue();
                break;
                }
            }
        } 
        //If the specific cookie doesn't exist, generate and send a new 
        
        if(!cookieFound){
            cookieValue = "generatedValue"; // Generate the value for the newCookie
            Cookie newCookie = new Cookie(cookieName,cookieValue);
            response.addCookie(newCookie); //Add the new cookie to the response
            
            //Display the value of the dpecific cookie
            out.println("<html><head><title>Cookie Servlet</title></head><body>");
            out.println("<h2>Value of the specific cookie: </h2>");
            out.println("<p>" + cookieValue + "</p>");
            out.println("</body></html>");
            
            //Close the PrintWritter
            out.close();
        }
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
