package Telas;

import DAO.ConsultaDAO;
import DAO.medicoDAO;
import DAO.pacienteDAO;
import Model.objConsulta;
import Model.objMedico;
import Model.objPaciente;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class FrmAgendamentoDeConsulta extends javax.swing.JInternalFrame {
    private boolean novo;
    private objConsulta consulta;
private List<objConsulta> listaDeConsultas;
private ListConsultas telaListConsultas;
private List<objMedico> listaDeMedicos; 

    public FrmAgendamentoDeConsulta() {
        initComponents();
        carregarMedicos();
        carregarTabela();
        consulta= new objConsulta();
        novo = true;
        lblCodigo.setText("");
    }
     public FrmAgendamentoDeConsulta(int codigo, ListConsultas telaListConsultas) {
        initComponents();
        carregarMedicos();
        carregarTabela();
        novo = false;
        consulta = ConsultaDAO.getConsultaByCodigo(codigo);
        carregarFormulario();
        this.telaListConsultas = telaListConsultas;
    }
    
     private void carregarFormulario(){   
       
        txtData.setText(String.valueOf(consulta.getDataconsulta()));
        cmbHora.setSelectedItem(consulta.getHora());
        cmbMedico.setSelectedItem( consulta.getMedico() );
       
        codigo.setText(String.valueOf(consulta.getCodigo()));
       
       
        //começa em 1 pq a posição 0 é o selecione
        for (int i = 1; i < listaDeMedicos.size(); i++) {
            objMedico med = listaDeMedicos.get(i);
            if(med.getCodigo() == consulta.getMedico().getCodigo()){
                cmbMedico.setSelectedIndex(i);
            }
        }
  }
    
        
        
                                             

     public void carregarMedicos(){
        
        listaDeMedicos = medicoDAO.getMedicos();
         objMedico fake = new objMedico(0, "Selecione...", "");
        listaDeMedicos.add(0, fake);
        
         DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for(objMedico med:listaDeMedicos){
            modelo.addElement(med);
        }
        cmbMedico.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbMedico = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        codigo = new javax.swing.JLabel();
        btnLimpar2 = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agendamento de Consulta");

        jLabel2.setText("Médico:");

        cmbMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedicoActionPerformed(evt);
            }
        });

        jLabel3.setText("Data:");

        jLabel4.setText("Hora:");

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setToolTipText("");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Agenda.png"))); // NOI18N

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
        jScrollPane2.setViewportView(tablePacientes);

        codigo.setText("Código:");

        btnLimpar2.setText("Limpar");
        btnLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar2)
                        .addGap(87, 87, 87)
                        .addComponent(btnCancelar)
                        .addGap(127, 127, 127))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtData))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(codigo)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo)
                    .addComponent(lblCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnLimpar2))
                        .addGap(41, 41, 41))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedicoActionPerformed

    
    }//GEN-LAST:event_cmbMedicoActionPerformed

    public void carregarTabela(){
         DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = { "Código" , "Nome" , "CPF"};
        
        modelo.setColumnIdentifiers(colunas);
         List<objPaciente> lista = pacienteDAO.getPacientes();
      
        for(objPaciente pac : lista){
            Object[] obj = { pac.getCodigo(), pac.getNome(), pac.getCpf()};
            modelo.addRow(obj);    
        }
        tablePacientes.setModel(modelo);
    }
    
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmAgendamentoDeConsulta.this.setVisible(false);
    
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void limparCadastro() {
        //txtPaciente.setText("");
        txtData.setText("");
        cmbMedico.setSelectedIndex(0);
        cmbHora.setSelectedIndex(0);
        tablePacientes.setSelectionMode(0);
    

    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            int linha = tablePacientes.getSelectedRow();
            if(linha> -1){
                String cpfPaciente = (String) tablePacientes.getValueAt(linha, 2);
           // }
            
            
            //String paciente = txtPaciente.getText();

            //if (!paciente.isEmpty()) {

                objConsulta consulta = new objConsulta();
//objPaciente pac = new objPaciente();
                consulta.setCpfpaciente(cpfPaciente);

                String data = txtData.getText();
                String sdia = data.substring(0, 2);
                String smes = data.substring(3, 5);
                String sano = data.substring(6, 10);
                int dia = Integer.valueOf(sdia);
                int mes = Integer.valueOf(smes);
                int ano = Integer.valueOf(sano);
                
                Date dataconsulta = new Date(ano, (mes - 1), dia);
                
                consulta.setDataconsulta(dataconsulta);
                consulta.setHora((String) cmbHora.getSelectedItem());
                consulta.setMedico((objMedico) cmbMedico.getSelectedItem());
                if(novo){
                    
                ConsultaDAO.inserir(consulta);
                limparCadastro();
                }else{
                     consulta.setCodigo( Integer.valueOf(codigo.getText()) );
                    ConsultaDAO.editar(consulta);
           telaListConsultas.carregarTabela();
                } 
                limparCadastro();
                
                if(!novo){
                this.dispose();
                }

                limparCadastro();
            }
        } catch (Exception ex) {

            Logger.getLogger(FrmAgendamentoDeConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar2ActionPerformed
        limparCadastro();
    }//GEN-LAST:event_btnLimpar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar2;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbMedico;
    private javax.swing.JLabel codigo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JTable tablePacientes;
    private javax.swing.JFormattedTextField txtData;
    // End of variables declaration//GEN-END:variables
}
