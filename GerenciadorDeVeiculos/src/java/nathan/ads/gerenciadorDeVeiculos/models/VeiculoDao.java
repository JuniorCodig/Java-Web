package nathan.ads.gerenciadorDeVeiculos.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import nathan.ads.gerenciadorDeVeiculos.utils.Formatter;

/**
 * @author Nathan
 */

public class VeiculoDao {
    
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static int sequenciaIds = 1;
    
    private final Connection conexao;
    
    public VeiculoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Veiculo veiculo) throws SQLException {
        
        String sql = "INSERT INTO veiculos (id_veiculo, nm_veiculo, ano_modelo, ano_fabrica, km_veiculo, vl_veiculo,"
                    + "tp_combustivel, id_categoria, desc_veiculo)";
        
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, veiculo.getVeiculoId());
        pstmt.setString(2, veiculo.getNomeVeiculo());
        pstmt.setInt(3, veiculo.getAnoModelo());
        pstmt.setInt(4, veiculo.getAnoFabricacao());
        pstmt.setInt(5, veiculo.getKmVeiculo());
        pstmt.setDouble(6, veiculo.getValorVeiculo());
        pstmt.setString(7, veiculo.getTipoCombustivel());
        pstmt.setInt(8, veiculo.getCatVeiculo());
        pstmt.setString(9, veiculo.getDescricao());
    }

    public Veiculo buscaPorId(long id) {
        
     return null;   
    }

    public void remover(long id) {
        
        Veiculo veiculo = buscaPorId(id);
        if (veiculo != null) {
            veiculos.remove(veiculo);
        }
    }

    public void atualizar(Veiculo veiculoAtualizado) {
        
        remover(veiculoAtualizado.getVeiculoId());
        veiculos.add(veiculoAtualizado);
    }

    public List<Veiculo> buscaTodos(String termoBusca) {
        
        if (termoBusca == null || termoBusca.isEmpty()) {
            return veiculos;
        }
        List<Veiculo> produtosEncontrados = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getNomeVeiculo().contains(termoBusca)
                    || veiculo.getDescricao().contains(termoBusca)) {
                produtosEncontrados.add(veiculo);
            }
        }
        
        return produtosEncontrados;
    }
    
    public static Veiculo getVeiculoByRequest(HttpServletRequest req) {
        
        Veiculo veiculo = new Veiculo();
        
        veiculo.setVeiculoId(Formatter.stringParaInt(req.getParameter("form-anunciar")));
        veiculo.setNomeVeiculo(req.getParameter("anuncio-titulo"));
        veiculo.setAnoFabricacao(Formatter.stringParaInt(req.getParameter("anuncio-ano-fabricacao")));
        veiculo.setAnoModelo(Formatter.stringParaInt(req.getParameter("anuncio-ano-modelo")));
        veiculo.setKmVeiculo(Formatter.stringParaInt(req.getParameter("anuncio-quilometragem")));
        veiculo.setValorVeiculo(Formatter.stringParaDouble(req.getParameter("anuncio-valor")));
        veiculo.setTipoCombustivel(req.getParameter("anuncio-combustivel"));
        veiculo.setCatVeiculo(Formatter.stringParaInt(req.getParameter("anuncio-categoria")));
        veiculo.setImgVeiculo(req.getParameter("anuncio-imagem"));
        veiculo.setDescricao(req.getParameter("anuncio-descricao"));
        
        return veiculo;
        
    }
}

