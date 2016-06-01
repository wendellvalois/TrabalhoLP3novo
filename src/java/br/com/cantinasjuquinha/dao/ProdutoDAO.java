/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Produto;
import java.util.List;


/**
 *
 * @author wendellvalois
 */
public interface ProdutoDAO {
    public void inserir(Produto produto);
    public void excluir(String codigo);
    public List<Produto> listar();
    public Produto buscar(int cpf);
    public void editar(Produto produto);
    
}
