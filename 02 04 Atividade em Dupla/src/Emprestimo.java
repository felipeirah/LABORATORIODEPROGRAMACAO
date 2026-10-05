/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Felipe Junior e Jhonathan Freitas
 */
import java.time.LocalDate;

// Relaciona um livro a um membro e controla a devolução.
public class Emprestimo {
    private int id;
    private Livro livro;
    private Membro membro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(int id, Livro livro, Membro membro) {
        this.id = id;
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
        this.ativo = true;

        livro.setDisponivel(false);
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public Membro getMembro() {
        return membro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void encerrarEmprestimo() {
        dataDevolucao = LocalDate.now();
        ativo = false;
        livro.setDisponivel(true);
    }

    public void exibirInformacao() {
        System.out.println("ID do emprestimo: " + id);
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Membro: " + membro.getNome());
        System.out.println("Data do emprestimo: " + dataEmprestimo);
        System.out.println("Status: " + (ativo ? "Ativo" : "Encerrado"));

        if (dataDevolucao != null) {
            System.out.println("Data da devolucao: " + dataDevolucao);
        }
    }
}
