<%-- 
    Document   : removeEscola
    Created on : 19/05/2016, 10:15:33
    Author     : Danilo
--%>

<jsp:include page="header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">
     <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicEscola&metodo=excluir"  method="post">
        <fieldset>
            <legend>Remo��o de Escola</legend>
            <table>                        
                <tr>
                    <td>Matricula Escola:</td>
                    <td><input type="text" name="matriculaescola"></td>
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

