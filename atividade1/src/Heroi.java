/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Heroi {

    private String nome;
    private int vida;
    private int energia;

    public void apresentar() {
        System.out.println("Sou um Heroi");
        System.out.println("Sou um Heroi, e me chamo: " + nome);
        System.out.println("Tenho um nivel de energia de: " + energia);
    }

    public void atacar() {
        System.out.println("O Heroi atacou");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
}