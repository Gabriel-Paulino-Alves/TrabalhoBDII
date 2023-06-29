package model.entity;

public class Pessoa {
private String cpf,nome;
private int id;

    //SUPERCONSTRUTORES
	public Pessoa() {
	}
	public Pessoa(String nome, String cpf) {
		this.cpf=cpf;
		this.nome=nome;
	}
	
	//SET´S
	public void setNome(String nome) {
		this.nome=nome;
	}
	public void setCPF(String cpf) {
		this.cpf=cpf;
	}
	
	//GET´S
	public String getNome() {
		return nome;
	}
	public String getCPF() {
		return cpf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}