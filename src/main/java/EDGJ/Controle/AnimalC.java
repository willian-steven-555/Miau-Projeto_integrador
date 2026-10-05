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
    private Label nome;
    @FXML
    private Label idade;
    @FXML
    private Label raca;
    @FXML
    private Label especie;
    @FXML
    private Label genero;
    @FXML
    private Label porte;
    @FXML
    private Label publicador;
    @FXML
    private ImageView imagem;
    @FXML
    private Button apagar;
    @FXML
    private Button ver;
    @FXML
    private Button apagarPostUsuario;
    @FXML
    private Button editarPost;
    @FXML
    private void mostrarDados(ActionEvent event){
        JOptionPane.showMessageDialog(null,
                "Telefone do dono: "+ Animal.animal.getFoneDono());
    }
    public void initialize(){
        apagar.setVisible(Usuario.usuarioLogado.getAdmin());
        ver.setVisible(Usuario.usuarioLogado.getAdmin());
        if(!Usuario.usuarioLogado.getNomeUsuario().equals(Animal.animal.getPublicador())){
            apagarPostUsuario.setVisible(false);
            editarPost.setVisible(false);
        }
        imagem.setImage(Animal.animal.getImagem());
        nome.setText(Animal.animal.getNome());
        idade.setText(""+Animal.animal.getIdade());
        raca.setText(Animal.animal.getRaca());
        especie.setText(Animal.animal.getSpecie().toString());
        genero.setText(Animal.animal.getGender().toString());
        porte.setText(Animal.animal.getPort().toString());
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
