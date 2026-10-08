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

public class EditorUsuarioC extends Controle {
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

    public void initialize(){
        txtEmail.setText(Usuario.usuarioLogado.getEmail());
        txtNome.setText(Usuario.usuarioLogado.getNome());
        txtEndereco.setText(Usuario.usuarioLogado.getEndereco());
        txtTelefone.setText(Usuario.usuarioLogado.getTelefone());
        txtUsuario.setText(Usuario.usuarioLogado.getNomeUsuario());
        txtSenha.setText(Usuario.usuarioLogado.getSenha());
    }

    @FXML
    private void enviar(ActionEvent a) {
        if(txtUsuario.getText().isBlank() || txtNome.getText().isBlank()|| txtEmail.getText().isBlank()|| txtTelefone.getText().isBlank()|| txtEndereco.getText().isBlank()|| txtSenha.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return;
        }
        if (!txtUsuario.getText().equals(Usuario.usuarioLogado.getNomeUsuario()) && DadosUsuario.existeNome(txtUsuario.getText())) {

            JOptionPane.showMessageDialog(null, "Nome de Usuario inválido");
            return;
        }

        if(!Verificador.verificaTelefone(txtTelefone.getText())){
            return;
        }
        if(!Verificador.verificaEmail(txtEmail.getText())){
            return;
        }
        String aux = JOptionPane.showInputDialog("Digite sua senha para confirmar");
        if(aux==null){
            return;
        }
        if (!aux.equals(Usuario.usuarioLogado.getSenha())){
            JOptionPane.showMessageDialog(null, "Senha incorreta");
            return;
        }
        Usuario usuario = new Usuario(
                txtNome.getText(),
                txtEmail.getText(),
                txtSenha.getText(),
                txtTelefone.getText(),
                txtEndereco.getText(),
                txtUsuario.getText(),
                false
        );
        DadosUsuario.editaUsuarioCompleto(usuario);
        Usuario.usuarioLogado = usuario;
        Navegador.irPara(Tela.PERFIL);
    }
}
