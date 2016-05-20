/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.controller.logic;

import br.com.cantinasjuquinha.bean.Aluno;
import br.com.cantinasjuquinha.dao.JDBCAlunoDAO;
import br.com.cantinasjuquinha.dao.AlunoDAO;
import br.com.cantinasjuquinha.util.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author wendellvalois
 */
public class ControllerLogicAluno implements ControllerLogic {
    
    
    @Override
    public void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        Aluno aluno = new Aluno();

        aluno.setMatricula(request.getParameter("matricula"));
        aluno.setNome(request.getParameter("nome"));
        aluno.setTurma(request.getParameter("turma"));
        aluno.setTurno(request.getParameter("turno"));
        aluno.setResponsavel(request.getParameter("responsavel"));
        aluno.setLogin(request.getParameter("login"));
        aluno.setSenha(request.getParameter("senha"));

        AlunoDAO rd = DAOFactory.createAlunoDAO();
        rd.inserir(aluno);
        
    //    request.setAttribute("nomeresp", aluno);

        request.getRequestDispatcher("funcionario/cadastraalunoConf.jsp").forward(request, response);

    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Aluno aluno = new Aluno();

        aluno.setMatricula(request.getParameter("matricula"));
        aluno.setNome(request.getParameter("nome"));
        aluno.setTurma(request.getParameter("turma"));
        aluno.setTurno(request.getParameter("turno"));
        aluno.setResponsavel(request.getParameter("responsavel"));
        aluno.setLogin(request.getParameter("login"));
        aluno.setSenha(request.getParameter("senha"));

        AlunoDAO rd = new JDBCAlunoDAO();
        rd.editar(aluno);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        AlunoDAO rd = new JDBCAlunoDAO();
        rd.excluir(matricula);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoDAO rd = new JDBCAlunoDAO();
        request.setAttribute("responsaveis", rd.listar());
        request.getRequestDispatcher("listaaluno").forward(request, response);
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); //mudar para matricula
        AlunoDAO rd = new JDBCAlunoDAO();
        Aluno r = rd.buscar(id);
        request.setAttribute("aluno", r);
        request.getRequestDispatcher("editaluno").forward(request, response);

    }

}
