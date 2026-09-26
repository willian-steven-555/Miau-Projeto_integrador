package EDGJ.Modelos.Enums;

public enum Genero {
    MACHO ("Macho"),
    FEMEA ("Fêmea");
    private final String genero;
    Genero(String genero) {
        genero.replaceAll("ê", "e");
        this.genero = genero;
    }
    public String toString(){
        return genero;
    }


}
