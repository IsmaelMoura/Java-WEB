package controller;

import java.io.IOException;
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
@WebServlet(urlPatterns = { "/Controller", "/inserir-produto"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans produto = new JavaBeans();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/inserir-produto")) {
			novoProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.produto.setMarca(request.getParameter("marca"));
		this.produto.setNome(request.getParameter("nome"));
		this.produto.setQuantidade(request.getParameter("quantidade"));
		this.produto.setValor(request.getParameter("valor"));
		this.produto.setVencimento(request.getParameter("vencimento"));
		this.produto.setCategoria(request.getParameter("categoria"));

		dao.inserirProduto(produto);

		response.sendRedirect("index.html");

	}

}
