/*
package br.com.cantinasjuquinha.controller.logic;

import br.com.cantinasjuquinha.bean.Pessoa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerLogicPessoa implements ControllerLogic {

    @Override
    public void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(request.getParameter("nome"));
        pessoa.setSobrenome(request.getParameter("sobrenome"));

        pessoa.getEndereco().setBairro(request.getParameter("bairro"));
        pessoa.getEndereco().setCep(request.getParameter("cep"));
        pessoa.getEndereco().setRua(request.getParameter("rua"));

        request.getSession().setAttribute("pessoa", pessoa);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        Pessoa pessoa = new Pessoa();
        
        pessoa.setNome(request.getParameter("nome"));
        pessoa.setSobrenome(request.getParameter("sobrenome"));

        pessoa.getEndereco().setBairro(request.getParameter("bairro"));
        pessoa.getEndereco().setCep(request.getParameter("cep"));
        pessoa.getEndereco().setRua(request.getParameter("rua"));

        request.getSession().setAttribute("pessoa", pessoa);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void excluir(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        
        PessoaDAO pd = new JDBCPessoaDAO;
        pd.excluir(id);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void listar(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
                
        PessoaDAO p = new JDBCPessoaDAO;
        request.setAttribute("pessoas", p.listar());        
        request.getRequestDispatcher("listaPessoa").forward(request, response);
    }
    
    
}
*/