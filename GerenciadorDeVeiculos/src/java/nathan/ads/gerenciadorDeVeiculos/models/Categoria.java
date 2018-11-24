package nathan.ads.gerenciadorDeVeiculos.models;
/**
 * @author Nathan
 */
public class Categoria {

    private Integer categoriaId;
    private String categoriaNome;
    
    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }
}
