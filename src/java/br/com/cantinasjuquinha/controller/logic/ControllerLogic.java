/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.controller.logic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wendell
 */
public interface ControllerLogic {
//    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void editarPopular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
