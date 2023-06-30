package model.entity;

public class CartaoADD extends Cartao{
private int idCartaoAdd;
private int idCartao;
private double novoL;
private Cartao cartao;
private double limiteT;
private double limiteD;
	//SUPERCONSTRUTORES
	public CartaoADD(String nome, String cpf,String dataV,String numeroC,double limiteT, int idCartao) {
		super(nome,cpf,dataV,numeroC, idCartao, idCartao);
		this.idCartao = idCartao;
		this.limiteT = limiteT;
		limiteD = limiteT;
		this.dataV = dataV;
		this.numeroC = numeroC;
		//this.novoL = novoL;
	}
	public CartaoADD() {
		
	}
	
	//SET'S
	public void setnovoL(double novoL,Cartao cartao) {
		this.novoL=novoL;
		this.cartao=cartao;
		if(novoL<=cartao.getLimiteDisp()) { // verifica o limite disponivel do cartao principal
		 setLimiteC(novoL);// insere o limite total do cartao adicional
		 double limite = cartao.getLimiteC()-novoL;
		 cartao.setLimiteC(limite);//altera o limite total do cartao principal
		 cartao.setLimiteDisp(limite);//altera o limite disponivel do cartao principal
		 System.out.println("Limite inserido no cartao adicional!");
		 System.out.println("Novo limite total do cartão princial: R$"+cartao.getLimiteC());
		 System.out.println("Novo limite total do cartão adicional: R$"+getLimiteC());
		}else {
			System.out.println("Não foi possível inserir esse limite!");
		}
	}

	public int getIdCartaoAdd() {
		return idCartaoAdd;
	}

	public void setIdCartaoAdd(int idCartaoAdd) {
		this.idCartaoAdd = idCartaoAdd;
	}
	public double getLimiteT() {
		return limiteT;
	}
	public void setLimiteT(double limiteT) {
		this.limiteT = limiteT;
	}
	public double getLimiteD() {
		return limiteD;
	}
	public void setLimiteD(double limiteD) {
		this.limiteD = limiteD;
	}
	public int getIdCartao() {
		return idCartao;
	}
	public void setIdCartao(int idCartao) {
		this.idCartao = idCartao;
	}

}
