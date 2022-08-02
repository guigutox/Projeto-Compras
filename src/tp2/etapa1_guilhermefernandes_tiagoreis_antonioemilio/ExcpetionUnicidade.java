/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.etapa1_guilhermefernandes_tiagoreis_antonioemilio;

import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class ExcpetionUnicidade extends
        RuntimeException {

     ExcpetionUnicidade(String message) {
     super(message);
         JOptionPane.showMessageDialog(null, message);
     
     }

}
