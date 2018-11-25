package nathan.ads.gerenciadorDeVeiculos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Policy;
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
import nathan.ads.gerenciadorDeVeiculos.dao.CategoriaDao;
import nathan.ads.gerenciadorDeVeiculos.dao.VeiculoDao;
import nathan.ads.gerenciadorDeVeiculos.models.Categoria;
import nathan.ads.gerenciadorDeVeiculos.models.Veiculo;

/**
 * @author Nathan
 */
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        //BUSCAR VEICULOS POR ID.
        //LISTAR VEICULOS POR CATEGORIA.
        
        Connection conexao = (Connection) req.getAttribute("conexao");
        
        
        try {
            //Listo todas as categorias do banco para a JSP.
            List<Categoria> categorias = new ArrayList<>();
            CategoriaDao catDao = new CategoriaDao(conexao);
           
            categorias = catDao.getAll();
           
            req.setAttribute("categorias", categorias);
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if(req.getParameter("buscar-veiculo") != null){
            listByName(req, resp);
            
        } else if (req.getParameter("categoria") != null){
            listByCategoria(req, resp);
        } 
        else {
            listAllVeiculos(req, resp);
        }
        
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/WEB-INF/paginas/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
    private void listAllVeiculos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        Connection conexao = (Connection) req.getAttribute("conexao");
        
        try {
            //Lista todos veiculos do banco de dados para a JSP.
            List<Veiculo> veiculos = new ArrayList<>();
            VeiculoDao dao = new VeiculoDao(conexao);
            veiculos = dao.getAll();
            req.setAttribute("veiculos", veiculos);
        } catch (SQLException ex) {
            req.setAttribute("mensagem-erro", "Não foi listar do banco");
           
            RequestDispatcher dispatcher
                = req.getRequestDispatcher("/WEB-INF/paginas/index.jsp");
            dispatcher.forward(req, resp);
        }
    }
    
    private void listByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        Connection conexao = (Connection) req.getAttribute("conexao");
        
        try {
            //Lista veiculos por nome
            String buscarVeiculo = req.getParameter("buscar-veiculo");
            
            System.out.println(buscarVeiculo);
            
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
    }
    
    private void listByCategoria(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        Connection conexao = (Connection) req.getAttribute("conexao");
        
        int id = Integer.parseInt(req.getParameter("categoria"));
        
        try {
            //Lista todos os veiculos que possui categoria com id.
            List<Veiculo> veiculos = new ArrayList<>();
            List<Categoria> categorias = new ArrayList<>();
            VeiculoDao dao = new VeiculoDao(conexao);
            
            CategoriaDao catDao = new CategoriaDao(conexao);
            
            veiculos = dao.getByCategoria(id);
            req.setAttribute("veiculos", veiculos);
            
            
            categorias = catDao.getAll();
            req.setAttribute( "categorias", categorias);
            
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("mensagem-erro", "Não foi possivel concluir a buca por ID");
        }
    }
    
}
