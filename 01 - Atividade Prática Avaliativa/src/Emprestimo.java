import java.time.LocalDate;

// Classe responsável por registrar empréstimos

public class Emprestimo {

    private Livro livro;
    private Membro membro;
    private LocalDate data;
    private boolean ativo = true;

    public Emprestimo(Livro livro, Membro membro) {

        this.livro = livro;
        this.membro = membro;

        // Guarda a data atual
        data = LocalDate.now();

        // Altera o status do livro
        livro.emprestar();
    }

    public boolean isAtivo() {
        return ativo;
    }

    // Finaliza o empréstimo
    public void encerrar() {
        ativo = false;
        livro.devolver();
    }

    @Override
    public String toString() {
        return livro.getTitulo() + " | " +
                membro.getNome() + " | " +
                data + " | " +
                (ativo ? "Ativo" : "Finalizado");
    }
}