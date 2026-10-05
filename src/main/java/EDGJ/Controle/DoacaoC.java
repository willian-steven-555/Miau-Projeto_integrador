package EDGJ.Controle;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;

public class DoacaoC extends Controle{
    @FXML
    private ImageView pix;
    @FXML
    private void initialize(){
        Image imagem = new Image(
                getClass().getResource("/EDGJ/Estilo/Imagens/pix.png").toExternalForm()
        );
        pix.setImage(imagem);
    }
}
