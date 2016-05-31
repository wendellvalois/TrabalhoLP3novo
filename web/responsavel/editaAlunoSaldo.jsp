<%-- 
    Document   : editaAluno
    Created on : May 18, 2016, 4:51:22 PM
    Author     : wendellvalois
--%>
<jsp:include page="header.jsp"/>
<link rel="stylesheet" type="text/css" href="estiloprincipal.css">

<jsp:useBean id="aluno" scope="request" class="br.com.cantinasjuquinha.bean.Aluno"/>


<section style="margin-left:25%;padding:1px 16px;height:1000px;">
    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicAluno&metodo=editar&matricula=${aluno.matricula}&saldo=${aluno.saldo}"  method="post">
        <fieldset>
            <legend>Alteração do cadastro de Aluno </legend>
            <table>                        
                <tr>
                    <td>Aluno:</td>
                    <td>${aluno.nome}</td>
                </tr>
                <tr>
                    <td>Matricula:</td>
                    <td>${aluno.matricula}</td>
                </tr>
                <tr>
                    <td>Turma:</td>
                    <td>${aluno.turma}</td>
                </tr>
                <tr>
                    <td>Turno</td>
                    <td>${aluno.turno}</td>
                </tr>
                <tr>
                    <td>Saldo</td>
                    <td>${aluno.saldo}</td>
                </tr>
                <td>Valor a ser acrescentado</td>
                <td><input type="text" name="valor"></td>
                </tr>


                <tr>
                    <td><input type="submit" value="enviar"></td>
                </tr>

            </table>     
        </fieldset>
    </form>
</body>
</html>
