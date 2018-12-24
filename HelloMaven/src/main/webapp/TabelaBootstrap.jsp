<%-- 
    Document   : TabelaBootstrap
    Created on : 07/04/2018, 10:24:43
    Author     : Andre
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
    <head>
        <title>Tabela do FormAluno</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" >
    </head>
    <body class="bg-light">
		<table class="table table-striped table-bordered">
                    <thead class="thead-dark">
			<tr>
				<th>Aluno</th>
				<th>Prova 1</th>
				<th>Trabalho</th>
				<th>Projeto Aula</th>
				<th>Prova Final</th>
				<th>Situação</th>
			</tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty ListaAlunos}">
                            <c:forEach items="${ListaAlunos}" var="aluno">
                                <tr>

                                    <td class="table-primary">${aluno.nome}</td>
                                    <td>${aluno.p1}</td>
                                    <td>${aluno.tr}</td>
                                    <td>${aluno.pj}</td>
                                    <td>${aluno.pf}</td>
                                    <c:choose>
                                        <c:when test="${aluno.situacao eq 'Reprovado direto'}">
                                            <td class="table-danger">${aluno.situacao}</td>
                                        </c:when>
                                        <c:when test="${aluno.situacao eq 'Reprovado final'}">
                                            <td class="table-danger">${aluno.situacao}</td>
                                        </c:when>
                                        <c:when test="${aluno.situacao eq 'Reprovado por falta'}">
                                            <td class="table-warning">${aluno.situacao}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td class="table-success">${aluno.situacao}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                </tr>  
                                
                            </c:forEach>
                            
                        </c:if>
                   </tbody>     
		</table>
                <script src="js/jquery-3.2.1.slim.min.js" ></script>
                <script src="js/popper.min.js" ></script>
                <script src="js/bootstrap.min.js"></script> 
	</body>
</html>
