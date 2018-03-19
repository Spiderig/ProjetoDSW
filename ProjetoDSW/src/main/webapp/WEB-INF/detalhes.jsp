<%-- 
    Document   : detalhes
    Created on : 19/03/2018, 11:42:52
    Author     : Igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Detalhes</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    </head>
    <body>
        <main class="container">
            <div class="d-flex justify-content-between align-items-center">
                <h1 class="d-inline-flex mt-4 mb-2">Detalhes Produto</h1>
                <c:url var="deletar" value="/ProjetoDSW/deletar?id=${produto.id}" ></c:url>
                <form action="${deletar}" method="POST">
                    <input type="hidden" value="${produro.id}" name="id">
                    <button type="submit" class="btn btn-danger">Deletar</button>
                </form>
            </div>
            <p>
                <strong>Nome: </strong>
            <c:out value="${produto.nome}"></c:out>
        </p>

        <p>
            <strong>Descrição: </strong>
        <c:out value="${produto.descricao}"></c:out>
    </p>

    <p>
        <strong>Preço Compra: </strong>
        R$ <c:out value="${produto.precoCompra}"></c:out>
</p>

<p>
    <strong>Preço Venda: </strong>
    R$ <c:out value="${produto.precoVenda}"></c:out>
</p>

<p>
    <strong>Quantidade: </strong>
<c:out value="${produto.quantidade}"></c:out>
</p>

<p>
    <strong>Data de Cadastro: </strong>
<c:out value="${produto.dtCadastro}"></c:out>
</p>

<p>
    <strong>Categorias: </strong>
<c:forEach items="${produto.categorias}" var="categoria">
    <span class="badge badge-primary p-2"> 
        <c:out value="${categoria.nome}"></c:out>
    </span>
</c:forEach>
</p>

<div class="d-flex justify-content-between">
    <c:url var="listar" value="/ProjetoDSW" ></c:url>
    <a href="${listar}" class="btn btn-link">Voltar</a>
    <c:url var="editar" value="/ProjetoDSW/editar?id=${produto.id}" ></c:url>
    <a href="${editar}" class="btn btn-success">Editar</a>
</div>

</main>
</body>
</html>
