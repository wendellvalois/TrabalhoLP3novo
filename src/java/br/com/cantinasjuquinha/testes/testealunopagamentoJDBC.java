
package br.com.cantinasjuquinha.testes;

import br.com.cantinasjuquinha.bean.Aluno;
import br.com.cantinasjuquinha.dao.JDBCAlunoDAO;

/**
 *
 * @author wendellvalois
 */
public class testealunopagamentoJDBC {
      public static void main(String[] args) {
          JDBCAlunoDAO bancoaluno = new JDBCAlunoDAO();
          Aluno aluno = new Aluno();
          
          bancoaluno.realizacompra("10", "2456332");
//          System.out.println(aluno.getMatricula() + " " + aluno.getNome() + " " 
//                  + aluno.getSaldo()+ " " +aluno.getResponsavel());
//          
     }
    
}
