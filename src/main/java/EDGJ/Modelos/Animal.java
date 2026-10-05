package EDGJ.Modelos;
import EDGJ.Modelos.Enums.*;
import javafx.scene.image.Image;

public class Animal {
    private String nome;
    private String raca;
    private String descricao;
    private String publicador;
    private String foneDono;
    private Image imagem;
    private int id;
    private int idade;
    private Porte porte;
    private Genero genero;
    private Especie especie;
    public static Animal animal;
    public String motivoRemocao;
    public Animal(String nome, Especie especie, String raca, String descricao, String publicador, String foneDono, int idade, Genero genero, Porte porte, Image imagem) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.descricao = descricao;
        this.publicador = publicador;
        this.foneDono = foneDono;
        this.idade = idade;
        this.genero = genero;
        this.porte = porte;
        this.imagem = imagem;
    }
    public Animal(int id,String nome, Especie especie, String raca, String descricao, String publicador, String foneDono, int idade, Genero genero, Porte porte, Image imagem){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.descricao = descricao;
        this.publicador = publicador;
        this.foneDono = foneDono;
        this.idade = idade;
        this.genero = genero;
        this.porte = porte;
        this.imagem = imagem;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getPublicador() {
        return publicador;
    }
    public void setPublicador(String publicador) {
        this.publicador = publicador;
    }
    public String getFoneDono() {
        return foneDono;
    }
    public void setFoneDono(String foneDono) {
        this.foneDono = foneDono;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public Porte getPort() {
        return porte;
    }
    public void setPort(Porte porte) {
        this.porte = porte;
    }
    public Genero getGender() {
        return genero;
    }
    public void setGender(Genero genero) {
        this.genero = genero;
    }
    public Especie getSpecie() {
        return especie;
    }
    public void setSpecie(Especie especie) {
        this.especie = especie;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Image getImagem() {
        return imagem;
    }

}
