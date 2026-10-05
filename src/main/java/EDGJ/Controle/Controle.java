package EDGJ.Controle;

import EDGJ.Modelos.Enums.Tela;
import javafx.event.ActionEvent;

public class Controle {
    public void irParaLogin(ActionEvent e){
        Navegador.irPara(Tela.LOGIN);
    }
    public void irParaInicio(ActionEvent e){
        Navegador.irPara(Tela.INICIO);
    }
    public void irParaRegistro(ActionEvent e){
        Navegador.irPara(Tela.REGISTRO);
    }
    public void irParaPerfil(ActionEvent e){
        Navegador.irPara(Tela.PERFIL);
    }
    public void irParaDoacao(ActionEvent e){
        Navegador.irPara(Tela.DOACAO);
    }
    public void irParaAddAnimal(ActionEvent e){
        Navegador.irPara(Tela.ADDANIMAL);
    }
    public void irParaVerDicas(ActionEvent e){
        Navegador.irPara(Tela.DICAS);
    }
    public void irParaAdmin(ActionEvent e){Navegador.irPara(Tela.VISOR_ADMIN2);}
}
