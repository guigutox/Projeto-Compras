/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.etapa1_guilhermefernandes_tiagoreis_antonioemilio;

import java.io.Serializable;

/**
 *
 * @author guilh
 */
public class Produto implements Serializable{
    
       private String nome;
       private double preco;
       private long id;
       private long quantidade;

public Produto( long id, String nome, double preco, long quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public long getQuantidade() {
        return quantidade;
    }



       
    
    
    
}
