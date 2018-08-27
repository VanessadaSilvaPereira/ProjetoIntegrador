package DAO;

import Model.objMedico;
import Model.objPaciente;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class pacienteDAO {

    public static void inserir(objPaciente pac) {
        int dia = pac.getNascimento().getDate();
        int mes = (pac.getNascimento().getMonth() + 1);
        int ano = pac.getNascimento().getYear();
        String data = "" + ano + "-" + mes + "-" + dia;

        String sql = "INSERT INTO pacientes "
                + " (codigo, nome , email, telefone, nascimento, endereco, bairro, cidade, cep, estadoCivil, cpf, rg, codMedico, convenio ) VALUES "
                + " ( " + pac.getCodigo() + ","
                + " '" + pac.getNome() + "',"
                + " '" + pac.getEmail() + "',"
                + " '" + pac.getTelefone() + "',"
                + " '" + data + "',"
                + " '" + pac.getEndereco() + "',"
                + " '" + pac.getBairro() + "',"
                + " '" + pac.getCidade() + "',"
                + " '" + pac.getCep() + "',"
                + " '" + pac.getEstadoCivil() + "',"
                + " '" + pac.getCpf() + "',"
                + " '" + pac.getRg() + "',"
                + "  " + pac.getMedico().getCodigo() + ","
                + " '" + pac.getConvenio() + "'  );";

        Conexao.executar(sql);
    }

    public static void editar(objPaciente pac) {
        String sql = "UPDATE pacientes SET "
                + " nome = '" + pac.getNome() + "' "
                + " email = '" + pac.getEmail() + "' "
                + " telefone = '" + pac.getTelefone() + "' "
                + " nascimento = " + pac.getNascimento() + " "
                + " endereco = '" + pac.getEndereco() + "' "
                + " bairro = '" + pac.getBairro() + "' "
                + " cidade = '" + pac.getCidade() + "' "
                + " cep = '" + pac.getCep() + "' "
                + " estadoCivil = '" + pac.getEstadoCivil() + "' "
                + " cpf = '" + pac.getCpf() + "' "
                + " rg = '" + pac.getRg() + "' "
                + " codMedico = '" + pac.getMedico() + " "
                + " WHERE codigo = " + pac.getCodigo();

        Conexao.executar(sql);
    }

    public static void excluir(objPaciente pac) {

        String sql = "DELETE FROM pacientes "
                + " WHERE codigo = " + pac.getCodigo();

        Conexao.executar(sql);
    }

    public static List<objPaciente> getPacientes() {

        List<objPaciente> lista = new ArrayList<>();
        
        String sql = "SELECT c.codigo, d.codigo, c.nome, d.nome, " 
               + " c.email, c.telefone, c.nascimento,c.endereco, c.bairro, c.cidade, c.cep, c.estadoCivil, c.cpf, c.rg, c.convenio "
               + " FROM pacientes c "
               + " INNER JOIN medicos d ON c.codMedico = d.codigo "
               + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            try {
                while (rs.next()) {

                    objMedico med = new objMedico();
                    med.setNome(rs.getString(4));
                    med.setCodigo(rs.getInt(2));
                    

                    objPaciente pac = new objPaciente();

                   // int dia = pac.getNascimento().getDate();
                    //int mes = (pac.getNascimento().getMonth() + 1);
                   // int ano = pac.getNascimento().getYear();
                    //String data = "" + dia + "-" + mes + "-" + ano;
                    

                    pac.setCodigo(rs.getInt(1));
                    pac.setNome(rs.getString(3));
                    pac.setEmail(rs.getString(5));
                    pac.setTelefone(rs.getString(6));
                    pac.setCpf(rs.getString(13));
                    pac.setNascimento(rs.getDate(7));
                    pac.setRg(rs.getString(14));
                    pac.setEstadoCivil(rs.getString(12));
                    pac.setCidade(rs.getString(10));
                    pac.setEndereco(rs.getString(8));
                    pac.setBairro(rs.getString(9));
                    pac.setMedico(med);
                    pac.setCep(rs.getString(11));
                    pac.setConvenio(rs.getString(15));
                    lista.add(pac);

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
        
        try {
            rs.first();
            objPaciente pac = new objPaciente();
            pac.setCodigo(rs.getInt(2));
            pac.setNome(rs.getString(4));
            
            String tipo = rs.getString(7);            
            if ( tipo.equals("") ) {
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
                
                
                
                paciente = paci;
            }
        }
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return paciente;
        
    }
    }


