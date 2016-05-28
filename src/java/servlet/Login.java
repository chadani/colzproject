/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.PasswordEncryption;
import dao.SignupDao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 *
 * @author chadani
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String email=request.getParameter("email");
       String password=request.getParameter("pass");
        SignupDao sud=new SignupDao();
         String pw=sud.select(email);
         System.out.println(pw);
         System.out.println(password);
         int i=sud.selind(email);
         System.out.println(i);
          String ePassword=PasswordEncryption.encryptPassword(password);
          
           if(ePassword.equals(pw)){
               
               if(i==1){
                 request.setAttribute("mail", email);
               RequestDispatcher rd=request.getRequestDispatcher("reset.jsp");
                rd.forward(request, response);
                
                System.out.println("reset.jsp");
                sud.update(email);
   
               }else{
                
             RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
              rd.forward(request, response);
              System.out.println("login.jsp");   
               }
               
           }else{
              
             System.out.println("username email not valid"); 
           }
     
    }
        
        
             


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
