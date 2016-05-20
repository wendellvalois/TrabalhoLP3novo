/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.dao;

import br.com.cantinasjuquinha.bean.Aluno;
import java.util.List;

/**
 *
 * @author wendellvalois
 */
public interface AlunoDAO {
    
    public void inserir(Aluno aluno);
    public void excluir(String cpf);
    public List<Aluno> listar();
    public Aluno buscar(int id);
    public void editar(Aluno aluno);
    
}
