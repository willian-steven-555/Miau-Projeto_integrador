package EDGJ.Controle;

import EDGJ.Dados.DadosAnimal;
import EDGJ.Dados.MDadosAdmin;
import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Enums.Tela;
import EDGJ.Modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class AnimalC extends Controle{
    @FXML
    private Label lblNome;
    @FXML
    private Label lblIdade;
    @FXML
    private Label lblRaca;
    @FXML
    private Label lblEspecie;
    @FXML
    private Label lblGenero;
    @FXML
    private Label lblPorte;
    @FXML
    private Label publicador;
    @FXML
    private ImageView imagem;
    @FXML
    private Button btnApagar;
    @FXML
    private Button btnVer;
    @FXML
    private Button btnApagarPostUsuario;
    @FXML
    private Button btnEditarPost;
    @FXML
    private void mostrarDados(ActionEvent event){
        JOptionPane.showMessageDialog(null,
                "Telefone do dono: "+ Animal.animal.getFoneDono());
    }
    public void initialize(){
        btnApagar.setVisible(Usuario.usuarioLogado.getAdmin());
        btnVer.setVisible(Usuario.usuarioLogado.getAdmin());
        if(!Usuario.usuarioLogado.getNomeUsuario().equals(Animal.animal.getPublicador())){
            btnApagarPostUsuario.setVisible(false);
            btnEditarPost.setVisible(false);
        }
        imagem.setImage(Animal.animal.getImagem());
        lblNome.setText(Animal.animal.getNome());
        lblIdade.setText(""+Animal.animal.getIdade());
        lblRaca.setText(Animal.animal.getRaca());
        lblEspecie.setText(Animal.animal.getSpecie().toString());
        lblGenero.setText(Animal.animal.getGender().toString());
        lblPorte.setText(Animal.animal.getPort().toString());
        publicador.setText(Animal.animal.getPublicador());
    }
    @FXML
    private void apagarAnimal(ActionEvent event){
        String aux = JOptionPane.showInputDialog(null,"Descrição da infração");
        if(aux == null || aux.isBlank()){
            JOptionPane.showMessageDialog(null,"É necessário justificar a remoção");
            return;
        }
        String aux2 = JOptionPane.showInputDialog("Digite sua senha para confirmar");
        if(aux2 == null || aux2.isBlank()){
            return;
        }
        if(!aux.equals(Usuario.usuarioLogado.getSenha())){
            return;
        }
        MDadosAdmin.removerPost(Animal.animal.getId(), aux);
        Navegador.irPara(Tela.INICIO);
    }
    @FXML
    private void verPublicador(ActionEvent event){
        Navegador.irPara(Tela.VISOR_ADMIN);
    }
    @FXML
    private void apagarPost(ActionEvent event){
        String aux = JOptionPane.showInputDialog("Insira sua senha");
        if(aux == null || aux.isBlank()){
            return;
        }
        if(aux.equals(Usuario.usuarioLogado.getSenha())){
            DadosAnimal.apagarAnimal(Animal.animal.getId());
            JOptionPane.showMessageDialog(null, "Post apagado com sucesso");
            Navegador.irPara(Tela.INICIO);
        }
    }
    @FXML
    private void editarPost(ActionEvent event){
        Navegador.irPara(Tela.EDITOR_ANIMAL);
    }
}
