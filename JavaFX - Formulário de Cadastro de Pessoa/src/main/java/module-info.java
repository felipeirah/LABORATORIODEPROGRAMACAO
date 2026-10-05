module br.com.felipe.cadastro {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.felipe.cadastro to javafx.fxml;
    exports br.com.felipe.cadastro;
}
