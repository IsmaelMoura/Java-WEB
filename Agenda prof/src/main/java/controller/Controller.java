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
@WebServlet(urlPatterns = {"/Controller","/main","/inserir"})
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Teste Conexão
		//DAO dao = new DAO();
		//dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")){
			contatos(request, response);
		} else
			if (action.equals("/inserir")) {
				novoContato(request,response);
			} else
				response.sendRedirect("index.html");
				
		
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("agenda.jsp");
		
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("fone"));
		//System.out.println(request.getParameter("email"));
		
		this.contato.setNome(request.getParameter("nome"));
		this.contato.setFone(request.getParameter("fone"));
		this.contato.setEmail(request.getParameter("email"));
		
		dao.inserirContato(contato);
		
	}

}
