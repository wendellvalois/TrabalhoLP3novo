/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.controller.logic;

import br.com.cantinasjuquinha.bean.Aluno;
import br.com.cantinasjuquinha.bean.Usuario;
import br.com.cantinasjuquinha.dao.JDBCAlunoDAO;
import br.com.cantinasjuquinha.dao.AlunoDAO;
import br.com.cantinasjuquinha.dao.JDBCUsuarioDAO;
import br.com.cantinasjuquinha.dao.UsuarioDAO;
import br.com.cantinasjuquinha.util.DAOFactory;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
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
        Usuario usuario = new Usuario();

        aluno.setMatricula(request.getParameter("matricula"));
        aluno.setNome(request.getParameter("nome"));
        aluno.setTurma(request.getParameter("turma"));
        aluno.setTurno(request.getParameter("turno"));
        
        //aluno.setResponsavel(request.getParameter("responsavel"));
        System.out.println(request.getSession().getAttribute("id"));

        aluno.setResponsavel((String) request.getSession().getAttribute("id"));

        //aluno.setLogin(request.getParameter("login"));
        //aluno.setSenha(request.getParameter("senha"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setMatriculaAluno(request.getParameter("matricula"));

        AlunoDAO rd = DAOFactory.createAlunoDAO();

        rd.inserir(aluno);

        UsuarioDAO ud = DAOFactory.createUsuarioDAO();
        ud.inserir(usuario);

        request.setAttribute("nomeresp", aluno);
        //response.sendRedirect("responsavel/cadastraAlunoConf.jsp");
        //request.getRequestDispatcher("responsavel/cadastraAlunoConf.jsp").forward(request, response);
        request.getRequestDispatcher("responsavel/cadastraAlunoConf.jsp").forward(request, response);
//        RequestDispatcher rdis = request.getRequestDispatcher("/responsavel/cadastraAlunoConf.jsp");
//        rdis.forward(request, response);
    }

    @Override
    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //apenas para mudanca em saldo
        Aluno aluno = new Aluno();
        String valorstring = request.getParameter("valor");
        String saldostring = request.getParameter("saldo");

        if (saldostring == null || saldostring == "") saldostring = "0";
        
        if (valorstring == null) {
            valorstring = "0";
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Valor nulo');");
            out.println("</script>");
            System.out.println("O valor enviado era nulo");
        }
        

            int valor = Integer.parseInt(valorstring);
            int saldo = Integer.parseInt(saldostring);

            saldo += valor;
        

        aluno.setMatricula(request.getParameter("matricula"));
        aluno.setSaldo(String.valueOf(saldo));
//        aluno.setNome(request.getParameter("nome"));
//        aluno.setTurma(request.getParameter("turma"));
//        aluno.setTurno(request.getParameter("turno"));
//        aluno.setResponsavel(request.getParameter("responsavel"));
//        aluno.setLogin(request.getParameter("login"));
//        aluno.setSenha(request.getParameter("senha"));

        AlunoDAO rd = new JDBCAlunoDAO();

        rd.editar(aluno);

        out.println("<script type=\"text/javascript\">");
        out.println("alert('Dinheiro enviado');");
        //           out.println("location='index.html';"); // reload de pagina
        out.println("</script>");

        request.getRequestDispatcher("responsavel/paginainicial.jsp").forward(request, response);

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
        String responsavel = (String) request.getSession().getAttribute("id");
        System.out.println(" estou dentro de listar: " + responsavel);
        request.setAttribute("alunos", rd.listar(responsavel));
        request.getRequestDispatcher("responsavel/listaAlunos.jsp").forward(request, response);

    }

    @Override
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int matricula = Integer.parseInt(request.getParameter("matricula")); //mudar para matricula

        AlunoDAO rd = new JDBCAlunoDAO();
        Aluno r = rd.buscar(matricula);
        request.setAttribute("aluno", r);
        request.getRequestDispatcher("responsavel/editaAlunoSaldo.jsp").forward(request, response);

    }

    @Override
    public void buscarcampo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
