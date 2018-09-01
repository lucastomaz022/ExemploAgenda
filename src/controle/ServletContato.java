package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * A anota��o @WebServlet substitui o mapeamento do servlet
 * realizado no arquivo web.xml (isso para a vers�o 3.0 ou
 * superior do servlet. Entre par�nteses passamos o url-pattern
 * para o servlet.
 * 
 */
@WebServlet("/novoContato")
public class ServletContato extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest requisicao, 
			HttpServletResponse resposta) throws ServletException, IOException {
		
		String nome = requisicao.getParameter("nomeContato");
		String email = requisicao.getParameter("emailContato");
		String telefone = requisicao.getParameter("telefoneContato");
		String endereco = requisicao.getParameter("enderecoContato");
		
		// Processamento necess�rio para persist�ncia
		
		resposta.sendRedirect("confirmacao.html");
		
	}

}







