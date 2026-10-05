package br.com.felipe.cadastro;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principal da aplicação JavaFX.
 * Ela cria a cena e exibe o formulário no palco (Stage).
 *
 * @author Felipe Junior
 */
public class FormularioCadastro extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                FormularioCadastro.class.getResource("formulario.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(FormularioCadastro.class
                .getResource("formulario.css").toExternalForm());

        stage.setTitle("Formulário para cadastro de Pessoa");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
