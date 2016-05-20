/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Escola;
import java.util.List;


/**
 *
 * @author Danilo
 */
public interface EscolaDAO {
    public void inserir(Escola escola);
    public void excluir(String matriculaescola);
    public List<Escola> listar();
    public Escola buscar(int matriculaescola);
    public void editar(Escola escola);
    
}

