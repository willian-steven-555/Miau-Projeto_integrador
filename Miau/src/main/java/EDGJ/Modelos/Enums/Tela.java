package EDGJ.Modelos.Enums;

public enum Tela {

    LOGIN("/EDGJ/Paginas/Login.fxml"),
    REGISTRO("/EDGJ/Paginas/Registro.fxml"),
    INICIO("/EDGJ/Paginas/Inicio.fxml"),
    PERFIL("/EDGJ/Paginas/Perfil.fxml"),
    DOACAO("/EDGJ/Paginas/Doacao.fxml"),
    ANIMAL("/EDGJ/Paginas/Animal.fxml"),
    DICAS("/EDGJ/Paginas/Dicas.fxml"),
    ADDANIMAL("/EDGJ/Paginas/AddAnimal.fxml");

    private final String pagina;

    Tela(String pagina) {
        this.pagina = pagina;
    }

    public String getTela() {
        return pagina;
    }
}