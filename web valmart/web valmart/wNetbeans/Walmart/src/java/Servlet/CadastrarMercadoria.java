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
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastrarMercadoria", urlPatterns = {"/CadastrarMercadoria"})
public class CadastrarMercadoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("sessao") == null || session.getAttribute("sessao").equals("0")) {
            response.sendRedirect("Login");
        }
       String nome = "";
       String imagem = "";
       int parcela = 0;
       float preco = 0;

        nome = request.getParameter("nome");
        parcela = Integer.parseInt(request.getParameter("qtdParcela"));
        preco = Float.parseFloat(request.getParameter("precoTotal"))/parcela;
        imagem = request.getParameter("imagem");
        MercadoriaDAO mercadoriaDAO = null;

        try {
            mercadoriaDAO = new MercadoriaDAO();
        } catch (Exception ex) {
            Logger.getLogger(CadastrarMercadoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Mercadoria mercadoria = new Mercadoria(imagem,nome, parcela, preco);
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
