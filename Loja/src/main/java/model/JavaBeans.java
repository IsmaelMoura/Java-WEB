package model;

public class JavaBeans {
	private String idprod;
	private String marca;
	private String nome;
	private String quantidade;
	private String valor;
	private String vencimento;
	private String categoria;

	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JavaBeans(String idprod, String marca, String nome, String quantidade, String valor, String vencimento,
			String categoria) {
		super();
		this.idprod = idprod;
		this.marca = marca;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.vencimento = vencimento;
		this.categoria = categoria;
	}

	public String getIdprod() {
		return idprod;
	}

	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
