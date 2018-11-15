package nathan.ads.gerenciadorDeVeiculos.models;

/**
 * @author Nathan
 */
public class Veiculo {
    
    private Integer veiculoId;
    private String nomeVeiculo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private long kmVeiculo;
    private double valorVeiculo;
    private String tipoCombustivel;
    private String catVeiculo;
    private String descricao;

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

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
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

    public String getCatVeiculo() {
        return catVeiculo;
    }

    public void setCatVeiculo(String catVeiculo) {
        this.catVeiculo = catVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
