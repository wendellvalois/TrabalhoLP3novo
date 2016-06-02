/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.controller.logic;

import br.com.cantinasjuquinha.bean.Aluno;
import br.com.cantinasjuquinha.bean.Compra;
import br.com.cantinasjuquinha.bean.Produto;
import br.com.cantinasjuquinha.bean.Usuario;
import br.com.cantinasjuquinha.dao.AlunoDAO;
import br.com.cantinasjuquinha.dao.JDBCCompraDAO;
import br.com.cantinasjuquinha.dao.CompraDAO;
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
public class ControllerLogicCompra implements ControllerLogic {

    @Override
    public void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Compra compra = new Compra();

//            private String idcompra;
//    private String quantidade;
//    private String aluno_matriculaaluno;
//    private String codigoproduto;
//    private String data;
        String codigoaluno = (String) request.getSession().getAttribute("id");
        String codigoproduto = request.getParameter("codigo");
        String valorcompra;

        compra.setQuantidade("1");
        compra.setAluno_matriculaaluno(codigoaluno);
        compra.setCodigoproduto(codigoproduto);

        ProdutoDAO pd = new JDBCProdutoDAO();
        Produto produto = new Produto();
        produto = pd.buscar(codigoproduto);

        valorcompra = produto.getPrecoproduto();

        AlunoDAO ad = DAOFactory.createAlunoDAO();
        ad.realizacompra(valorcompra, codigoaluno);

        CompraDAO rd = DAOFactory.createCompraDAO();
        rd.inserir(compra);

        //    request.setAttribute("nomeresp", compra);
        request.getRequestDispatcher("aluno/paginainicial.jsp").forward(request, response);

    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Compra compra = new Compra();

//        compra.setCpf(request.getParameter("cpf"));
//        compra.setNome(request.getParameter("nome"));
//        compra.setTelefone(request.getParameter("telefone"));
//        compra.setEmail(request.getParameter("email"));
//        compra.setEndereco(request.getParameter("endereco"));
//        compra.setLogin(request.getParameter("login"));
//        compra.setSenha(request.getParameter("senha"));
        CompraDAO rd = new JDBCCompraDAO();
        rd.editar(compra);
        request.getRequestDispatcher("funcionario/paginainicial.jsp").forward(request, response);

    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        CompraDAO rd = new JDBCCompraDAO();
        rd.excluir(cpf);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompraDAO rd = new JDBCCompraDAO();
        request.setAttribute("responsaveis", rd.listar());
        request.getRequestDispatcher("funcionario/listaCompra.jsp").forward(request, response);
    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpf = Integer.parseInt(request.getParameter("cpf")); //mudar para cpf
        CompraDAO rd = new JDBCCompraDAO();
        Compra r = rd.buscar(cpf);
        request.setAttribute("compra", r);
        request.getRequestDispatcher("funcionario/editaCompra.jsp").forward(request, response);

    }

    @Override
    public void buscarcampo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Aluno aluno = new Aluno();
        String codigoaluno = (String) request.getSession().getAttribute("id");
        AlunoDAO ad = DAOFactory.createAlunoDAO();
        aluno = ad.buscar(Integer.parseInt(codigoaluno));
        request.setAttribute("aluno", aluno);
        request.getRequestDispatcher("aluno/saldoAluno.jsp").forward(request, response);
        
        
        
    }

}
