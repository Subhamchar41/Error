/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author charv
 */
public class ViewItem extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
         
            Connection conn=ConnectDB.connect();
           String q;
            PreparedStatement pst;
           ResultSet trs;
        }
        try{
           Cookie c=new Cookie(request.getParameter("ItemId"),"1");
            c.setMaxAge(0);
            response.addCookie(c);
            out.print("Product Removed");
        }catch(Exception e){
           
        }
        out.print("<a href='ViewItem'>Go Back</a>");
        try{
            Cookie ck[]=request.getCookies();
             out.print(
          "<style>"
                +"td,th(padding14px 30px)"
                +"body{font-family:arial;}"
                +"table{border:1px solid black;}"
                +"a:hover{color:red;}"
          +"</style>"
             +"<table>"
               +"<tr>"
                +"<th>id</th>"
               +"<th>name</th>"
               +"<th>price</th>"
                   
        ); 
             for(int i=0;i<ck.length;i++){
                 q="select * from product where pid = " + ck[i].getName()+" ";
                 pst=conn.prepareStatement(q);
                 rst=pst..executeQuery();
                 
                 while(trs.next()){
            out.print("<tr><td>"+trs.geInt(1) +"</td>" 
                    +"<td>"+trs.geString(2) +"</td>"
                    +"<td>"+trs.geInt(3) +"</td>"  
                    +"<td><a href='DisplayItems?ItemId=" +trs.getInt(1)+"'>Remove</a></td>"
                    +"</tr><br><br>");
                 }
        }
        out.print("</table></body><html>");
             }
            
        }catch(Exception ex){
           
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
