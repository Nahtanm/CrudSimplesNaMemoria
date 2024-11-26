package br.com.crud.domain;

import java.util.Objects;

public class Cliente {
    private String nome;
    private Long cpf;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String estado;

    public Cliente(String nome, String estado, String cidade, String numero, String end, String tel, String cpf) {
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.numero = Integer.valueOf(numero.trim());
        this.end = end;
        this.tel = Long.valueOf(tel.trim());
        this.cpf = Long.valueOf(cpf.trim());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "\nNOME: '-%15s'" + nome +
                "   |   CPF: " + cpf +
                "   |   TELEFONE: " + tel +
                "\nCIDADE: " + cidade  +
                "   |   ESTADO: " + estado  +
                "   |   ENDEREÇO: " + end  +
                "   |   NUMERO: " + numero;
    }
}
