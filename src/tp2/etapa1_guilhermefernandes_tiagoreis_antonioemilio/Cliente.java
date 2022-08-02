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
public class Cliente implements Serializable{
    
    private String nome;
    private String cpf;
    private long id;
    private int idade;
    

    public Cliente(String nome, long id, String cpf, int idade) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    
    
}
