package main;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.dao.CartaoAddDAO;
import model.dao.CartaoDAO;
import model.dao.PessoaDAO;
import model.dao.TransacaoDAO;
import model.entity.Cartao;
import model.entity.CartaoADD;
import model.entity.Pessoa;
import model.entity.Transacao;

public class App {

	public static String leString(String msg) {
        String valor = JOptionPane.showInputDialog(null, msg);
        return valor;
    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);        
        System.out.println("MENU");
        System.out.println("1- Inserir");
        System.out.println("2- Listar todos");
        System.out.println("3- Listar por id");
        System.out.println("4- Excluir por id");
        System.out.println("5- Atualizar");
        System.out.println("6- inserir cartao");
        System.out.println("7- inserir cartao adicional");
        System.out.println("8- efetuar transação");
        System.out.println("9- Listar cartões principais por id");
        System.out.println("10- Listar cartões adicionais por id");
        System.out.println("11- listar transações");
        System.out.println("12- atualizar cartão");
        System.out.println("13- atualizar cartão adicional");
        System.out.println("14- deletar cartão");
        System.out.println("15- deletar cartão adicional");
        System.out.println("16- Sair");
        System.out.print("Digite: ");
        return teclado.nextInt();
    }
    public static void metodoInserir() {
        String nome = leString("Digite o nome");
        String cpf = leString("Digite o cpf");
        Pessoa pessoa = new Pessoa(nome,cpf);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.inserir(pessoa);        
    }
    public static void inserirCartao() {
    	String nome = leString("digite o nome");
    	String cpf = leString("digite o cpf");
    	String datav = leString("Digite a data validade");
        String numero = leString("Digite o numero");
        String limiteT = leString("Digite o limite total");
        String id = leString("digite o id do titular");
        int idP = Integer.parseInt(id);
        //String limiteD = leString("Digite o limite disponivel");
        double l = Double.parseDouble(limiteT);
       // double ld = Double.parseDouble(limiteD);
        Cartao cartao = new Cartao(nome,cpf,datav,numero,l,idP);
        CartaoDAO cartaoDAO = new CartaoDAO();
        cartaoDAO.inserirCartao(cartao);  
    }
    public static void inserirCartaoAdd() {
    	String nome = leString("digite o nome");
    	String cpf = leString("digite o cpf");
    	String datav = leString("Digite a data validade");
        String numero = leString("Digite o numero");
        String limiteT = leString("Digite o limite total");
        //String limiteD = leString("Digite o limite disponivel");
        String id = leString("Digite o id do cartao principal");
        int idC = Integer.parseInt(id);
        double l = Double.parseDouble(limiteT);
        CartaoADD cartaoAdd = new CartaoADD(nome, cpf,datav,numero,l,idC);
        CartaoAddDAO cartaoAddDAO = new CartaoAddDAO();
        cartaoAddDAO.inserirCartaoAdd(cartaoAdd);
    }
   // public static void efetuarTransacao() {
    	//String valor = leString("Digite o valor");
        //String comercio = leString("Digite o comercio");
        //Transacao t = new Transacao(valor,comercio);
        //TransacaoDAO dao = new TransacaoDAO();
        //dao.inserir(t);  
    //} 
    
    
    public static void metodoConsultarTodos() {;
        List<Pessoa> registros = new PessoaDAO().consultarTodos();
        if (!registros.isEmpty()){
            String saida = "";
            saida += "id\tcpf\tnome\n";
            for (int i = 0; i < registros.size(); i++) {
                Pessoa p = registros.get(i);
                saida += p.getId()+"\t";
                saida = saida + p.getCPF()+"\t";
                saida += p.getNome()+"\n";                
            }
            JOptionPane.showMessageDialog(null, new JTextArea(saida));
        }else{
            System.out.println("Nao tem registros");
        }           
    }
    
    public static Cartao consultarIdCartao() {
        String idStr = leString("Digite id");
        // converter de String para int
        int idCartao = Integer.parseInt(idStr);
        CartaoDAO dao = new CartaoDAO();
        Cartao c = dao.consultarIdCartao(idCartao);
        return c; 
    }
    public static CartaoADD consultarCartaoAdd() {
        String idStr = leString("Digite id");
        // converter de String para int
        int idCartaoAdd = Integer.parseInt(idStr);
        CartaoAddDAO dao = new CartaoAddDAO();
        CartaoADD ca = dao.consultarIdCartaoAdd(idCartaoAdd);
        return ca; 
    	
    }
    public static void consultarTransacao() {
    	List<Transacao> registros = new TransacaoDAO().consultarTodos();
        if (!registros.isEmpty()){
            String saida = "";
            saida += "id\tvalor\tcomercio\n";
            for (int i = 0; i < registros.size(); i++) {
                Transacao t = registros.get(i);
                saida += t.getId()+"\t";
                saida = saida + t.getValorT()+"\t";
                saida += t.getComercio()+"\n";                
            }
            JOptionPane.showMessageDialog(null, new JTextArea(saida));
        }else{
            System.out.println("Nao tem registros");
        }           
    }
    
    public static void metodoExcluir() {
        String tmp = leString("Digite id para excluir");
        int id = Integer.parseInt(tmp); 
        PessoaDAO dao = new PessoaDAO();
        if (dao.excluir(id)){
            JOptionPane.showMessageDialog(null, "Registro " +id + " excluido");
        }else{
            JOptionPane.showMessageDialog(null, "Registro " +id + " nao existe");
        }
    }
    
    public static void excluirCartao() {
        String tmp = leString("Digite id para excluir");
        int id = Integer.parseInt(tmp); 
        CartaoDAO dao = new CartaoDAO();
        if (dao.excluirCartao(id)){
            JOptionPane.showMessageDialog(null, "Registro " +id + " excluido");
        }else{
            JOptionPane.showMessageDialog(null, "Registro " +id + " nao existe");
        }
    }
    public static void excluirCartaoAdd() {
        String tmp = leString("Digite id para excluir");
        int id = Integer.parseInt(tmp); 
        CartaoAddDAO dao = new CartaoAddDAO();
        if (dao.excluirCartaoAdd(id)){
            JOptionPane.showMessageDialog(null, "Registro " +id + " excluido");
        }else{
            JOptionPane.showMessageDialog(null, "Registro " +id + " nao existe");
        }
    }
    
    public static Pessoa metodoConsultarId() {
        String idStr = leString("Digite id");
        int id = Integer.parseInt(idStr);
        PessoaDAO dao = new PessoaDAO();
        Pessoa p = dao.consultar(id);
        return p;       
    }

    public static void metodoAtualizar(Pessoa p) {
        String cpfAntigo = p.getCPF();
        String nomeAntigo = p.getNome(); 
        String novoCpf = leString("Alterar cpf: "+ cpfAntigo);
        String novoNome = leString("Alterar nome: "+ nomeAntigo);
        p.setCPF(novoCpf);
        p.setNome(novoNome);
        PessoaDAO dao = new PessoaDAO();
        dao.atualizar(p);
    }
    
    public static void atualizarCartao(Cartao c) {
        String datav = c.getDataV();
        String numero = c.getNumeroC();
        double limiteT = c.getLimiteC();
        double limiteD = c.getLimiteDisp();
        String limitestr = Double.toString(limiteT);
        String limitedstr = Double.toString(limiteD);
        String novadata = leString("Alterar data: "+ datav);
        String novonum = leString("Alterar numero: "+ numero);
        String limitenovo = leString("alterar limite: "+limitestr);
        String limiteDnovo = leString("alterar limite disponivel: "+limitedstr);
        double limiteN = Double.parseDouble(limitenovo);
        double limiteND = Double.parseDouble(limiteDnovo);
        c.setDataV(novadata);
        c.setNumeroC(novonum);
        c.setLimiteC(limiteN);
        c.setLimiteDisp(limiteND);
        CartaoDAO dao = new CartaoDAO();
        dao.atualizar(c);
    }
    public static void atualizarCartaoAdd(CartaoADD ca) {
        String datav = ca.getDataV();
        String numero = ca.getNumeroC();
        double limiteT = ca.getLimiteT();
        double limiteD = ca.getLimiteD();
        String limitestr = Double.toString(limiteT);
        String limitedstr = Double.toString(limiteD);
        String novadata = leString("Alterar data: "+ datav);
        String novonum = leString("Alterar numero: "+ numero);
        String limitenovo = leString("alterar limite: "+limitestr);
        String limiteDnovo = leString("alterar limite disponivel: "+limitedstr);
        double limiteN = Double.parseDouble(limitenovo);
        double limiteND = Double.parseDouble(limiteDnovo);
        ca.setDataV(novadata);
        ca.setNumeroC(novonum);
        ca.setLimiteT(limiteN);
        ca.setLimiteD(limiteND);
        CartaoAddDAO dao = new CartaoAddDAO();
        dao.atualizar(ca);
    }
    public static void main(String[] args) {
        int op;
        do{
            op = menu();
            switch (op){
                case 1:
                    metodoInserir();
                    break;
                case 2:
                    metodoConsultarTodos();
                    break;
                case 3:
                    Pessoa pess=metodoConsultarId();
                    String saida;
                    if (pess != null){
                        saida = "id\tnome\tcpf\n";
                        saida += pess.getId()+"\t";
                        saida = saida + pess.getCPF()+"\t";
                        saida += pess.getNome()+"\n"; 
                    }else{
                        saida = "Registro nao foi localizado";
                    }
                    JOptionPane.showMessageDialog(null, new JTextArea(saida));
                    break;
                case 4:
                    metodoExcluir();
                    break;
                case 5:
                    Pessoa p = metodoConsultarId();
                    if (p !=null){
                        metodoAtualizar(p);
                    }else{
                        System.out.println("registro nao encontrado");
                    }                  

                    break;
                case 6:
                	inserirCartao();
                	break;
                case 7:
                	inserirCartaoAdd();
                	break;
                case 8:
                	System.out.println("ainda estamos trabalhando neste aqui");
                	break;
                case 9:
                	Cartao c1 = consultarIdCartao();
                	String s;
                    if (c1 != null){
                        s = "id\tcpf\tnome\tdataV\tnumeroC\tlimiteT\tlimiteD\n";
                        s += c1.getId()+"\t";
                        s+= c1.getNome()+"\t";
                        s+= c1.getCPF()+"\t";
                        s = s + c1.getDataV()+"\t";
                        s += c1.getNumeroC()+"\t"; 
                        s += c1.getLimiteC()+"\t";
                        s += c1.getLimiteDisp()+"\n";
                    }else{
                        s = "Registro nao foi localizado";
                    }
                    JOptionPane.showMessageDialog(null, new JTextArea(s));
                	break;
                case 10:
                	CartaoADD ca1 = consultarCartaoAdd();
                	String ss;
                	if(ca1 !=null) {
                		ss = "id\tdataV\tnumeroC\tlimiteT\tlimiteD\n";
                		ss += ca1.getId()+"\t";
                        ss += ca1.getDataV()+"\t";
                        ss += ca1.getNumeroC()+"\t"; 
                        ss += ca1.getLimiteT()+"\t";
                        ss += ca1.getLimiteD()+"\n";
                	}else{
                        ss = "Registro nao foi localizado";
                    }
                    JOptionPane.showMessageDialog(null, new JTextArea(ss));
                	break;
                case 11:
                	System.out.println("ainda estamos trabalhando neste aqui");
                	break;
                case 12:
                	Cartao c = consultarIdCartao();
                	if(c != null) {
                		atualizarCartao(c);
                	}else {
                		System.out.println("registro nao encontrado");
                	}
                	break;
                case 13:
                	CartaoADD ca = consultarCartaoAdd();
                	if(ca !=null) {
                		atualizarCartaoAdd(ca);
                	}else {
                		System.out.println("registro nao encontrado");
                	}
                	break;
                case 14:
                	excluirCartao();
                	break;
                case 15:
                	excluirCartaoAdd();
                	break;
                case 16:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }while(op!=16);
    }
}
