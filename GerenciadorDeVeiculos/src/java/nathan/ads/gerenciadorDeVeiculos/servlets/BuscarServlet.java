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
import nathan.ads.gerenciadorDeVeiculos.dao.VeiculoDao;
import nathan.ads.gerenciadorDeVeiculos.models.Veiculo;

/**
 * @author Nathan
 */
public class BuscarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conexao = (Connection) req.getAttribute("conexao");
        
        try {
            String buscarVeiculo = req.getParameter("buscar-veiculo");
            
            List<Veiculo> veis = new ArrayList<>();
            VeiculoDao veiDao = new VeiculoDao(conexao);
            veis = veiDao.getBySearch(buscarVeiculo);
            
            if(veis.size() >= 1){
                req.setAttribute("veiculos", veis);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("mensagem-erro", "Não foi possivel pesquisar no banco de dados");
        }
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/index.jsp");
        dispatcher.forward(req, resp);
    }
   
    
}
