package EDGJ.Dados;

import java.sql.*;

public class Conexao {
    private String url = "jdbc:mysql://localhost:3306/EDGJ";
    private String usuario = "root";
    private String senha = "root";
    private Connection connection;
    public static Conexao conexao = new Conexao();
    public Conexao(){
        try{
            connection = DriverManager.getConnection(url,usuario, senha);
        } catch(SQLException error){
            error.printStackTrace();
        }
    }
    public  PreparedStatement prepared(String sql){
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
        }catch(SQLException error){
            ps = null;
            error.printStackTrace();
        }
        return ps;
    }
}
