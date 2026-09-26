package EDGJ.Dados;

import EDGJ.Modelos.Animal;
import EDGJ.Modelos.Enums.Especie;
import EDGJ.Modelos.Enums.Genero;
import EDGJ.Modelos.Enums.Porte;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.embed.swing.SwingFXUtils;

public class DadosAnimal {
    public static ArrayList<Animal> listarAnimais(String sql) {
        ArrayList<Animal> animais = new ArrayList<>();

        try(ResultSet r = Conexao.conexao.prepared(sql).executeQuery()){
            while(r.next()){
                animais.add(new Animal(
                        r.getInt("id"),
                        r.getString("nome"),
                        Especie.valueOf(r.getString("especie")),
                        r.getNString("raca"),
                        r.getString("descricao"),
                        r.getString("publicador"),
                        r.getString("telefoneDono"),
                        r.getInt("idade"),
                        Genero.valueOf(r.getString("genero").replaceAll("ê", "e").toUpperCase()),
                        Porte.valueOf(r.getString("porte")),
                        byteImagem(r.getBytes("imagem"))
                                ));
            }
        }catch(SQLException error){

        }

        return animais;
    }
    public static void addAnimal(Animal animal){
        try(PreparedStatement p = Conexao.conexao.prepared("insert into animal(nome,idade,imagem, " +
                "descricao,raca,publicador,telefoneDono,porte,genero,especie) values(?,?,?,?,?,?,?,?,?,?)")){

            p.setString(1, animal.getNome());
            p.setInt(2, animal.getIdade());
            p.setBytes(3, imagemByte(animal.getImagem()));
            p.setString(4, animal.getDescricao());
            p.setString(5, animal.getRaca());
            p.setString(6, animal.getPublicador());
            p.setString(7, animal.getFoneDono());
            p.setString(8,animal.getPort().toString());
            p.setString(9,animal.getGender().toString());
            p.setString(10,animal.getSpecie().toString());

            p.executeUpdate();
        }catch(SQLException error){
            error.printStackTrace();
        }
    }
    public static Image byteImagem(byte[] imagem){
        return new Image(new ByteArrayInputStream(imagem));
    }
    public static byte[] imagemByte(Image imagem){
        try {
            BufferedImage bufferedImage =
                    SwingFXUtils.fromFXImage(imagem, null);

            ByteArrayOutputStream output =
                    new ByteArrayOutputStream();

            ImageIO.write(bufferedImage, "png", output);

            return output.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}