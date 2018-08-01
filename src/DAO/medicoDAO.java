
package DAO;

import Model.objMedico;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




public class medicoDAO {
    
    
 public static void inserir( objMedico med){

        String sql = "INSERT INTO medicos "
                + " ( nome , especialidade) VALUES "
                + "  ( "
                + "  '" + med.getNome()          + "' , " 
                + "  '" + med.getEspecialidade() + "' );";  
        Conexao.executar(sql);   
    }
    
public static void editar( objMedico med){
        String sql = "UPDATE medicos SET "
                + " nome = '" + med.getNome() + "' , " 
                + " especialidade = '" + med.getEspecialidade()+ "' " 
                + " WHERE codigo = " + med.getCodigo();
        
        Conexao.executar(sql); 
    }

public static void excluir( objMedico med){

        String sql = "DELETE FROM medicos "
               + " WHERE codigo = " + med.getCodigo();
        
        Conexao.executar(sql);
    }


public static List<objMedico> getMedicos(){
   
    
    List<objMedico> lista = new ArrayList<>();
    String sql = "SELECT * FROM medicos";
    ResultSet rs = Conexao.consultar(sql);
    
    if (rs != null){
        try {
            while (rs.next()) {           
                
                objMedico med = new objMedico();
                med.setCodigo(rs.getInt(1));
                med.setEspecialidade(rs.getString(3));
                med.setNome(rs.getString(2));
                lista.add(med);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    return lista;
    
}
}


