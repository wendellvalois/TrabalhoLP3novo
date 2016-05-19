<%-- 
    Document   : removeResponsavel
    Created on : 19/05/2016, 10:15:33
    Author     : Danilo
--%>

<jsp:include page="header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">
     <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicResponsavel&metodo=excluir"  method="post">
        <fieldset>
            <legend>Remoção de Responsavel</legend>
            <table>                        
                <tr>
                    <td>CPF:</td>
                    <td><input type="text" name="cpf"></td>
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

