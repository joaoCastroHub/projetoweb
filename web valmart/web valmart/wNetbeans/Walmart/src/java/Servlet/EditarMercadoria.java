package Servlet;

import DAO.MercadoriaDAO;
import Model.Mercadoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditarMercadoria", urlPatterns = {"/EditarMercadoria"})
public class EditarMercadoria extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("sessao") == null || session.getAttribute("sessao").equals("0")) {
            response.sendRedirect("Login");
        }
        
        MercadoriaDAO mercadoriaDAO = null;
        String nome = request.getParameter("nome");
        int parcela = Integer.parseInt(request.getParameter("qtdParcela"));
        float preco = Float.parseFloat(request.getParameter("precoTotal"))/parcela;
        String figura = request.getParameter("imagem");
        
        try {
            mercadoriaDAO = new MercadoriaDAO();
        } catch (Exception ex) {
            Logger.getLogger(CadastrarMercadoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Mercadoria mercadoria = new Mercadoria(figura,nome, parcela, preco);
        try {
            mercadoriaDAO.editarMercadoria(mercadoria);
        } catch (Exception ex) {
            Logger.getLogger(EditarMercadoria.class.getName()).log(Level.SEVERE, null, ex);
        }
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
