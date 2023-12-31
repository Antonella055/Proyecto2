/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces.GestionDoc;

import Estructuras.ArrayList;
import Estructuras.ModificarArchivo;
import static MonticuloBinario.Monticulo.selectedFile;
import interfaces.Menu;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Antonella
 */
public class RegistroUsr extends javax.swing.JFrame {
        public static  ArrayList<Object> usuarioData;
        public static String UsuarioName;
        public static  ArrayList<Object> ListaDocumentos = new ArrayList<>(new Object[0], 0);
    /**
     * Creates new form RegistroUsr
     */
    public RegistroUsr() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        Fondo = new Fondo();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RegistroUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        continuar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Fondo.setToolTipText("Registro");
        Fondo.setName("Registro"); // NOI18N
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel2.setText("Para ingresar a la gestion de documentos, por favor indique su ");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel4.setText("nombre de usuario");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        RegistroUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroUserActionPerformed(evt);
            }
        });
        Fondo.add(RegistroUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 271, -1));

        jLabel1.setText("Nombre:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconuser2.0.png"))); // NOI18N
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        Fondo.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        continuar.setBackground(new java.awt.Color(204, 255, 255));
        continuar.setFont(new java.awt.Font("ISOCT_IV50", 1, 12)); // NOI18N
        continuar.setForeground(new java.awt.Color(102, 102, 102));
        continuar.setText("Continuar");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });
        Fondo.add(continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_volverActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        try {
            // TODO add your handling code here:
            
            
            if(!new ModificarArchivo().validador(selectedFile.toString(), RegistroUser.getText())){
                JOptionPane.showMessageDialog(null, "Error el usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
                
            }else{
                
                
                setVisible(false);
                new Documentos().setVisible(true);}
            //    usuarioDocumento.add(RegistroUser.getText());
                UsuarioName = RegistroUser.getText();
                usuarioData = new ArrayList<>(new Object[0], 0);
                usuarioData.add(UsuarioName);
                System.out.println(UsuarioName);
        } catch (IOException ex) {
            Logger.getLogger(RegistroUsr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_continuarActionPerformed

    public String getUsuarioName() {
        return UsuarioName;
    }

    
    
    
    private void RegistroUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistroUserActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroUsr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsr().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JTextField RegistroUser;
    private javax.swing.JButton continuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
class Fondo extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/imagenes/fondo2.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    
                    super.paint(g);
        }
    }


}
