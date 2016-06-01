/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.controller.logic;

import br.com.cantinasjuquinha.bean.Produto;
import br.com.cantinasjuquinha.dao.JDBCProdutoDAO;
import br.com.cantinasjuquinha.dao.ProdutoDAO;
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
public class ControllerLogicProduto implements ControllerLogic {

    @Override
    public void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto produto = new Produto();
        produto.setCodigoproduto(request.getParameter("codigo"));
        produto.setPrecoproduto(request.getParameter("preco"));
        produto.setNomeproduto(request.getParameter("nome"));
        produto.setFornecedorproduto(request.getParameter("fornecedor"));
        produto.setIngredientesproduto(request.getParameter("ingredientes"));


        ProdutoDAO rd = DAOFactory.createProdutoDAO();
        rd.inserir(produto);
        
        UsuarioDAO ud = DAOFactory.createUsuarioDAO();

        
    //    request.setAttribute("nomeresp", produto);

        request.getRequestDispatcher("funcionario/cadastraProdutoConf.jsp").forward(request, response);

    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto produto = new Produto();

        produto.setCodigoproduto("codigo");
        produto.setPrecoproduto(request.getParameter("preco"));
        produto.setNomeproduto(request.getParameter("nome"));
        produto.setFornecedorproduto(request.getParameter("fornecedor"));
        produto.setIngredientesproduto(request.getParameter("ingredientes"));

        ProdutoDAO rd = new JDBCProdutoDAO();
        rd.editar(produto);
        request.getRequestDispatcher("funcionario/paginainicial.jsp").forward(request, response);

    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        ProdutoDAO rd = new JDBCProdutoDAO();
        rd.excluir(cpf);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoDAO rd = new JDBCProdutoDAO();
        request.setAttribute("responsaveis", rd.listar());
        request.getRequestDispatcher("funcionario/listaProduto.jsp").forward(request, response);
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpf = Integer.parseInt(request.getParameter("cpf")); //mudar para cpf
        ProdutoDAO rd = new JDBCProdutoDAO();
        Produto r = rd.buscar(cpf);
        request.setAttribute("produto", r);
        request.getRequestDispatcher("funcionario/editaProduto.jsp").forward(request, response);

    }

}
