<%-- 
    Document   : cadastro
    Created on : 19/03/2018, 06:17:50
    Author     : leome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastro</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h1>Cadastro</h1><br>
            <c:url var="context" value="${action}"></c:url>
                <!--    
                <div class="form-group row">
                        <label for="nome" class="col-sm-2 col-form-label">Nome</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="nome" placeholder="">
                        </div>-->
                <form action = "${context}" method ="POST">
                <input type="hidden" name="id" value="${produto.id}">

                <div class="form-group row">
                    <label for="nome" class="col-md-2 col-form-label">Nome</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="nome" name="nome" value="${produto.nome}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="descricao" class="col-md-2 col-form-label">Descrição</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="descricao" name="descricao" value="${produto.descricao}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="preco-compra" class="col-md-2 col-form-label">Preço de Compra</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="preco_compra" name="preco_compra" value="${produto.precoCompra}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="preco-venda" class="col-md-2 col-form-label">Preço de Venda</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="preco_venda" name="preco_venda" value="${produto.precoVenda}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="quantidade" class="col-md-2 col-form-label">Quantidade</label>
                    <div class="col-md-10">
                        <input type="number" class="form-control" id="quantidade" name="quantidade" value="${produto.quantidade}" min="0" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="categorias">Categorias</label>
                    <select multiple class="form-group" id="categorias" name="categorias">
                        <c:forEach items="${categorias}" var="categoria">
                            <c:set var="cont" value="false" />
                            <c:forEach items ="${produto.categorias}" var ="prodCategoria">
                                <c:if test="${prodCategoria.id eq categoria.id}">
                                    <c:set var="cont" value="true"/>
                                </c:if>
                            </c:forEach>
                            <c:if test="${cont}">
                                <option value="${categoria.id}" selected>
                                    <c:out value="${categoria.nome}" />
                                </option>
                            </c:if>
                            <c:if test="${not cont}">
                                <option value="${categoria.id}">
                                    <c:out value="${categoria.nome}" />
                                </option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>  
                <div class="form-group row">
                    <div class="col-md-10 offset-sm-2">
                        <button type="submit" class="btn btn-success">Salvar</button>
                    </div>
                </div>   
            </form>
            <c:url var="listar" value="/ProjetoDSW" />
            <a href="${listar}" class="btn btn-link">Voltar</a>
            
            <!--    
            </div>
                    <div class="form-group row">
                    <label for="desc" class="col-sm-2 col-form-label">Descrição</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="desc" placeholder="">
                        </div>
                    </div>
                    <div class="form-group row">
                            <label for="quantidade" class="col-sm-2 col-form-label">Quantidade</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="quantidade" placeholder="0">
                        </div>
                    </div>
                    <div class="form-group row">
                            <label for="pCompra" class="col-sm-2 col-form-label">Preço de Compra</label>
                        <div class="col-sm-10">
                            <input type="number" min="0.00" step="0.05" class="form-control" id="pCompra" placeholder="0.00">
                        </div>
                    </div>
                    <div class="form-group row">
                            <label for="pVenda" class="col-sm-2 col-form-label">Preço de Venda</label>
                        <div class="col-sm-10">
                            <input type="number" min="0.00" step="0.05" class="form-control" id="pVenda" placeholder="0.00">
                        </div>
                    </div>
                    
                    <div class="form-group row">
                        <div class="col-sm-2">Checkbox</div>
                            <div class="col-sm-10">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="gridCheck1">
                                    <label class="form-check-label" for="gridCheck1">
                                        Cat Um
                                    </label><br>
                                    <input class="form-check-input" type="checkbox" id="gridCheck2">
                                    <label class="form-check-label" for="gridCheck1">
                                        Cat Dois
                                    </label><br>
                                    <input class="form-check-input" type="checkbox" id="gridCheck3">
                                    <label class="form-check-label" for="gridCheck1">
                                        Cat Três
                                    </label><br>
                                    <input class="form-check-input" type="checkbox" id="gridCheck4">
                                    <label class="form-check-label" for="gridCheck1">
                                        Cat Quatro
                                    </label><br>
                                    <input class="form-check-input" type="checkbox" id="gridCheck5">
                                    <label class="form-check-label" for="gridCheck1">
                                        Cat Cinco
                                    </label><br>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-success">Cadastrar</button>
                        </div>
                        <a class="btn btn-light" href="#" role="button">Voltar</a>
                    </div>
                </form>
        </div> -->
    </body>
</html>
