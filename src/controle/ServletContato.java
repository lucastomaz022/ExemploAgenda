package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.ContainerThreadMarker;

import modelo.Contato;
import modelo.dao.ContatoDAO;

/*
 * A anotação @WebServlet substitui o mapeamento do servlet
 * realizado no arquivo web.xml (isso para a versão 3.0 ou
 * superior do servlet. Entre parênteses passamos o url-pattern
 * para o servlet.
 * 
 */
@WebServlet("/novoContato")
public class ServletContato extends HttpServlet{
	
	private boolean gravarContato(Contato c){
		ContatoDAO dao = ContatoDAO.getInstancia();
		return dao.gravar(c);
	}
	
	private List<Contato> listarContatos() {
		ContatoDAO dao = ContatoDAO.getInstancia();
		
		List<Contato> contatos = dao.listarContatos();
		
		return contatos;
	}
	
	@Override
	protected void service(HttpServletRequest requisicao, 
			HttpServletResponse resposta) throws ServletException, IOException {
		
		String opcao = requisicao.getParameter("opcao");
		
		if(opcao.equals("cadastrar")) {
			
			Contato c = new Contato();
			
			c.setNome(requisicao.getParameter("nomeContato"));
			c.setEmail(requisicao.getParameter("emailContato"));
			c.setEndereco(requisicao.getParameter("enderecoContato"));
			c.setTelefone(requisicao.getParameter("telefoneContato"));
			
			if(gravarContato(c)){
				resposta.sendRedirect("confirmacao.html");
			}
			
		} else if(opcao.equals("remover")) {
			
		} else if(opcao.equals("listar")){
			requisicao.getSession().
				setAttribute("contatos", listarContatos());
			resposta.sendRedirect("lista.jsp");
		}
		
	}

}








