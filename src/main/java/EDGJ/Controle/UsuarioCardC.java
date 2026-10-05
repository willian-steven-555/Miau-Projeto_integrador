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
    private Label usuario;
    @FXML
    private Label nome;
    @FXML
    private Label telefone;
    @FXML
    private Button justificativa;
    public static Usuario usuarioVisto;
    @FXML
    private void initialize(){
        justificativa.setVisible(Usuario.usuarioLogado.getAdmin());
    }
    public void setUsuario(Usuario u){
        user = u;
        usuario.setText(u.getNomeUsuario());
        nome.setText((u.getNome()));
        telefone.setText(u.getTelefone());
    }
    @FXML
    private void verMais(ActionEvent e){
        usuarioVisto = user;
        Navegador.irPara(Tela.VISOR_ADMIN);
        //mudar
    }
    @FXML
    private void verJustificativa(ActionEvent e){
        JOptionPane.showMessageDialog(null, user.motivoRemocao);
    }
}