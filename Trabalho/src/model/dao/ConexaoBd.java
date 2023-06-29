package model.dao;

import java.sql.*;

public class ConexaoBd {

	private Connection conexao;

	public ConexaoBd() {
		String url = "jdbc:mariadb://localhost:3306/conexaoBd";
		String user = "root";
        String pwd = "root";
        try{
            conexao = DriverManager.getConnection(url, user, pwd);
            System.out.println("conexao realizada");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
}
	
	public Connection getConexao(){
        return conexao;
    }
}
