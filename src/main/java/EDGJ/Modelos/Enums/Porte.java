package EDGJ.Modelos.Enums;

public enum Porte {
    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande");
    private final String porte;
    Porte(String porte) {
        this.porte = porte;
    }
    public String toString() {
        return porte;
    }
}
