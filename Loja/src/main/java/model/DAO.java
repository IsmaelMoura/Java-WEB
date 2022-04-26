package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbloja?useTimezone=true&serverTimezone=UTC";
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

	public void inserirProduto(JavaBeans produto) {
		String SQLinsert = "INSERT INTO produtos(marca, nome, quantidade, valor, vencimento, categoria) VALUES(?,?,?,?,?,?);";

		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(SQLinsert);

			// Substituir as ?
			pst.setString(1, produto.getMarca());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getQuantidade());
			pst.setString(4, produto.getValor());
			pst.setString(5, produto.getVencimento());
			pst.setString(6, produto.getCategoria());
			

			// Executar SQL
			pst.executeUpdate();

			// Encerrar a conexão
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
