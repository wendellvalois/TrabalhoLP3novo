/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function CriticaFormulario(){
 var retorno=true;
 var tamanho;   
tamanho = document.forms["formulario"].elements.length;
for (i=0;i<=(tamanho-2);i++){
   if (document.forms["formulario"].elements[i].value===""){
         window.alert(" O campo " + document.forms["formulario"].elements[i].name + " é obrigatório");
      retorno=false;
      break;
      }
   }
return retorno;
}
