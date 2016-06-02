

<jsp:include page="header.jsp"/>

<section style="margin-left:25%;padding:1px 16px;height:1000px;">
    
    <jsp:useBean id="aluno" scope="request" class="br.com.cantinasjuquinha.bean.Aluno"/>
       <fieldset>
            <legend>Seu saldo é</legend>
            <table>                 
 
                
                <tr>
                    <td>Valor:</td>
                    <td>${aluno.saldo}</td>
                </tr>


            </table>     
        </fieldset>
    </form>


</section>

</body>
</html>
