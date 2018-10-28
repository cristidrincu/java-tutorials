/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apress.ejb.chp02.client;

import com.apress.ejb.chp02.SearchFacadeBean;
import com.apress.ejb.chp02.utility.ShopperCountBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cristiandrincu
 */
@WebServlet(name = "SearchFacadeClient", urlPatterns = {"/SearchFacadeClient"})
public class SearchFacadeClient extends HttpServlet {

    @EJB
    SearchFacadeBean searchFacade;
    
    @EJB
    ShopperCountBean shopperCount;
    
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
            out.println("<title>Servlet SearchFacadeClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchFacadeClient at " + request.getContextPath() + "</h1>");
            out.println("<h1>Starting Search Facade test... </h1>");
            out.println("<h1>Search Wines... </h1>");
            List<String> winesList = searchFacade.wineSearch("Red");
            out.println("<p>Printing wines list</p><br/>");
            for( String wine : (List<String>)winesList){
                out.println("<ul><li>" + wine + "</li></ul>");
            }
            System.out.println("Printing shopper count after incrementing it: ");
            shopperCount.incrementShopperCount();
            out.println("<h1>" + shopperCount.getNumberOfShopers() + "</h1>");
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
