package Servlet;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        UsuarioDAO dAO = new UsuarioDAO();
        HttpSession session = request.getSession();
        
        if (request.getParameter("senha").equals(request.getParameter("confirmarSenha")) && !request.getParameter("senha").equals("")) {
            Usuario usuario = new Usuario();
            if(request.getParameter("nome") != null)
                usuario.setNome(request.getParameter("nome"));
            else
                response.sendRedirect("Cadastre?Nome=1");
            if(!dAO.validarEmail(request.getParameter("email")))
                usuario.setEmail(request.getParameter("email"));
            else
                response.sendRedirect("Cadastre?Email=1");
            if(request.getParameter("cpfcnpj") != null)
                usuario.setCpf(request.getParameter("cpfcnpj"));
            else
                response.sendRedirect("Cadastre?CPF=1");
            if(request.getParameter("telefone") != null)
                usuario.setTelefone(request.getParameter("telefone"));
            else
                response.sendRedirect("Cadastre?Telefone=1");
            usuario.setSenha(request.getParameter("senha"));
            System.out.println(request.getParameter("senha"));
            usuario.setReceberEmail(Boolean.valueOf(request.getParameter("receberemail")));
            
            
            UsuarioDAO usuarioDAO;
            try {
                usuarioDAO = new UsuarioDAO();
                usuarioDAO.adicionarUsuario(usuario);
            } catch (Exception ex) {
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("Mercadoria");
            
        }else{
        
            response.sendRedirect("Cadastre?Senha=1");
            
        }
    }

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
