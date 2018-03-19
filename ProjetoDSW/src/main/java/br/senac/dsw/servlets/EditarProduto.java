package br.senac.dsw.servlets;

import br.com.senac.dsw.dao.DAOCategoria;
import br.com.senac.dsw.dao.DAOProduto;
import br.com.senac.dsw.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarProduto", urlPatterns = {"/EditarProduto"})
public class EditarProduto extends HttpServlet {

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

        if (url.equals("/ProjetoDSW/editar")) {
            Long id = Long.parseLong(request.getParameter("id"));
            if (id != null && id > 0) {
                request.setAttribute("action", "/ProjetoDSW/atualizar");
                request.setAttribute("produto", DAOProduto.read(id));
                request.setAttribute("categorias", DAOCategoria.search());
                request.getRequestDispatcher("/WEB-INF/cadastro.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
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
        
        if (url.equals("/ProjetoDSW/atualizar")) {
            Produto produto = new Produto();
            produto.setId(Long.parseLong(request.getParameter("id")));
            produto.setNome(request.getParameter("nome"));
            produto.setDescricao(request.getParameter("descricao"));
            produto.setPrecoCompra(Double.parseDouble(request.getParameter("preco_compra")));
            produto.setPrecoVenda(Double.parseDouble(request.getParameter("preco_venda")));
            produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            String[] categorias = request.getParameterValues("categorias");
            
            if (DAOProduto.update(produto)) {
                DAOCategoria.deleteRelationship(produto.getId());
                DAOCategoria.createRelationship(produto.getId(), util.parseToArrayLong(categorias));
                response.sendRedirect(request.getContextPath() + "/ProjetoDSW?id=" + produto.getId());
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
