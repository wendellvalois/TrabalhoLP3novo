<jsp:include page="/header.jsp" />
        
<jsp:useBean id="pessoa" scope="session" class="br.com.senacrs.bean.Pessoa" />

<form name="formulario" action="/Pessoa_Polimorfico/Controller?classe=ControllerLogicPessoaEditar" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th> Alteração no cadastro de Pessoa </th>                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nome: </td>
                        <td> <input type="text" name="nome" value="${pessoa.nome}" size="30" /> </td>
                    </tr>
                    <tr>
                        <td> Sobrenome: </td>
                        <td> <input type="text" name="sobrenome" value="${pessoa.sobrenome}" size="30" /> </td>
                    </tr>
                    <tr>
                        <td>Rua: </td>
                        <td> <input type="text" name="rua" value="${pessoa.endereco.rua}" size="30" /> </td>
                    </tr>
                    <tr>
                        <td> Bairro: </td>
                        <td> <input type="text" name="bairro" value="${pessoa.endereco.bairro}" size="30" /> </td>
                    </tr>
                    <tr>
                        <td>CEP: </td>
                        <td> <input type="text" name="cep" value="${pessoa.endereco.cep}" size="30" /> </td>
                    </tr>
                    <tr>
                        <td> <input type="submit" value="Salvar" name="enviar" /> </td>
                        <td> <input type="reset" value="Limpar" name="limpar" /> </td>
                    </tr>
                </tbody>
            </table>            
            
        </form>

<jsp:include page="/footer.jsp" />