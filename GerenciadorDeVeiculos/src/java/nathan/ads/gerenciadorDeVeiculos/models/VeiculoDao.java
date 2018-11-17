package nathan.ads.gerenciadorDeVeiculos.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        
        String sql = "INSERT INTO veiculos (nm_veiculo, ano_modelo, ano_fabrica, km_veiculo, vl_veiculo,"
                    + "tp_combustivel, id_categoria, imagem , desc_veiculo)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, veiculo.getNomeVeiculo());
        pstmt.setInt(2, veiculo.getAnoModelo());
        pstmt.setInt(3, veiculo.getAnoFabricacao());
        pstmt.setInt(4, veiculo.getKmVeiculo());
        pstmt.setDouble(5, veiculo.getValorVeiculo());
        pstmt.setString(6, veiculo.getTipoCombustivel());
        pstmt.setInt(7, veiculo.getCatVeiculo());
        pstmt.setString(8, veiculo.getImgVeiculo());
        pstmt.setString(9, veiculo.getDescricao());
        
        pstmt.execute();
    }
    
    public List<Veiculo> getAll() throws SQLException{
        String sql = "SELECT * FROM veiculos";
        
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            List<Veiculo> veiculos = new ArrayList<>();
            
            if(result.first()){
                do {
                    Veiculo veiculo = getVeiculoByResult(result);
                    veiculos.add(veiculo);
                } while(result.next());
            }
            
        } catch (Exception e) {
        }
        
        return veiculos;
    }
    
    public static Veiculo getVeiculoByResult(ResultSet result) throws SQLException{
        
        Veiculo veiculo = new Veiculo();
        
        veiculo.setVeiculoId(result.getInt("id_veiculo"));
        veiculo.setNomeVeiculo(result.getString("nm_veiculo"));
        veiculo.setAnoFabricacao(result.getInt("ano_fabrica"));
        veiculo.setAnoModelo(result.getInt("ano_modelo"));
        veiculo.setKmVeiculo(result.getInt("km_veiculo"));
        veiculo.setValorVeiculo(result.getDouble("vl_veiculo"));
        veiculo.setTipoCombustivel(result.getString("tp_combustivel"));
        veiculo.setCatVeiculo(result.getInt("id_categoria"));
        veiculo.setImgVeiculo(result.getString("imagem"));
        veiculo.setDescricao(result.getString("desc_veiculo"));
        
        return veiculo;
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
        
        
        
        return null;
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

