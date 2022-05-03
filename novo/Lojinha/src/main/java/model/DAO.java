package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	// parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dblojinha?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	// Conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	// CRUD Create
	public void inserirContato(JavaBeans produto) {
		String SQLinsert = "insert into contatos(nome, fone, email, obs) values(?, ?, ?, ?);";
		
		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(SQLinsert);
			
			// Substituir as ?
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			
			// Executar SQL
			pst.executeUpdate();
			
			//Encerrar a conexão
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}