package EDGJ.Modelos;

import EDGJ.Dados.DadosUsuario;

import javax.swing.*;

public class Verificador {
    public static boolean verificaEmail(String email){
        if(!email.contains("@")){
            JOptionPane.showMessageDialog(null,"Email inválido");
            return false;
        }
        return true;
    }
    public static boolean verificaTelefone(String telefone){
        try{
            String aux = telefone.replaceAll("[()\\-\\s]","");
            System.out.print(aux);
            long a = Long.parseLong(aux);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"O telefone só pode ter números");
            return false;
        }
        if(!(telefone.length()>=10)){
            JOptionPane.showMessageDialog(null,"Número de telefone inválido");
            return false;
        }
        return true;
    }
}
