package EDGJ.Erros;

public class FalhaNaConexaoErro extends RuntimeException {
    public FalhaNaConexaoErro() {
        super("Não foi possivel se conectar ao banco.\nVerifique sua conexão.");
    }
}
