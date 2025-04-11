package com.example.sistemaimobiliario.test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestController {

    @FXML
    private void onGerenciarCorretoresClick() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gerenciar-corretores-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Gerenciar Corretores");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onGerenciarClientesClick() {
        // Lógica para abrir a tela de gerenciamento de clientes
        System.out.println("Gerenciar Clientes");
    }

    @FXML
    private void onGerenciarImoveisClick() {
        // Lógica para abrir a tela de gerenciamento de imóveis
        System.out.println("Gerenciar Imóveis");
    }
}