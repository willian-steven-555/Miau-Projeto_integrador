package EDGJ.Controle;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DicasC extends Controle{
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private void initialize(){
        Image imagem = new Image(
                getClass().getResource("/EDGJ/Estilo/Imagens/img1.png").toExternalForm()
        );
        img1.setImage(imagem);
        Image imagem2 = new Image(
                getClass().getResource("/EDGJ/Estilo/Imagens/pix.png").toExternalForm()
        );
        img2.setImage(imagem2);
    }
}
