/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import DAO.ConsultaDAO;
import Model.objConsulta;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 181710106
 */
public class ListConsultas extends javax.swing.JInternalFrame {

    private final JDesktopPane painelTelaInicial;

    /**
     * Creates new form ListConsultas
     */
    public ListConsultas(JDesktopPane painelTelaInicial) {
        initComponents();
        this.painelTelaInicial = painelTelaInicial;
        carregarTabela();
        
    }
    
public void carregarTabela(){
    
    
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = { "Código" , "Paciente" , "Medico", "Data", "Hora"};
        
        modelo.setColumnIdentifiers(colunas);
         List<objConsulta> lista = ConsultaDAO.getConsultas();
        
        for(objConsulta con : lista){
            Object[] obj = {con.getCodigo(), con.getPaciente().getNome(), con.getMedico().getNome(),
            con.getDataconsulta(), con.getHora()};
            modelo.addRow(obj);
            
        }
        tableConsultas.setModel(modelo);
   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableConsultas = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de consultas");

        tableConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableConsultas);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnExcluir)
                .addGap(28, 28, 28)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    ListConsultas.this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         int linha = tableConsultas.getSelectedRow();
        if(linha == -1){
            JOptionPane.showMessageDialog(this, "Você deve selecionar uma consulta!");
            
        }else{
            objConsulta con = new objConsulta();
            int codigo = (int) tableConsultas.getModel().getValueAt(linha, 0);
            con.setCodigo(codigo);
            ConsultaDAO.excluir(con);
            carregarTabela();
        }
    
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableConsultas;
    // End of variables declaration//GEN-END:variables
}
