/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.grupointegrado.ads.sistema;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nathan
 */
public class LoginServlet extends HttpServlet {
    
    private void imprimirFormularioLogin(HttpServletResponse resp, boolean erroLogin) throws IOException{
        resp.setContentType("text/html");
        
        PrintWriter conteudo = resp.getWriter();
        
        conteudo.println("<html>");
        conteudo.println("<head>");
        conteudo.println("<meta charset=\"utf-8\">");
        conteudo.println("<title>Pagina de Login</title>");
        conteudo.println("</head>");
        conteudo.println("<body>");
        conteudo.println("<h1>Informe os dados de Login</h1>");
        conteudo.println("<form method=\"POST\">");
        conteudo.println("<input type=\"text\" name=\"usuario\" placeholder=\"Usuario\">");
        conteudo.println("<br><br>");
        conteudo.println("<input type=\"password\" name=\"senha\" placeholder=\"senha\">");
        conteudo.println("<br><br>");
        if(erroLogin){
            conteudo.println("<p style=\"color: red\">Usuario ou senha incorretos.</p>");
        }
        conteudo.println("<button type=\"submit\">Entrar</button>");
        conteudo.println("</form>");
        conteudo.println("</body>");
        conteudo.println("</html>");
    }
        
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        imprimirFormularioLogin(resp, false);
    }
    
    private static final String USUARIO = "nathan";
    private static final String SENHA = "12345";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");*/
        String usuario = (String) req.getAttribute("usuario");
        String senha = (String) req.getAttribute("senha");
        
        if (USUARIO.equals(usuario) && SENHA.equals(senha)) {
            // acertou usuario e senha --
            
            HttpSession session = req.getSession();
            session.setAttribute("Usuario Logado", senha);
            
            //Cookie cookieLogin = new Cookie("cookie-login", "dsfa97as97d89asdf");
            //cookieLogin.setMaxAge(60 * 60 * 24);
            
            //resp.addCookie(cookieLogin);
            
            resp.sendRedirect("/Sistema/index.html");
        } else {
            // errou usuario ou senha --
            resp.sendError(401, "Usuario ou senha incorreto.");
            //imprimirFormularioLogin(resp, true);
        }
    }
    
}