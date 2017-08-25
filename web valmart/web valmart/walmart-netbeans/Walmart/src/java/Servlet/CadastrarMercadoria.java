package Servlet;

import DAO.MercadoriaDAO;
import Model.Mercadoria;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarMercadoria", urlPatterns = {"/CadastrarMercadoria"})
public class CadastrarMercadoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
        MercadoriaDAO mercadoriaDAO = null;
        String nome = request.getParameter("nome");
        int parcela = Integer.parseInt(request.getParameter("qtdParcela"));
        float preco = Float.parseFloat(request.getParameter("precoTotal"))/parcela;
        
        try {
            mercadoriaDAO = new MercadoriaDAO();
        } catch (Exception ex) {
            Logger.getLogger(CadastrarMercadoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Mercadoria mercadoria = new Mercadoria(nome, parcela, preco);
        mercadoriaDAO.adicionarMercadoria(mercadoria);
        response.sendRedirect("Mercadoria");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
