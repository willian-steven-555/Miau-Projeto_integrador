package EDGJ.Controle;

import EDGJ.Dados.DadosAnimal;
import EDGJ.Modelos.Animal;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class InicioC extends Controle {

    @FXML
    private FlowPane painelAnimais;

    private PainelAnimais painel;

    ArrayList<Animal> lista = DadosAnimal.listarAnimais("SELECT * FROM animal");
    @FXML
    public void initialize() {
        painel = new PainelAnimais(painelAnimais);
        painel.adicionarAnimais(lista);
    }
}