    package EDGJ.Dados;
    import EDGJ.Erros.UsuarioBanidoErro;
    import EDGJ.Modelos.Usuario;

    import java.sql.*;
    import java.util.ArrayList;

    public class DadosUsuario{
        public static Usuario verificaLogin(String nomeUsuario, String senha) {
            String sql = "SELECT u.* FROM usuario u WHERE NOT EXISTS (SELECT * FROM usuariosRemovidos ub WHERE ub.nomeUsuario = u.nomeUsuario) and nomeUsuario = ? and senha = ?;";
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
                            rs.getString("nomeUsuario"),
                            rs.getBoolean("administrador")
                    );
                }else{
                    sql = "SELECT u.*,ur.* FROM usuario u WHERE EXISTS (SELECT * FROM usuariosRemovidos ub WHERE ub.nomeUsuario = u.nomeUsuario) and nomeUsuario = ? and senha = ?;";
                    PreparedStatement p2 = Conexao.conexao.prepared(sql);
                    p2.setString(1, nomeUsuario);
                    p2.setString(2, senha);
                    ResultSet r = p2.executeQuery();
                    if(r.next()){
                        throw new UsuarioBanidoErro(r.getString("descricaoDeInfracao"));
                    }else{
                        return null;
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
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

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static boolean existeNome(String nomeUsuario) {
            String sql = "SELECT nomeUsuario FROM usuario WHERE nomeUsuario = ?";

            try {
                PreparedStatement p = Conexao.conexao.prepared(sql);
                p.setString(1, nomeUsuario);

                ResultSet rs = p.executeQuery();

                return rs.next();

            } catch (SQLException e) {
                e.printStackTrace();
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

            } catch (SQLException e) {
                e.printStackTrace();
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

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }
        public static void apagarConta() {

            String nomeUsuario = Usuario.usuarioLogado.getNomeUsuario();

            try {
                PreparedStatement p1 = Conexao.conexao.prepared(
                        "DELETE FROM animal WHERE publicador = ?"
                );

                p1.setString(1, nomeUsuario);
                p1.executeUpdate();

                PreparedStatement p2 = Conexao.conexao.prepared(
                        "DELETE FROM usuario WHERE nomeUsuario = ?"
                );

                p2.setString(1, nomeUsuario);
                p2.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void editaUsuarioCompleto(Usuario usuario) {
            String sql = "update usuario set nomeUsuario = ?,nome = ?, email = ?, telefone = ?, senha = ?, endereco = ? where nomeUsuario = ?";
            try {
                PreparedStatement p = Conexao.conexao.prepared(sql);
                p.setString(1,usuario.getNomeUsuario());
                p.setString(2,usuario.getNome());
                p.setString(3,usuario.getEmail());
                p.setString(4,usuario.getTelefone());
                p.setString(5,usuario.getSenha());
                p.setString(6,usuario.getEndereco());
                p.setString(7,Usuario.usuarioLogado.getNomeUsuario());
                p.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static Usuario getUsuario(String nomeUsuario) {
            Usuario a;
            String sql = "select nome,email,telefone from usuario where nomeUsuario = ?;";
            try {
                PreparedStatement p = Conexao.conexao.prepared(sql);
                p.setString(1,nomeUsuario);
                ResultSet r = p.executeQuery();
                while(r.next()){
                    a = new Usuario(
                      r.getString("nome"),
                      r.getString("email"),
                      r.getString("telefone"),
                      nomeUsuario
                    );
                    return a;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static ArrayList<Usuario> listarUsuario(String sql) {

            ArrayList<Usuario> usuarios = new ArrayList<>();

            try {
                PreparedStatement p = Conexao.conexao.prepared(sql);
                ResultSet r = p.executeQuery();

                while (r.next()) {
                    Usuario u = new Usuario(
                            r.getString("nome"),
                            r.getString("email"),
                            r.getString("telefone"),
                            r.getString("nomeUsuario")
                    );

                    usuarios.add(u);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return usuarios;
        }
        //Adiconar correção para erros de conexão
    }
