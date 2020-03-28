package br.com.fiap.fiapcovid19.dto;

import br.com.fiap.fiapcovid19.model.Doador;

import java.io.Serializable;

public class DoadorDTO implements Serializable {
    private static final long serialVersionUID = -1L;

    private Integer id;
    private String nome;
    private String tipoSanguineo;
    private Integer cidade;
    private Integer UF;
    private Integer idade;
    private String cpf;
    private String email;
    private String telefone;

    public DoadorDTO() {
    }

    public DoadorDTO(Doador doador) {
        this.id = doador.getId();
        this.nome = doador.getNome();
        this.tipoSanguineo = doador.getTipoSanguineo();
        this.cidade = doador.getCidade();
        this.UF = doador.getUF();
        this.idade = doador.getIdade();
        this.cpf = doador.getCpf();
        this.email = doador.getEmail();
        this.telefone = doador.getTelefone();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
