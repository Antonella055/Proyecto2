/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Antonella
 */
public class CronometroInter extends javax.swing.JFrame {
   public String tiempoUsuario;
   private final Timer tiempo;
   private int miliseg=0;
   private int segundos=0;
   private int minutos=0;
   private int horas=0;
   
   
    private ActionListener acciones= new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
           miliseg ++;
           
           if (miliseg ==100){
               segundos++;
               miliseg=0;
               
           }if(segundos==60){
               minutos++;
               segundos=0;
               
           }if(minutos==60){
               horas++;
               minutos=0;
               
           }if(horas==24){
               horas=0;
           }
           actualizarEtiqueta();
        }
                
                
                };
   
    public void StartReloj(){
        tiempo.start();
    }
    public void StopReloj(){
        tiempo.stop();
        tiempoUsuario = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, miliseg);
    }
    
    
   
   private void actualizarEtiqueta(){
       String texto= (horas<=9?"0":"")+horas+":"+(minutos<=9?"0":"")+minutos+":"+(segundos<=9?"0":"")+segundos+":"+(miliseg <=9?"0":"")+miliseg;
       etiquetatiempo.setText(texto);
   }
   
   
   
        public CronometroInter() {
        initComponents();
        tiempo= new Timer(10,acciones);
    }
       
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Fondo = new Fondo();
        jLabel2 = new javax.swing.JLabel();
        etiquetatiempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cronometro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 67, -1, 27));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reloj.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        etiquetatiempo.setBackground(new java.awt.Color(102, 0, 102));
        etiquetatiempo.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        etiquetatiempo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetatiempo.setText("00:00:00:00");
        etiquetatiempo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        etiquetatiempo.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                etiquetatiempoComponentAdded(evt);
            }
        });
        etiquetatiempo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                etiquetatiempoPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(etiquetatiempo)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(etiquetatiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etiquetatiempoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_etiquetatiempoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_etiquetatiempoPropertyChange

    private void etiquetatiempoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_etiquetatiempoComponentAdded

    }//GEN-LAST:event_etiquetatiempoComponentAdded

    
    
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
            java.util.logging.Logger.getLogger(CronometroInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CronometroInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CronometroInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CronometroInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel etiquetatiempo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
class Fondo extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/imagenes/fondocron.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    
                    super.paint(g);
        }
    }

}
