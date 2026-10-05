/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Felipe Junior e Jhonathan Freitas
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// Gerencia os livros, os membros e os empréstimos da biblioteca.
public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Membro> membros;
    private ArrayList<Emprestimo> emprestimos;
    
    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
    }

    public List<Membro> getMembros() {
        return Collections.unmodifiableList(membros);
    }

    public List<Emprestimo> getEmprestimos() {
        return Collections.unmodifiableList(emprestimos);
    }

    public Biblioteca() {
        livros = new ArrayList<>();
        membros = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {
            livro.exibirInformacao();
            System.out.println("--------------------");
        }
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public void removerLivro(int id) {
        Livro livro = buscarLivroPorId(id);

        if (livro != null) {
            livros.remove(livro);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro nao encontrado.");
        }
    }

    public void editarLivro(int id, String novoTitulo, String novoAutor, String novoIsbn) {
        Livro livro = buscarLivroPorId(id);

        if (livro != null) {
            livro.setTitulo(novoTitulo);
            livro.setAutor(novoAutor);
            livro.setIsbn(novoIsbn);
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Livro nao encontrado.");
        }
    }

    public void cadastrarMembro(Membro membro) {
        membros.add(membro);
        System.out.println("Membro cadastrado com sucesso!");
    }

    public void listarMembros() {
        if (membros.isEmpty()) {
            System.out.println("Nenhum membro cadastrado.");
            return;
        }

        for (Membro membro : membros) {
            membro.exibirInformacao();
            System.out.println("--------------------");
        }
    }

    public Membro buscarMembroPorId(int id) {
        for (Membro membro : membros) {
            if (membro.getId() == id) {
                return membro;
            }
        }
        return null;
    }

    public void editarMembro(int id, String novoNome, String novoEmail, String novoTelefone) {
        Membro membro = buscarMembroPorId(id);

        if (membro != null) {
            membro.setNome(novoNome);
            membro.setEmail(novoEmail);
            membro.setTelefone(novoTelefone);
            System.out.println("Membro atualizado com sucesso!");
        } else {
            System.out.println("Membro nao encontrado.");
        }
    }

    public void realizarEmprestimo(int idEmprestimo, int idLivro, int idMembro) {
        Livro livro = buscarLivroPorId(idLivro);
        Membro membro = buscarMembroPorId(idMembro);

        if (livro == null) {
            throw new IllegalArgumentException("Livro nao encontrado.");
        }

        if (membro == null) {
            throw new IllegalArgumentException("Membro nao encontrado.");
        }

        if (!livro.getDisponivel()) {
            throw new IllegalStateException("Livro nao esta disponivel.");
        }

        Emprestimo emprestimo = new Emprestimo(idEmprestimo, livro, membro);
        emprestimos.add(emprestimo);
        System.out.println("Emprestimo realizado com sucesso!");
    }

    public void encerrarEmprestimo(int id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId() == id) {
                if (!emprestimo.isAtivo()) {
                    System.out.println("Este emprestimo ja foi encerrado.");
                    return;
                }

                emprestimo.encerrarEmprestimo();
                System.out.println("Emprestimo encerrado com sucesso!");
                return;
            }
        }

        System.out.println("Emprestimo nao encontrado.");
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo cadastrado.");
            return;
        }

        for (Emprestimo emprestimo : emprestimos) {
            emprestimo.exibirInformacao();
            System.out.println("--------------------");
        }
    }
}
