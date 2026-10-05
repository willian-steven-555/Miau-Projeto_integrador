package EDGJ.Modelos;

public class Usuario {
    public String motivoRemocao;
    private String nomeUsuario;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
    public static Usuario usuarioLogado;
    private boolean admin;
    public Usuario(String nome, String email, String senha, String telefone, String endereco, String nomeUsuario, boolean admin) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.nomeUsuario = nomeUsuario;
        this.admin = admin;
    }
    public Usuario(String nome, String email, String telefone, String nomeUsuario) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.nomeUsuario = nomeUsuario;
    }

    //get e set
    //nomeUsuario
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }
    //Nome
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    //Email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    //Senha
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    //Telefone
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    //Endereço
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    //Admin
    public boolean getAdmin(){
        return admin;
    }
    //tirar depois
    public void setAdmin(boolean b) {
        admin = b;
    }
}

