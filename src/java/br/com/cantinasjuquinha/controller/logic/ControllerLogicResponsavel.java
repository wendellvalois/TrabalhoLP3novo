/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.controller.logic;

import br.com.cantinasjuquinha.bean.Responsavel;
import br.com.cantinasjuquinha.dao.JDBCResponsavelDAO;
import br.com.cantinasjuquinha.dao.ResponsavelDAO;
import br.com.cantinasjuquinha.util.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wendellvalois
 */
public class ControllerLogicResponsavel implements ControllerLogic {

    @Override
    public void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Responsavel responsavel = new Responsavel();

        responsavel.setCpf(request.getParameter("cpf"));
        responsavel.setNome(request.getParameter("nome"));
        responsavel.setTelefone(request.getParameter("telefone"));
        responsavel.setEmail(request.getParameter("email"));
        responsavel.setEndereco(request.getParameter("endereco"));
        responsavel.setLogin(request.getParameter("login"));
        responsavel.setSenha(request.getParameter("senha"));

        ResponsavelDAO rd = DAOFactory.createResponsavelDAO();
        rd.inserir(responsavel);
        
    //    request.setAttribute("nomeresp", responsavel);

        request.getRequestDispatcher("funcionario/cadastraResponsavelConf.jsp").forward(request, response);

    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Responsavel responsavel = new Responsavel();

        responsavel.setCpf(request.getParameter("cpf"));
        responsavel.setNome(request.getParameter("nome"));
        responsavel.setTelefone(request.getParameter("telefone"));
        responsavel.setEmail(request.getParameter("email"));
        responsavel.setEndereco(request.getParameter("endereco"));
        responsavel.setLogin(request.getParameter("login"));
        responsavel.setSenha(request.getParameter("senha"));

        ResponsavelDAO rd = new JDBCResponsavelDAO();
        rd.editar(responsavel);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        ResponsavelDAO rd = new JDBCResponsavelDAO();
        rd.excluir(cpf);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponsavelDAO rd = new JDBCResponsavelDAO();
        request.setAttribute("responsaveis", rd.listar());
        request.getRequestDispatcher("funcionario/listaResponsavel.jsp").forward(request, response);
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpf = Integer.parseInt(request.getParameter("cpf")); //mudar para cpf
        ResponsavelDAO rd = new JDBCResponsavelDAO();
        Responsavel r = rd.buscar(cpf);
        request.setAttribute("responsavel", r);
        request.getRequestDispatcher("funcionario/editaResponsavel.jsp").forward(request, response);

    }

}
