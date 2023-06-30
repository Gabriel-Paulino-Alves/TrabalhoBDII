package main;

import java.util.LinkedList;
import java.util.List;

import model.entity.Cartao;
import model.entity.CartaoADD;
import model.entity.Pessoa;
import model.entity.Transacao;
public class Main {

	public static void main(String[] args) {
	//setando a Pessoa e o Cartao
	Pessoa pessoa1 = new Pessoa("Gustavo","150.767.026-55");
	Cartao cartao1 = new Cartao ("Amanda","155.762.025-77","10/26","xxxxxx",0,1);
	
	cartao1.setLimiteC(1700);// seta o limite total do cartao principal
	cartao1.setLimiteDisp(cartao1.getLimiteC());// seta o limite disponivel do cartao principal
	System.out.println("Limite total de: R$"+cartao1.getLimiteC()+"\nLimite disponivel de: R$"+cartao1.getLimiteDisp());
	System.out.println("---------------------------------------------");
	
	//setando o cartao adicional
	CartaoADD cartaoADD1 = new CartaoADD("Junior","xxxx","10/27","xxxxxx",0,1);
	cartaoADD1.setnovoL(300,cartao1); //setando o limite do cartao adicional
	CartaoADD cartaoADD2 = new CartaoADD("Pedro","xxxx","10/28","xxxxxx",0,1);
	cartaoADD2.setnovoL(400,cartao1); //setando o limite do cartao adicional
	
	//Inserindo a lista 
	cartao1.adicionarCartaoADD(cartaoADD1);
	cartao1.adicionarCartaoADD(cartaoADD2);
	System.out.println("---------------------------------------------");
	
	
	//verificando o limite disponivel
	System.out.println("limite disponivel do cartao principal R$"+cartao1.getLimiteDisp());
	System.out.println("---------------------------------------------");
	
	//Transacao para alterar o limite
	Transacao transacao = new Transacao();
	
	System.out.println("COMPRAR");
	transacao.comprar(300, "magazine", cartao1);
	
	System.out.println("\nPAGAR");
	transacao.pagar(200, cartao1);
	
	//Imprimindo a lista dos cartoes adicionais do CARTAO1
	 List<CartaoADD> cartoesAdicionais = cartao1.getCartoesAdicionais();
     System.out.println("\nCartões Adicionais:");
     for (CartaoADD cartao : cartoesAdicionais) {
         System.out.println("Nome: " + cartao.getNome());
         System.out.println("CPF: " + cartao.getCPF());
         System.out.println("Número do Cartão: " + cartao.getNumeroC());
         System.out.println("Limite: Disponivel: " + cartao.getLimiteDisp());
         System.out.println();
     }
	}
}
