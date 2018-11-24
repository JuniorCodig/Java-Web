<%@page import="javax.swing.JOptionPane"%>
<%@page import="nathan.ads.gerenciadorDeVeiculos.models.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="nathan.ads.gerenciadorDeVeiculos.models.Veiculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Veiculo veiculo =  new Veiculo();
    
      if (request.getAttribute("result") != null) {
            veiculo = (Veiculo) request.getAttribute("result");
      }
%>


<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Anuncio</title>

    <link rel="stylesheet" type="text/css" href="css/fontawesome.all.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style-default.css">
    <link rel="stylesheet" type="text/css" href="css/style-anuncio.css">
    
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
                    <li class="nav-item">
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
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index">Veículos</a></li>
                    <li class="breadcrumb-item"><a href="index?categoria=">amosdoa</a></li>
                </ol>
            </nav>
            
            <h3><%= veiculo.getNomeVeiculo() %></h3>
            <div class="dropdown-divider"></div>

            <div class="row">
                <div class="col-md-6 mb-4">
                    <img src="imagem?caminho=<%= veiculo.getImgVeiculo() %>" class="rounded float-left veiculo-imagem">
                </div>
                <div class="col-md-6 mb-3">
                    <div class="veiculo-valor rounded mb-2">
                        <span>R$ <%= veiculo.getValorVeiculo()%></span>
                    </div>
                    <div>
                        <strong>Ano:</strong>
                        <span><%= veiculo.getAnoFabricacao() %>/<%= veiculo.getAnoModelo() %></span>
                    </div>
                    <div>
                        <strong>Quilometragem:</strong>
                        <span><%= veiculo.getKmVeiculo() %></span>
                    </div>
                    <div>
                        <strong>Combustível:</strong>
                        <span><%= veiculo.getTipoCombustivel() %></span>
                    </div>
                </div>
            </div>

            <h4>Descrição</h4>

            <div class="row">
                <div class="col">
                    <%= veiculo.getDescricao() %>
                </div>
            </div>
    </main>
    
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts-default.js"></script>
    
</body>

</html>
