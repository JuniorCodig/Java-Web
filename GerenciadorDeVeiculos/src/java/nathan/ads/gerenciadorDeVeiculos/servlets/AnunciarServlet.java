package nathan.ads.gerenciadorDeVeiculos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nathan.ads.gerenciadorDeVeiculos.dao.CategoriaDao;
import nathan.ads.gerenciadorDeVeiculos.models.Arquivo;
import nathan.ads.gerenciadorDeVeiculos.models.Veiculo;
import nathan.ads.gerenciadorDeVeiculos.dao.VeiculoDao;
import nathan.ads.gerenciadorDeVeiculos.models.Categoria;
import nathan.ads.gerenciadorDeVeiculos.utils.ServletUtil;
import nathan.ads.gerenciadorDeVeiculos.utils.Validations;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

/**
 * @author Nathan
 */
public class AnunciarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        Connection conexao = (Connection) req.getAttribute("conexao");
        
        List<Categoria> categorias = new ArrayList<>();
        CategoriaDao dao = new CategoriaDao(conexao);
        
        try {
            categorias = dao.getAll();
            req.setAttribute("categorias", categorias);
        } catch (SQLException ex) {
            Logger.getLogger(AnunciarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/WEB-INF/paginas/anunciar.jsp");
        dispatcher.forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String mensagemErro = validaAnuncio(req);
        
        Veiculo veiculo = new Veiculo();
        try {
            Map<String, Object> parameters = ServletUtil.recuperaParametrosMultipart(req);
            
            String docName = ServletUtil.gravarArquivo( (Arquivo) parameters.get("anuncio-imagem"));
           
            veiculo.setNomeVeiculo( (String) parameters.get("anuncio-titulo"));
            veiculo.setAnoFabricacao(Long.parseLong((String) parameters.get("anuncio-ano-fabricacao")));
            veiculo.setAnoModelo(Long.parseLong((String) parameters.get("anuncio-ano-modelo")));
            veiculo.setKmVeiculo(Long.parseLong((String) parameters.get("anuncio-quilometragem")));
            veiculo.setValorVeiculo(Long.parseLong((String) parameters.get("anuncio-valor")));
            veiculo.setTipoCombustivel((String) parameters.get("anuncio-combustivel"));
            veiculo.setCatVeiculo(Long.parseLong((String) parameters.get("anuncio-categoria")));
            veiculo.setImgVeiculo(docName);
            veiculo.setDescricao((String) parameters.get("anuncio-descricao"));
            veiculo.setDataHora(new Date());
            
            System.out.println("Veiculo construido");
            
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Erro ao cadastrar o veiculo");
            
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/anunciar.jsp");
            dispatcher.forward(req, resp);
        }
        
        try {
            Connection conexao = (Connection) req.getAttribute("conexao");
            VeiculoDao dao = new VeiculoDao(conexao);
            dao.inserir(veiculo);
            
            System.out.println("Salvo no banco de dados");
        } catch (Exception e) {
            req.setAttribute("error", "Não foi possivel salvar no bancos de dados" + e.getMessage());
            
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/anunciar.jsp");
            dispatcher.forward(req, resp);
        }
        
        req.setAttribute("sucesso", "Seu anuncio foi salvo com exito.");
            
        resp.sendRedirect("index");
        
     
    }
    
    
    private String validaAnuncio(HttpServletRequest req){
        
        Calendar cal = GregorianCalendar.getInstance();
        
        if (!Validations.validaString(req.getParameter("anuncio-titulo"), 5)){
            return "O titulo deve conter no minimo 5 caracteres.";
        }
        
        if (!Validations.validaLong(req.getParameter("anuncio-ano-fabricacao"), 1885, cal.get(Calendar.YEAR))){
            return "O ano de fabricação tem que estar entre 1890 e " + cal.get(Calendar.YEAR) + ".";
        }
        
        if (!Validations.validaLong(req.getParameter("anuncio-ano-modelo"), 1885, 2019)){
            return "O ano de fabricação tem que estar entre 1890.";
        }
        
        if (!Validations.validaLong(req.getParameter("anuncio-quilometragem"), 0, Integer.MAX_VALUE)){
            return "Informe uma quilometragem correta.";
        }
        
        if (!Validations.validaDouble(req.getParameter("anuncio-valor"), 0, Double.MAX_VALUE)){
            return "Informe um valor correto.";
        }
        
        if (!Validations.validaString(req.getParameter("anuncio-combustivel"), 1)){
            return "Selecione ao menos um tipo de combustivel.";
        }
        
        if (!Validations.validaString(req.getParameter("anuncio-categoria"), 1)){
           return "Selecione ao menos uma categoria.";
        }
        
        if (!Validations.validaString(req.getParameter("anuncio-imagem"), 1)){
            return "Adicione uma imagem";
        }
        
        if (!Validations.validaString(req.getParameter("anuncio-descricao"), 30)){
            return "Sua descrição está muito curta. Com pouca informação talvez o interesse seja menor por seu veiculo";
        }
        
        return null;
    }
    
}
