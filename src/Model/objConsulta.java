
package Model;

import java.util.Date;




public class objConsulta {
    int codigo;
    String cpfpaciente;
    objMedico medico;
    Date dataconsulta;
    String hora;
    objPaciente paciente;
    
    

    public objConsulta() {
    }
    
    
    

    public objConsulta(int codigo, String cpfpaciente, objMedico medico, Date dataconsulta, String hora) {
        this.codigo = codigo;
        this.cpfpaciente = cpfpaciente;
        this.medico = medico;
        this.dataconsulta = dataconsulta;
        this.hora = hora;
    }

    public objPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(objPaciente paciente) {
        this.paciente = paciente;
    }
    
    
    
   
       
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpfpaciente() {
        return cpfpaciente;
    }

    public void setCpfpaciente(String cpfpaciente) {
        this.cpfpaciente = cpfpaciente;
    }

    public objMedico getMedico() {
        return medico;
    }

    public void setMedico(objMedico medico) {
        this.medico = medico;
    }

    public Date getDataconsulta() {
        return dataconsulta;
    }

    public void setDataconsulta(Date dataconsulta) {
        this.dataconsulta = dataconsulta;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
  @Override
    public String toString() {
        return cpfpaciente; //To change body of generated methods, choose Tools | Templates.
    }
    }
    
    
    
    
    
    

