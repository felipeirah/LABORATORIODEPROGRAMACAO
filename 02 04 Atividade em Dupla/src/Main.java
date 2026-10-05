/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Felipe Junior e Jhonathan Freitas
 */

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));

        Biblioteca biblioteca = new Biblioteca();

        // Criação e inclusão dos livros.
        Livro livro1 = new Livro(1, "Dom Casmurro", "Machado de Assis", "123456");
        Livro livro2 = new Livro(2, "O Pequeno Principe", "Antoine de Saint-Exupery", "654321");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        System.out.println("\nLIVROS CADASTRADOS");
        biblioteca.listarLivros();

        // Edição de um livro.
        biblioteca.editarLivro(
                2,
                "O Pequeno Principe - Edicao Especial",
                "Antoine de Saint-Exupery",
                "654321-ED"
        );

        System.out.println("\nLIVROS APOS EDICAO");
        biblioteca.listarLivros();

        // Criação e cadastro dos membros.
        Membro membro1 = new Membro(1, "Joao", "joao@email.com", "11999999999");
        Membro membro2 = new Membro(2, "Maria", "maria@email.com", "11888888888");

        biblioteca.cadastrarMembro(membro1);
        biblioteca.cadastrarMembro(membro2);

        System.out.println("\nMEMBROS CADASTRADOS");
        biblioteca.listarMembros();

        // Edição de um membro.
        biblioteca.editarMembro(2, "Maria Silva", "maria.silva@email.com", "11777777777");

        System.out.println("\nMEMBROS APOS EDICAO");
        biblioteca.listarMembros();

        // Herança e do polimorfismo.
        Usuario funcionario = new Funcionario(
                3,
                "Carlos",
                "carlos@biblioteca.com",
                "Bibliotecario"
        );

        System.out.println("\nFUNCIONARIO");
        funcionario.exibirInformacao();

        // Realização do empréstimo.
        biblioteca.realizarEmprestimo(1, 1, 1);

        System.out.println("\nEMPRESTIMOS");
        biblioteca.listarEmprestimos();

        // Tentativa de emprestar um livro indisponível.
        try {
            biblioteca.realizarEmprestimo(2, 1, 2);
        } catch (IllegalStateException e) {
            System.out.println("\nERRO TRATADO: " + e.getMessage());
        }

        System.out.println("\nLIVROS APOS EMPRESTIMO");
        biblioteca.listarLivros();

        // Encerramento do empréstimo e devolução do livro.
        biblioteca.encerrarEmprestimo(1);

        System.out.println("\nEMPRESTIMOS APOS DEVOLUCAO");
        biblioteca.listarEmprestimos();

        System.out.println("\nLIVROS APOS DEVOLUCAO");
        biblioteca.listarLivros();

        // Remoção de um livro.
        biblioteca.removerLivro(2);

        System.out.println("\nLIVROS APOS REMOCAO");
        biblioteca.listarLivros();
    }
}
