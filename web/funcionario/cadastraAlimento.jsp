<%-- 
    Document   : cadastraresponsavel
    Created on : May 15, 2016, 12:26:11 AM
    Author     : wendellvalois
--%>

<jsp:include page="header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">

    <!--
        <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicResponsavelCadastrar"  method="post">
    -->     
    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicProduto&metodo=adicionar"  method="post">
        <fieldset>
            <legend>Cadastro de Responsavel</legend>
            <table>                 
   
                

                <tr>
                    <td>Codigo de Produto:</td>
                    <td><input type="text" name="codigo"></td>
                </tr>
                <tr>
                    <td>Preço:</td>
                    <td><input type="text" name="preco"></td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nome"></td>
                </tr>
                <tr>
                    <td>Ingredientes:</td>
                    <td><input type="text" name="ingredientes"></td>
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
