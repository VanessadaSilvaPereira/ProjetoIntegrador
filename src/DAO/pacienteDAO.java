package DAO;

import Model.objMedico;
import Model.objPaciente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class pacienteDAO {

    public static void inserir(objPaciente pac) {
        int dia = pac.getNascimento().getDate();
        int mes = (pac.getNascimento().getMonth() + 1);
        int ano = pac.getNascimento().getYear();
        String data = "" + ano + "-" + mes + "-" + dia;

        String sql = "INSERT INTO pacientes "
                + " (nome, email, telefone, nascimento, endereco, bairro, cidade, cep, estadoCivil, cpf, rg, convenio, codMedico) VALUES( "
                + " '" + pac.getNome() + "' ,"
                + " '" + pac.getEmail() + "' ,"
                + " '" + pac.getTelefone() + "',"
                + " '" + data + "',"
                + " '" + pac.getEndereco() + "',"
                + " '" + pac.getBairro() + "',"
                + " '" + pac.getCidade() + "',"
                + " '" + pac.getCep() + "',"
                + " '" + pac.getEstadoCivil() + "',"
                + " '" + pac.getCpf() + "',"
                + " '" + pac.getRg() + "',"
                + " '" + pac.getConvenio() + "',"
                + " '" + pac.getMedico().getCodigo() + "'  );";

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
                + " convenio= '" + pac.getConvenio() + "' "
                + " codMedico = " + pac.getMedico().getCodigo() + " "
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

        String sql = "SELECT c.codigo, m.codigo, c.nome, m.nome, "
                + " c.email, c.telefone, c.nascimento, c.endereco, c.bairro, c.cidade, c.cep, c.estadoCivil, c.cpf, c.rg, c.convenio "
                + " FROM pacientes c "
                + " INNER JOIN medicos m ON c.codMedico = m.codigo "
                + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            try {
                while (rs.next()) {

                    objMedico med = new objMedico();
                    med.setNome(rs.getString(4));
                    med.setCodigo(rs.getInt(2));

                    objPaciente pac = new objPaciente();

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

    public static objPaciente getPacienteByCodigo(int codigo) {

        String sql = "SELECT c.codigo, d.codigo, c.nome, d.nome , "
                + " c.email, c.telefone, c.nascimento, c.endereco, c.bairro, c.cidade, c.cep, c.estadoCivil, c.cpf, c.rg, c.convenio "
                + " FROM pacientes c "
                + " INNER JOIN medicos d ON c.codMedico = d.codigo "
                + " WHERE c.codigo = " + codigo
                + " ORDER BY c.nome ";
        ResultSet rs = Conexao.consultar(sql);

        try {
            rs.first();
            objPaciente paciente = new objPaciente();

            objMedico med = new objMedico();
            med.setCodigo(rs.getInt(2));
            med.setNome(rs.getString(4));

            paciente.setCodigo(rs.getInt(1));
            paciente.setNome(rs.getString(3));
            paciente.setEmail(rs.getString(5));
            paciente.setTelefone(rs.getString(6));
            paciente.setNascimento(rs.getDate(7));
            paciente.setEndereco(rs.getString(8));
            paciente.setBairro(rs.getString(9));
            paciente.setCidade(rs.getString(10));
            paciente.setCep(rs.getString(11));
            paciente.setEstadoCivil(rs.getString(12));
            paciente.setCpf(rs.getString(13));
            paciente.setRg(rs.getString(14));
            paciente.setConvenio(rs.getString(15));
            paciente.setMedico(med);

            return paciente;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }

    }
}
