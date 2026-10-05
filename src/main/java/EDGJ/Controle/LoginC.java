package EDGJ.Controle;

import EDGJ.Dados.DadosUsuario;
import EDGJ.Erros.UsuarioBanidoErro;
import EDGJ.Modelos.Enums.Tela;
import EDGJ.Modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

public class LoginC extends Controle{

    @FXML
    private TextField barraUsuario;

    @FXML
    private PasswordField barraSenha;

    @FXML
    private void entrar(ActionEvent a) {
        String nomeUsuario = barraUsuario.getText();
        String senha = barraSenha.getText();

        if (!nomeUsuario.isBlank()&&!senha.isBlank()) {
            Usuario aux;
            try{
                aux  = DadosUsuario.verificaLogin(nomeUsuario, senha);
            }catch(UsuarioBanidoErro e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                return;
            }
            if (aux!=null){
                Usuario.usuarioLogado = aux;
            }else{
                JOptionPane.showMessageDialog(null,"Usuario ou senha incorretos");
                return;
            }
            Navegador.irPara(Tela.INICIO);
        }
    }
}