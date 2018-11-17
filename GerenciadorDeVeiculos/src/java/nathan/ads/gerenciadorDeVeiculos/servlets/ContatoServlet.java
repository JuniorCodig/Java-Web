package nathan.ads.gerenciadorDeVeiculos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nathan.ads.gerenciadorDeVeiculos.models.Contato;
import nathan.ads.gerenciadorDeVeiculos.utils.JavaMailApp;
import nathan.ads.gerenciadorDeVeiculos.utils.Validations;

/**
 * @author Nathan
 */
public class ContatoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/contato.jsp");
        dispatcher.forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String mensagemErro = validaContato(req);
        
           if (mensagemErro == null){
               
               Contato contato = new Contato();
                
                try {
                    contato.setNome(req.getParameter("contato-nome"));
                    contato.setEmail(req.getParameter("contato-email"));
                    contato.setMensagem(req.getParameter("contato-mensagem"));
                    
                } catch (Exception e) {
                    req.setAttribute("contato", "Não foi possivel criar objeto contato");
            
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/contato.jsp");
                    dispatcher.forward(req, resp);
                }
                
                try {
                    JavaMailApp.sendEmail(contato);
                } catch (Exception e) {
                    
                    req.setAttribute("contato", "Não foi possivel enviar email");
            
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/contato.jsp");
                    dispatcher.forward(req, resp);
                }
            
                resp.sendRedirect("/veiculos/home");
           }
                
                
                
            /*} else {
                
                req.setAttribute("contato", mensagemErro);
            
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/contato.jsp");
                dispatcher.forward(req, resp);
            }*/
        
    }

    private String validaContato(HttpServletRequest req) {
        
        Calendar cal = GregorianCalendar.getInstance();
        
        if(!Validations.validaString(req.getParameter("contato-nome"), 5)){
                return "O nome deve conter no minimo 5 caracteres";
        }
        
        if(!Validations.validaString(req.getParameter("contato-email"), 10)){
            return "O email deve conter no minimo 10 caracteres";
        }
        
        if(!Validations.validaString(req.getParameter("contato-mensagem"), 10)){
            return "A mensagem tem que conter no minimo 10 caracteres";
        }
        
        return null;
    }
}
