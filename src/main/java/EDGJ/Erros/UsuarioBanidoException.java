package EDGJ.Erros;

public class UsuarioBanidoException extends RuntimeException {
    public UsuarioBanidoException(String justificativa) {
        super("Este usuario está banido, justificativa:\n"+justificativa);
    }
}
