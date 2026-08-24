// Classe abstrata (ABSTRAÇÃO)
// Serve como modelo para Membro e Funcionario

public abstract class Pessoa {

    // ENCAPSULAMENTO: atributos privados
    private String nome;
    private String cpf;

    // Construtor
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    // POLIMORFISMO: será implementado pelas classes filhas
    public abstract void exibirDados();
}