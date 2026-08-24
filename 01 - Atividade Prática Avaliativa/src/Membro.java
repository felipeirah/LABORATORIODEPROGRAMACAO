// HERANÇA: Membro herda de Pessoa

public class Membro extends Pessoa {

    private String matricula;

    public Membro(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Matrícula: " + matricula);
    }
}