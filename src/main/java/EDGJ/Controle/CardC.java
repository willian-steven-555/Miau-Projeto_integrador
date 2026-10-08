package EDGJ.Controle;

import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Enums.Tela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class CardC extends Controle{
    @FXML
    private Label lblNome;

    @FXML
    private Label lblInformacao;

    @FXML
    private ImageView imagem;
    @FXML
    private Button btnJustificativa;

    private Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
        lblNome.setText(animal.getNome());
        lblInformacao.setText("Idade: "+animal.getIdade()+"\nSexo: "+animal.getGender().toString());
        imagem.setImage(animal.getImagem());
        if(animal.motivoRemocao == null){
            btnJustificativa.setVisible(false);
        }
    }
    @FXML
    private void irParaVerMais(ActionEvent actionEvent) {
        if(animal.motivoRemocao == null){
            Animal.animal = animal;
            Navegador.irPara(Tela.ANIMAL);
        }else{
            Animal.animal = animal;
            Navegador.irPara(Tela.ANIMAL2);
        }
    }
    @FXML
    private void verJustificativa(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,animal.motivoRemocao);
    }
}