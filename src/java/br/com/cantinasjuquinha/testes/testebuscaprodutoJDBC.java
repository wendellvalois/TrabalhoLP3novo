/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.testes;

import br.com.cantinasjuquinha.bean.Produto;
import br.com.cantinasjuquinha.dao.JDBCProdutoDAO;

/**
 *
 * @author wendellvalois
 */
public class testebuscaprodutoJDBC {
      public static void main(String[] args) {
          JDBCProdutoDAO bancoproduto = new JDBCProdutoDAO();
          Produto produto = new Produto();
          
          produto = bancoproduto.buscar("12");
          System.out.println(produto.getCodigoproduto() + " " + produto.getNomeproduto() + " " 
                  + produto.getFornecedorproduto()+ " " +produto.getIngredientesproduto());
          
      }
    
}
