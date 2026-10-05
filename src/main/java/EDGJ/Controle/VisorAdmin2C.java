package EDGJ.Controle;

import EDGJ.Dados.DadosAnimal;
import EDGJ.Dados.DadosUsuario;
import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class VisorAdmin2C extends Controle{
    @FXML
    private FlowPane painelAnimais;
    @FXML
    private FlowPane painelUsuarios;
    private  ArrayList<Animal> animaisRemovidos;
    private ArrayList<Animal> animais;
    private ArrayList<Usuario> usuariosRemovidos;
    private ArrayList<Usuario> usuarios;
    @FXML
    private CheckBox usuarioCheckBox;
    @FXML
    private CheckBox animalCheckBox;
    private PainelAnimais painelA;
    private PainelUsuario painelU;

    @FXML
    private void initialize(){
        animais = DadosAnimal.listarAnimais("SELECT * FROM animal a where not exists(SELECT * FROM animaisRemovidos ar WHERE ar.id = a.id) and not exists(select nomeUsuario from usuariosRemovidos ur where a.publicador = ur.nomeUsuario)");
        animaisRemovidos = DadosAnimal.listarAnimalRemovido();
        usuarios = DadosUsuario.listarUsuario("SELECT * FROM usuario u WHERE NOT EXISTS (SELECT * FROM usuariosRemovidos ub WHERE ub.nomeUsuario = u.nomeUsuario)");
        usuariosRemovidos = DadosUsuario.listarUsuario("select * from usuario u, usuariosRemovidos ur where u.nomeUsuario = ur.nomeUsuario");
        painelA = new PainelAnimais(painelAnimais);
        painelA.adicionarAnimais(animais);
        painelU = new PainelUsuario(painelUsuarios);
        painelU.adicionarUsuarios(usuarios);
    }
    @FXML
    private void mudaVU(ActionEvent event){
        painelU.limpar();
        if(usuarioCheckBox.isSelected()){
            painelU.adicionarUsuarios(usuariosRemovidos);
        }else{
            painelU.adicionarUsuarios(usuarios);
        }
    }
    @FXML
    private void mudaVA(ActionEvent event){
        painelA.limpar();
        if(animalCheckBox.isSelected()){
            painelA.adicionarAnimais(animaisRemovidos);
        }else{
            painelA.adicionarAnimais(animais);
        }
    }
}
