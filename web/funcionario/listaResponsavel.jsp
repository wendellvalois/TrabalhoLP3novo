<%-- 
    Document   : listaResponsavel
    Created on : May 20, 2016, 6:07:55 PM
    Author     : wendellvalois
--%>


<jsp:include page="header.jsp"/>
<link rel="stylesheet" type="text/css" href="estiloprincipal.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="responsavel" scope="session" class="br.com.cantinasjuquinha.bean.Responsavel"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">



<table border="1">
    <thead>
        <tr>
            <th>CPF</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Email</th>
            <th>Endereço</th>
            <th>Login</th>
            <th>Senha</th>
            <th colspan="2">Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${responsaveis}" var="responsavel">
            <tr>
                <td>${responsavel.cpf}</td>
                <td>${responsavel.nome}</td>
                <td>${responsavel.telefone}</td>
                <td>${responsavel.email}</td>
                <td>${responsavel.endereco}</td>
                <td>${responsavel.login}</td>
                <td>${responsavel.senha}</td>

                <td><a href="/TrabalhoLP3novo/Controller?classe=ControllerLogicResponsavel&metodo=editarPopular&cpf=${responsavel.cpf}">Editar</a></td>
                <td><a href="/TrabalhoLP3novo/Controller?classe=ControllerLogicResponsavel&metodo=excluir&cpf=${responsavel.cpf}">Excluir</a></td>
            </tr>
        </c:forEach>


    </tbody>
</table>

<jsp:include page="/footer.jsp"/>

