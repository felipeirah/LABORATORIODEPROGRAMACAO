package br.com.felipe.cadastro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Controlador do formulário. As listas observáveis alimentam os ComboBox
 * e o evento do botão é tratado por uma expressão lambda.
 *
 * @author Felipe Junior
 */
public class FormularioController {
    @FXML private TextField campoCpf;
    @FXML private TextField campoNome;
    @FXML private TextField campoEndereco;
    @FXML private ComboBox<String> comboEstado;
    @FXML private ComboBox<String> comboCargo;
    @FXML private Button botaoImprimir;

    private final ObservableList<String> estados = FXCollections.observableArrayList(
            "Acre", "Bahia", "Espírito Santo", "Minas Gerais", "Rio de Janeiro", "São Paulo");
    private final ObservableList<String> cargos = FXCollections.observableArrayList(
            "Estagiário(a)", "Assistente", "Analista", "Gerente", "Professor(a)");

    @FXML
    private void initialize() {
        comboEstado.setItems(estados);
        comboCargo.setItems(cargos);
        comboEstado.setPromptText("Selecione o estado");
        comboCargo.setPromptText("Selecione o cargo");

        // Lambda exigida pela atividade para responder ao clique do botão.
        botaoImprimir.setOnAction(evento -> imprimirDados());
    }

    private void imprimirDados() {
        String estado = comboEstado.getValue() == null ? "Não informado" : comboEstado.getValue();
        String cargo = comboCargo.getValue() == null ? "Não informado" : comboCargo.getValue();
        String dados = "CPF: " + valorOuNaoInformado(campoCpf.getText())
                + "\nNome: " + valorOuNaoInformado(campoNome.getText())
                + "\nEndereço: " + valorOuNaoInformado(campoEndereco.getText())
                + "\nEstado: " + estado
                + "\nCargo: " + cargo;

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Dados cadastrados");
        alerta.setHeaderText("Cadastro de Pessoa");
        alerta.setContentText(dados);
        alerta.showAndWait();
    }

    private String valorOuNaoInformado(String valor) {
        return valor == null || valor.isBlank() ? "Não informado" : valor.trim();
    }
}
