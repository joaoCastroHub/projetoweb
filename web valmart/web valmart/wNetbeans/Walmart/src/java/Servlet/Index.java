package Servlet;

import DAO.MercadoriaDAO;
import Helpers.Helpers;
import Model.Mercadoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Index"})
public class Index extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int i = 0, j = 0, k = 0, l =0;
        HttpSession session = request.getSession();
        MercadoriaDAO mercadoriaDAO = null;
        ArrayList<Mercadoria> mercadorias = null;
        try {
            mercadoriaDAO = new MercadoriaDAO();
            if(request.getParameter("pesquisar") != null){
                mercadoriaDAO.conectar();
                mercadorias = (ArrayList<Mercadoria>) mercadoriaDAO.pesquisarMercadorias(request.getParameter("pesquisar"));
            }else{
                mercadoriaDAO.conectar();
                mercadorias = (ArrayList<Mercadoria>) mercadoriaDAO.todasMercadorias();
            }
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("	<head>");
            out.println("		<title>Walmart.com - Milhares de Produtos em Oferta. Clique Aqui!</title>");
            out.println("		<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
            out.println("		<link rel='stylesheet' type='text/css' href='_css/estilo.css'/>");
            out.println("		<link rel='stylesheet' type='text/css' href='_css/estilo_propaganda.css'/>");
            out.println("               <link rel='shortcut icon' href='_img/Favicon/favicon.ico' type='image/x-icon' />");
            out.println("	</head>");
            out.println("	<body>");
            out.println("		<div id='tudo' class='tudo'>");
            out.println("			<header id='cabecalho' class='cabecalho'>");
            out.println("				<a href='Index.html'>");
            out.println("                    <div class='cabecalho-esquerda'>");
            out.println("                        <img class='logo' src='_img/logo-branco.png'>");
            out.println("                    </div>");
            out.println("                </a>");
            out.println("				<div class='conteiner'>");
            out.println("	            	<a href=''>");
            out.println("                        <div class='ajuda'>");
            out.println("                            <div class='img-ajuda'></div>  ");
            out.println("                            <span class='span-ajuda hovercabecalho'>Ajuda</span>");
            out.println("                        </div>");
            out.println("					</a>");
            out.println("    	            <div class='pesquisa'>");
            out.println("    	            <form action='Index' method='get'>");
            out.println("    	                <input name='pesquisar' placeholder='Olá, o que você procura?' type='text' class='pesquisa-cabecalho' value=''>");
            out.println("    	                <input type='submit'>");
            out.println("    	            </form>");
            out.println("    	            </div>");
            out.println("		            <div class='usuario'>");
            if(session.getAttribute("nomeUsuario") == null){
                out.println("		                <a href='Login'>");
                out.println("                            <div class='img-usuario'></div>");
                out.println("                            <span class='span-usuario hovercabecalho'>Entre</span>");
                out.println("                        </a>");
                out.println("		                <span class='texto-usuario '>ou</span>");
                out.println("		                <a href='Cadastre'>");
                out.println("                        	<span class='texto-usuario '>Cadastre-se</span>");
                out.println("                       	</a>");
            }else{
                out.println("		                <a href='UsuarioSv'>");
                out.println("                            <span class='span-usuario hovercabecalho'>Bem vindo, "+session.getAttribute("nomeUsuario")+"</span>");
                out.println("                        </a>");
            }
            out.println("		            </div>");
            out.println("                    <a href=''>");
            out.println("                        <div class='carrinho'>");
            out.println("                            <img alt='teste' src='_img/Carrinho-menor.png' class='img-carrinho'>");
            out.println("                        </div>");
            out.println("                    </a>");
            out.println("	    		</div>");
            out.println("			</header>");
            out.println("			<div class='header'>");
            out.println("			</div>");
            while (i < ((mercadorias.size()%3==0)?mercadorias.size()/3:mercadorias.size()/3+1) ) {
                out.println("			<div class='conteudo'>");
                out.println("				<div class='conteudo-geral'>");
                while (j < 3 && j <= mercadorias.size()-k) { 
                    if(j != 2)
                        out.println("                    <div class='geral'>");
                    else    
                        out.println("                    <div class='geral sumir'>");
                    out.println("                        <div class='propaganda'>");
                    out.println("                            <div class='img-propaganda'>");
                    out.println("                                <img src='"+mercadorias.get(k).getFigura()+"' />");
                    out.println("                            </div>");
                    out.println("                            <div class='texto-direita'>");
                    out.println("                                <div class='texto-propaganda'>");
                    out.println("                                    <span class='titulo'>" + mercadorias.get(k).getNome() + "</span>");
                    out.println("                                    <span>");
                    out.println("                                        <span class='apartir'>A partir de</span>");
                    out.println("                                        <span class='preco'>");
                    out.println("                                            <span class='cifrao'>R$</span>");
                    out.println("                                            <span class='real'>" + Helpers.fmReal(mercadorias.get(k).getPreco() * mercadorias.get(k).getParcela()) + "</span>");
                    out.println("                                            <span class='cents'>" + Helpers.fmCents(mercadorias.get(k).getPreco() * mercadorias.get(k).getParcela()) + "</span>");
                    out.println("                                        </span>");
                    out.println("                                        <span class='parcela'>" + mercadorias.get(k).getParcela() + "x de R$ " + mercadorias.get(k).getPreco() + "</span>");
                    out.println("                                        <span class='juros'>Sem Juros</span>");
                    out.println("                                    </span>");
                    out.println("                                </div>");
                    out.println("                            </div>");
                    out.println("                            <input type='button'></input>");
                    out.println("                        </div>");
                    out.println("                    </div>");
                    j++;
                    k++;
                }
                j = 0;
                out.println("            	</div>");
                out.println("		</div>");
                i++;
            }
            out.println("		</div>");
            out.println("	</body>");
            out.println("<html>");
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
