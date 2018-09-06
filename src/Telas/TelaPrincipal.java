/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
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

        jLabel1 = new javax.swing.JLabel();
        jdpTelaInicial = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuCadastrosMedicos = new javax.swing.JMenuItem();
        menuCadastrosPacientes = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuListasPacientes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuAgendamentoConsultas = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Neon-Blue-Abstract-4K-Wallpaper.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jdpTelaInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdpTelaInicial.setMaximumSize(new java.awt.Dimension(1200, 900));
        jdpTelaInicial.setMinimumSize(new java.awt.Dimension(1200, 900));
        getContentPane().add(jdpTelaInicial);
        jdpTelaInicial.setBounds(0, 0, 1510, 970);

        menuCadastros.setText("Cadastros");

        menuCadastrosMedicos.setText("Médicos");
        menuCadastrosMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrosMedicosActionPerformed(evt);
            }
        });
        menuCadastros.add(menuCadastrosMedicos);

        menuCadastrosPacientes.setText("Pacientes");
        menuCadastrosPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrosPacientesActionPerformed(evt);
            }
        });
        menuCadastros.add(menuCadastrosPacientes);

        jMenuBar1.add(menuCadastros);

        jMenu1.setText("Listas");

        menuListasPacientes.setText("Pacientes");
        menuListasPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListasPacientesActionPerformed(evt);
            }
        });
        jMenu1.add(menuListasPacientes);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Agendamento");

        menuAgendamentoConsultas.setText("Consultas");
        menuAgendamentoConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgendamentoConsultasActionPerformed(evt);
            }
        });
        jMenu2.add(menuAgendamentoConsultas);

        jMenuItem1.setText("Lista de Consultas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1525, 1007));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastrosMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrosMedicosActionPerformed
       FrmCadastroMedico frm = new FrmCadastroMedico();
       jdpTelaInicial.add(frm);
       
       frm.setVisible(true);
    }//GEN-LAST:event_menuCadastrosMedicosActionPerformed

    private void menuCadastrosPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrosPacientesActionPerformed
        FrmCadastroPacientes frm = new FrmCadastroPacientes();
        jdpTelaInicial.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_menuCadastrosPacientesActionPerformed

    private void menuListasPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListasPacientesActionPerformed
        ListPacientes list = new ListPacientes(jdpTelaInicial);
        jdpTelaInicial.add(list);
        list.setVisible(true);
    }//GEN-LAST:event_menuListasPacientesActionPerformed

    private void menuAgendamentoConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgendamentoConsultasActionPerformed
      FrmAgendamentoDeConsulta frm = new FrmAgendamentoDeConsulta();
        jdpTelaInicial.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_menuAgendamentoConsultasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         ListConsultas list = new ListConsultas();
        jdpTelaInicial.add(list);
        list.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JDesktopPane jdpTelaInicial;
    private javax.swing.JMenuItem menuAgendamentoConsultas;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuCadastrosMedicos;
    private javax.swing.JMenuItem menuCadastrosPacientes;
    private javax.swing.JMenuItem menuListasPacientes;
    // End of variables declaration//GEN-END:variables
}
