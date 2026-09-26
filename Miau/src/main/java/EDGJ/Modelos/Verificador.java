package EDGJ.Modelos;

import EDGJ.Dados.DadosUsuario;

import javax.swing.*;

public class Verificador {
    public static boolean verificaEmail(String email){
        if(DadosUsuario.existeEmail(email)){
            JOptionPane.showMessageDialog(null, "Email já existente em outra conta");
            return false;
        }
        if(!email.contains("@")){
            JOptionPane.showMessageDialog(null,"Email inválido");
            return false;
        }
        return true;
    }
    public static boolean verificaTelefone(String telefone){
        try{
            long a = Long.parseLong(telefone);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"O telefone só pode ter números");
            return false;
        }
        if(!(telefone.length()==11)){
            JOptionPane.showMessageDialog(null,"Número de telefone inválido");
            return false;
        }
        return true;
    }
}
