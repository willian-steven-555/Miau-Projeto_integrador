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

    private ArrayList<Animal> animaisDoUsuario = DadosAnimal.listarAnimais("select * from animal where publicador ="+Usuario.usuarioLogado.getNomeUsuario());
    public void initialize(){
        nome.setText(Usuario.usuarioLogado.getNome());
        nomeUsuario.setText(Usuario.usuarioLogado.getNomeUsuario());
        email.setText(Usuario.usuarioLogado.getEmail());
        telefone.setText(Usuario.usuarioLogado.getTelefone());
        endereco.setText(Usuario.usuarioLogado.getEndereco());
        PainelAnimais painel = new PainelAnimais(painelAnimais);
        painel.adicionarAnimais(animaisDoUsuario);
    }

    public void logout(ActionEvent e){
        Usuario.usuarioLogado = null;
        Navegador.irPara(Tela.LOGIN);
    }
    public void editarNomeUsuario(ActionEvent e){
        String novoNomeUsuario = JOptionPane.showInputDialog("Editar Nome Usuario");
        if(novoNomeUsuario==null){
            return;
        }
        if(!DadosUsuario.existeNome(novoNomeUsuario)){
            Usuario.usuarioLogado.setNome(novoNomeUsuario);
            DadosUsuario.editUsuario("nomeUsuario", novoNomeUsuario);
            nomeUsuario.setText(Usuario.usuarioLogado.getNomeUsuario());
        }else{
            JOptionPane.showMessageDialog(null,"Nome de Usuario inválido");
        }
    }
    public void editarEmail(ActionEvent e){
        String novoEmail = JOptionPane.showInputDialog("Editar Email");
        if(novoEmail==null){
            return;
        }
        if(Verificador.verificaEmail(novoEmail)){
            Usuario.usuarioLogado.setEmail(novoEmail);
            DadosUsuario.editUsuario("email", novoEmail);
            email.setText(Usuario.usuarioLogado.getEmail());
        }
    }
    public void editarSenha(ActionEvent e){
        String novoSenha = JOptionPane.showInputDialog("Editar Senha");
        if(novoSenha==null){
            return;
        }
        Usuario.usuarioLogado.setSenha(novoSenha);
        DadosUsuario.editUsuario("senha", novoSenha);
    }
    public void editarNome(ActionEvent e){
        String novoNome = JOptionPane.showInputDialog("Editar Nome");
        if(novoNome==null){
            return;
        }
        Usuario.usuarioLogado.setNome(novoNome);
        DadosUsuario.editUsuario("nome", novoNome);
        nome.setText(Usuario.usuarioLogado.getNome());
    }
    public void editarTelefone(ActionEvent e){
        String novoTelefone = JOptionPane.showInputDialog("Editar Telefone");
        if(novoTelefone==null){
            return;
        }
        if(Verificador.verificaTelefone(novoTelefone)){
            Usuario.usuarioLogado.setTelefone(novoTelefone);
            DadosUsuario.editUsuario("telefone", novoTelefone);
            telefone.setText(Usuario.usuarioLogado.getTelefone());
        }else{
            JOptionPane.showMessageDialog(null,"Insira um número de telefone válido");
        }
    }
    public void editarEndereco(ActionEvent e){
        String novoEndereco = JOptionPane.showInputDialog("Editar Endereco");
        if(novoEndereco==null){
            return;
        }
        Usuario.usuarioLogado.setEndereco(novoEndereco);
        DadosUsuario.editUsuario("endereco", novoEndereco);
        endereco.setText(Usuario.usuarioLogado.getEndereco());
    }
    public void apagarConta(ActionEvent e){
        String aux = JOptionPane.showInputDialog("Digite sua senha para poder apagar sua conta");
        if(aux==null){
            return;
        }
        if(aux!=Usuario.usuarioLogado.getSenha()){
            JOptionPane.showMessageDialog(null,"Senha incorreta");
            return;
        }
        aux = JOptionPane.showInputDialog("Digite 'Apagar conta'");
        if(aux==null){
            return;
        }
        if(aux.equals("Apagar conta")){
            DadosUsuario.apagarConta();
        }
    }
}
