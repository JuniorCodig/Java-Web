package nathan.ads.gerenciadorDeVeiculos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nathan.ads.gerenciadorDeVeiculos.models.Categoria;
/**
 * @author Nathan
 */
public class CategoriaDao {
    
    private Connection conexao;
    
    public CategoriaDao(Connection conn) {
        this.conexao = conn;
    }
    
    public List<Categoria> getAll() throws SQLException{
        
        String sql = "SELECT * FROM categoria";
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        ResultSet result = statement.executeQuery();
            
        List<Categoria> categorias = new ArrayList<>();
        if(result.first()){
            do{
                Categoria cat = getByResult(result);
                categorias.add(cat);
            }while (result.next());
        }
        return categorias;
    }
    
    private Categoria getById(int id) throws SQLException {
        
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setLong(1, id);
        
        ResultSet result = statement.executeQuery();
        
        Categoria cat = getByResult(result);
        
        return cat;
    }
    
    private static Categoria getByResult (ResultSet result) throws SQLException {
        
        Categoria cat = new Categoria();
        
        cat.setCategoriaId(result.getInt("id_categoria"));
        cat.setCategoriaNome(result.getString("titulo"));
        
        return cat;
    }
}
