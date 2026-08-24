// Classe responsável pelos livros da biblioteca

public class Livro {

    private String titulo;
    private String autor;
    private boolean disponivel = true;

    // Construtor
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Marca o livro como emprestado
    public void emprestar() {
        disponivel = false;
    }

    // Marca o livro como disponível novamente
    public void devolver() {
        disponivel = true;
    }

    // Exibe as informações do livro
    @Override
    public String toString() {
        return titulo + " - " + autor + " (" +
                (disponivel ? "Disponível" : "Emprestado") + ")";
    }
}