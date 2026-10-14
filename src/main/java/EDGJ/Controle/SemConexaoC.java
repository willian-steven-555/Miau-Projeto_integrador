package EDGJ.Controle;

import EDGJ.Dados.Conexao;
import EDGJ.Erros.FalhaNaConexaoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.swing.*;

public class SemConexaoC {
    @FXML
    private void tryConexao(ActionEvent a){
        try{
            Conexao.conexao.conector();
        }catch (FalhaNaConexaoException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
