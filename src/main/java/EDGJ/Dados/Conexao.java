package EDGJ.Dados;

import EDGJ.Controle.Navegador;
import EDGJ.Erros.FalhaNaConexaoException;
import EDGJ.Modelos.Enums.Tela;

import java.sql.*;

public class Conexao {
    private String url = "jdbc:mysql://localhost:3306/EDGJ";
    private String usuario = "root";
    private String senha = "root";
    private Connection connection;
    public static Conexao conexao = new Conexao();
    public Conexao(){
        try{
            conector();
        }catch (FalhaNaConexaoException e){
            Navegador.irPara(Tela.SEM_CONEXAO);
        }
    }
    public void conector(){
        try{
            connection = DriverManager.getConnection(url,usuario, senha);
        } catch(SQLException e){
            e.printStackTrace();
            throw new FalhaNaConexaoException();
        }
    }
    public  PreparedStatement prepared(String sql){
        if(connection == null){
            throw new FalhaNaConexaoException();
        }
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
        }catch(SQLException error){
            throw new FalhaNaConexaoException();
        }
        return ps;
    }
}
