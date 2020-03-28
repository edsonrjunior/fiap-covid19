package br.com.fiap.fiapcovid19.model;

import io.swagger.models.auth.In;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "doador")
public class Doador {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String cpf;
    private String nome;
    private TipoSanguineo tipoSanguineo;
    private Integer cidade;
    private Integer UF;
    private Integer idade;
    private String email;
    private String telefone;

    public Doador(String cpf, String nome, TipoSanguineo tipoSanguineo, Integer cidade, Integer UF, Integer idade, String email, String telefone) {
        this.nome = nome;
        this.tipoSanguineo = tipoSanguineo;
        this.cidade = cidade;
        this.UF = UF;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    public Integer getCidade() {
        return cidade;
    }
    public void setCidade(Integer cidade) {
        this.cidade = cidade;
    }
    public Integer getUF() {
        return UF;
    }
    public void setUF(Integer UF) {
        this.UF = UF;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}