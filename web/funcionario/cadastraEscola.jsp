<%-- 
    Document   : cadastraEscola
    Created on : 20/05/2016, 10:39:24
    Author     : Danilo
--%>

<link rel="stylesheet" type="text/css" href="../estiloprincipal.css">
<jsp:include page="header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">

    <!--
        <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicEscolaCadastrar"  method="post">
    -->     
    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicEscola&metodo=adicionar"  method="post">
        <fieldset>
            <legend>Cadastro de Escola</legend>
            <table>                        
                <tr>
                    <td>Matricula Escola:</td>
                    <td><input type="text" name="matriculaescola"></td>
                </tr>
                <tr>
                    <td>Nome Escola:</td>
                    <td><input type="text" name="nomeescola"></td>
                </tr>
                <tr>
                    <td>Endereco Escola:</td>
                    <td><input type="text" name="enderecoescola"></td>
                </tr>
                <tr>
                    <td>Telefone Escola:</td>
                    <td><input type="text" name="telefoneescola"></td>
                </tr>
                <tr>
                    <td>Email Escola:</td>
                    <td><input type="text" name="emailescola"></td>
                </tr>
                <tr>
                    <td>Funcionario:</td>
                    <td><input type="text" name="funcionario"></td>
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
