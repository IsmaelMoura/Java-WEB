package controller;

import java.io.IOException;



import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/inserir", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	/**
	 * Default constructor.
	 */
	public Controller() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// Teste Conex�o
		// DAO dao = new DAO();
		// dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/inserir")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			alterarContato(request, response);
		} else if(action.equals("/delete")) {
			removerContato(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// receber dados da inst�ncia JavaBeans
		ArrayList<JavaBeans> lista = dao.listaContatos();

		// atribui o apelido para o objeto
		request.setAttribute("contatos", lista);

		// para onde ser� despachado
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");

		// despacha para o caminho declarado anteriormente
		rd.forward(request, response);

	}

	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.contato.setNome(request.getParameter("nome"));
		this.contato.setFone(request.getParameter("fone"));
		this.contato.setEmail(request.getParameter("email"));

		dao.inserirContato(contato);

		response.sendRedirect("main");

	}

	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebe o par�metro idcon
		String idcon = request.getParameter("idcon");

		// testa o envio do parametro
		System.out.println(idcon);

		// configura o parametro no objeto
		this.contato.setIdcon(idcon);

		// selecionar o contato
		this.dao.selecionarContato(contato);
		// teste
		// System.out.println(contato.getIdcon());
		// System.out.println(contato.getNome());
		// System.out.println(contato.getEmail());
		// System.out.println(contato.getFone());

		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("fone", contato.getFone());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void alterarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.contato.setIdcon(request.getParameter("idcon"));
		this.contato.setNome(request.getParameter("nome"));
		this.contato.setFone(request.getParameter("fone"));
		this.contato.setEmail(request.getParameter("email"));
		
		this.dao.editarContato(this.contato);
		response.sendRedirect("main");
	}
	
	/* CRUD Delete */
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do contato a ser exclu�do (validador.js)
		String idcon = request.getParameter("idcon");
		// setar a veri�vel idcon JavaBeans
		this.contato.setIdcon(idcon);
		// executar o m�todo deletarContato(dao) passando objeto contato
		dao.deletarContato(contato);
		
		// redirecionar para o documento agenda.jsp (atualizando as altera��es)
		
	}

}
