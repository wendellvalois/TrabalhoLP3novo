/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Responsavel;
import java.util.List;


/**
 *
 * @author wendellvalois
 */
public interface ResponsavelDAO {
    public void inserir(Responsavel responsavel);
    public void excluir(String cpf);
    public List<Responsavel> listar();
    public Responsavel buscar(int id);
    public void editar(Responsavel responsavel);
    
}
