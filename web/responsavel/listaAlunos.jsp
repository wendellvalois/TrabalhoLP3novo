<%-- 
    Document   : listaAlunos
    Created on : May 20, 2016, 6:07:55 PM
    Author     : wendellvalois
--%>


<jsp:include page="header.jsp"/>
<link rel="stylesheet" type="text/css" href="/TrabalhoLP3novo/tabelalista.css">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="aluno" scope="session" class="br.com.cantinasjuquinha.bean.Aluno"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">



<table>
    <thead>
        <tr>
            <th>Matricula</th>
            <th>Nome</th>
            <th>Turma</th>
            <th>Turno</th>
            <th>Saldo</th>

            <th colspan="2">Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${alunos}" var="aluno">
            <tr>
                <td>${aluno.matricula}</td>
                <td>${aluno.nome}</td>
                <td>${aluno.turma}</td>
                <td>${aluno.turno}</td>
                <td>${aluno.saldo}</td>


                <td><a href="/TrabalhoLP3novo/Controller?classe=ControllerLogicAluno&metodo=editarPopular&matricula=${aluno.matricula}">Dar dinheiro</a></td>
                <!-- <td><a href="/TrabalhoLP3novo/Controller?classe=ControllerLogicAluno&metodo=excluir&cpf=${aluno.matricula}">Excluir</a></td> !-->
            </tr>
        </c:forEach>


    </tbody>
</table>

<jsp:include page="/footer.jsp"/>

