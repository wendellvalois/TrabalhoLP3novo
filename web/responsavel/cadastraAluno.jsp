<%-- 
    Document   : cadastraAluno
    Created on : May 20, 2016, 11:06:23 AM
    Author     : wendellvalois
--%>

<jsp:include page="header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">

    <!--
        <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicAlunoCadastrar"  method="post">
    -->     
    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicAluno&metodo=adicionar"  method="post">
        <fieldset>
            <legend>Cadastro de Aluno</legend>
            <table>       
                
                <tr>
                    <td>Aluno:</td>
                    <td><input type="text" name="nome"></td>
                </tr>
                <tr>
                    <td>Matricula:</td>
                    <td><input type="text" name="matricula"></td>
                </tr>
                <tr>
                    <td>Turma:</td>
                    <td><input type="text" name="turma"></td>
                </tr>
                <tr>
                    <td>Turno:</td>
                    <td><input type="text" name="turno"></td>
                </tr>
                <!-- <tr>
                    <td>CPF Responsavel:</td>
                    <td><input type="text" name="responsavel"></td>
                </tr>
                            !-->
                <tr>
                    <td>Login de usuario:</td>
                    <td><input type="text" name="login"></td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input type="password" name="senha"></td>
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
