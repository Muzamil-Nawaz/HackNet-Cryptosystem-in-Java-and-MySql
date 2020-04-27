/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isproject;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author ADMIN
 */
public class SymmetricDecryption extends javax.swing.JFrame {
    String secretKey="";
    public SymmetricDecryption() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(1000,545);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        key = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        etext = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ptext = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setPreferredSize(new java.awt.Dimension(1000, 580));
        getContentPane().setLayout(null);

        key.setFont(new java.awt.Font("Ebrima", 1, 11)); // NOI18N
        key.setBorder(null);
        getContentPane().add(key);
        key.setBounds(95, 131, 809, 23);

        etext.setBackground(new java.awt.Color(199, 208, 216));
        etext.setColumns(20);
        etext.setFont(new java.awt.Font("Ebrima", 0, 13)); // NOI18N
        etext.setForeground(new java.awt.Color(255, 0, 0));
        etext.setRows(5);
        jScrollPane1.setViewportView(etext);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 200, 370, 190);

        ptext.setBackground(new java.awt.Color(199, 208, 216));
        ptext.setColumns(20);
        ptext.setFont(new java.awt.Font("Ebrima", 0, 13)); // NOI18N
        ptext.setRows(5);
        jScrollPane2.setViewportView(ptext);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(540, 200, 370, 190);

        jButton1.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jButton1.setText("Decrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(329, 427, 152, 38);

        jButton2.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jButton2.setText("Dashboard");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(520, 427, 152, 38);

        jLabel4.setIcon(new javax.swing.ImageIcon("G:\\Netbeans Project\\IsProject\\src\\isproject\\Symmetric Encryption.png")); // NOI18N
        jLabel4.setMinimumSize(new java.awt.Dimension(1000, 540));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, -60, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        secretKey = key.getText(); // TODO add your handling code here:
        String cypher = etext.getText();
        String decryptedString = Methods.decrypt(cypher, secretKey) ;
        ptext.setText(decryptedString);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Dashboard().setVisible(true);
        this.setVisible(false);
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SymmetricDecryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SymmetricDecryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SymmetricDecryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SymmetricDecryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SymmetricDecryption().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea etext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField key;
    private javax.swing.JTextArea ptext;
    // End of variables declaration//GEN-END:variables
}