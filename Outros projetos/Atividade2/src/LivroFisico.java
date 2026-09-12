/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class LivroFisico extends Livro {
    private double peso;
    
    public LivroFisico(String titulo, String autor, int numeroPaginas, double peso){
        super(titulo, autor,numeroPaginas);
        this.peso = peso;
    }
    
    public double getPeso(){
        return peso;
    }
    
    public void setPeso(double peso){
        this.peso = peso;
    }
    
    @Override
    public void descricao(){
        System.out.println("Livro Físico: " + getTitulo()
                + " | Autor: " + getautor( )
                + " | Paginas:" + getnumeroPaginas( )
                + " | Peso:" + peso + "kg");
    }
}
