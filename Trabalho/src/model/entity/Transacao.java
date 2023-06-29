package model.entity;

public class Transacao {
private int idTransacao;
private double valorT;
private String comercio;
private Cartao cartao;
private CartaoADD cartaoADD;
	public Transacao() {
	}
	
	//COMPRAR
	public void comprar (double valorT,String comercio, Cartao cartao) {
		this.cartao=cartao;
		this.setComercio(comercio);
		this.setValorT(valorT);
		//verifica se o valor inserido é maior que 0 e menor ou igual ao limite disponivel
		if (valorT>0 && valorT<=cartao.getLimiteDisp()) {
			double valor = cartao.getLimiteDisp()- valorT;
			cartao.setLimiteDisp(valor); //Atualiza o limite disponivel
			System.out.println("Compra realizada com sucesso no estabelecimento: "+comercio+"\nNo valor de R$"+valorT+"\nLimite Disponivel: "+cartao.getLimiteDisp());
		}else {
			System.out.println("Não foi possível realizar a compra!");
		}
	}
	//COMPRAR ADD
	public void comprarADD (double valorT,String comercio, CartaoADD cartaoADD) {
		this.cartaoADD=cartaoADD;
		this.setComercio(comercio);
		this.setValorT(valorT);
		//verifica se o valor inserido é maior que 0 e menor ou igual ao limite disponivel
		if (valorT>0 && valorT<=cartaoADD.getLimiteDisp()) {
			cartaoADD.setLimiteDisp(cartaoADD.getLimiteDisp()-valorT); //Atualiza o limite disponivel
			System.out.println("Compra realizada com sucesso no estabelecimento: "+comercio+"\nNo valor de R$"+valorT);
		}else {
			System.out.println("Não foi possível realizar a compra!");
		}
	}
	
	
	//PAGAR
	public void pagar(double valorT, Cartao cartao) {
		this.cartao=cartao;
		this.setValorT(valorT);
		//verifica se o valor inserido é maior que 0 e menor ou igual ao valor da fatura
		double valorFatura = cartao.getLimiteC()-cartao.getLimiteDisp();
		if(valorT>0 && valorT<= valorFatura) {
			cartao.setLimiteDisp(cartao.getLimiteDisp()+valorT); //Atualiza o limite disponivel
			System.out.println("Pagamento realizado com sucesso!\nNo valor de: R$"+valorT);
			System.out.println("Limite dispinivel: R$"+cartao.getLimiteDisp());
		}else {
			System.out.println("Não foi possível realizar o pagamento!");
		}
	}
	//PAGAR CARTAO ADD	
		public void pagarADD(double valorT, CartaoADD cartaoADD) {
			this.cartaoADD=cartaoADD;
			this.setValorT(valorT);
			//verifica se o valor inserido é maior que 0 e menor ou igual ao valor da fatura
			double valorFatura = cartaoADD.getLimiteC()-cartaoADD.getLimiteDisp();
			if(valorT>0 && valorT<= valorFatura) {
				cartao.setLimiteDisp(cartaoADD.getLimiteDisp()+valorT); //Atualiza o limite disponivel
				System.out.println("Pagamento realizado com sucesso!");
			}else {
				System.out.println("Não foi possível realizar o pagamento!");
			}
	}

		public int getId() {
			return idTransacao;
		}

		public void setId(int idTransacao) {
			this.idTransacao = idTransacao;
		}

		public double getValorT() {
			return valorT;
		}

		public void setValorT(double valorT) {
			this.valorT = valorT;
		}

		public String getComercio() {
			return comercio;
		}

		public void setComercio(String comercio) {
			this.comercio = comercio;
		}
		
			
}

