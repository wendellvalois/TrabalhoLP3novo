/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.bean;

/**
 *
 * @author wendellvalois
 */
public class Produto {

    private String codigoproduto;
    private String precoproduto;
    private String nomeproduto;

    private String fornecedorproduto;
    private String ingredientesproduto;


    public Produto() {
    }

    /**
     * @return the codigoproduto
     */
    public String getCodigoproduto() {
        return codigoproduto;
    }

    /**
     * @param codigoproduto the codigoproduto to set
     */
    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    /**
     * @return the precoproduto
     */
    public String getPrecoproduto() {
        return precoproduto;
    }

    /**
     * @param precoproduto the precoproduto to set
     */
    public void setPrecoproduto(String precoproduto) {
        this.precoproduto = precoproduto;
    }

    /**
     * @return the nomeproduto
     */
    public String getNomeproduto() {
        return nomeproduto;
    }

    /**
     * @param nomeproduto the nomeproduto to set
     */
    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }


    /**
     * @return the fornecedorproduto
     */
    public String getFornecedorproduto() {
        return fornecedorproduto;
    }

    /**
     * @param fornecedorproduto the fornecedorproduto to set
     */
    public void setFornecedorproduto(String fornecedorproduto) {
        this.fornecedorproduto = fornecedorproduto;
    }

    /**
     * @return the ingredientesproduto
     */
    public String getIngredientesproduto() {
        return ingredientesproduto;
    }

    /**
     * @param ingredientesproduto the ingredientesproduto to set
     */
    public void setIngredientesproduto(String ingredientesproduto) {
        this.ingredientesproduto = ingredientesproduto;
    }


    
    
}
