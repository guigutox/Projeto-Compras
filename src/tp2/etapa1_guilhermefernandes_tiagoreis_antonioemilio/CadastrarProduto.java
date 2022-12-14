/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tp2.etapa1_guilhermefernandes_tiagoreis_antonioemilio;

import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class CadastrarProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarProduto
     */
    public CadastrarProduto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_preco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        btn_cadastrarProduto = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Digite a ID do produto: ");

        jLabel2.setText("Digite o nome do produto: ");

        jLabel3.setText("Digite o preco: ");

        jLabel4.setText("Digite a quantidade:");

        btn_cadastrarProduto.setText("Cadastrar");
        btn_cadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_id, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_quantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addComponent(txt_preco, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_nome, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cadastrarProduto)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarProdutoActionPerformed

        long id;
        float preco;
        int quantidade;
        try{
            id =  Long.parseLong(txt_id.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ID invalido inserido!");
            return;
        }
        try{
           preco = Float.parseFloat(txt_preco.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Preco invalido inserido!");
            return;
        }
        try{
            quantidade = Integer.parseInt(txt_quantidade.getText());
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Quantidade invalido inserido!");
            return;
        }
        String nome = txt_nome.getText();
        
        if(nome.equals("") || preco <= 0 || id <= 0 || quantidade <= 0){
             JOptionPane.showMessageDialog(null, "Dado invalido inserido!");
             return;
        }
            
        
        Servico.getInstancia().cadastrarProduto(id, nome , preco, quantidade);
        Servico.getInstancia().escreveProduto("DadosProdutos.ser");
        
       
    }//GEN-LAST:event_btn_cadastrarProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_preco;
    private javax.swing.JTextField txt_quantidade;
    // End of variables declaration//GEN-END:variables
}
