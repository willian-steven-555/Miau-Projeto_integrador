package EDGJ.Controle;

import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.ArrayList;

public class PainelUsuario {

    private final FlowPane painel;

    public PainelUsuario(FlowPane painel) {
        this.painel = painel;
    }

    public void adicionarUsuario(Usuario usuario) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/EDGJ/Pecas/UsuarioCard.fxml")
            );

            Node card = loader.load();

            UsuarioCardC controller = loader.getController();

            controller.setUsuario(usuario);

            painel.getChildren().add(card);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarUsuarios(ArrayList<Usuario> usuarios) {
        limpar();

        for (Usuario u : usuarios) {
            adicionarUsuario(u);
        }
    }

    public void limpar() {
        painel.getChildren().clear();
    }
}