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

public class Animal2C extends AnimalC{
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
    private void mostrarDados(ActionEvent event){
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
    @FXML
    private void verPublicador(ActionEvent event){
        Navegador.irPara(Tela.VISOR_ADMIN);
    }
    @FXML
    private void anularRemocao(ActionEvent event) {
        String aux = JOptionPane.showInputDialog("Digite sua senha para confirmar");
        if(aux == null){
            return;
        }
        if(!aux.equals(Usuario.usuarioLogado.getSenha())){
            return;
        }
        //daria para evitar repetições usando uma função que faça essa verificação
        //arrumar depois o fato de que as vezes é ==null e outras isEmty
        DadosAnimal.anularRemocao(Animal.animal.getId());
        Navegador.irPara(Tela.VISOR_ADMIN);
    }

}
