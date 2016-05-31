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

                <li><a href="/TrabalhoLP3novo/responsavel/paginainicial.jsp">Home</a></li>



            </ul>
        </nav>
        <div id="nav-left">
            <ul>
                <li><a href="/TrabalhoLP3novo/responsavel/cadastraAluno.jsp">Cadastrar Aluno</a></li>
                <li><a href="/TrabalhoLP3novo/Controller?classe=ControllerLogicAluno&metodo=listar">Listar Alunos</a></li>


            </ul>



        </div>
    </body>
</html>