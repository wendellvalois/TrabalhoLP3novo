<jsp:include page="/header.jsp"/>

<jsp:useBean id="pessoa" scope="session" class="br.com.senacrs.bean.Pessoa"/>

<c:if test="${not empty pessoa.nome}">
    Nome: ${pessoa.nome} 
    ${pessoa.sobrenome} <br>
</c:if>

Rua: ${pessoa.endereco.rua}<br>
Bairro: ${pessoa.endereco.bairro} <br>
CEP: ${pessoa.endereco.cep} <br>

<jsp:include page="/footer.jsp"/>
