package br.com.fiap.fiapcovid19.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "doador")
public class Doador {

    @Id
    private Integer id;
    private String nome;
    private String tipoSanguineo;
    private Integer cidade;
    private Integer UF;
    private Integer idade;
    private String cpf;
    private String email;
    private Integer telefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(String tipoSanguineo) {
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
    public Integer getTelefone() {
        return telefone;
    }
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }
}