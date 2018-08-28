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

        int segundo = (int) c.getHora().getTime();
        int minuto = (int) c.getHora().getTime();
        int horas = (int) c.getHora().getTime();
        String hora = "" + horas + "-" + minuto + "-" + segundo;

        String sql = "INSERT INTO consultas "
                + " ( cpfpaciente , medico, dataconsulta, hora) VALUES "
                + " ( '" + c.getCpfpaciente() + "' ,"
                + "  " + c.getMedico() + " , "
                + "  " + c.getDataconsulta() + " , "
                + "  " + hora + " );";
        Conexao.executar(sql);
    }

    public static void excluir(objConsulta con) {

        String sql = "DELETE FROM consultas "
                + " WHERE codigo = " + con.getCodigo();

        Conexao.executar(sql);
    }

    public static List<objConsulta> getConsultas() {

        List<objConsulta> lista = new ArrayList<>();

        //String sql = "SELECT * FROM consultas";
         String sql = "SELECT c.codigo, d.codigo, c.nome, d.nome , "
                + " c.endereco, c.tipo, c.cpf_cnpj, c.rg_ie "
                + " FROM consultas c "
                + " INNER JOIN consultas d ON c.codMedico = d.codigo "
                + " ORDER BY c.nome";

        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
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


    public static Object getPacienteByCpf(int cpf) {
       Object paciente = null;
        
        String sql = "SELECT c.codigo, d.codigo, c.nome, d.nome , "
               + " c.email, c.telefone, c.nascimento, c.endereco, c.bairro, c.cidade, c.cep, c.estadoCivil, c.cpf, c.rg, c.convenio "
                + " FROM pacientes c "
                + " INNER JOIN medicos d ON c.codMedico = d.codigo "
                + " WHERE c.cpf = '" + cpf + "' "
                + " ORDER BY c.nome ";        
       ResultSet rs = Conexao.consultar(sql);
        
       try {
           rs.first();
           objPaciente pac = new objPaciente();
           pac.setCodigo(rs.getInt(2));
           pac.setNome(rs.getString(4));
              
                   
            if ( rs != null) {
              
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
                paci.setMedico(rs.getString(16));
                
                
                
               paciente = pac;
            }
       }

            catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
}
        return paciente;
        }
        
    }



