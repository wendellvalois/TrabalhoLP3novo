/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Compra;
import java.util.List;


/**
 *
 * @author wendellvalois
 */
public interface CompraDAO {
    public void inserir(Compra compra);
    public void excluir(String cpf);
    public List<Compra> listar();
    public Compra buscar(int cpf);
    public void editar(Compra compra);
    
}
