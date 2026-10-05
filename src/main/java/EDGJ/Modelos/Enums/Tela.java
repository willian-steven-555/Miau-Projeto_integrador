package EDGJ.Modelos.Enums;

public enum Tela {

    LOGIN("/EDGJ/Paginas/Login.fxml"),
    REGISTRO("/EDGJ/Paginas/Registro.fxml"),
    INICIO("/EDGJ/Paginas/Inicio.fxml"),
    PERFIL("/EDGJ/Paginas/Perfil.fxml"),
    DOACAO("/EDGJ/Paginas/Doacao.fxml"),
    ANIMAL("/EDGJ/Paginas/Animal.fxml"),
    DICAS("/EDGJ/Paginas/Dicas.fxml"),
    ADDANIMAL("/EDGJ/Paginas/AddAnimal.fxml"),
    EDITOR_ANIMAL("/EDGJ/Paginas/EditorAnimal.fxml"),
    EDITOR_USUARIO("/EDGJ/Paginas/EditorUsuario.fxml"),
    VISOR_ADMIN("/EDGJ/Paginas/VisorAdmin.fxml"),
    ANIMAL2("/EDGJ/Paginas/Animal2.fxml"),
    VISOR_ADMIN2("/EDGJ/Paginas/VisorAdmin2.fxml");

    private final String pagina;

    Tela(String pagina) {
        this.pagina = pagina;
    }

    public String getTela() {
        return pagina;
    }
}