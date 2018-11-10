<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem-Vindo a Pagina JSP</title>
    </head>
    <body>
        <h1>
            <%
              out.println("Olá Mundo!");
            %>
        </h1>
        
            <%!
                private String getDataAtual(){
                    return new Date().toString();
                }
            %>
        <% 
            String nome = request.getParameter("nome");
            if (nome != null){
        %>
        <h2>
            Olá <%= nome %>, seja bem vindo ao nosso site!
        </h2>
        
        <% 
            }else{
        %>
        <h2>Olá visitante</h2>
        <%
            }
        %>
        <h3>
            Hora data atual: <%= getDataAtual() %>
        </h3>
    </body>
</html>
