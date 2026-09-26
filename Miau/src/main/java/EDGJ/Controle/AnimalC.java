package EDGJ.Controle;

import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Enums.Tela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    public void mostrarDados(ActionEvent event){
        JOptionPane.showMessageDialog(null,
                "Telefone do dono: "+ Animal.animal.getFoneDono());
    }
    public void initialize(){
        imagem.setImage(Animal.animal.getImagem());
        nome.setText(Animal.animal.getNome());
        idade.setText(""+Animal.animal.getIdade());
        raca.setText(Animal.animal.getRaca());
        especie.setText(Animal.animal.getSpecie().toString());
        genero.setText(Animal.animal.getGender().toString());
        porte.setText(Animal.animal.getPort().toString());
        publicador.setText(Animal.animal.getPublicador());
    }
}
