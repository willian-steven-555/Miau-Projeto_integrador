package EDGJ.Controle;

import EDGJ.Dados.DadosAnimal;
import EDGJ.Dados.DadosUsuario;
import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Enums.Tela;
import EDGJ.Modelos.Usuario;
import EDGJ.Modelos.Verificador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class PerfilC extends Controle{
    @FXML
    private Label nome;
    @FXML
    private Label nomeUsuario;
    @FXML
    private Label email;
    @FXML
    private Label telefone;
    @FXML
    private Label endereco;
    @FXML
    private FlowPane painelAnimais;

    private ArrayList<Animal> animaisDoUsuario = DadosAnimal.listarAnimais("select * from animal where publicador = '"+Usuario.usuarioLogado.getNomeUsuario()+"'");
    @FXML
    private void initialize(){
        nome.setText(Usuario.usuarioLogado.getNome());
        nomeUsuario.setText(Usuario.usuarioLogado.getNomeUsuario());
        email.setText(Usuario.usuarioLogado.getEmail());
        telefone.setText(Usuario.usuarioLogado.getTelefone());
        endereco.setText(Usuario.usuarioLogado.getEndereco());
        PainelAnimais painel = new PainelAnimais(painelAnimais);
        painel.adicionarAnimais(animaisDoUsuario);
    }
    @FXML
    private void logout(ActionEvent e){
        Usuario.usuarioLogado = null;
        Navegador.irPara(Tela.LOGIN);
    }
    @FXML
    private void editarNomeUsuario(ActionEvent e){
        String aux = JOptionPane.showInputDialog("Editar Nome Usuario");
        if(aux==null || aux.isBlank()){
            return;
        }
        if(!DadosUsuario.existeNome(aux)){
            Usuario.usuarioLogado.setNomeUsuario(aux);
            DadosUsuario.editUsuario("nomeUsuario", aux);
            nomeUsuario.setText(Usuario.usuarioLogado.getNomeUsuario());
        }else{
            JOptionPane.showMessageDialog(null,"Nome de Usuario inválido");
        }
    }
    @FXML
    private void editarEmail(ActionEvent e){
        String aux = JOptionPane.showInputDialog("Editar Email");
        if(aux==null || aux.isBlank()){
            return;
        }
        if(Verificador.verificaEmail(aux)){
            Usuario.usuarioLogado.setEmail(aux);
            DadosUsuario.editUsuario("email", aux);
            email.setText(Usuario.usuarioLogado.getEmail());
        }
    }
    @FXML
    private void editarSenha(ActionEvent e){
        String aux = JOptionPane.showInputDialog("Editar Senha");
        if(aux==null || aux.isBlank()){
            return;
        }
        Usuario.usuarioLogado.setSenha(aux);
        DadosUsuario.editUsuario("senha", aux);
    }
    @FXML
    private void editarNome(ActionEvent e){
        String aux = JOptionPane.showInputDialog("Editar Nome");
        if(aux==null || aux.isBlank()){
            return;
        }
        Usuario.usuarioLogado.setNome(aux);
        DadosUsuario.editUsuario("nome", aux);
        nome.setText(Usuario.usuarioLogado.getNome());
    }
    @FXML
    private void editarTelefone(ActionEvent e){
        String aux = JOptionPane.showInputDialog("Editar Telefone");
        if(aux==null || aux.isBlank()){
            return;
        }
        if(Verificador.verificaTelefone(aux)){
            Usuario.usuarioLogado.setTelefone(aux);
            DadosUsuario.editUsuario("telefone", aux);
            telefone.setText(Usuario.usuarioLogado.getTelefone());
        }else{
            JOptionPane.showMessageDialog(null,"Insira um número de telefone válido");
        }
    }
    @FXML
    private void editarEndereco(ActionEvent e){
        String aux = JOptionPane.showInputDialog("Editar Endereco");
        if(aux==null || aux.isBlank()){
            return;
        }
        Usuario.usuarioLogado.setEndereco(aux);
        DadosUsuario.editUsuario("endereco", aux);
        endereco.setText(Usuario.usuarioLogado.getEndereco());
    }
    @FXML
    private void apagarConta(ActionEvent e){
        String aux = JOptionPane.showInputDialog("Digite sua senha para poder apagar sua conta");
        if(aux==null || aux.isBlank()){
            return;
        }
        if(!aux.equals(Usuario.usuarioLogado.getSenha())){
            JOptionPane.showMessageDialog(null,"Senha incorreta");
            return;
        }
        aux = JOptionPane.showInputDialog("Digite 'Apagar conta'");
        if(aux==null || aux.isBlank()){
            return;
        }
        if(aux.equals("Apagar conta")){
            DadosUsuario.apagarConta();
        }
    }
    @FXML
    private void editarAll(){
        Navegador.irPara(Tela.EDITOR_USUARIO);
    }
}
