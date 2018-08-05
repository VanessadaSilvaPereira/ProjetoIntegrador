
package Model;

import java.sql.Time;
import java.util.Date;




public class objConsulta {
    int codigo;
    String cpfpaciente;
    objMedico medico;
    Date dataconsulta;
    Time hora;

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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setHora(String hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
