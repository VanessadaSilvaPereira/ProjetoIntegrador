
package DAO;

import Model.objConsulta;
import Model.objMedico;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsultaDAO {
    public static void inserir( objConsulta c){

        String sql = "INSERT INTO consultas "
                + " ( cpfpaciente , medico, dataconsulta, hora) VALUES "
                + " ( '" + c.getCpfpaciente() + "' ,"
                + "  " + c.getMedico()       + " , " 
                + "  " + c.getDataconsulta() + " , " 
                + "  " + c.getHora()         + " );";  
        Conexao.executar(sql);   
    }
    
    
    public static List<objConsulta> getConsultas(){
   
    
    List<objConsulta> lista = new ArrayList<>();
    
    
    
    String sql = "SELECT * FROM consultas";
    //inner join
    
        ResultSet rs = Conexao.consultar(sql);
   
    
    if (rs != null){
        try {
            while (rs.next()) {           
                                
                objConsulta con = new objConsulta();
                objMedico med = new objMedico();
                
                con.setCpfpaciente(rs.getString(1));
                con.setMedico(med);
                con.setDataconsulta(rs.getDate(3));
                con.setHora(rs.getTime(4));
                lista.add(con);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    return lista;
    
}

}
