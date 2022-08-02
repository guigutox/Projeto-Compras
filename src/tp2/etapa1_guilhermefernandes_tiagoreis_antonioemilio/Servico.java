package tp2.etapa1_guilhermefernandes_tiagoreis_antonioemilio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */


public class Servico {
    
    private static Servico instancia = new Servico();
    private static Random random = new Random();
    
    
    List<Produto> produtos = new ArrayList();
    List<Cliente> clientes = new ArrayList();
    List<Compra> compras = new ArrayList();
    
    public static Servico getInstancia(){
        return instancia;
    }
    
    public void cadastrarProduto( long id, String nome, double preco,long quantidade)throws ExcpetionUnicidade{
        Produto p = findByIdProduto(id);
        if(p == null){
           
            produtos.add(new Produto(id,nome,preco,quantidade));
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            return;
        }throw new ExcpetionUnicidade("Invalido, pois ja foi cadastrado");
       
  
       
    }
    
    public void cadastrarCliente(String nome, String cpf, int idade)throws ExcpetionUnicidade{
        long id = random.nextInt(10000);
        
        Cliente c = findByCpfCliente(cpf);
        
        if(c == null){
            clientes.add(new Cliente(nome,id,cpf, idade));
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            return;
        }
        throw new ExcpetionUnicidade("Invalido, pois ja foi cadastrado");

    }
    
    
    public Produto findByIdProduto(long id){
        Produto foundProduct[] = new Produto[1];
        
        
        produtos.forEach(produto->{
            if(produto.getId() == id){
              foundProduct[0] = produto;
        }
        
        });
        
        if(foundProduct[0] != null){
            return foundProduct[0];
        }
        
        return null;
    }
   
    public Cliente findByCpfCliente(String cpf){
         Cliente c[] = new Cliente[1];
 
         
        for(Cliente cli : clientes){
            if(cli.getCpf().equals(cpf)){
               c[0] = cli;
               
            } 
        }
         if(c[0] != null){
            return c[0];
             
         }
         return null;
    }

    
    public boolean alterarProduto(long id, String nome, double preco, long quantidade){
        
       Produto p = findByIdProduto(id);
        
       if(p!=null){
           if(nome != null){
               p.setNome(nome);
           }
           if(preco > 0){
               p.setPreco(preco);
           }
           if(quantidade > 0){
              p.setQuantidade(quantidade); 
           }
           return true;
           
       }
       return false;
    }
    
    public boolean alterarCliente(String cpf, String nome, int idade){
        Cliente c = findByCpfCliente(cpf);
        
        if(c != null){
            if(!nome.equals("")){
                c.setNome(nome);
            }
            if(idade != 0){
                c.setIdade(idade);
            }
            return true;
        }  
      return false;  
    }
    
    public boolean deletarProduto(long id){
        Produto p = findByIdProduto(id);
        
        if(p != null){
            produtos.remove(p);
            return true;
        }
        return false;
    }
    
    public boolean deletarCliente(String cpf){
        Cliente c = findByCpfCliente(cpf);
        
        if(c != null){
            clientes.remove(c);
            return true;
        }
        
        return false;
    }
    
    public boolean comprar(String cpf, long id){
        Cliente c = findByCpfCliente(cpf);
        Produto p = findByIdProduto(id);
        
        if(c !=null && p != null){
            if(p.getQuantidade()>0){
                compras.add(new Compra(c,p));
                p.setQuantidade(p.getQuantidade()-1);
                return true;
            }
        }
        return false;
    }
    
    public String toStringCliente(Cliente cli){
        
        return"Resultado: \nNome: "+cli.getNome()+"\nID: "+cli.getId()+"\nIdade: "+cli.getIdade();
        
    }
    
    public String toStringProduto(Produto prod){
        
        return"Resultado: \nNome :"+prod.getNome()+"\nPreco: "+prod.getPreco()+"\nQuantidade: "+prod.getQuantidade();
        
}
    
    public boolean excluiCliente(String cpf){

        
        for(int i = 0; i < clientes.size(); i++){
            
            if(clientes.get(i).getCpf().equals(cpf)){
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    
    public boolean excluiProduto(long id){
        
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i).getId() == id){
                produtos.remove(i);
                return true;
            }
            
        }
        return false;
        
    }
    

    public void showAllProduto(){
       produtos.forEach(produto->{
           System.out.println(""+produto.getNome());
       });
    }
    
    public void showAllCliente(){
       clientes.forEach(cliente->{
           System.out.println(""+cliente.getNome());
       });
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public void showAllCompras(){
        
        compras.forEach(compras->{
            System.out.println("Compra: ");
            
            clientes.forEach(clientes->{
                 
                if(clientes.getCpf().equals(compras.getCli().getCpf())){
                   
                    System.out.println("User: "+compras.getCli().getCpf());
                    System.out.println("Produto: "+compras.getProd().getId());
                    System.out.println("|||||||||||||||||||");
                    
                }
                
            });
            //System.out.println("Compra: ");
            //System.out.println("User: "+compras.getCpfCliente());
            //System.out.println("Compra: "+compras.getIdProduto());
            //System.out.println("|||||||||||||||||||");
        });
    }
    
    public void escreverCliente(String nomeArquivo){
     
       try{
           FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
           ObjectOutputStream servico = new ObjectOutputStream(arquivo);
           servico.writeObject(clientes);
           servico.close();
       }catch(IOException e){
           System.out.println("ERRO: "+e);
       }
        
        
    }
    
    public void lerCliente(String nomeArquivo){
     
        try{
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream servico = new ObjectInputStream(arquivo);
            clientes = (List<Cliente>) servico.readObject();
            System.out.println("Relatorio:");
            for (Cliente cliente : clientes) {
                System.out.println(""+cliente.getCpf());
            }
            
        }catch(IOException e){
            System.out.println("ERRO NA LEITURA DO ARQUIVO BINARIO" +e);
        }catch(ClassNotFoundException e){
            System.out.println("CLASSE NAO ENCONTRADA! "+e);
        } 
    }
    
    public void escreveProduto(String nomeArquivo){
      try{
           FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
           ObjectOutputStream servico = new ObjectOutputStream(arquivo);
           servico.writeObject(produtos);
           servico.close();
       }catch(IOException e){
           System.out.println("ERRO: "+e);
       }
        
    }
    
    public void lerProduto(String nomeArquivo){
        try{
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream servico = new ObjectInputStream(arquivo);
            produtos = (List<Produto>) servico.readObject();
            System.out.println("Relatorio:");
            for (Produto produto : produtos) {
                System.out.println(""+produto.getId());
            }
            
        }catch(IOException e){
            System.out.println("ERRO NA LEITURA DO ARQUIVO BINARIO" +e);
        }catch(ClassNotFoundException e){
            System.out.println("CLASSE NAO ENCONTRADA! "+e);
        } 
        
        
        
    }
    
       public void escreveCompra(String nomeArquivo){
      try{
           FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
           ObjectOutputStream servico = new ObjectOutputStream(arquivo);
           servico.writeObject(compras);
           servico.close();
       }catch(IOException e){
           System.out.println("ERRO: "+e);
       }
        
    }
       
        public void lerCompra(String nomeArquivo){
        try{
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream servico = new ObjectInputStream(arquivo);
            compras= (List<Compra>) servico.readObject();
            System.out.println("Relatorio:");
            for (Compra compra : compras) {
                System.out.println(""+compra.getCli());
            }
            
        }catch(IOException e){
            System.out.println("ERRO NA LEITURA DO ARQUIVO BINARIO" +e);
        }catch(ClassNotFoundException e){
            System.out.println("CLASSE NAO ENCONTRADA! "+e);
        } 
        
        
        
    }
    
    
    
    
    
    
    
    
    
}
