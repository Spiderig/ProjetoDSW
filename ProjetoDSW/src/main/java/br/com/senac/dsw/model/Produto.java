package br.com.senac.dsw.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class Produto implements Serializable {

    private long id;
    private String nome;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private int quantidade;
    private Date dtCadastro;
    private List<Categoria> categorias;

    public Produto() {
        this.id = 0;
        this.categorias = new ArrayList<>();
    }

    public Produto(long id, String nome, String descricao, double precoCompra, double precoVenda, int quantidade, Date dtCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
        this.dtCadastro = dtCadastro;
        this.categorias = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
}
