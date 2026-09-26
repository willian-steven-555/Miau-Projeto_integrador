package EDGJ.Controle;

import EDGJ.Dados.DadosUsuario;
import EDGJ.Modelos.Enums.Tela;
import EDGJ.Modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginC extends Controle{

    @FXML
    private TextField barraUsuario;

    @FXML
    private PasswordField barraSenha;

    @FXML
    public void entrar(ActionEvent a) {
        String nomeUsuario = barraUsuario.getText();
        String senha = barraSenha.getText();

        if (!nomeUsuario.isBlank()&&!senha.isBlank()) {
            Usuario.usuarioLogado = DadosUsuario.verificaLogin(nomeUsuario, senha);
            Navegador.irPara(Tela.INICIO);
        }
    }
}