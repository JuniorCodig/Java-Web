package nathan.ads.gerenciadorDeVeiculos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nathan.ads.gerenciadorDeVeiculos.dao.VeiculoDao;
import nathan.ads.gerenciadorDeVeiculos.models.Veiculo;

/**
 * @author Nathan
 */
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        Connection conexao = (Connection) req.getAttribute("conexao");
        
        List<Veiculo> veiculos = new ArrayList<>();
        VeiculoDao dao = new VeiculoDao(conexao);
        
        try {
            veiculos = dao.getAll();
            req.setAttribute("veiculos", veiculos);
        } catch (SQLException ex) {
            Logger.getLogger(AnunciarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/WEB-INF/paginas/index.jsp");
        dispatcher.forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
}
