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
import java.util.Locale;

import javafx.embed.swing.SwingFXUtils;

public class DadosAnimal {
    public static ArrayList<Animal> listarAnimais(String sql) {
        ArrayList<Animal> animais = new ArrayList<>();

        try(ResultSet r = Conexao.conexao.prepared(sql).executeQuery()){
            while(r.next()){
                animais.add(new Animal(
                        r.getInt("id"),
                        r.getString("nome"),
                        Especie.valueOf(r.getString("especie").toUpperCase()),
                        r.getNString("raca"),
                        r.getString("descricao"),
                        r.getString("publicador"),
                        r.getString("telefoneDono"),
                        r.getInt("idade"),
                        Genero.valueOf(r.getString("genero").replaceAll("ê", "e").toUpperCase()),
                        Porte.valueOf(r.getString("porte").replaceAll("é","e").toUpperCase()),
                        //ver depois se deixar assim ou se será exigido algo mais robusto
                        byteImagem(r.getBytes("imagem"))
                                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
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

    public static void apagarAnimal(int id) {
        String sql ="delete from animal where id=?";
        PreparedStatement p = Conexao.conexao.prepared(sql);
        try {
            p.setInt(1,id);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editarAnimal(Animal animalNovo) {
        String sql = "update animal set imagem = ?, nome = ?, idade = ?, raca = ?, telefoneDono = ?, genero = ?, porte = ?, especie = ?, descricao = ? where id = ?";
        try {
            PreparedStatement p = Conexao.conexao.prepared(sql);
            p.setBytes(1,imagemByte(animalNovo.getImagem()));
            p.setString(2, animalNovo.getNome());
            p.setInt(3, animalNovo.getIdade());
            p.setString(4, animalNovo.getRaca());
            p.setString(5, animalNovo.getFoneDono());
            p.setString(6, animalNovo.getGender().toString());
            p.setString(7, animalNovo.getPort().toString());
            p.setString(8, animalNovo.getSpecie().toString());
            p.setString(9,animalNovo.getDescricao());
            p.setInt(10,animalNovo.getId());
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Animal> listarAnimalRemovido(String nomeUsuario) {
        String sql = "SELECT * FROM animal a, animaisRemovidos ar where a.id = ar.id and publicador = ?";
        ArrayList<Animal> animals = new ArrayList<>();
        PreparedStatement p = Conexao.conexao.prepared(sql);
        try {
            p.setString(1,nomeUsuario);
            ResultSet r = p.executeQuery();
            Animal animal;
            while (r.next()) {
                animal = new Animal(
                        r.getInt("id"),
                        r.getString("nome"),
                        Especie.valueOf(r.getString("especie").toUpperCase()),
                        r.getNString("raca"),
                        r.getString("descricao"),
                        r.getString("publicador"),
                        r.getString("telefoneDono"),
                        r.getInt("idade"),
                        Genero.valueOf(r.getString("genero").replaceAll("ê", "e").toUpperCase()),
                        Porte.valueOf(r.getString("porte").replaceAll("é","e").toUpperCase()),
                        //ver depois se deixar assim ou se será exigido algo mais robusto
                        byteImagem(r.getBytes("imagem")));
                animal.motivoRemocao = r.getString("descricaoDeInfracao");
                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  animals;
    }
    public static ArrayList<Animal> listarAnimalRemovido() {
        String sql = "SELECT * FROM animal a, animaisRemovidos ar where a.id = ar.id";
        ArrayList<Animal> animals = new ArrayList<>();
        PreparedStatement p = Conexao.conexao.prepared(sql);
        try {
            ResultSet r = p.executeQuery();
            Animal animal;
            while (r.next()) {
                animal = new Animal(
                        r.getInt("id"),
                        r.getString("nome"),
                        Especie.valueOf(r.getString("especie").toUpperCase()),
                        r.getNString("raca"),
                        r.getString("descricao"),
                        r.getString("publicador"),
                        r.getString("telefoneDono"),
                        r.getInt("idade"),
                        Genero.valueOf(r.getString("genero").replaceAll("ê", "e").toUpperCase()),
                        Porte.valueOf(r.getString("porte").replaceAll("é","e").toUpperCase()),
                        //ver depois se deixar assim ou se será exigido algo mais robusto
                        byteImagem(r.getBytes("imagem")));
                animal.motivoRemocao = r.getString("descricaoDeInfracao");
                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  animals;
    }

    public static void anularRemocao(int id){
        String sql ="delete from animaisRemovidos where id=?";
        PreparedStatement p = Conexao.conexao.prepared(sql);
        try {
            p.setInt(1,id);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}