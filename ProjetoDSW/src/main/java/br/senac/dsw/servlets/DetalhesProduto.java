/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.dsw.servlets;

import br.com.senac.dsw.dao.DAOCategoria;
import br.com.senac.dsw.dao.DAOProduto;
import br.com.senac.dsw.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetalhesProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String url = request.getServletPath();
        String id = request.getParameter("id");
        
        if (url.equals("/ProjetoDSW")) {
            String responseURL;
            if (id != null) {
                Produto produto = DAOProduto.read(Long.parseLong(id));
                request.setAttribute("produto", produto);
                request.getRequestDispatcher("/WEB-INF/detalhes.jsp").forward(request, response);
            } else {
                List<Produto> produtos = DAOProduto.search();
                request.setAttribute("produtos", produtos);
                request.getRequestDispatcher("/WEB-INF/lista.jsp").forward(request, response);
            }
            
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
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
   request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String url = request.getServletPath();
        String id = request.getParameter("id");
        
        if (url.equals("/ProjetoDSW/deletar") && id != null) {
            DAOCategoria.deleteRelationship(Long.parseLong(id));
            DAOProduto.delete(DAOProduto.read(Long.parseLong(id)));
            response.sendRedirect(request.getContextPath() + "/ProjetoDSW");
        } else {        
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
