package EDGJ.Controle;

import EDGJ.Dados.DadosAnimal;
import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Enums.Tela;
import EDGJ.Modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class Animal2C extends AnimalC{
    @FXML
    private Label lblNome;
    @FXML
    private Label lblIdade;
    @FXML
    private Label lblRaca;
    @FXML
    private Label lblEspecie;
    @FXML
    private Label lblGenero;
    @FXML
    private Label lblPorte;
    @FXML
    private Label lblPublicador;
    @FXML
    private ImageView imagem;
    @FXML
    private void mostrarDados(ActionEvent event){
        JOptionPane.showMessageDialog(null,
                "Telefone do dono: "+ Animal.animal.getFoneDono());
    }
    public void initialize(){
        imagem.setImage(Animal.animal.getImagem());
        lblNome.setText(Animal.animal.getNome());
        lblIdade.setText(""+Animal.animal.getIdade());
        lblRaca.setText(Animal.animal.getRaca());
        lblEspecie.setText(Animal.animal.getSpecie().toString());
        lblGenero.setText(Animal.animal.getGender().toString());
        lblPorte.setText(Animal.animal.getPort().toString());
        lblPublicador.setText(Animal.animal.getPublicador());
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
        DadosAnimal.anularRemocao(Animal.animal.getId());
        Navegador.irPara(Tela.VISOR_ADMIN);
    }

}
