
package br.com.cantinasjuquinha.testes;

import br.com.cantinasjuquinha.bean.Aluno;
import br.com.cantinasjuquinha.dao.JDBCAlunoDAO;

/**
 *
 * @author wendellvalois
 */
public class testebuscaalunoJDBC {
      public static void main(String[] args) {
          JDBCAlunoDAO bancoaluno = new JDBCAlunoDAO();
          Aluno aluno = new Aluno();
          
          aluno = bancoaluno.buscar(23);
          System.out.println(aluno.getMatricula() + " " + aluno.getNome() + " " 
                  + aluno.getSaldo()+ " " +aluno.getResponsavel());
          
      }
    
}
