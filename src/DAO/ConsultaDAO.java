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

        String sql = "SELECT * FROM consultas";
        // String sql = "SELECT c.codigo, d.codigo, c.nome, d.nome , "
               // + " c.endereco, c.tipo, c.cpf_cnpj, c.rg_ie "
              //  + " FROM clientes c "
               // + " INNER JOIN cidades d ON c.codCidade = d.codigo "
               // + " WHERE c.tipo = '' "
               // + " ORDER BY c.nome";

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


    public static Object getPacienteByCodigo(int codigo) {
        Object paciente = null;
        
        String sql = "SELECT c.codigo, d.codigo, c.nome, d.nome , "
                + " c.email, c.telefone, c.nascimento, c.endereco, c.bairro, c.cidade, c.cep, c.estadoCivil, c.cpf, c.rg, c.convenio "
                + " FROM pacientes c "
                + " INNER JOIN medicos d ON c.codMedico = d.codigo "
                + " WHERE c.codigo = " + codigo
                + " ORDER BY c.nome ";        
        ResultSet rs = Conexao.consultar(sql);
        
        try{
            rs.first();
            objPaciente pac = new objPaciente();
            paciente.setCodigo(rs.getInt(2));
            paciente.setNome(rs.getString(4));
              
            String tipo = rs.getString(7);            
            if ( tipo.equals("") ) {
                objPaciente paci = new objPaciente();
                
                pac.setCodigo(rs.getInt(1));
                pac.setNome(rs.getString(3));
                pac.setEmail(rs.getString(5));
                pac.setTelefone(rs.getString(6));
                pac.setNascimento(rs.getDate(7));
                pac.setEndereco(rs.getString(8));
                pac.setBairro(rs.getString(9));
                pac.setCidade(rs.getString(10));
                pac.setCep(rs.getString(11));
                pac.setEstadoCivil(rs.getString(12));
                pac.setCpf(rs.getString(13));
                pac.setRg(rs.getString(14));
                pac.setConvenio(rs.getString(15));
                pac.setMedico(rs.getString(16));
                
                
                
                paciente = pac;
            

}
        }
    }
}
