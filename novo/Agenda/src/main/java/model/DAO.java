package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	// Parametros de conex�o
	private String driver="com.mysql.cj.jdbc.Driver";
	private String url=
"jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user="root";
	private String password="";
	
	//Conex�o
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	
	public void inserirContato(JavaBeans contato) {
		String SQLinsert = 
	"insert into contatos(nome,fone,email,obs) values (?,?,?,?);";
		
		try {
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(SQLinsert);
			
			// Substituir as ?
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getObsPath());
			
			System.out.println(pst);
			
			//Executar SQL
			pst.executeUpdate();
			
			//Encerrar a conex�o
			con.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	
	
	/*
	public void testeConexao() {
		try {
			Connection con=conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}*/
	
	
	
	
	
	
	
	
	
}
