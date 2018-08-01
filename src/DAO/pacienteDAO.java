
package DAO;

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
                + " (codigo, nome , email, telefone, nascimento, endereco, bairro, cidade, cep, estadoCivil, cpf, rg, medico, convenio ) VALUES "
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
                + " medico = '" + pac.getMedico()+ "' " 
                + 
                " WHERE codigo = " + pac.getCodigo();
        
        Conexao.executar(sql); 
    }

public static void excluir( objPaciente pac){

        String sql = "DELETE FROM pacientes "
               + " WHERE CPF = " + pac.getCpf();
        
        Conexao.executar(sql);
    }


public static List<objPaciente> getPacientes(){
   
    
    List<objPaciente> lista = new ArrayList<>();
    
    
    
    String sql = "SELECT * FROM pacientes ORDER BY nome";
    
    
    ResultSet rs = Conexao.consultar(sql);
   
    
    if (rs != null){
        try {
            while (rs.next()) {           
                                
                objPaciente pac = new objPaciente();
                pac.setNome(rs.getString(1));
                pac.setCpf(rs.getString(2));
                lista.add(pac);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    return lista;
    
}

}

