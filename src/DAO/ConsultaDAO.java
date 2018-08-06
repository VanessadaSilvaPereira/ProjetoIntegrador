package DAO;

import Model.objConsulta;
import Model.objMedico;
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

}
