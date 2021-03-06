
package Telas;

import DAO.pacienteDAO;
import Model.objPaciente;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListPacientes extends javax.swing.JInternalFrame {
    
    private JDesktopPane painelTelaInicial;
    
    
    
    public ListPacientes(JDesktopPane painelTelaInicial) {
        initComponents();
        this.painelTelaInicial = painelTelaInicial;
        carregarTabela();
        
    }
    
     public void carregarTabela(){
         DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = { "Código" , "Nome" , "E-mail", "Telefone", "Nascimento",
        "Endereço", "Bairro", "Cidade", "CEP", "Estado Civil" ,"CPF","RG","Convênio", "Médico"};
        
        modelo.setColumnIdentifiers(colunas);
         List<objPaciente> lista = pacienteDAO.getPacientes();
      
        for(objPaciente pac : lista){
            Object[] obj = { pac.getCodigo(), pac.getNome(), pac.getEmail(), pac.getTelefone(),
            pac.getNascimento(), pac.getEndereco(), pac.getBairro(), pac.getCidade(), pac.getCep(),
            pac.getEstadoCivil(), pac.getCpf(), pac.getRg(), pac.getConvenio(), pac.getMedico().getNome()};
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
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

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

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addGap(49, 49, 49)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ListPacientes.this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tablePacientes.getSelectedRow();
        if(linha == -1){
            JOptionPane.showMessageDialog(this, "Você deve selecionar um paciente!");
            
        }else{
            objPaciente pac = new objPaciente();
            int codigo = (int) tablePacientes.getModel().getValueAt(linha, 0);
            pac.setCodigo(codigo);
            pacienteDAO.excluir(pac);
            carregarTabela();
        }
    
    
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed


int linha = tablePacientes.getSelectedRow();
        if(linha == -1){
            JOptionPane.showMessageDialog(this, "Você deve selecionar um paciente!");
        }else{
            int codigo = (int) tablePacientes.getValueAt(linha, 0);
            FrmCadastroPacientes formulario = new FrmCadastroPacientes(codigo, this);
            this.painelTelaInicial.add(formulario);
            formulario.setVisible(true);
            
        }
        
        
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePacientes;
    // End of variables declaration//GEN-END:variables
}
