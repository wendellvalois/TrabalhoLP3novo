/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.bean;

/**
 *
 * @author Danilo
 */
public class Escola {

    private String matriculaescola;
    private String nomeescola;
    private String enderecoescola;
    private String telefoneescola;
    private String emailescola;
    private String funcionario;
    

    public Escola() {
    }
    
    /**
     * @return the matriculaescola
     */
    public String getmatriculaEscola() {
        return matriculaescola;
    }

    /**
     * @param matriculaescola the nome to set
     */
    public void setmatriculaEscola(String matriculaescola) {
        this.matriculaescola = matriculaescola;
    }

    /**
     * @return the nomeescola
     */
    public String getnomeEscola() {
        return nomeescola;
    }

    /**
     * @param nomeescola the nomeescola to set
     */
    public void setnomeEscola(String nomeescola) {
        this.nomeescola = nomeescola;
    }

    /**
     * @return the enderecoescola
     */
    public String getenderecoEscola() {
        return enderecoescola;
    }

    /**
     * @param enderecoescola the enderecoescola to set
     */
    public void setenderecoEscola(String enderecoescola) {
        this.enderecoescola = enderecoescola;
    }

    /**
     * @return the telefoneescola
     */
    public String gettelefoneEscola() {
        return telefoneescola;
    }

    /**
     * @param telefoneescola the telefoneescola to set
     */
    public void settelefoneEscola(String telefoneescola) {
        this.telefoneescola = telefoneescola;
    }

    /**
     * @return the emailescola
     */
    public String getemailEscola() {
        return emailescola;
    }

    /**
     * @param emailescola the emailescola to set
     */
    public void setemailEscola(String emailescola) {
        this.emailescola = emailescola;
    }

    /**
     * @return the funcionario
     */
    public String getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
