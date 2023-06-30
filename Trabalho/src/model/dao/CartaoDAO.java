package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.entity.Cartao;
import model.entity.Pessoa;

public class CartaoDAO {


	public void inserirCartao(Cartao cartao) {
			ConexaoBd con = new ConexaoBd();
			String sql = "INSERT INTO cartao (dataValidade, numeroCartao, limiteTotal, limiteDisponivel, idPessoa) VALUES (?,?,?,?,?)";
			try {
				PreparedStatement pst = con.getConexao().prepareStatement(sql);
				pst.setString(1, cartao.getDataV());
	            pst.setString(2, cartao.getNumeroC());
	            pst.setDouble(3, cartao.getLimiteC());
	            pst.setDouble(4, cartao.getLimiteDisp());
	            pst.setInt(5, cartao.getIdPessoa());
	            pst.execute();
	            System.out.println("Cartao principal inserido");
			} catch (SQLException e){
	            System.out.println(e.getMessage());
	        }	
	}
	public Cartao consultarIdCartao(int idCartao){
        ConexaoBd con = new ConexaoBd();
        String sql = "SELECT * FROM cartao WHERE idCartao = ?";
        Cartao c = null;
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            pst.setInt(1, idCartao);
            ResultSet rs =  pst.executeQuery();
            if (rs.next()){
            	//String nome = rs.getString("nome");
            	//String cpf = rs.getString("cpf");
                String dataV = rs.getString("dataValidade");
                String numero = rs.getString("numeroCartao");
                String limiteTotal = rs.getString("limiteTotal");
                String id = rs.getString("idPessoa");
                int idP = Integer.parseInt(id);
                PessoaDAO dao = new PessoaDAO();
                Pessoa p = dao.consultar(idP);
                
                //String limiteDisponivel = rs.getString("limiteDisponivel");
                double l = Double.parseDouble(limiteTotal);
                //double ld = Double.parseDouble(limiteDisponivel);
                c = new Cartao(p.getNome(),p.getCPF(),dataV,numero,l,idP);
                c.setId(rs.getInt("idCartao"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
	public List<Cartao> consultarTodos(){
        ConexaoBd con = new ConexaoBd();
        String sql = "SELECT * FROM cartao";
        List<Cartao> lista = new LinkedList<Cartao>();
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Cartao cartao = new Cartao();
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String dataV = rs.getString("dataValidade");
                String numero = rs.getString("numeroCartao");
                Double limiteTotal = rs.getDouble("limiteTotal");
                Double limiteDisponivel = rs.getDouble("limiteDisponivel");
                cartao.setIdCartao(id);
                cartao.setNome(nome);
                cartao.setCPF(cpf);
                cartao.setDataV(dataV);
                cartao.setNumeroC(numero);
                cartao.setLimiteC(limiteTotal);
                cartao.setLimiteDisp(limiteDisponivel);
                lista.add(cartao);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
	
	public boolean excluirCartao(int chave){
        String sql = "DELETE FROM cartao WHERE idCartao = ?";
        try{
        	ConexaoBd conexao = new ConexaoBd();
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, chave);
            int linhas = pst.executeUpdate();
            return linhas>0;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
	public boolean atualizar(Cartao cartao){
        try {
            String sql = "UPDATE cartao SET dataValidade = ?, numeroCartao = ?, limiteTotal = ?, limiteDisponivel = ? WHERE idCartao = ?";
            ConexaoBd conexao = new ConexaoBd();
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setString(1, cartao.getDataV());
            pst.setString(2, cartao.getNumeroC());
            pst.setDouble(3, cartao.getLimiteC());
            pst.setDouble(4, cartao.getLimiteDisp());
            pst.setInt(5, cartao.getId());
            int linhas = pst.executeUpdate();
            return linhas>0;            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
