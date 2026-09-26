package EDGJ.Controle;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;

public class DoacaoC extends Controle{
    @FXML
    private ImageView pix;

    public void initialize(){
        File img;
            img = new File(
                    "src/main/resources/EDGJ/Estilo/Imagens/pix.png"
            );
        Image ima = new Image(
                img.toURI().toString()
        );
        pix.setImage(ima);
    }
}
