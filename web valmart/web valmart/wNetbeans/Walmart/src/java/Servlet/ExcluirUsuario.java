package Servlet;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ExcluirUsuario", urlPatterns = {"/ExcluirUsuario"})
public class ExcluirUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session.getAttribute("sessao") == null || session.getAttribute("sessao").equals("0")) {
            response.sendRedirect("Login");
        }
        
        UsuarioDAO usuarioDAO = null;
        String email = request.getParameter("email");
        String senhaAnt = request.getParameter("senhaAnt");
        String nome = request.getParameter("Nome");
        String CPF = request.getParameter("CPF");
        String telefone = request.getParameter("telefone");
        String receberEmail = request.getParameter("receberEmail");
        Usuario usuario = new Usuario(nome, email, CPF, telefone, senhaAnt, Boolean.parseBoolean(receberEmail));
        
        try {
            if(usuarioDAO.validarLogin(email, senhaAnt) != 0){
                usuarioDAO.excluirUsuario(usuario);
                response.sendRedirect("UsuarioSv");
            }else{
                response.sendRedirect("UsuarioSv");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExcluirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ExcluirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExcluirUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExcluirUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
