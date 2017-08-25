package Servlet;

import DAO.MercadoriaDAO;
import Helpers.Helpers;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ExcluirMercadoria", urlPatterns = {"/ExcluirMercadoria"})
public class ExcluirMercadoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("sessao") == null || session.getAttribute("sessao").equals("0")) {
            response.sendRedirect("Login");
        }
        
        MercadoriaDAO mercadoriaDAO = null;
        String[] ids = request.getParameterValues("excluir");
        
        try {
            mercadoriaDAO = new MercadoriaDAO();
            mercadoriaDAO.excluirMercadoria(Helpers.selectInId(ids));
        } catch (Exception ex) {
            Logger.getLogger(ExcluirMercadoria.class.getName()).log(Level.SEVERE, null, ex);
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
