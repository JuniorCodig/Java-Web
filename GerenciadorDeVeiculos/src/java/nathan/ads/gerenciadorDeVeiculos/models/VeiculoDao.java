package nathan.ads.gerenciadorDeVeiculos.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nathan
 */

public class VeiculoDao {
    
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static int sequenciaIds = 1;

    public void inserir(Veiculo veiculo) {
        
        veiculo.setVeiculoId(sequenciaIds++);
        veiculos.add(veiculo);
    }

    public Veiculo buscaPorId(long id) {
        
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getVeiculoId()== id) {
                return veiculo;
            }
        }
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
    
}
