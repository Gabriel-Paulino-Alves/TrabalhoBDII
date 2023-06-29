package model.entity;

public class CartaoADD extends Cartao{
private int idCartaoAdd;
private double novoL;
private Cartao cartao;
	//SUPERCONSTRUTORES
	public CartaoADD(String nome, String cpf,String dataV,String numeroC) {
		super(nome,cpf,dataV,numeroC);
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

}