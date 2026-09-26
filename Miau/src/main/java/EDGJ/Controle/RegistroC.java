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
    private TextField barraUsuario;
    @FXML
    private TextField barraNome;
    @FXML
    private TextField barraEmail;
    @FXML
    private TextField barraTelefone;
    @FXML
    private TextField barraEndereco;
    @FXML
    private PasswordField barraSenha;

    public void registrar(ActionEvent a) {
        if(barraUsuario.getText().isBlank() || barraNome.getText().isBlank()||barraEmail.getText().isBlank()||barraTelefone.getText().isBlank()||barraEndereco.getText().isBlank()||barraSenha.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return;
        }
        if(DadosUsuario.existeNome(barraUsuario.getText())){
            JOptionPane.showMessageDialog(null,"Nome de usuario já existente");
            return;
        }
        if(!Verificador.verificaTelefone(barraTelefone.getText())){
            return;
        }
        if(!Verificador.verificaEmail(barraEmail.getText())){
            return;
        }
        Usuario usuario = new Usuario(
                barraNome.getText(),
                barraEmail.getText(),
                barraSenha.getText(),
                barraTelefone.getText(),
                barraEndereco.getText(),
                barraUsuario.getText()
        );
        DadosUsuario.addUsuario(usuario);
        Navegador.irPara(Tela.LOGIN);
    }
}
