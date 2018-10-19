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
	
	private List<String> listarContatos() {
		ContatoDAO dao = ContatoDAO.getInstancia();
		
		List<Contato> contatos = dao.listarContatos();
		List<String> nomes = new ArrayList<String>();
		
		for(Contato c : contatos) {
			nomes.add(c.getNome());
		}
		
		return nomes;
		
	}
	
	@Override
	protected void service(HttpServletRequest requisicao, 
			HttpServletResponse resposta) throws ServletException, IOException {
		
		/*
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
		*/
		
		// Disponibilizar a lista de nomas na sessão
		requisicao.getSession().setAttribute("listaNomes", listarContatos());
		resposta.sendRedirect("lista.jsp");
		
	}

}








