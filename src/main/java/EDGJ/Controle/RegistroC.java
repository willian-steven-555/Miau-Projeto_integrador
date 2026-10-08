package EDGJ.Controle;

import EDGJ.Dados.DadosUsuario;
import EDGJ.Modelos.Enums.Tela;
import EDGJ.Modelos.Usuario;
import EDGJ.Modelos.Verificador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

public class RegistroC extends Controle{
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtEndereco;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private void registrar(ActionEvent a) {
        if(txtUsuario.getText().isBlank() || txtNome.getText().isBlank()|| txtEmail.getText().isBlank()|| txtTelefone.getText().isBlank()|| txtEndereco.getText().isBlank()|| txtSenha.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return;
        }
        if(DadosUsuario.existeNome(txtUsuario.getText())){
            JOptionPane.showMessageDialog(null,"Nome de usuario já existente");
            return;
        }
        if(!Verificador.verificaTelefone(txtTelefone.getText())){
            return;
        }
        if(!Verificador.verificaEmail(txtEmail.getText())){
            return;
        }
        Usuario usuario = new Usuario(
                txtNome.getText(),
                txtEmail.getText(),
                txtSenha.getText(),
                txtTelefone.getText().replaceAll("[()\\-\\s]",""),
                txtEndereco.getText(),
                txtUsuario.getText(),
                false
        );
        DadosUsuario.addUsuario(usuario);
        Navegador.irPara(Tela.LOGIN);
    }
}
