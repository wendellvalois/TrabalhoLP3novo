<%-- 
    Document   : compra
    Created on : Jun 2, 2016, 3:04:21 PM
    Author     : wendellvalois
--%>
<style>
    input{
        margin: 10px;




    }
    input:hover{

        box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);

    }


    form {
        display: inline;




    }
    #bebidas{

        background-color: sandybrown;
        border-radius: 10px;
        padding: 3px;

    }
    #comidas{
        background-color: chocolate;
        background-color: khaki;
        border-radius: 10px;
        padding: 3px;

    }


</style>
<jsp:include page="header.jsp"/>
<section style="margin-left:25%;padding:1px 16px;height:1000px;">




    <p><h1>Aperte no item desejado para comprar</h1></p>

<p>
<div id="bebidas">
    <h3>Bebidas</h3>


    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=2353" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/Agua De Coco Ducoco.jpg" width="100px" height="100px"  name="saveForm" class="btTxt submit" id="saveForm"/>
    </form>

    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=2353" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/aguamineral.jpg" width="100px" height="100px" name="saveForm" class="btTxt submit" id="saveForm" />
    </form>

    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=13452" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/Suco.jpg" width="100px" height="100px" name="saveForm" class="btTxt submit" id="saveForm" />
    </form>

    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=2422" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/Toddynho.png" width="100px" height="100px" name="saveForm" class="btTxt submit" id="saveForm" />
    </form>

    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=12" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/Dollynho.jpg" width="100px" height="100px" name="saveForm" class="btTxt submit" id="saveForm" />
    </form>

</div>

<div id="comidas">
    <h3>Comidas</h3>
    <p>
    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=1000" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/saladadefruta.jpg" width="100px" height="100px" name="saveForm" class="btTxt submit" id="saveForm" />
    </form>

    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=1000" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/pastel.jpg" width="100px" height="100px" name="saveForm" class="btTxt submit" id="saveForm" />
    </form>

    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=1000" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/pipoca.jpg" width="100px" height="100px" name="saveForm" class="btTxt submit" id="saveForm" />
    </form>

    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=1000" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/bolo.jpg" width="100px" height="100px" name="saveForm" class="btTxt submit" id="saveForm" />
    </form>

    <form action="/TrabalhoLP3novo/Controller?classe=ControllerLogicCompra&metodo=adicionar&codigo=1000" method="post">
        <input type="image" src="/TrabalhoLP3novo/images/paozinho.jpg" width="100px" height="100px" name="saveForm" class="btTxt submit" id="saveForm" />
    </form>
</div>
</p>

</body>
</html>
