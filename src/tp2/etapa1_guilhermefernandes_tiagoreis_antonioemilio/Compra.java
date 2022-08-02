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
public class Compra implements Serializable{
    
    private Cliente cli;
    private Produto prod;

    public Compra(Cliente cli, Produto prod) {
        this.cli = cli;
        this.prod = prod;
    }

    public Cliente getCli() {
        return cli;
    }

    public Produto getProd() {
        return prod;
    }

   
    
    
}
