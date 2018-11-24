<%@page import="nathan.ads.gerenciadorDeVeiculos.models.Veiculo"%>
<%@page import="nathan.ads.gerenciadorDeVeiculos.models.Categoria"%>
<%@page import="java.util.List"%>

<%
    List<Veiculo> veiculos = (List) request.getAttribute("veiculos");
    
    List<Categoria> categorias = (List) request.getAttribute("categorias");
    
    String buscarVeiculos = request.getParameter("buscar-veiculo");
    
    String mensagemErro = (String) request.getAttribute("mensagem-erro");
%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Anúncios de Veículos</title>

    <link rel="stylesheet" type="text/css" href="css/fontawesome.all.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style-default.css">
    <link rel="stylesheet" type="text/css" href="css/style-index.css">

    <script>
        function abrirAnuncio(anuncioId) {
            window.location = "anuncio.html?anuncio=" + anuncioId;
        }
    </script>
</head>

<body>
    <header>
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <a class="navbar-brand" href="index">SoCarrinhos</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index">Início</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="anunciar">Anunciar</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contato">Contato</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    
    <main class="container-fluid">
        <div class="conteudo col-sm-12 col-md-11 col-lg-10">
        <%
            if (mensagemErro != null){
        %>
            <div class="alert alert-danger" role="alert">
                <%= mensagemErro%>
            </div>
        <%
            }
        %>
            <div class="row">
                <div class="menu-esquerdo col-md-auto">
                    <nav>
                        <form>
                            <div class="input-group input-group-sm mb-3">
                                <input type="text" class="form-control" name="buscar-veiculo" value="<%= buscarVeiculos%>" placeholder="Busca por palavras chave"
                                    aria-label="Busca por palavras chave" aria-describedby="button-search">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-primary" title="Buscar" type="submit" id="button-search">
                                        <i class="fas fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                        <%
                            for(Categoria c : categorias) {
                        %>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <a href="?categoria=<%= c.getCategoriaId() %>"><%= c.getCategoriaNome() %></a>
                            </li>
                        </ul>
                        <% } %>
                    </nav>
                </div>
                
                <div class="col">
                    <h3>Veículos anunciados</h3>
                    <table class="table table-hover">
                    
                    <% for (Veiculo v : veiculos) { %>
                        <tr class="tabela-veiculos-linha" onclick="abrirAnuncio(<%= v.getVeiculoId()%>)">
                            <td class="tv-col-imagem">
                                <img src="imagem?caminho=<%= v.getImgVeiculo() %>">
                            </td>
                            <td class="informacoes-anuncio">
                                <div class="row">
                                    <div class="col descricao-anuncio">
                                        <p>
                                            <%= v.getNomeVeiculo() %> 
                                        </p>
                                        <p>
                                            Ano - <%= v.getAnoModelo() %> 
                                        </p> 
                                        <p>
                                            Quilimotragem - <%= v.getKmVeiculo() %>
                                        </p>
                                        <p>
                                            Combustivel - <%= v.getTipoCombustivel()%>
                                        </p>
                                    </div>
                                    <div class="col-sm-auto valor-anuncio">
                                        <p> R$ <%= v.getValorVeiculo() %></p>
                                    </div>
                                    <div class="col-sm-auto data-hora-anuncio">
                                        <p>
                                            <%= v.getDataHora() %>
                                        </p>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <% } %>
                    </table>   
                </div>
            </div>
        </div>
    </main>