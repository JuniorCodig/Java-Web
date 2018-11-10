package br.grupointegrado.ads.gerenciadorDeProdutos.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nathan
 */
public class Produto {
    
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private Date dataValidade;
    private long quantidade;

    public Produto(){
        nome = "";
        descricao = "";
        dataValidade = new Date();
    }
    
    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public String getDataValidadeString(){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.format(this.dataValidade);
        } catch (Exception e) {
            return "";
        }
    }
    
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
