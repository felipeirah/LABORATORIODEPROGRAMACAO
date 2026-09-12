import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Membro membro;
    private LocalDate data;
    private boolean ativo = true;

    public Emprestimo(Livro livro, Membro membro) {

        this.livro = livro;
        this.membro = membro;
        data = LocalDate.now();
        livro.emprestar();
    }

    public boolean isAtivo() {
        return ativo;
    }
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