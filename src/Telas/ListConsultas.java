/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import DAO.ConsultaDAO;
import Model.objConsulta;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 181710106
 */
public class ListConsultas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListConsultas
     */
    public ListConsultas() {
        initComponents();
    }
private void carregarTabela(){
         DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = { "Código" , "CPF" , "Data", "Hora", "Medico"};
        
        modelo.setColumnIdentifiers(colunas);
         List<objConsulta> lista = ConsultaDAO.getConsultas();
        
        for(objConsulta con : lista){
            Object[] obj = { con.getCodigo(), con.getCpfpaciente(), con.getDataconsulta(), con.getHora(), con.getMedico() };
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableConsultas;
    // End of variables declaration//GEN-END:variables
}
