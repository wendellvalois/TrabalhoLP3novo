<%-- 
    Document   : cadastraresponsavel
    Created on : May 15, 2016, 12:26:11 AM
    Author     : wendellvalois
--%>
<link rel="stylesheet" type="text/css" href="../estiloprincipal.css">
<jsp:include page="header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">

    <!--
        <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicResponsavelCadastrar"  method="post">
    -->     
    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicResponsavel&metodo=adicionar"  method="post">
        <fieldset>
            <legend>Cadastro de Responsavel</legend>
            <table>                        
                <tr>
                    <td>Responsavel:</td>
                    <td><input type="text" name="nome"></td>
                </tr>
                <tr>
                    <td>CPF:</td>
                    <td><input type="text" name="cpf"></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="telefone"></td>
                </tr>
                <tr>
                    <td>Endereço:</td>
                    <td><input type="text" name="endereco"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>Login de usuario:</td>
                    <td><input type="text" name="novologin"></td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input type="password" name="novasenha"></td>
                </tr>
                <tr>
                    <td>Confirmação de senha</td>
                    <td><input type="password" name="confimasenha"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="enviar"></td>
                </tr>

            </table>     
        </fieldset>
    </form>


</section>

</body>
</html>
