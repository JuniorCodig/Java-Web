package br.grupointegrado.ads.sistema;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Nathan
 */

public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List <String> produtos = new ArrayList<>();
        produtos.add("adaptador HDMI para VGA");
        produtos.add("case para HD externo");
        produtos.add("cabo de rede ethernet RJ45");
   
        req.setAttribute("produtos", produtos);
        
        RequestDispatcher rq = req.getRequestDispatcher("/pagamento");
        
        rq.forward(req, resp);
    }
    
    
}
