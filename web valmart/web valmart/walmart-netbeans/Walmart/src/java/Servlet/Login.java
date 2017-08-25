package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!doctype html>");
            out.println("<html>");
            out.println("	<head>");
            out.println("		<title></title>");
            out.println("		<link rel='stylesheet' type='text/css' href='_css/logincss.css'>");
            out.println("		<meta charset='utf-8'>");
            out.println("	</head>");
            out.println("	<body>");
            out.println("		<div class='fundo'>");
            out.println("		</div>");
            out.println("		<form action='ValidarLogin' method='post'>");
            out.println("		<div class='login'>");
            out.println("                   <div class='corpo'>");
            out.println("                       <div class='entrar'>");
            out.println("                           Entrar");
            out.println("			</div>");
            out.println("			<div class='meio'>");
            out.println("				<div class='useconta'>");
            out.println("					Use sua conta Walmart.com");
            out.println("				</div>");
            out.println("       			<div class='email'>");
            out.println("					<img class='envelope' src='_img/envelope.png' alt='envelope'>");
            out.println("               			<input class='input-box' type='text' maxlength='100' name='email' placeholder='E-mail, CPF ou CNPJ' autocomplete='off'>");
            out.println("				</div>");
            out.println("				<div class='senha'>");
            out.println("					<img class='cadeado' src='_img/cadeado.png' alt='cadeado'>");
            out.println("					<input class='input-box pass' type='password' maxlength='100' name='senha' placeholder='Senha' autocomplete='off'>");
            out.println("				</div>	");
            out.println("				<input type='submit'>");
            out.println("                       	<p class='continuarconectado'>");
            out.println("                               	<input  class='cboxconectado' id='stayconected' type='checkbox' value='true' name='conected'> <label for='stayconected'>Continuar conectado</label> ");
            out.println("				</p>");
            out.println("				<p class=esqueciasenha>");
            out.println("					<a href=''>Esqueci minha senha</a>");
            out.println("               		</p>						");
            out.println("			</div>");
            out.println("			<div class='rodape'>");
            out.println("				'Não tem conta no Walmart.com?'");
            out.println("				<p class='cadastreaqui'>");
            out.println("					<a href=''>Cadastre aqui</a>");
            out.println("				</p>");
            out.println("			</div>");
            out.println("		</div>			");
            out.println("           </div>");
            out.println("           </form>");
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
