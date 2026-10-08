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

public class EditorAnimalC extends Controle {

    @FXML
    private ImageView imagemAnimal;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtRaca;

    @FXML
    private TextField txtTelefone;

    @FXML
    private ToggleGroup genero;

    @FXML
    private ToggleGroup porte;

    @FXML
    private ToggleGroup especie;

    @FXML
    private TextArea descricao;

    public void initialize() {
        imagemAnimal.setImage(Animal.animal.getImagem());
        txtNome.setText(Animal.animal.getNome());
        txtIdade.setText(""+Animal.animal.getIdade());
        txtRaca.setText(Animal.animal.getRaca());
        txtTelefone.setText(Animal.animal.getFoneDono());
        descricao.setText(Animal.animal.getDescricao());

    }

    @FXML
    private void enviar(ActionEvent event) {
        if(imagemAnimal.getImage()  == null
                || txtNome.getText().isBlank()
                || txtIdade.getText().isBlank()
                || txtRaca.getText().isBlank()
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
        nomeA = txtNome.getText();
        try{
            idadeA = Integer.parseInt(txtIdade.getText().trim());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"A idade tem que ser um número");
            return;
        }
        racaA = txtRaca.getText();
        descricaoA = descricao.getText();
        publicador = Usuario.usuarioLogado.getNomeUsuario();
        telefoneA = txtTelefone.getText();

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
        Animal animalNovo = new Animal(Animal.animal.getId(), nomeA, especieA,racaA,descricaoA,publicador, telefoneA,idadeA,generoA,porteA,imagemAnimal.getImage());
        DadosAnimal.editarAnimal(animalNovo);
        JOptionPane.showMessageDialog(null, "Animal editado com sucesso");
        Navegador.irPara(Tela.ANIMAL);
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

            Image imagem = new Image(
                    arquivo.toURI().toString()
            );

            imagemAnimal.setImage(cortarQuadrado(imagem));
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
    @FXML
    private void irParaAnimal(ActionEvent event) {
        Navegador.irPara(Tela.ANIMAL);
    }
}