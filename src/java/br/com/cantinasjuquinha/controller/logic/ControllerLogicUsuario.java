/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.controller.logic;

import br.com.cantinasjuquinha.bean.Usuario;
import br.com.cantinasjuquinha.dao.JDBCUsuarioDAO;
import br.com.cantinasjuquinha.dao.UsuarioDAO;
import br.com.cantinasjuquinha.util.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wendellvalois
 */
public class ControllerLogicUsuario implements ControllerLogic {

    @Override
    public void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();

        usuario.setLogin(request.getParameter("cpf"));
        usuario.setSenha(request.getParameter("nome"));
        
        usuario.setCpfFuncionario(request.getParameter("cpf"));
        usuario.setCpfResponsavel(request.getParameter("cpf"));
        usuario.setMatriculaAluno(request.getParameter("matricula"));

        UsuarioDAO rd = DAOFactory.createUsuarioDAO();
        rd.inserir(usuario);

        //    request.setAttribute("nomeresp", usuario);
        request.getRequestDispatcher("responsavel/paginainicial.jsp").forward(request, response);

    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login"); 
        UsuarioDAO rd = new JDBCUsuarioDAO();
        Usuario r = rd.buscar(login);
        request.setAttribute("usuario", r);
        
        //request.getRequestDispatcher("funcionario/editaUsuario.jsp").forward(request, response);

    }
    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
