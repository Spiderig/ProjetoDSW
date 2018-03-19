<%-- 
    Document   : lista
    Created on : 19/03/2018, 11:36:00
    Author     : Igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Lista</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
         <c:url var="detalhe" value="/ProjetoDSW?id="></c:url>
    </head>
    <body>
        <main class="container">
             <div class="d-flex align-items-center justify-content-between">
                <h1 class="d-inline-flex mt-4 mb-2">Lista Produtos</h1>
                <a class="btn btn-primary" href="ProjetoDSW/cadastro">Novo Produto</a>
            </div>
             <div class="row">
                <c:forEach items="${produtos}" var="produto">
                    <div class="col-md-3 mb-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title"><c:out value="${produto.nome}"></c:out></h5>
                                <p class="card-text"><c:out value="${produto.descricao}"></c:out></p>
                                <a href="${detalhes}${produto.id}" class="btn btn-primary">Detalhes</a>
                            </div>
                            <div class="card-footer text-muted">
                                <c:out value="${produto.dtCadastro}"></c:out>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </main>
    </body>
</html>
