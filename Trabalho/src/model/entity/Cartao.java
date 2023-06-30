package model.entity;

import java.util.LinkedList;
import java.util.List;

public class Cartao  extends Pessoa{

private int idPessoa;
private int idCartao;
protected String dataV;
protected String numeroC;
private double limiteC;
private double limiteDisp=limiteC;
private List<CartaoADD> cartoesAdicionais;


	public Cartao() {
		
	}
    //SUPERCONSTRUTORES
	public Cartao(String nome, String cpf,String dataV,String numeroC, double limiteC,int idPessoa) {
		super(nome,cpf);
		this.limiteC = limiteC;
		limiteDisp = limiteC;
		this.idPessoa = idPessoa;
		this.dataV=dataV;
		this.numeroC=numeroC;
		this.cartoesAdicionais = new LinkedList<>();
	}
	
	//SET´S
	public void adicionarCartaoADD(CartaoADD cartaoAdicional) {
	    cartoesAdicionais.add(cartaoAdicional);
	}
	public void setDataV(String dataV) {
		this.dataV = dataV;
	}
	public void setNumeroC(String numeroC) {
		this.numeroC = numeroC;
	}
	public void setLimiteC(double limiteC) {
		this.limiteC = limiteC;
	}
	public void setLimiteDisp(double limiteDisp) {
		this.limiteDisp=limiteDisp;
	}
	
	//GET´S
	public List<CartaoADD> getCartoesAdicionais() {
	    return cartoesAdicionais;
	}
	public double getLimiteC() {
		return limiteC;
	}
	public String getDataV() {
		return dataV;
	}
	public String getNumeroC() {
		return numeroC;
	}
	public double getLimiteDisp() {
		return limiteDisp;
	}

	public int getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(int idCartao) {
		this.idCartao = idCartao;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	

}
