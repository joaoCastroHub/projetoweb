package Servlet;

import DAO.MercadoriaDAO;
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

@WebServlet(name = "Mercadoria", urlPatterns = {"/Mercadoria"})
public class MercadoriaSv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session.getAttribute("sessao") == null || session.getAttribute("sessao").equals("0")) {
            response.sendRedirect("Login");
        }
        
        MercadoriaDAO mercadoriaDAO = null;
        ArrayList<Mercadoria> mercadorias = null;
        try {
            mercadoriaDAO = new MercadoriaDAO();
            mercadorias = (ArrayList)mercadoriaDAO.todasMercadorias();
        } catch (Exception ex) {
            Logger.getLogger(Mercadoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = 0;
        boolean editar = false;
        if(request.getParameter("Editar") != null)
            editar = request.getParameter("Editar").equals("1");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("	<head>");
            out.println("		<title>Cadastrar Mercadoria</title>");
            out.println("		<meta charset='UTF-8'>");
            out.println("	</head>");
            out.println("	<body>");
            out.println("		<fieldset>");
            if(!editar)
                out.println("			<legend>Cadastrar Mercadoria</legend>");
            else
                out.println("			<legend>Editar Mercadoria</legend>");
            out.println("			<table style='width:100%;' align='center'>");
            if(editar)
                out.println("				<form action='EditarMercadoria' method='POST'>");
            else
                out.println("				<form action='CadastrarMercadoria' method='GET'>");
            out.println("					<tr>");
            out.println("						<td align='right' style='width:50%'>Nome:</td>");
            out.println("						<td>");
            if(editar)
                out.println("							<input type='text' name='nome' value='"+request.getParameter("Nome")+"'/>");
            else
                if(request.getParameter("Nome") != null)
                    out.println("					<span>Campo Obrigatori!</span>");
                out.println("							<input type='text' name='nome'/>");
            out.println("						</td>");
            out.println("					</tr>");
            out.println("					<tr>");
            out.println("						<td align='right'>Preço Total:</td>");
            out.println("						<td>");
            if(editar)
                out.println("							<input type='text' name='precoTotal' value='"+Integer.parseInt(request.getParameter("qtdParcela"))*Float.parseFloat(request.getParameter("Preco"))+"'/>");
            else    
                if(request.getParameter("Preco") != null)
                    out.println("					<span>Campo Obrigatori!</span>");
                out.println("							<input type='text' name='precoTotal'/>");
            out.println("						</td>");
            out.println("					</tr>");
            out.println("					<tr>");
            out.println("						<td align='right'>Imagem:</td>");
            out.println("						<td>");
            if(editar)
                out.println("							<input type='text' name='imagem' value='"+request.getParameter("imagem")+"'/>");
            else    
                if(request.getParameter("Imagem") != null)
                    out.println("					<span>Campo Obrigatori!</span>");
                out.println("							<input type='text' name='imagem'/>");
            out.println("						</td>");
            out.println("					</tr>");
            out.println("					<tr>");
            out.println("						<td align='right'>Qtde. de Parcelas:</td>");
            out.println("						<td>");
            if(editar)
                out.println("							<input type='text' name='qtdParcela' value='"+request.getParameter("qtdParcela")+"'/>");
            else
                if(request.getParameter("Parcela") != null)
                    out.println("					<span>Campo Obrigatori!</span>");
                out.println("							<input type='text' name='qtdParcela'/>");
            out.println("						</td>");
            out.println("					</tr>");
            out.println("					<tr>");
            out.println("						<td colspan='2' align='center'>");
            if(editar)
                out.println("							<input type='submit' value='Salvar'/>");
            else
                out.println("							<input type='submit' value='Cadastrar'/>");
            out.println("						</td>");
            out.println("					</tr>");
            out.println("				</form>");
            out.println("			</table>");
            out.println("		</fieldset>");
            out.println("		<fieldset>");
            out.println("			<legend>Mercadorias Cadastradas</legend>");
            out.println("			<table style='width:100%;'>");
            out.println("				<tr>");
            out.println("					<td align='center'>Cód. Mercadoria</td>");
            out.println("					<td>Nome</td>");
            out.println("					<td>Qtde. de Parcelas</td>");
            out.println("					<td>Valor da Parcela</td>");
            out.println("					<td>Total</td>");
            out.println("					<td align='center'>Editar</td>");
            out.println("					<td align='center'>Excluir</td>");
            out.println("				</tr>");
            out.println("				<form action='ExcluirMercadoria' method='POST'>	");
            while(i < mercadorias.size()){
                out.println("					<tr>");
                out.println("						<td align='center'> " +  mercadorias.get(i).getId() + " </td>");
                out.println("						<td> " +  mercadorias.get(i).getNome() + " </td>");
                out.println("						<td> " +  mercadorias.get(i).getParcela() + " </td>");
                out.println("						<td> " +  mercadorias.get(i).getPreco() + " </td>");
                out.println("						<td> " +  mercadorias.get(i).getParcela()*mercadorias.get(i).getPreco() + " </td>");
                out.println("						<td align='center'>");
                out.println("							<a href='Mercadoria?Editar=1&Nome=" +  mercadorias.get(i).getNome() + "&qtdParcela=" +  mercadorias.get(i).getParcela() + "&Preco=" +  mercadorias.get(i).getPreco() + "' target='_parent'>Editar</a>");
                out.println("						</td>");
                out.println("						<td align='center'>");
                out.println("							<input type='checkbox' value='" +  mercadorias.get(i).getId() + "' name='excluir'/>");
                out.println("						</td>");
                out.println("					</tr>");
                out.println("					<tr>");
                i++;
            }
            out.println("						<td></td>");
            out.println("						<td></td>");
            out.println("						<td></td>");
            out.println("						<td></td>");
            out.println("						<td></td>");
            out.println("						<td></td>");
            out.println("						<td align='center'>");
            out.println("							<input type='submit' value='Excluir' name='Excluir'/>");
            out.println("						</td>");
            out.println("					</tr>");
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
