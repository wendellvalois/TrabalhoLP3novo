<%-- 
    Document   : cadastraEscolaConf
    Created on : May 20, 2016, 12:01:54 PM
    Author     : wendellvalois
--%>

<link rel="stylesheet" type="text/css" href="../estiloprincipal.css">
<jsp:include page="header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">

<jsp:useBean id="escola" scope="session" class="br.com.cantinasjuquinha.bean.Escola"/> 
<jsp:setProperty property="*" name="escola"/>
        <h1>Operação bem sucedida!</h1>
         
        <p>A escola
            ${escola.getnomeEscola()} foi cadastrado com sucesso
        </p>
    </body>
</html>
