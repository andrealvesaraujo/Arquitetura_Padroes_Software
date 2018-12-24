<%-- 
    Document   : index
    Created on : 07/04/2018, 10:23:30
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="selects" uri="WEB-INF/selects.tld"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trabalho</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" >
    </head>
    <body class="bg-light ">
        <form action="ValidarFormulario" method="POST">
            <div class="container ">
                <h2 class="bg-primary text-center">Formulario padrão</h2>
                <h3 class="text-warning text-center">${requestScope.ErroGeral}</h3>

                <div class="form-group form-control-sm col-md-12">
                        <h5 class="text-danger">${requestScope.ErroFormatoNome}</h5>
                        <h5 class="text-warning">${requestScope.ErroNome}</h5>

                        <label for="nome" class="text-dark">Nome Completo do Aluno:</label>
                        <input class="form-control" id="nome" type="text" name="nome" value="${nome}" ><br>
                </div>

                <div class="row">
                    <div class="col col-md-6 ">
                            <h5 class="text-danger">${ErroP1}</h5>
                            <h5 class="text-warning">${ErroFormatoP1}</h5>
                            <label for="prova1" >P1:</label>
                            <input  class="form-control" id="prova1" type="text" name="prova1" value="${requestScope.p1}"><br>
                    </div>
                    <br>
                    <br>
                    <div class="col col-md-6">
                             <h5 class="text-danger">${requestScope.ErroTR}</h5>
                             <h5 class="text-warning">${requestScope.ErroFormatoTR}</h5>
                            <label for="trabalho">Trabalho:</label>
                            <input class="form-control" id="trabalho"  type="text" name="trabalho" value="${requestScope.tr}"><br>
                    </div>

                    <br>
                </div>
                <div class="row">    

                    <div class="col col-md-6">
                             <h5 class="text-danger">${requestScope.ErroPJ}</h5>
                             <h5 class="text-warning">${requestScope.ErroFormatoPJ}</h5>
                            <label for="projetoaula">Projeto Aula:</label>
                            <input class="form-control" id="projetoaula" type="text" name="projetoaula" value="${requestScope.pj}"><br>
                    </div>
                    <br>

                    <div class="col col-md-6">
                            <h5 class="text-danger">${requestScope.ErroFR}</h5>
                            <h5 class="text-warning">${requestScope.ErroFormatoFR}</h5>
                            <label for="freq">Frequência:</label>
                            <input class="form-control" id="freq" type="text" name="freq" value="${requestScope.fr}"><br>
                    </div>
                    <br>
                </div>
                <div class="row">              
                    
                    
                    <div class="form-group col-md-6">
                            <h5 class="text-danger">${requestScope.ErroPF}</h5>
                            <h5 class="text-warning">${requestScope.ErroFormatoPF}</h5>
                            <label for="pf">Prova Final:</label>
                            <input  class="form-control" id="pf" type="text" name="pf" value="${requestScope.pf}"><br>
                    </div>
                    
                </div>
                    <div class="text-center">
                        <input class="btn btn-info btn-md text-center btn-sm"   type="submit" value="Enviar formulario para a tabela">
                    </div>
            </div>    
        </form>
        <script src="js/jquery-3.2.1.slim.min.js" ></script>
        <script src="js/popper.min.js" ></script>
        <script src="js/bootstrap.min.js"></script>     
    </body>
</html>