/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Usuario;
import java.util.List;

/**
 *
 * @author wendellvalois
 */
public interface UsuarioDAO {
    public void inserir(Usuario usuario);
    public void excluir(String login);
    public List<Usuario> listar();
    public Usuario buscar(String login);
    public void editar(Usuario usuario);
    
}
