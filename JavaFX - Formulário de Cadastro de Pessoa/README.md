# Formulário de Cadastro de Pessoa — JavaFX

Atividade JavaFX que recebe CPF, nome, endereço, estado e cargo. Ao clicar em **Imprimir Dados**, a aplicação apresenta os dados informados em uma janela `Alert`.

## Requisitos

- JDK 21 ou superior
- Maven 3.9 ou superior

## Como executar

```bash
mvn javafx:run
```

Também é possível abrir a pasta como um projeto Maven no NetBeans ou no IntelliJ IDEA e executar a classe `FormularioCadastro`.

## Estrutura

- `FormularioCadastro.java`: classe `Application`, responsável pelo `Stage` e pela `Scene`.
- `FormularioController.java`: popula as `ObservableList` e trata, por expressão lambda, o clique no botão.
- `formulario.fxml`: define a interface com `GridPane`.
- `formulario.css`: estilos visuais da interface.
