package model;

public class JavaBeans {
	private String idcon;
	private String nome;
	private String fone;
	private String fone2;
	private String email;
	private String cep;
	private String obs;
	
	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public JavaBeans(String idcon, String nome, String fone,  String fone2, String email,  String cep,  String obs) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.fone2 = fone2;
		this.email = email;
		this.cep = cep;
		this.obs = obs;
	}


	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getFone2() {
		return fone2;
	}
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
