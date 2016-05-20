/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.controller.logic;

import br.com.cantinasjuquinha.bean.Escola;
import br.com.cantinasjuquinha.dao.JDBCEscolaDAO;
import br.com.cantinasjuquinha.dao.EscolaDAO;
import br.com.cantinasjuquinha.util.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Danilo
 */
public class ControllerLogicEscola implements ControllerLogic {

    @Override
    public void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Escola escola = new Escola();

        escola.setmatriculaEscola(request.getParameter("matriculaescola"));
        escola.setnomeEscola(request.getParameter("nomeescola"));
        escola.setenderecoEscola(request.getParameter("enderecoescola"));
        escola.settelefoneEscola(request.getParameter("telefoneescola"));
        escola.setemailEscola(request.getParameter("emailescola"));
        escola.setFuncionario(request.getParameter("funcionario"));
        

        EscolaDAO rd = DAOFactory.createEscolaDAO();
        rd.inserir(escola);
        
    //    request.setAttribute("nomeresp", escola);

        request.getRequestDispatcher("funcionario/cadastraEscolaConf.jsp").forward(request, response);

    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Escola escola = new Escola();

        escola.setmatriculaEscola(request.getParameter("matriculaescola"));
        escola.setnomeEscola(request.getParameter("nomeescola"));
        escola.setenderecoEscola(request.getParameter("enderecoescola"));
        escola.settelefoneEscola(request.getParameter("telefoneescola"));
        escola.setemailEscola(request.getParameter("emailescola"));
        escola.setFuncionario(request.getParameter("funcionario"));

        EscolaDAO rd = new JDBCEscolaDAO();
        rd.editar(escola);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        EscolaDAO rd = new JDBCEscolaDAO();
        rd.excluir(cpf);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EscolaDAO rd = new JDBCEscolaDAO();
        request.setAttribute("escolas", rd.listar());
        request.getRequestDispatcher("listaEscola").forward(request, response);
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int matriculaescola = Integer.parseInt(request.getParameter("matriculaescola")); //mudar para cpf
        EscolaDAO rd = new JDBCEscolaDAO();
        Escola r = rd.buscar(matriculaescola);
        request.setAttribute("escola", r);
        request.getRequestDispatcher("editEscola").forward(request, response);

    }

}
