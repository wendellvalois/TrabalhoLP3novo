/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.servlet;

import br.com.cantinasjuquinha.bean.Usuario;
import br.com.cantinasjuquinha.dao.UsuarioDAO;
import br.com.cantinasjuquinha.util.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wendellvalois
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

//        public String efetuaLogin(Usuario usuario, HttpSession session) {
//            return usuario.getLogin();
//        }
//BUSCA E CONFIRMA USUARIO
        Usuario usuariorequisitado = new Usuario();

        UsuarioDAO ud = DAOFactory.createUsuarioDAO();
        usuariorequisitado = ud.buscar(usuario);
         
        RequestDispatcher rd;

        if (usuariorequisitado != null && senha.equals(usuariorequisitado.getSenha())) {
            if (usuariorequisitado.getCpfResponsavel() != null) {                
                request.getSession().setAttribute("id", usuariorequisitado.getCpfResponsavel());
                rd = request.getRequestDispatcher("responsavel/paginainicial.jsp");
                rd.forward(request, response);
                //System.out.println( request.getSession().getAttribute("id"));
                
               // response.sendRedirect("responsavel/paginainicial.jsp");
                
            } else if (usuariorequisitado.getCpfFuncionario() != null) {
                request.getSession().setAttribute("id", usuariorequisitado.getCpfFuncionario());
                //response.sendRedirect("funcionario/paginainicial.jsp");
                rd = request.getRequestDispatcher("funcionario/paginainicial.jsp");
                rd.forward(request, response);
            } else if (usuariorequisitado.getMatriculaAluno() != null) {
                request.getSession().setAttribute("id", usuariorequisitado.getMatriculaAluno());
                //response.sendRedirect("aluno/paginainicial.jsp");
                rd = request.getRequestDispatcher("aluno/paginainicial.jsp");
                rd.forward(request, response);

            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Usuário ou senha incorreta');");
                //           out.println("location='index.html';"); // reload de pagina
                out.println("</script>");
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.include(request, response);
            }
        }
    }

//        if (usuario.equals("responsavel") && senha.equals("123")) {
//            response.sendRedirect("responsavel/paginainicial.jsp");
//        } else if (usuario.equals("funcionario") && senha.equals("123")) {
//            response.sendRedirect("funcionario/paginainicial.jsp");
//        } else if (usuario.equals("aluno") && senha.equals("123")) {
//            response.sendRedirect("aluno/paginainicial.jsp");
//        } else {
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Usuário ou senha incorreta');");
//            //           out.println("location='index.html';"); // reload de pagina
//            out.println("</script>");
//            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
//            rs.include(request, response);
//        }
//    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
