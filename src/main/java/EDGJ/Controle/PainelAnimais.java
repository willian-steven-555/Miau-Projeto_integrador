package EDGJ.Controle;

import EDGJ.Modelos.Animal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.ArrayList;

public class PainelAnimais {

    private final FlowPane painel;

    public PainelAnimais(FlowPane painel) {
        this.painel = painel;
    }

    public void adicionarAnimal(Animal animal) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/EDGJ/Pecas/Card.fxml")
            );

            Node card = loader.load();

            CardC controller = loader.getController();

            controller.setAnimal(animal);

            painel.getChildren().add(card);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarAnimais(ArrayList<Animal> animais) {
        limpar();

        for (Animal animal : animais) {
            adicionarAnimal(animal);
        }
    }

    public void limpar() {
        painel.getChildren().clear();
    }
}