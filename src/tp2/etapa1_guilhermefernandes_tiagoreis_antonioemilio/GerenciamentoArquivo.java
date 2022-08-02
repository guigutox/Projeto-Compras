/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.etapa1_guilhermefernandes_tiagoreis_antonioemilio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author guilh
 */
public class GerenciamentoArquivo {
    
    public void escrita(String nomeArq, List<Compra> compras){
           try{
               FileWriter arq = new FileWriter (nomeArq);
               PrintWriter out = new PrintWriter(arq);
               for(int i = 0; i < compras.size(); i++){
                   String linha = compras.get(i).getCli().getCpf() +":"+compras.get(i).getProd().getId();
                   out.println(linha);
               }
               out.close();
               
           }catch(IOException e){
               System.out.println("ERRO na escrita dos dados txt!");
           }
}
    
   public void leitura(String nomeArq){
       try{
           FileReader reader = new FileReader(nomeArq);
            BufferedReader br = new BufferedReader(reader);
            String linha;
            String[] campos = null;
            
            while((linha = br.readLine()) != null){
                campos = linha.split(":");
                String cpf = campos[0];
                Long id = Long.parseLong(campos[1]);
                System.out.println("CPF: "+cpf+"\nID: "+id+"\n -------");
            }
            br.close();
       }catch(IOException e){
           System.out.println("Erro leitura dos dados txt");
       }
       
       
       
   }
    
    
}
