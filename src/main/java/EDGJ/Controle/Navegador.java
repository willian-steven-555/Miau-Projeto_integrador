package EDGJ.Controle;

import EDGJ.Modelos.Enums.Tela;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navegador {

    private static Stage stage;

    public static void iniciar(Stage stagePrincipal) {
        stage = stagePrincipal;
    }

    public static void irPara(Tela tela) {
        try{
            FXMLLoader loader = new FXMLLoader(
                    Navegador.class.getResource(tela.getTela())
            );

            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}