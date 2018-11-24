<%@page import="nathan.ads.gerenciadorDeVeiculos.models.Contato"%>
<%@page import="nathan.ads.gerenciadorDeVeiculos.utils.JavaMailApp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    JavaMailApp enviarMail = new JavaMailApp();
            
    String mensagemErro = (String) request.getAttribute("contato");
%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Contato</title>
    
    <link rel="stylesheet" type="text/css" href="css/fontawesome.all.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style-default.css">
    <link rel="stylesheet" type="text/css" href="css/style-contato.css">
    
    <script src="js/validations.js"></script>
    
    <script>
        function validarFormulario() {
            var inputNome = document['form-contato']['contato-nome'];
            var inputEmail = document['form-contato']['contato-email'];
            var inputMensagem = document['form-contato']['contato-mensagem'];
            
            var formValido = true;
                        
            if(!validaString(inputNome.value, 5)) {
                formValido = false;
                inputNome.classList.add('is-invalid');
                inputNome.classList.remove('is-valid');
            }else{
                inputNome.classList.remove('is-invalid');
                inputNome.classList.add('is-valid');
            }
            
            if(!validaString(inputEmail.value, 10)) {
                formValido = false;
                inputEmail.classList.add('is-invalid');
                inputEmail.classList.remove('is-valid');
            }else{
                inputEmail.classList.remove('is-invalid');
                inputEmail.classList.add('is-valid');
            }
            
            if(!validaString(inputMensagem.value, 10)) {
                formValido = false;
                inputMensagem.classList.add('is-invalid');
                inputMensagem.classList.remove('is-valid');
            }else{
                inputMensagem.classList.remove('is-invalid');
                inputMensagem.classList.add('is-valid');
            }
            
            return formValido;
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
                    <li class="nav-item">
                        <a class="nav-link" href="index">Início</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="anunciar">Anunciar</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="contato">Contato</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <main class="container-fluid">
        <div class="conteudo col-sm-12 col-md-11 col-lg-10">
            <h3>Preencha o formulário para entrar em contato com a SoCarrinhos Veículos.</h3>
                <%
                    if (mensagemErro != null){
                %>
                <div class="alert alert-danger" role="alert">
                    <%= mensagemErro%>
                </div>
                <%
                    }
                %>
            <div class="dropdown-divider"></div>

            <form name="form-contato" method="POST" onsubmit="return validarFormulario()">

                <div class="form-row">
                    <div class="col-md-8 col-lg-7 col-xl-6">
                        <div class="form-group">
                            <label for="contato-nome">Nome completo</label>
                            <input type="text" class="form-control" name="contato-nome" id="contato-nome" placeholder="Seu nome">
                            <div class="invalid-feedback">
                                Informe seu nome completo.
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="col-md-8 col-lg-7 col-xl-6">
                        <div class="form-group">
                            <label for="contato-email">E-mail</label>
                            <input type="email" class="form-control" name="contato-email" id="contato-email" placeholder="Seu e-mail" value="">
                            
                            <div class="invalid-feedback">
                                Informe seu e-mail de contato.
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-row">
                    <div class="col-lg-8 col-xl-7">
                        <div class="form-group">
                            <label for="contato-mensagem">Mensagem</label>
                            <textarea class="form-control" name="contato-mensagem" id="contato-mensagem" placeholder="Escreva sua mensagem aqui..."></textarea>
                            <div class="invalid-feedback">
                                Informe sua mensagem.
                            </div>
                        </div>
                    </div>
                </div>

                <a href="index" class="btn" >Cancelar</a>
                <button type="submit" class="btn btn-primary">
                    Enviar
                </button>

            </form>

        </div>
    </main>

    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts-default.js"></script>
</body>

</html>
