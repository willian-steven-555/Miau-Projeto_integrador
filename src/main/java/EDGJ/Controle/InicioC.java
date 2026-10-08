package EDGJ.Controle;

import EDGJ.Dados.DadosAnimal;
import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class InicioC extends Controle {

    @FXML
    private FlowPane painelAnimais;
    @FXML
    private Button btnAdmin;

    private PainelAnimais painel;

    ArrayList<Animal> lista = DadosAnimal.listarAnimais("SELECT * FROM animal a where not exists(SELECT * FROM animaisRemovidos ar WHERE ar.id = a.id) and not exists(select nomeUsuario from usuariosRemovidos ur where a.publicador = ur.nomeUsuario)");
    @FXML
    private void initialize() {
        btnAdmin.setVisible(Usuario.usuarioLogado.getAdmin());
        painel = new PainelAnimais(painelAnimais);
        painel.adicionarAnimais(lista);
    }
}