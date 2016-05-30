<%-- 
    Document   : cadastraAlunoConf
    Created on : May 15, 2016, 10:17:46 PM
    Author     : wendellvalois
--%>
<link rel="stylesheet" type="text/css" href="../estiloprincipal.css">
<jsp:include page="../responsavel/header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">

<jsp:useBean id="aluno" scope="session" class="br.com.cantinasjuquinha.bean.Aluno"/> 
<jsp:setProperty property="*" name="aluno"/>
        <h1>Operação bem sucedida!</h1>
         
        <p>O aluno:
            ${aluno.nome} foi cadastrado com sucesso
        </p>
    </body>
</html>
