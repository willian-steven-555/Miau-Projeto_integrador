package EDGJ.Controle;

import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Enums.Tela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardC extends Controle{
    @FXML
    private Label nome;

    @FXML
    private Label informacao;

    @FXML
    private ImageView imagem;

    private Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
        nome.setText(animal.getNome());
        informacao.setText("Idade: "+animal.getIdade()+"\nSexo: "+animal.getGender().toString());
        imagem.setImage(animal.getImagem());
    }

    public void irParaVerMais(ActionEvent actionEvent) {
        Animal.animal = animal;
        Navegador.irPara(Tela.ANIMAL);
    }
}