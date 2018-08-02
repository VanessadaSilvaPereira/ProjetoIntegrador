
package Model;

import java.util.Date;


public class objPaciente {
    private int codigo;
    private String nome;
    private String email;
    private Date nascimento;
    private String telefone;
    private String endereco;
    private String bairro;
    private String cidade;
    private String cep;
    private String estadoCivil;
    private String cpf;
    private String rg;
    private objMedico medico;
    private String convenio;

    public objPaciente() {
    }
    
    

    public objPaciente(int codigo, String nome, String email, Date nascimento, String telefone, String endereco, String bairro, String cidade, String cep, String estadoCivil, String cpf, String rg, objMedico médico, String convenio) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estadoCivil = estadoCivil;
        this.cpf = cpf;
        this.rg = rg;
        this.medico = médico;
        this.convenio = convenio;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public objMedico getMedico() {
        return medico;
    }

    public void setMedico(objMedico médico) {
        this.medico = médico;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }        
}
