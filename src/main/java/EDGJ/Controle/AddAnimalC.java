package EDGJ.Controle;

import EDGJ.Dados.DadosAnimal;
import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Enums.Especie;
import EDGJ.Modelos.Enums.Genero;
import EDGJ.Modelos.Enums.Porte;

import EDGJ.Modelos.Enums.Tela;
import EDGJ.Modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.swing.*;
import java.io.File;

public class AddAnimalC extends Controle {

    @FXML
    private ImageView imagemAnimal;

    @FXML
    private TextField nome;

    @FXML
    private TextField idade;

    @FXML
    private TextField raca;

    @FXML
    private TextField telefone;

    @FXML
    private ToggleGroup genero;

    @FXML
    private ToggleGroup porte;

    @FXML
    private ToggleGroup especie;

    @FXML
    private CheckBox checkTelefone;

    @FXML
    private TextArea descricao;

    private Image imagem;

    private File imagemSelecionada;
    @FXML
    private void enviar(ActionEvent event) {
        if(imagemSelecionada == null
                ||nome.getText().isBlank()
                || idade.getText().isBlank()
                || raca.getText().isBlank()
                || descricao.getText().isBlank()
                || genero.getSelectedToggle() == null
                || porte.getSelectedToggle() == null
                || especie.getSelectedToggle() == null
        ){
            JOptionPane.showMessageDialog(null, "Complete todos os campos");
            return;
        }
        String nomeA;
        Especie especieA;
        String racaA;
        String descricaoA;
        String publicador;
        String telefoneA;
        int idadeA;
        Genero generoA;
        Porte porteA;
        nomeA = nome.getText();
        try{
            idadeA = Integer.parseInt(idade.getText().trim());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"A idade tem que ser um número");
            return;
        }
        racaA = raca.getText();
        descricaoA = descricao.getText();
        publicador = Usuario.usuarioLogado.getNomeUsuario();
        telefoneA = telefone.getText();

        RadioButton especieSelecionada = (RadioButton) especie.getSelectedToggle();
        RadioButton generoSelecionado = (RadioButton) genero.getSelectedToggle();
        RadioButton porteSelecionado = (RadioButton) porte.getSelectedToggle();
        if(especieSelecionada.getText().equals("Gato")){
            especieA = Especie.GATO;
        }else{
            especieA = Especie.CACHORRO;
        }
        if(generoSelecionado.getText().equals("Fêmea")){
            generoA = Genero.FEMEA;
        }else{
            generoA = Genero.MACHO;
        }
        switch (porteSelecionado.getText()){
            case "Pequeno":
                porteA = Porte.PEQUENO;
                break;
            case "Médio":
                porteA = Porte.MEDIO;
                break;
            case "Grande":
                porteA = Porte.GRANDE;
                break;
            default: porteA = Porte.MEDIO;
        }
        Animal animalNovo = new Animal(nomeA, especieA,racaA,descricaoA,publicador, telefoneA,idadeA,generoA,porteA,imagem);
        DadosAnimal.addAnimal(animalNovo);
        JOptionPane.showMessageDialog(null, "Animal adicionado com sucesso");
        Navegador.irPara(Tela.INICIO);
    }
    @FXML
    private void selecionarImagem() {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Selecionar imagem do animal");

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Imagens",
                        "*.png",
                        "*.jpg",
                        "*.jpeg",
                        "*.webp"
                )
        );

        Window janela = imagemAnimal.getScene().getWindow();

        File arquivo = fileChooser.showOpenDialog(janela);

        if (arquivo != null) {

            imagemSelecionada = arquivo;

            Image original = new Image(
                    arquivo.toURI().toString()
            );
            imagem = cortarQuadrado(original);

            imagemAnimal.setImage(imagem);
        }
    }
    @FXML
    private void numero(ActionEvent event) {
        if(checkTelefone.isSelected()){
            telefone.setText(Usuario.usuarioLogado.getTelefone());
        }else{
            telefone.setText("");
        }
    }
    private Image cortarQuadrado(Image imagem) {
        double largura = imagem.getWidth();
        double altura = imagem.getHeight();

        double tamanho = Math.min(largura, altura);

        double x = (largura - tamanho) / 2;
        double y = (altura - tamanho) / 2;

        return new WritableImage(
                imagem.getPixelReader(),
                (int) x,
                (int) y,
                (int) tamanho,
                (int) tamanho
        );
    }
}