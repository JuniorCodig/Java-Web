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
import javax.swing.JOptionPane;
import nathan.ads.gerenciadorDeVeiculos.dao.CategoriaDao;
import nathan.ads.gerenciadorDeVeiculos.models.Veiculo;
import nathan.ads.gerenciadorDeVeiculos.dao.VeiculoDao;
import nathan.ads.gerenciadorDeVeiculos.models.Categoria;
import nathan.ads.gerenciadorDeVeiculos.utils.Formatter;

/**
 * @author Nathan
 */
public class AnuncioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conexao = (Connection) req.getAttribute("conexao");
        
        try {
            long id =  Long.parseLong(req.getParameter("anuncio"));
         
            VeiculoDao veiDao = new VeiculoDao(conexao);
            
            Veiculo veiculo = veiDao.getById(id);
            req.setAttribute("result", veiculo);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/WEB-INF/paginas/anuncio.jsp");
        dispatcher.forward(req, resp); 
       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
}
