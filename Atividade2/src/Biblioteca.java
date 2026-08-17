/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */

import java.util.ArrayList;
public class Biblioteca {
    
    private ArrayList<Livro> livros;
    
    public Biblioteca (){
        livros = new ArrayList();
    }
    
    public void adicionarLivros( Livro livro){
        livros.add(livro);
    }
    
    public void listarLivros(){
        for (Livro livro: livros){
            livro.descricao();
        }
    }
    
    public Livro buscarLivroPorTitulo(String titulo){
        for (Livro livro: livros){
            if ( livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }
        }
        
        return null;
    }
}
