
package DAO;

import Model.objMedico;
import Model.objPaciente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class pacienteDAO {
    public static void inserir( objPaciente pac){
        int dia = pac.getNascimento().getDate();
        int mes =( pac.getNascimento().getMonth()+1);
        int ano = pac.getNascimento().getYear();
        String data = ""+ ano + "-"+ mes+ "-"+ dia;
        

        String sql = "INSERT INTO pacientes "
                + " (codigo, nome , email, telefone, nascimento, endereco, bairro, cidade, cep, estadoCivil, cpf, rg, codMedico, convenio ) VALUES "
                + " ( " + pac.getCodigo()       + "," 
                + " '" + pac.getNome()          + "'," 
                + " '"   + pac.getEmail()       + "'," 
                + " '"   + pac.getTelefone()    + "',"
                + " '"    + data                + "',"
                + " '"   + pac.getEndereco()    + "',"
                + " '"   + pac.getBairro()      + "',"
                + " '"   + pac.getCidade()      + "',"
                + " '"   + pac.getCep()         + "',"
                + " '"   + pac.getEstadoCivil() + "',"
                + " '"   + pac.getCpf()         + "',"
                + " '"   + pac.getRg()          + "',"
                + "  "   + pac.getMedico().getCodigo()      + ","
                + " '"   + pac.getConvenio()    + "'  );";
        
        Conexao.executar(sql);   
    }
    
public static void editar( objPaciente pac){
        String sql = "UPDATE pacientes SET "
                + " nome = '" + pac.getNome() + "' " 
                + " email = '" + pac.getEmail()+ "' " 
                + " telefone = '" + pac.getTelefone()+ "' " 
                + " nascimento = " + pac.getNascimento()+ " " 
                + " endereco = '" + pac.getEndereco()+ "' " 
                + " bairro = '" + pac.getBairro()+ "' " 
                + " cidade = '" + pac.getCidade()+ "' " 
                + " cep = '" + pac.getCep()+ "' " 
                + " estadoCivil = '" + pac.getEstadoCivil()+ "' " 
                + " cpf = '" + pac.getCpf()+ "' " 
                + " rg = '" + pac.getRg()+ "' " 
                + " codMedico = '" + pac.getMedico()+ " " 
                + 
                " WHERE codigo = " + pac.getCodigo();
        
        Conexao.executar(sql); 
    }

public static void excluir( objPaciente pac){

        String sql = "DELETE FROM pacientes "
               + " WHERE codigo = " + pac.getCodigo();
        
        Conexao.executar(sql);
    }


public static List<objPaciente> getPacientes(){
   
    
    List<objPaciente> lista = new ArrayList<>();
    
    
    
    String sql = "SELECT * FROM pacientes ORDER BY nome";
    
    
    ResultSet rs = Conexao.consultar(sql);
   
    
    if (rs != null){
        try {
            while (rs.next()) {           
                       
                
                objMedico med = new objMedico();
                
                objPaciente pac = new objPaciente();
                pac.setCodigo(rs.getInt(1));
                pac.setNome(rs.getString(2));
                pac.setEmail(rs.getString(3));
                pac.setTelefone(rs.getString(4));
                pac.setCpf(rs.getString(11));
                pac.setNascimento(rs.getDate(5));
                pac.setRg(rs.getString(12));
                pac.setEstadoCivil(rs.getString(10));
                pac.setCidade(rs.getString(8));
                pac.setEndereco(rs.getString(6));
                pac.setBairro(rs.getString(7));
                pac.setMedico(med);
                pac.setCep(rs.getString(9));
                pac.setConvenio(rs.getString(13));
                lista.add(pac);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    return lista;
    
}

}

