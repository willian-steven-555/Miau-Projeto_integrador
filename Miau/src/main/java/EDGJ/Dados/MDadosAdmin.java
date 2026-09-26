package EDGJ.Dados;


public class MDadosAdmin{
    public void deleteUser(String numUser){
        String sql = "DELETE FROM usuario WHERE nomeUsuario=?";

    }
    public void deletePost(int id){
        String sql = "delete from animal where id=?";

    }
}