/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.testes;

import br.com.cantinasjuquinha.bean.Responsavel;
import br.com.cantinasjuquinha.dao.ResponsavelDAO;
import br.com.cantinasjuquinha.util.DAOFactory;

/**
 *
 * @author wendellvalois
 */
public class Teste {

    public static void main(String[] args) {
        /*
        Responsavel responsavel = new Responsavel();
        responsavel.setNome("Angelo");
        responsavel.setCpf("1232");
        responsavel.setEmail("angelo@agda.com");
        responsavel.setTelefone("31312356");
        responsavel.setEndereco("Rua ha");
       // responsavel.setLogin("angeloluis");
        //responsavel.setSenha("123456");
                */
        
        ResponsavelDAO rd = DAOFactory.createResponsavelDAO();
        //rd.inserir(responsavel);
         System.out.println(rd.listar());
    }

}
