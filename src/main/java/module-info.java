module org.combatstudios.miau2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.swing;

    opens EDGJ.Controle to javafx.fxml;
    exports EDGJ.Controle;
    exports EDGJ;
    opens EDGJ to javafx.fxml;
}