
package Model;


public class objMedico {
   int codigo;
    String nome;
    String especialidade;

    public objMedico(int codigo, String nome, String especialidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public objMedico() {
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
    
    

    
      
   