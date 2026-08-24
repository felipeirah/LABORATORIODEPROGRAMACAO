// Outra classe que herda de Pessoa

public class Funcionario extends Pessoa {

    private String cargo;

    public Funcionario(String nome, String cpf, String cargo) {
        super(nome, cpf);
        this.cargo = cargo;
    }

    @Override
    public void exibirDados() {
        System.out.println("Funcionário: " + getNome());
        System.out.println("Cargo: " + cargo);
    }
}