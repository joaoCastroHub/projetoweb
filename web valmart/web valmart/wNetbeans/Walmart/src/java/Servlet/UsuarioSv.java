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

@WebServlet(name = "UsuarioSv", urlPatterns = {"/UsuarioSv"})
public class UsuarioSv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("sessao") == null || session.getAttribute("sessao").equals("0")) {
            response.sendRedirect("Login");
        }
        Usuario usuario = new Usuario();
        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuario = usuarioDAO.procurarUsuario(Integer.parseInt(session.getAttribute("sessao").toString()));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioSv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioSv.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("	<head>");
            out.println("		<title>Editar Usuário</title>");
            out.println("		<meta charset='UTF-8'>");
            out.println("	</head>");
            out.println("	<body>");
            out.println("		<fieldset>");
            out.println("			<legend>Editar Usuário</legend>");
            out.println("			<table>");
            out.println("				<form action='EditarUsuario' method='POST'>");
            out.println("					<table style='width:100%'>");
            out.println("						<form action='EditarUsuario' method='POST'>");
            out.println("							<tr>");
            out.println("								<td style='width:50%' align='right'>Nome Completo:</td>");
            out.println("								<td><input type='text' name='nome' value='"+usuario.getNome()+"'/></td>");
            out.println("							</tr>");
            out.println("							<tr>");
            out.println("								<td align='right'>Email:</td>");
            out.println("								<td><input type='text' name='email' value='"+usuario.getEmail()+"'/>");
            if(request.getParameter("email") != null)
                out.println("                                                                   <span>Email ja existente!<span/>");
            out.println("                                                               </td>");
            out.println("							</tr>");
            out.println("							<tr>");
            out.println("								<td align='right'>CPF ou CNPJ:</td>");
            out.println("								<td><input type='text' name='CPF' value='"+usuario.getCpf()+"'/></td>");
            out.println("							</tr>");
            out.println("							<tr>");
            out.println("								<td align='right'>Telefone:</td>");
            out.println("								<td>");
            out.println("                                                                   <input type='text' name='telefone' value='"+usuario.getTelefone()+"'/>");
            out.println("                                                               </td>");
            out.println("							<tr>");
            out.println("							<tr>");
            out.println("								<td align='right'>Senha Antiga:</td>");
            out.println("								<td>");
            out.println("                                                                   <input type='password' name='senhaAnt'/>");
            if(request.getParameter("senhaAnt") != null)
                out.println("                                                                   <span>Senha Invalida!<span/>");
            out.println("                                                               </td>");
            out.println("							</tr>");
            out.println("							<tr>");
            out.println("								<td align='right'>Nova Senha:</td>");
            out.println("								<td><input type='password' name='senhaNov'/>");
            if(request.getParameter("senhaCon") != null)
                out.println("                                                                   <span>Senhas não são iguais!<span/>");
            out.println("</td>");
            out.println("							</tr>");
            out.println("							<tr>");
            out.println("								<td align='right'>Confirmar Senha:</td>");
            out.println("								<td><input type='password' name='senhaCon'/></td>");
            out.println("							</tr>");
            out.println("							<tr>");
            if(usuario.isReceberEmail())
                out.println("								<td align='right'><input type='checkbox' name='receberEmail' checked/></td>");
            else
                out.println("								<td align='right'><input type='checkbox' name='receberEmail'/></td>");
            out.println("								<td>Desejo receber ofertas por e-mail</td>");
            out.println("							</tr>");
            out.println("							<tr>");
            out.println("								<td align='right'><a href='ExcluirUsuario?IdUsuario="+session.getAttribute("sessao")+"&senhaAnt="+request.getParameter("senhaAnt")+"'><input type='button' name='' value='Excluir'/></a></td>");
            out.println("								<td><input type='submit' value='salvar'/></td>");
            out.println("							</tr>");
            out.println("						</form>");
            out.println("					</table>");
            out.println("				</form>");
            out.println("			</table>");
            out.println("		</fieldset>");
            out.println("	</body>");
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
