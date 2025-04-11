module com.example.sistemaimobiliario {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.sistemaimobiliario to javafx.fxml;
    exports com.example.sistemaimobiliario;
    exports com.example.sistemaimobiliario.usuario;
    opens com.example.sistemaimobiliario.usuario to javafx.fxml;
    exports com.example.sistemaimobiliario.imoveis;
    opens com.example.sistemaimobiliario.imoveis to javafx.fxml;
    exports com.example.sistemaimobiliario.test to javafx.graphics;
    opens com.example.sistemaimobiliario.test to javafx.fxml;
}