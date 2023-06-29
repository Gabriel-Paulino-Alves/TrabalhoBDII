package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.entity.Transacao;

public class TransacaoDAO {

    public void inserir(Transacao transacao){
        ConexaoBd con = new ConexaoBd();
        String sql = "INSERT INTO transacao (valorTransacao, comercio) VALUES (?,?)";
        try{
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            pst.setDouble(1, transacao.getValorT());
            pst.setString(2, transacao.getComercio());
            pst.execute();
            System.out.println("transacao efetuada");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Transacao> consultarTodos(){
        ConexaoBd con = new ConexaoBd();
        String sql = "SELECT * FROM transacao";
        List<Transacao> lista = new LinkedList<Transacao>();
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Transacao t = new Transacao();
                int id = rs.getInt("id");
                Double valorT = rs.getDouble("valor transacao");
                String comercio = rs.getString("comercio");
                t.setId(id);
                t.setValorT(valorT);
                t.setComercio(comercio);
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
