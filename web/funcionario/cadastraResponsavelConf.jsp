<%-- 
    Document   : cadastraResponsavelConf
    Created on : May 15, 2016, 10:17:46 PM
    Author     : wendellvalois
--%>

<jsp:include page="header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">

<jsp:useBean id="responsavel" scope="session" class="br.com.cantinasjuquinha.bean.Responsavel"/> 
<jsp:setProperty property="*" name="responsavel"/>
        <h1>Operação bem sucedida!</h1>
         
        <p>O responsavel:
            ${responsavel.nome} foi cadastrado com sucesso
        </p>
    </body>
</html>
