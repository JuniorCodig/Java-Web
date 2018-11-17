package nathan.ads.gerenciadorDeVeiculos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nathan.ads.gerenciadorDeVeiculos.models.Veiculo;
import nathan.ads.gerenciadorDeVeiculos.models.VeiculoDao;
import nathan.ads.gerenciadorDeVeiculos.utils.Validations;

/**
 * @author Nathan
 */
public class AnunciarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/WEB-INF/paginas/anunciar.jsp");
        dispatcher.forward(req, resp); 
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Connection conexao = (Connection) req.getAttribute("conexao");
        Veiculo veiculo = VeiculoDao.getVeiculoByRequest(req);
        
        VeiculoDao dao = new VeiculoDao(conexao);
            try {
                
                if (veiculo.getVeiculoId() > 0) {
                    
                    dao.atualizar(veiculo);
                } else{
                    
                    dao.inserir(veiculo);
                }
            } catch (Exception e) {
                e.printStackTrace();
                req.setAttribute("error", "Não foi possivel gravar no banco");
            }
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
