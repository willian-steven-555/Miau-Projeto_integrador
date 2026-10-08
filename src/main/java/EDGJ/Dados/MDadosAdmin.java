package EDGJ.Dados;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MDadosAdmin{
    public static void removerUsuario(String numUser, String descricao){
        String sql = "Insert into usuariosRemovidos values (?,?);";
        try{
            PreparedStatement p = Conexao.conexao.prepared(sql);
            p.setString(1,numUser);
            p.setString(2,descricao);
            p.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void removerPost(int id, String descricao){
        String sql = "Insert into animaisRemovidos values (?,?)";
        try{
            PreparedStatement p = Conexao.conexao.prepared(sql);
            p.setInt(1,id);
            p.setString(2,descricao);
            p.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void anularRemocao(String nomeUsuario){
        String sql ="delete from usuariosRemovidos where nomeUsuario =?";
        PreparedStatement p = Conexao.conexao.prepared(sql);
        try {
            p.setString(1,nomeUsuario);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}