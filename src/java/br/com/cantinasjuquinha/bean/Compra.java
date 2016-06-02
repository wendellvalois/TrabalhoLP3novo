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
public class Compra {

    private String idcompra;
    private String quantidade;
    private String aluno_matriculaaluno;
    private String codigoproduto;
    private String data;
    
    public Compra(){
        
    }

    /**
     * @return the idcompra
     */
    public String getIdcompra() {
        return idcompra;
    }

    /**
     * @param idcompra the idcompra to set
     */
    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the aluno_matriculaaluno
     */
    public String getAluno_matriculaaluno() {
        return aluno_matriculaaluno;
    }

    /**
     * @param aluno_matriculaaluno the aluno_matriculaaluno to set
     */
    public void setAluno_matriculaaluno(String aluno_matriculaaluno) {
        this.aluno_matriculaaluno = aluno_matriculaaluno;
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
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
    
    
}
