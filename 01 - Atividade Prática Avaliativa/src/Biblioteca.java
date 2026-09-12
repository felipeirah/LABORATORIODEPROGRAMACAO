import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Membro> membros = new ArrayList<>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    public void adicionarLivro(Livro l) {
        livros.add(l);
    }
    public void adicionarMembro(Membro m) {
        membros.add(m);
    }
    public void listarLivros() {

        for(int i = 0; i < livros.size(); i++) {
            System.out.println(i + " - " + livros.get(i));
        }

    }
    public void listarMembros() {

        for(int i = 0; i < membros.size(); i++) {

            System.out.print(i + " - ");
            membros.get(i).exibirDados();

        }

    }
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
    public void listarEmprestimos() {

        for(int i = 0; i < emprestimos.size(); i++) {
            System.out.println(i + " - " + emprestimos.get(i));
        }

    }
    public void devolver(int indice) {

        emprestimos.get(indice).encerrar();

        System.out.println("Livro devolvido.");

    }

}