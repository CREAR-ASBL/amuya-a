
package ñ;

import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUI_Visualize extends javax.swing.JFrame {
    private javax.swing.JScrollPane scrollPane;
    private final javax.swing.JPanel tabulatorPanel;
    
    public GUI_Visualize(JPanel tabulatorPanel) {
        // The received panel should be of fixed size
        this.tabulatorPanel=tabulatorPanel;
        initComponents();
        setIcon();
    }
            
    private void initComponents() {
        this.setTitle("Visualización de la Tabla de deducciones");
        scrollPane = new JScrollPane(tabulatorPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(35);
        
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

//        this.setContentPane(scrollPane);
        this.add(scrollPane);
//         was this.add(scrollPane);
        this.setSize(900, 600); 
    }                     

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Visualize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUI_Visualize().setVisible(true);
//            }
//        });
    }
             private void setIcon() {

        // from https://www.youtube.com/watch?v=40ikcEonWng
        setIconImage(Toolkit.getDefaultToolkit().
                getImage(getClass().getResource("/ñ/resources/icon_64.png")));
    }     
}
