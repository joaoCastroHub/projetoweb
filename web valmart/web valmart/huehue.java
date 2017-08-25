/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Italo
 */
@WebServlet(name = "huehue", urlPatterns = {"/huehue"})
public class huehue extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <title>Walmart.com - Milhares de Produtos em Oferta. Clique Aqui!</title>");
            out.println("        <meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
            out.println("        <link rel='stylesheet' type='text/css' href='_css/estilo.css'/>");
            out.println("        <link rel='stylesheet' type='text/css' href='_css/estilo_propaganda.css'/>");
            out.println("        <link rel='stylesheet' type='text/css' href='_css/logincss.css'/>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <div id='tudo' class='tudo'>");
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
            out.println("    	                <input placeholder='Olá, o que você procura?' type='text' class='pesquisa-cabecalho'>");
            out.println("    	                <input type='submit' value=''>");
            out.println("    	            </div>");
            out.println("		            <div class='usuario'>");
            out.println("		                <a href='login.html'>");
            out.println("                            <div class='img-usuario'></div>");
            out.println("                            <span class='span-usuario hovercabecalho'>Entre</span>");
            out.println("                        </a>");
            out.println("		                <span class='texto-usuario '>ou</span>");
            out.println("		                <a href=''>");
            out.println("                        	<span class='texto-usuario '>Cadastre-se</span>");
            out.println("                       	</a>");
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
            out.println("			<div class='conteudo'>");
            out.println("				<div class='conteudo-geral'>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/motog.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Smartphone Motorola Moto G2</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>648</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 64,80</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/motog3.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Smartphone Motorola Moto G3</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>Por apenas</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>999</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 99,90</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral sumir'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/lgl3.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Smartphone LG G3 Stylus Titanium</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>659</span>");
            out.println("                                            <span class='cents'>,90</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 65,99</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("            	</div>");
            out.println("			</div>");
            out.println("            <div class='conteudo'>");
            out.println("                <div class='conteudo-geral'>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/pc1.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Notebook Acer Intel Core i3-4005U</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>1.399</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>9x de R$ 155,44</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/pc2.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Notebook Acer Intel Core i7-5500U 5°</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>Por apenas</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>2.699</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 269,90</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral sumir'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/pc3.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Computador All In One LG Intel</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>1.699</span>");
            out.println("                                            <span class='cents'>,90</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 169,90</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                </div>");
            out.println("            </div>");
            out.println("            <div class='conteudo'>");
            out.println("                <div class='conteudo-geral'>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/tablet1.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Tablet Multilaser M7 Supra NB152</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>228</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>3x de R$ 76,00</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/tablet2.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Tablet Samsung Galaxy Tab A 9.7'</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>Por apenas</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>1.399</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 139,90</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral sumir'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/tablet3.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Tablet Positivo Mini Quad Tela 7,85'</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>659</span>");
            out.println("                                            <span class='cents'>,90</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 65,99</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                </div>");
            out.println("            </div>");
            out.println("            <div class='conteudo'>");
            out.println("                <div class='conteudo-geral'>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/tv1.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>55' 3D Samsung</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>4.399</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 439,90</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/tv2.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>HD 43' LG</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>Por apenas</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>1.699</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 169,90</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral sumir'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/tv3.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>LE32D1352 2 HDMI</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>899</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 89,90</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                </div>");
            out.println("            </div>");
            out.println("            <div class='conteudo'>");
            out.println("                <div class='conteudo-geral'>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/video1.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Console Xbox One 500GB c/ Kinect +</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>1.849</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 184,90</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/video2.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Jogo SONY GOD OF WAR 3</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>Por apenas</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>148</span>");
            out.println("                                            <span class='cents'>,24</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>9x de R$ 16,47</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                    <div class='geral sumir'>");
            out.println("                        <div class='propaganda'>");
            out.println("                            <div class='img-propaganda'>");
            out.println("                                <img src='_img/_merc/video3.jpg' />");
            out.println("                            </div>");
            out.println("                            <div class='texto-direita'>");
            out.println("                                <div class='texto-propaganda'>");
            out.println("                                    <span class='titulo'>Console PS Vita Sony + Jogos para</span>");
            out.println("                                    <span>");
            out.println("                                        <span class='apartir'>A partir de</span>");
            out.println("                                        <span class='preco'>");
            out.println("                                            <span class='cifrao'>R$</span>");
            out.println("                                            <span class='real'>729</span>");
            out.println("                                            <span class='cents'>,00</span>");
            out.println("                                        </span>");
            out.println("                                        <span class='parcela'>10x de R$ 72,90</span>");
            out.println("                                        <span class='juros'>Sem Juros</span>");
            out.println("                                    </span>");
            out.println("                                </div>");
            out.println("                            </div>");
            out.println("                            <input type='button'></input>");
            out.println("                        </div>");
            out.println("                    </div>");
            out.println("                </div>");
            out.println("            </div>");
            out.println("		</div>");
            out.println("        <div class='fundo'>");

            out.println("        </div>");

            out.println("        <div class='login'>");

            out.println("                <a title='close' class='fechar' href='Index.html'> ");
            out.println("                    <img src='_img/close.png'>");
            out.println("                </a>");

            out.println("                <div class='corpo'>");

            out.println("                    <div class='entrar'>");
            out.println("                        Entrar");
            out.println("                    </div>");

            out.println("                    <div class='meio'>");
            out.println("                        <div class='useconta'>");
            out.println("                            Use sua conta Walmart.com");
            out.println("                        </div>");

            out.println("                        <div class='email'>");

            out.println("                            <img class='envelope' src='_img/envelope.png' alt='envelope'>");
            out.println("                            <input class='input-box' type='text' maxlength='100' name='signinfield' placeholder='E-mail, CPF ou CNPJ' autocomplete='off'>");

            out.println("                        </div>");

            out.println("                        <div class='senha'>");

            out.println("                            <img class='cadeado' src='_img/cadeado.png' alt='cadeado'>");
            out.println("                            <input class='input-box pass' type='password' maxlength='100' name='password' placeholder='Senha' autocomplete='off'>");

            out.println("                            <button title='seta' class='seta'>");
            out.println("                                <img class='iconeseta' src='_img/seta.png'>");
            out.println("                            </button>");

            out.println("                        </div>  ");

            out.println("                        <p class='continuarconectado'>");
            out.println("                            <input  class='cboxconectado' id='stayconected' type='checkbox' value='true' name='conected'> <label for='stayconected'>Continuar conectado</label> ");
            out.println("                        </p>");

            out.println("                        <p class=esqueciasenha>");
            out.println("                            <a href=''>Esqueci minha senha</a>");

            out.println("                        </p>");

            out.println("                    </div>");

            out.println("                    <div class='rodape'>");

            out.println("                        'Não tem conta no Walmart.com?'");
            out.println("                        <p class='cadastreaqui'>");
            out.println("                            <a href=''>Cadastre aqui</a>");
            out.println("                        </p>");
            out.println("                    </div>");

            out.println("                </div>          ");
            out.println("        </div>");
            out.println("	</body>");
            out.println("/html>");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
