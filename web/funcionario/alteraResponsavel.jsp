<%-- 
    Document   : alteraResponsavel
    Created on : May 18, 2016, 4:51:22 PM
    Author     : wendellvalois
--%>
<jsp:include page="header.jsp"/>

<jsp:useBean id="responsavel" scope="request" class="br.com.cantinasjuquinha.bean.Responsavel"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">
    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicResponsavel&metodo=editar"  method="post">
        <fieldset>
            <legend>Alteração do cadastro de Responsavel </legend>
            <table>                        
                <tr>
                    <td>Responsavel:</td>
                    <td><input type="text" name="nome" value="${responsavel.nome}"></td>
                </tr>
                <tr>
                    <td>CPF:</td>
                    <td><input type="text" name="cpf" value="${responsavel.cpf}"></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="telefone" value="${responsavel.telefone}"></td>
                </tr>
                <tr>
                    <td>Endereço:</td>
                    <td><input type="text" name="endereco" value="${responsavel.endereco}"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" value="${responsavel.email}"></td>
                </tr>


                <tr>
                    <td><input type="submit" value="enviar"></td>
                </tr>

            </table>     
        </fieldset>
    </form>
</body>
</html>
