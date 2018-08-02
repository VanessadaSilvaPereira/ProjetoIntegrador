
package Telas;

import DAO.pacienteDAO;
import Model.objPaciente;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ListPacientes extends javax.swing.JInternalFrame {

    
    public ListPacientes() {
        initComponents();
        carregarTabela();
    }
    
     private void carregarTabela(){
         DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = { "Código" , "Nome" , "E-mail", "Telefone", "Nascimento",
        "Endereço", "Bairro", "Cidade", "CEP", "Estado Civil" ,"CPF","RG","Convênio", "Médico"};
        
        modelo.setColumnIdentifiers(colunas);
         List<objPaciente> lista = pacienteDAO.getPacientes();
        
        for(objPaciente pac : lista){
            Object[] obj = { pac.getCpf(), pac.getNome() };
            modelo.addRow(obj);
            
        }
        tablePacientes.setModel(modelo);
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
        tablePacientes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Pacientes");

        tablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablePacientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePacientes;
    // End of variables declaration//GEN-END:variables
}
