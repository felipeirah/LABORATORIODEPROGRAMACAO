
public class Livro {

    private String titulo;
    private String autor;
    private boolean disponivel = true;
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
    public void emprestar() {
        disponivel = false;
    }
    public void devolver() {
        disponivel = true;
    }
    @Override
    public String toString() {
        return titulo + " - " + autor + " (" +
                (disponivel ? "Disponível" : "Emprestado") + ")";
    }
}