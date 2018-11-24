package nathan.ads.gerenciadorDeVeiculos.models;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Nathan
 */
public class Veiculo {
    
    private Integer veiculoId;
    private String nomeVeiculo;
    private long anoFabricacao;
    private long anoModelo;
    private long kmVeiculo;
    private double valorVeiculo;
    private String tipoCombustivel;
    private long catVeiculo;
    private String imgVeiculo;
    private String descricao;
    private Date dataHora;

    public Integer getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Integer veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public long getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(long anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public long getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(long anoModelo) {
        this.anoModelo = anoModelo;
    }

    public long getKmVeiculo() {
        return kmVeiculo;
    }

    public void setKmVeiculo(long kmVeiculo) {
        this.kmVeiculo = kmVeiculo;
    }

    public double getValorVeiculo() {
        return valorVeiculo;
    }

    public void setValorVeiculo(double valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public long getCatVeiculo() {
        return catVeiculo;
    }

    public void setCatVeiculo(long catVeiculo) {
        this.catVeiculo = catVeiculo;
    }

    public String getImgVeiculo() {
        return imgVeiculo;
    }

    public void setImgVeiculo(String imgVeiculo) {
        this.imgVeiculo = imgVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataHora() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(this.dataHora);
        } catch (Exception e) {
            return "";
        }
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
