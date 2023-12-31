package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.entity.Cartao;
import model.entity.CartaoADD;
import model.entity.Pessoa;

public class CartaoAddDAO {

	public CartaoAddDAO() {
		// TODO Auto-generated constructor stub
	}

	public void inserirCartaoAdd(CartaoADD cartaoAdd) {
		ConexaoBd con = new ConexaoBd();
		String sql = "INSERT INTO cartaoAdd (dataValidade,numeroCartao, limiteTotal, limiteDisponivel, idCartao) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, cartaoAdd.getDataV());
			pst.setString(2, cartaoAdd.getNumeroC());
            pst.setDouble(3, cartaoAdd.getLimiteT());
            pst.setDouble(4, cartaoAdd.getLimiteD());
            pst.setInt(5, cartaoAdd.getIdCartao());
            pst.execute();
            System.out.println("Cartao adicional inserido");
		} catch (SQLException e){
            System.out.println(e.getMessage());
        }	
	}
	
	public CartaoADD consultarIdCartaoAdd(int idCartaoAdd) {
        ConexaoBd con = new ConexaoBd();
        String sql = "SELECT * FROM cartaoAdd WHERE idCartaoAdd = ?";
        CartaoADD ca = null;
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            pst.setInt(1, idCartaoAdd);
            ResultSet rs =  pst.executeQuery();
            if (rs.next()){
            	//String nome = rs.getString("nome");
            	//String cpf = rs.getString("cpf");
                String dataV = rs.getString("dataValidade");
                String numero = rs.getString("numeroCartao");
                String limiteTotal = rs.getString("limiteTotal");
                //String limiteDisponivel = rs.getString("limiteDisponivel");
                String id = rs.getString("idCartao");
                int idC = Integer.parseInt(id);
                CartaoDAO dao = new CartaoDAO();
                Cartao c = dao.consultarIdCartao(idC);
                double l = Double.parseDouble(limiteTotal);
                ca = new CartaoADD(c.getNome(), c.getCPF(),dataV,numero,l,idC);
                ca.setId(rs.getInt("idCartaoAdd"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ca;
	}

	public List<CartaoADD> consultarTodos(){
        ConexaoBd con = new ConexaoBd();
        String sql = "SELECT * FROM cartaoAdd";
        List<CartaoADD> lista = new LinkedList<CartaoADD>();
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                CartaoADD cartao = new CartaoADD();
                int id = rs.getInt("id");
                String dataV = rs.getString("dataValidade");
                String numero = rs.getString("numeroCartao");
                Double limiteTotal = rs.getDouble("limiteTotal");
                Double limiteDisponivel = rs.getDouble("limiteDisponivel");
                cartao.setIdCartao(id);
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
	
	public boolean excluirCartaoAdd(int chave){
        String sql = "DELETE FROM cartaoAdd WHERE idCartaoAdd = ?";
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
	
	public boolean atualizar(CartaoADD cartaoAdd){
        try {
            String sql = "UPDATE cartaoAdd SET dataValidade = ?, numeroCartao = ?, limiteTotal = ?, limiteDisponivel = ? WHERE idCartaoAdd = ?";
            ConexaoBd conexao = new ConexaoBd();
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setString(1, cartaoAdd.getDataV());
            pst.setString(2, cartaoAdd.getNumeroC());
            pst.setDouble(3, cartaoAdd.getLimiteT());
            pst.setDouble(4, cartaoAdd.getLimiteD());
            pst.setInt(5, cartaoAdd.getId());
            int linhas = pst.executeUpdate();
            return linhas>0;            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
