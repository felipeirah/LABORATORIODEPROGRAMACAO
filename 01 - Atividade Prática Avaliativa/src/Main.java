import java.util.Scanner;

// Classe principal do programa

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Cria a biblioteca
        Biblioteca biblioteca = new Biblioteca();

        int opcao;

        do {

            // Menu principal
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Cadastrar Membro");
            System.out.println("4 - Listar Membros");
            System.out.println("5 - Realizar Empréstimo");
            System.out.println("6 - Devolver Livro");
            System.out.println("7 - Listar Empréstimos");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){

                case 1:

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    biblioteca.adicionarLivro(new Livro(titulo, autor));

                    break;

                case 2:

                    biblioteca.listarLivros();

                    break;

                case 3:

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    biblioteca.adicionarMembro(
                        new Membro(nome, cpf, matricula)
                    );

                    break;

                case 4:

                    biblioteca.listarMembros();

                    break;

                case 5:

                    biblioteca.listarLivros();

                    System.out.print("Escolha o livro: ");
                    int livro = sc.nextInt();

                    biblioteca.listarMembros();

                    System.out.print("Escolha o membro: ");
                    int membro = sc.nextInt();

                    biblioteca.realizarEmprestimo(livro, membro);

                    break;

                case 6:

                    biblioteca.listarEmprestimos();

                    System.out.print("Índice: ");
                    int indice = sc.nextInt();

                    biblioteca.devolver(indice);

                    break;

                case 7:

                    biblioteca.listarEmprestimos();

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");

            }

        } while(opcao != 0);

        sc.close();

    }

}