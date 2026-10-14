package EDGJ.Modelos.Enums;

public enum Especie {
    GATO("Gato"),
    CACHORRO("Cachorro");
    private String especie;
    Especie(String especie) {
        this.especie = especie;
    }
    public String toString() {
        return especie;
    }
}
