package nathan.ads.gerenciadorDeVeiculos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nathan.ads.gerenciadorDeVeiculos.dao.CategoriaDao;
import nathan.ads.gerenciadorDeVeiculos.dao.VeiculoDao;
import nathan.ads.gerenciadorDeVeiculos.models.Categoria;
import nathan.ads.gerenciadorDeVeiculos.models.Veiculo;

/**
 * @author Nathan
 */
public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conexao = (Connection) req.getAttribute("conexao");
        
        int id = Integer.parseInt(req.getParameter("categoria"));
        
        try {
            //Listo todos os veiculos que possui categoria com id.
            List<Veiculo> veiculos = new ArrayList<>();
            VeiculoDao dao = new VeiculoDao(conexao);
            
            Categoria cat = new Categoria();
            CategoriaDao catDao = new CategoriaDao(conexao);
            
            veiculos = dao.getByCategoria(id);
            req.setAttribute("veiculos", veiculos);
            
            cat = catDao.getById(id);
            req.setAttribute( "categorias", cat );
            
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("mensagem-erro", "Não foi possivel concluir a buca por ID");
        }
        
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/WEB-INF/paginas/categoria.jsp");
        dispatcher.forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
    }
}
