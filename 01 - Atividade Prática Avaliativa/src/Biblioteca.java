import java.util.ArrayList;

// Classe que gerencia todo o sistema

public class Biblioteca {

    // Listas onde ficam armazenados os dados
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Membro> membros = new ArrayList<>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    // Adiciona um livro
    public void adicionarLivro(Livro l) {
        livros.add(l);
    }

    // Adiciona um membro
    public void adicionarMembro(Membro m) {
        membros.add(m);
    }

    // Lista todos os livros
    public void listarLivros() {

        for(int i = 0; i < livros.size(); i++) {
            System.out.println(i + " - " + livros.get(i));
        }

    }

    // Lista todos os membros
    public void listarMembros() {

        for(int i = 0; i < membros.size(); i++) {

            System.out.print(i + " - ");
            membros.get(i).exibirDados();

        }

    }

    // Realiza um empréstimo
    public void realizarEmprestimo(int livro, int membro) {

        if(livros.get(livro).isDisponivel()) {

            emprestimos.add(
                new Emprestimo(livros.get(livro), membros.get(membro))
            );

            System.out.println("Empréstimo realizado!");

        } else {

            System.out.println("Livro indisponível.");

        }

    }

    // Lista empréstimos
    public void listarEmprestimos() {

        for(int i = 0; i < emprestimos.size(); i++) {
            System.out.println(i + " - " + emprestimos.get(i));
        }

    }

    // Devolve um livro
    public void devolver(int indice) {

        emprestimos.get(indice).encerrar();

        System.out.println("Livro devolvido.");

    }

}