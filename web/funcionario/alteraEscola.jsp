<%-- 
    Document   : alteraEscola
    Created on : May 18, 2016, 4:51:22 PM
    Author     : Danilo
--%>
<jsp:include page="header.jsp"/>

<jsp:useBean id="escola" scope="request" class="br.com.cantinasjuquinha.bean.Escola"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">
    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicEscola&metodo=editar"  method="post">
        <fieldset>
            <legend>Alteração do cadastro de Escola </legend>
            <table>                        
                <tr>
                    <td>Matrícula Escola:</td>
                    <td><input type="text" name="nome" value="${escola.getmatriculaEscola()}"></td>
                </tr>
                <tr>
                    <td>Nome Escola:</td>
                    <td><input type="text" name="cpf" value="${escola.getnomeEscola()}"></td>
                </tr>
                <tr>
                    <td>Endereço Escola:</td>
                    <td><input type="text" name="telefone" value="${escola.gettelefoneEscola()}"></td>
                </tr>
                <tr>
                    <td>Telefone Escola:</td>
                    <td><input type="text" name="endereco" value="${escola.getenderecoEscola()}"></td>
                </tr>
                <tr>
                    <td>Email Escola:</td>
                    <td><input type="text" name="email" value="${escola.getemailEscola()}"></td>
                </tr>
                <tr>
                    <td>Funcionario:</td>
                    <td><input type="text" name="email" value="${escola.funcionario}"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="enviar"></td>
                </tr>

            </table>     
        </fieldset>
    </form>
</body>
</html>
