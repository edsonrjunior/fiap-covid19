package br.com.fiap.fiapcovid19.model;

public enum TipoSanguineo {

    AP(1, "A+"),
    AN(2, "A-"),
    BP(3,"B+"),
    BM(4, "B-"),
    ABP(5,"AB+"),
    ABN(6,"AB-"),
    OP(7,"O+"),
    ON(8,"O-");

    private String descricao;
    private Integer codigo;

    TipoSanguineo(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public static TipoSanguineo toEnum(Integer codigo) {

        if (codigo == null) {
            return null;
        }

        for (TipoSanguineo x : TipoSanguineo.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("ID Tipo Sanguíneo inválido: " + codigo);
    }
}
