/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        LivroFisico livro1 = new LivroFisico(
                "Harry Potter",
                "J.K. Rowling",
                300,
                0.8
        );

        Ebook livro2 = new Ebook(
                "O Hobbit",
                "J.R.R. Tolkien",
                250,
                5.5
        );

        biblioteca.adicionarLivros(livro1);
        biblioteca.adicionarLivros(livro2);

        System.out.println("=== LIVROS DA BIBLIOTECA ===");

        biblioteca.listarLivros();

        System.out.println("\n=== BUSCA POR TÍTULO ===");

        Livro encontrado = biblioteca.buscarLivroPorTitulo("Harry Potter");

        if (encontrado != null) {
            encontrado.descricao();
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}