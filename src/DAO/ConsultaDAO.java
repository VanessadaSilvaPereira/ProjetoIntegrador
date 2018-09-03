package DAO;

import Model.objConsulta;
import Model.objMedico;
import Model.objPaciente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsultaDAO {

    public static void inserir(objConsulta c) {
 int dia = c.getDataconsulta().getDate();
        int mes = (c.getDataconsulta().getMonth() + 1);
        int ano = c.getDataconsulta().getYear();
        String data = "" + ano + "-" + mes + "-" + dia;
        
        //int segundo = (int) c.getHora().getTime();
        //int minuto = (int) c.getHora().getTime();
       // int horas = (int) c.getHora().getTime();
       // String hora = "" + horas + "-" + minuto + "-" + segundo;

        String sql = "INSERT INTO consultas "
                + " ( cpfpaciente, medico, dataconsulta, hora) VALUES "
                + " ( '" + c.getCpfpaciente() + "' ,"
                + "  " + c.getMedico().getNome() + " , "
                + "  " + data + " , "
                + "  '" + c.getHora() + "' );";
        Conexao.executar(sql);
    }

    public static void excluir(objConsulta con) {

        String sql = "DELETE FROM consultas "
                + " WHERE codigo = " + con.getCodigo();

        Conexao.executar(sql);
    }
    
    
  

    public static List<objConsulta> getConsultas() {

        List<objConsulta> lista = new ArrayList<>();
         String sql = "SELECT c.codigo, m.codigo, c.cpfpaciente, m.nome , "
               + " c.dataconsulta, c.hora"
               + " FROM consultas c "
               + " INNER JOIN medicos m ON c.codMedico = m.codigo ";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    objMedico med = new objMedico();
                    med.setCodigo(rs.getInt(2));
                    med.setNome(rs.getString(4));
                    
                    objConsulta con = new objConsulta();
                    con.setCodigo(rs.getInt(1));
                    con.setCpfpaciente(rs.getString(3));
                    con.setMedico(med);
                    con.setDataconsulta(rs.getDate(5));
                    con.setHora(rs.getString(6));
                    
                    lista.add(con);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }

        return lista;

    }


    public static Object getPacienteByCpf(String cpf) {
       Object paciente = null;
        
        String sql = "SELECT c.codigo, d.codigo, c.nome, d.nome , "
               + " c.email, c.telefone, c.nascimento, c.endereco, c.bairro, c.cidade, c.cep, c.estadoCivil, c.cpf, c.rg, c.convenio "
                + " FROM pacientes c "
                + " INNER JOIN medicos d ON c.medico = d.codigo "
                + " WHERE c.cpf = '" + cpf + "' ";      
        
       ResultSet rs = Conexao.consultar(sql);
        
       try {
           rs.first();
           objPaciente pac = new objPaciente();
           pac.setCodigo(rs.getInt(1));
           pac.setNome(rs.getString(3));
              
                   
            if ( rs != null) {
              objMedico med = new objMedico();
              med.setCodigo(rs.getInt(2));
              med.setNome(rs.getString(4));
              
               objPaciente paci = new objPaciente();
                paci.setCodigo(rs.getInt(1));
                paci.setNome(rs.getString(3));
                paci.setEmail(rs.getString(5));
                paci.setTelefone(rs.getString(6));
                paci.setNascimento(rs.getDate(7));
                paci.setEndereco(rs.getString(8));
                paci.setBairro(rs.getString(9));
                paci.setCidade(rs.getString(10));
                paci.setCep(rs.getString(11));
                paci.setEstadoCivil(rs.getString(12));
                paci.setCpf(rs.getString(13));
                paci.setRg(rs.getString(14));
                paci.setConvenio(rs.getString(15));
                paci.setMedico(med);
  
               paciente = pac;
            }
       }

            catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
}
        return paciente;
     
        }
        
    }



