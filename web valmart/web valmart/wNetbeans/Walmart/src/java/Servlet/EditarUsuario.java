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

@WebServlet(name = "EditarUsuario", urlPatterns = {"/EditarUsuario"})
public class EditarUsuario extends HttpServlet {

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
        HttpSession session = request.getSession();
        if (session.getAttribute("sessao") == null || session.getAttribute("sessao").equals("0")) {
            response.sendRedirect("Login");
        }
        String nome = request.getParameter("nome");
        String CPF = request.getParameter("CPF");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String senhaAnt = request.getParameter("senhaAnt");
        String senhaNov = request.getParameter("senhaNov");
        String senhaCon = request.getParameter("senhaCon");
        String receberEmail = request.getParameter("receberEmail");
        Usuario usuario = new Usuario(nome, email, CPF, telefone, senhaAnt, Boolean.parseBoolean(receberEmail));
        usuario.setId(Integer.parseInt(session.getAttribute("sessao").toString()));
        UsuarioDAO usuarioDAO;
        
        try {
            
            usuarioDAO = new UsuarioDAO();
            if(usuarioDAO.validarLogin(email, senhaAnt) != 0 && senhaNov.equals(senhaCon) && !usuarioDAO.validarEmail(usuario.getEmail(), usuario.getId())){
                usuarioDAO.conectar();
                usuarioDAO.editarUsuario(usuario);
                response.sendRedirect("UsuarioSv");
            }else if(!senhaNov.equals(senhaCon)){
                response.sendRedirect("UsuarioSv?senhaCon=1");
            }else if(usuarioDAO.validarEmail(usuario.getEmail(), usuario.getId())){
                response.sendRedirect("UsuarioSv?email=1");
            }else{
                response.sendRedirect("UsuarioSv?senhaAnt=1");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
