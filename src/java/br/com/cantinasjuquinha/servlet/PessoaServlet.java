package br.com.cantinasjuquinha.servlet;

import br.com.cantinasjuquinha.bean.Pessoa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angelo
 */
public class PessoaServlet extends HttpServlet {

    private Pessoa pessoa;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final int INSERIR = 1;
        final int VISUALIZAR = 2;
        final int EDITAR = 3;

        switch (Integer.parseInt(request.getParameter("id"))) {

            case INSERIR:
                
                pessoa = new Pessoa();

                pessoa.setNome(request.getParameter("nome"));
                pessoa.setSobrenome(request.getParameter("sobrenome"));

                pessoa.getEndereco().setBairro(request.getParameter("bairro"));
                pessoa.getEndereco().setCep(request.getParameter("cep"));
                pessoa.getEndereco().setRua(request.getParameter("rua"));

                request.getSession().setAttribute("pessoa", pessoa);

                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case VISUALIZAR:
                request.getRequestDispatcher("visualizaPessoa.jsp").forward(request, response);
                break;
                
            case EDITAR:

                pessoa.setNome(request.getParameter("nome"));
                pessoa.setSobrenome(request.getParameter("sobrenome"));

                pessoa.getEndereco().setBairro(request.getParameter("bairro"));
                pessoa.getEndereco().setCep(request.getParameter("cep"));
                pessoa.getEndereco().setRua(request.getParameter("rua"));

                request.getSession().setAttribute("pessoa", pessoa);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
