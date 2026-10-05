package EDGJ.Erros;

public class UsuarioBanidoErro extends RuntimeException {
    public UsuarioBanidoErro(String justificativa) {
        super("Este usuario está banido, justificativa:\n"+justificativa);
    }
}
