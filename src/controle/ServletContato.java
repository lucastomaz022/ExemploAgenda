package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@Override
	protected void service(HttpServletRequest requisicao, 
			HttpServletResponse resposta) throws ServletException, IOException {
		
		String nome = requisicao.getParameter("nomeContato");
		String email = requisicao.getParameter("emailContato");
		String telefone = requisicao.getParameter("telefoneContato");
		String endereco = requisicao.getParameter("enderecoContato");
		
		// Processamento necessário para persistência
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setTelefone(telefone);
		
		if(gravarContato(contato)){
			resposta.sendRedirect("confirmacao.html");
		} else {
			resposta.sendRedirect("erro.html");
		}
		
		
	}

}








