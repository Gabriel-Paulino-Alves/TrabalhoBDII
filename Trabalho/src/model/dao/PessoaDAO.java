package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.entity.Pessoa;

public class PessoaDAO {
    public void inserir(Pessoa pessoa){
        ConexaoBd con = new ConexaoBd();
        String sql = "INSERT INTO pessoa (cpf, nome) VALUES (?,?)";
        try{
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            pst.setString(1, pessoa.getCPF());
            pst.setString(2, pessoa.getNome());
            pst.execute();
            System.out.println(pessoa.getNome() + " inserido");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Pessoa consultar(int id){
        ConexaoBd con = new ConexaoBd();
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        Pessoa p = null;
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs =  pst.executeQuery();
            if (rs.next()){
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                p = new Pessoa(cpf, nome);
                p.setId(rs.getInt("id"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }
    
    public List<Pessoa> consultarTodos(){
        ConexaoBd con = new ConexaoBd();
        String sql = "SELECT * FROM pessoa";
        List<Pessoa> lista = new LinkedList<Pessoa>();
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Pessoa pessoa = new Pessoa(); 
                int id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                pessoa.setId(id);
                pessoa.setCPF(cpf);
                pessoa.setNome(nome);
                lista.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public boolean excluir(int chave){
        String sql = "DELETE FROM pessoa WHERE id = ?";
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
    public boolean atualizar(Pessoa pessoa){
        try {
            String sql = "UPDATE pessoa SET cpf = ?, nome = ? WHERE id = ?";
            ConexaoBd conexao = new ConexaoBd();
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setString(1, pessoa.getCPF());
            pst.setString(2, pessoa.getNome());
            pst.setInt(3, pessoa.getId());
            int linhas = pst.executeUpdate();
            return linhas>0;            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
