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
    public void inserir(Escola responsavel);
    public void excluir(String cpf);
    public List<Escola> listar();
    public Escola buscar(int id);
    public void editar(Escola responsavel);
    
}

