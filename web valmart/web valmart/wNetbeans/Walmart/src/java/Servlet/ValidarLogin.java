package Servlet;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ValidarLogin", urlPatterns = {"/ValidarLogin"})
public class ValidarLogin extends HttpServlet {

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
        processRequest(request, response);
        
        UsuarioDAO udao = null;
        int idUsuario = 0;
        RequestDispatcher dispatcher;
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Usuario usuario = null;
        try {
            udao = new UsuarioDAO();
            idUsuario = udao.validarLogin(email, senha);
        } catch (Exception ex) {
            Logger.getLogger(ValidarLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (idUsuario != 0) {
            request.getSession().setAttribute("sessao", idUsuario);
            try {
                udao.conectar();
                usuario = udao.procurarUsuario(idUsuario);
            } catch (SQLException ex) {
                Logger.getLogger(ValidarLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ValidarLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ValidarLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getSession().setAttribute("nomeUsuario", usuario.getNome());
            response.sendRedirect("Mercadoria");
        }else{
            request.setAttribute("sessao", idUsuario);
            response.sendRedirect("Login");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
