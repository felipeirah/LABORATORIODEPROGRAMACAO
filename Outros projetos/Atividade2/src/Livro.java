/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public abstract class Livro {
    
    private String titulo;
    private String autor;
    private int numeroPaginas;
    
    public Livro(String titulo, String autor, int numeroPaginas){
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo= titulo;
    }
    
    public String getautor(){
        return autor;
    }
    
    public void setautor(String autor){
        this.autor= autor;
    }
    
    public int getnumeroPaginas(){
        return numeroPaginas;
    }
    
    public void setnumeroPaginas(int numeroPaginas){
        this.numeroPaginas= numeroPaginas;
    }
    
    public abstract void descricao ();
}
