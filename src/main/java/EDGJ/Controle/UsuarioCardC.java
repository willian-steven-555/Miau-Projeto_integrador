package EDGJ.Controle;

import EDGJ.Modelos.Enums.Tela;
import EDGJ.Modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;

public class UsuarioCardC{
    private  Usuario user;
    @FXML
    private Label lblUsuario;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblTelefone;
    @FXML
    private Button btnJustificativa;
    public static Usuario usuarioVisto;
    @FXML
    private void initialize(){
        btnJustificativa.setVisible(Usuario.usuarioLogado.getAdmin());
    }
    public void setUsuario(Usuario u){
        user = u;
        lblUsuario.setText(u.getNomeUsuario());
        lblNome.setText((u.getNome()));
        lblTelefone.setText(u.getTelefone());
    }
    @FXML
    private void verMais(ActionEvent e){
        usuarioVisto = user;
        Navegador.irPara(Tela.VISOR_ADMIN);
    }
    @FXML
    private void verJustificativa(ActionEvent e){
        JOptionPane.showMessageDialog(null, user.motivoRemocao);
    }
}