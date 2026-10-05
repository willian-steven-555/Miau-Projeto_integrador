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

    public void initialize(){
        barraEmail.setText(Usuario.usuarioLogado.getEmail());
        barraNome.setText(Usuario.usuarioLogado.getNome());
        barraEndereco.setText(Usuario.usuarioLogado.getEndereco());
        barraTelefone.setText(Usuario.usuarioLogado.getTelefone());
        barraUsuario.setText(Usuario.usuarioLogado.getNomeUsuario());
        barraSenha.setText(Usuario.usuarioLogado.getSenha());
    }

    @FXML
    private void enviar(ActionEvent a) {
        if(barraUsuario.getText().isBlank() || barraNome.getText().isBlank()||barraEmail.getText().isBlank()||barraTelefone.getText().isBlank()||barraEndereco.getText().isBlank()||barraSenha.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return;
        }
        if (!barraUsuario.getText().equals(Usuario.usuarioLogado.getNomeUsuario()) && DadosUsuario.existeNome(barraUsuario.getText())) {

            JOptionPane.showMessageDialog(null, "Nome de Usuario inválido");
            return;
        }

        if(!Verificador.verificaTelefone(barraTelefone.getText())){
            return;
        }
        if(!Verificador.verificaEmail(barraEmail.getText())){
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
                barraNome.getText(),
                barraEmail.getText(),
                barraSenha.getText(),
                barraTelefone.getText(),
                barraEndereco.getText(),
                barraUsuario.getText(),
                false
        );
        DadosUsuario.editaUsuarioCompleto(usuario);
        Usuario.usuarioLogado = usuario;
        Navegador.irPara(Tela.PERFIL);
    }
}
