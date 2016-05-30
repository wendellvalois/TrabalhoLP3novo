<%-- 
    Document   : header
    Created on : May 15, 2016, 10:03:09 PM
    Author     : wendellvalois
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cantinas Juquinha</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/TrabalhoLP3novo/estiloprincipal.css">

    </head>
    <body>

        <header>

            <img src="/TrabalhoLP3novo/images/logo.png" height="100" alt="logo"> 
            <h1 style="font-family:fantasy ">Cantinas Juquinha</h1>

        </header>
        <nav id="nav">
            <ul>

                <li><a href="paginainicial.jsp">Home</a></li>


                <li><a href="#about">Sobre</a></li>
            </ul>
        </nav>
        <div id="nav-left">
            <ul>
                <li><a href="/TrabalhoLP3novo/funcionario/cadastraResponsavel.jsp">Cadastrar Responsavel</a></li>
                <li><a href="/TrabalhoLP3novo/Controller?classe=ControllerLogicResponsavel&metodo=listar">Listar Responsáveis</a></li>
                
                <!--
                <li><a href="cadastraEscola.jsp">Cadastrar Escola</a></li>
                <li><a href="alteraEscola.jsp">Alterar Escola</a></li>
                <li><a href="removeEscola.jsp">Remover Escola</a></li>
                !-->
                
                <li><a href="cadastraProduto.jsp">Cadastrar Produto</a></li>
               <!-- <li><a href="cadastraAluno">Cadastrar Aluno</a></li> !-->

                
                <li><a href="alteraProduto.jsp">Alterar Produto</a></li>
               <!-- <li><a href="alteraAluno.jsp">Alterar Aluno</a></li> !-->
               
 
                <li><a href="removeProduto.jsp">Remover Produto</a></li>
                
             
                <li><a href="consultarSaldoAluno.jsp">Consultar Saldo de Aluno</a></li>
                
            </ul>
        </div>
