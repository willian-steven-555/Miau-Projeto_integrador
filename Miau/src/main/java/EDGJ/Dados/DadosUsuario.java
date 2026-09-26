    package EDGJ.Dados;
    import EDGJ.Modelos.Usuario;

    import java.sql.*;


    public class DadosUsuario{
        public static Usuario verificaLogin(String nomeUsuario, String senha) {
            String sql = "select * from usuario where nomeUsuario=? and senha=?";
            try{
                PreparedStatement p = Conexao.conexao.prepared(sql);
                p.setString(1, nomeUsuario);
                p.setString(2, senha);
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    return new Usuario(
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("senha"),
                            rs.getString("telefone"),
                            rs.getString("endereco"),
                            rs.getString("nomeUsuario")
                    );
                }
            }catch(SQLException error){
                error.printStackTrace();
            }
            return null;
        }
        public static void addUsuario(Usuario usuario) {
            String sql = "INSERT INTO usuario(nomeUsuario,nome,email,senha,telefone,endereco,administrador) VALUES (?,?,?,?,?,?,false)";

            try {
                PreparedStatement p = Conexao.conexao.prepared(sql);

                p.setString(1, usuario.getNomeUsuario());
                p.setString(2, usuario.getNome());
                p.setString(3, usuario.getEmail());
                p.setString(4, usuario.getSenha());
                p.setString(5, usuario.getTelefone());
                p.setString(6, usuario.getEndereco());
                p.executeUpdate();

            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
        public static boolean existeNome(String nomeUsuario) {
            String sql = "SELECT nomeUsuario FROM usuario WHERE nomeUsuario = ?";

            try {
                PreparedStatement p = Conexao.conexao.prepared(sql);
                p.setString(1, nomeUsuario);

                ResultSet rs = p.executeQuery();

                return rs.next();

            } catch (SQLException error) {
                error.printStackTrace();
            }

            return false;
        }
        public static boolean existeEmail(String email) {
            String sql = "SELECT email FROM usuario WHERE email = ?";

            try {
                PreparedStatement p = Conexao.conexao.prepared(sql);
                p.setString(1, email);

                ResultSet rs = p.executeQuery();

                return rs.next();

            } catch (SQLException error) {
                error.printStackTrace();
            }

            return false;
        }
        public static boolean editUsuario(String coluna, String novoValor) {

            String sql = "UPDATE usuario SET " + coluna + " = ? WHERE nomeUsuario = ?";

            try {
                PreparedStatement p = Conexao.conexao.prepared(sql);

                p.setString(1, novoValor);
                p.setString(2, Usuario.usuarioLogado.getNomeUsuario());

                return p.executeUpdate() > 0;

            } catch (SQLException error) {
                error.printStackTrace();
            }

            return false;
        }
        public static void apagarConta(){
            String sql = "delete from animal where publicador = ?;"+
                    "delete from usuario where nomeUsuario = ?;";
            try {
                PreparedStatement p = Conexao.conexao.prepared(sql);
                p.setString(1, Usuario.usuarioLogado.getNomeUsuario());
                p.setString(2, Usuario.usuarioLogado.getNomeUsuario());
            }catch (Exception error){
                error.printStackTrace();
            }
        }
    }
