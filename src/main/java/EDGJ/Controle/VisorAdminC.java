package EDGJ.Controle;

import EDGJ.Dados.DadosAnimal;
import EDGJ.Dados.DadosUsuario;
import EDGJ.Dados.MDadosAdmin;
import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Enums.Tela;
import EDGJ.Modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import javax.swing.*;
import java.util.ArrayList;

public class VisorAdminC extends Controle{
    private Usuario u;
    @FXML
    private Label nome;
    @FXML
    private Label nomeUsuario;
    @FXML
    private Label email;
    @FXML
    private Label telefone;
    @FXML
    private FlowPane painelAnimais;
    @FXML
    private CheckBox removidos;
    @FXML
    private Button justificativa;
    @FXML
    private Button b1;
    private PainelAnimais painel;
    private ArrayList<Animal> animais;
    private ArrayList<Animal> animaisRemovidos;
    public void initialize(){
        u = UsuarioCardC.usuarioVisto;
        if(u.motivoRemocao == null){
            justificativa.setVisible(false);
        }
        nome.setText(u.getNome());
        nomeUsuario.setText(u.getNomeUsuario());
        email.setText(u.getEmail());
        telefone.setText(u.getTelefone());
        animais = DadosAnimal.listarAnimais("select * from animal a where publicador = '"+u.getNomeUsuario()+"' and not exists(select ar.id from animaisRemovidos ar where a.id = ar.id)");
        animaisRemovidos = DadosAnimal.listarAnimalRemovido(u.getNomeUsuario());
        painel = new PainelAnimais(painelAnimais);
        painel.adicionarAnimais(animais);

    }
    @FXML
    private void b1Action(ActionEvent event){
        if(b1.getText().equals("Remover usuario")){
            removerUsuario();
        }
        else if(b1.getText().equals("Anular remoção")){
            anularRemocao();
        }
    }
    private void anularRemocao(){
        String aux = JOptionPane.showInputDialog("Digite sua senha para confirmar");
        if(aux == null){
            return;
        }
        if(!aux.equals(Usuario.usuarioLogado.getSenha())){
            return;
        }
        MDadosAdmin.anularRemocao(u.getNomeUsuario());
        JOptionPane.showMessageDialog(null,"Remoção de usuario anulada");
    }
    private void removerUsuario() {
        String motivo = JOptionPane.showInputDialog("Digite a justificativa");
        if(motivo == null){
            return;
        }
        if(motivo.isEmpty()){
            return;
        }
        String aux = JOptionPane.showInputDialog("Digite sua senha para confirmar");
        if(aux == null){
            return;
        }
        if(!aux.equals(Usuario.usuarioLogado.getSenha())){
            return;
        }
        MDadosAdmin.removerUsuario(u.getNomeUsuario(),motivo);
        Navegador.irPara(Tela.INICIO);
    }
    @FXML
    private void verAnimais(ActionEvent event) {
        if (removidos.isSelected()) {
            painel.limpar();
            painel.adicionarAnimais(animaisRemovidos);
        }else{
            painel.limpar();
            painel.adicionarAnimais(animais);
        }
    }
    @FXML
    private void verJustificativa(ActionEvent e){
        JOptionPane.showMessageDialog(null, u.motivoRemocao);
    }
    @FXML
    private void irParaVerUsuario(ActionEvent e){
        Navegador.irPara(Tela.VISOR_ADMIN2);
    }
}
