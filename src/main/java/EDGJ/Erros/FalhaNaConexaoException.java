package EDGJ.Erros;

public class FalhaNaConexaoException extends RuntimeException {
    public FalhaNaConexaoException() {
        super("Não foi possivel se conectar ao banco.\nVerifique sua conexão e tente novamente.");
    }
}
