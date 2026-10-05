/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Felipe Junior e Jhonathan Freitas
 */

// Representa um membro cadastrado na biblioteca.
public class Membro extends Usuario {
    private String telefone;
    private String matricula;

    public Membro(int id, String nome, String email, String telefone) {
        super(id, nome, email);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    

    @Override
    public void exibirInformacao() {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + telefone);
    }
}
