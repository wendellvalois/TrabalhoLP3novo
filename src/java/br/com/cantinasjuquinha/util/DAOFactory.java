/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.util;

import br.com.cantinasjuquinha.dao.JDBCAlunoDAO;
import br.com.cantinasjuquinha.dao.AlunoDAO;
import br.com.cantinasjuquinha.dao.JDBCResponsavelDAO;
import br.com.cantinasjuquinha.dao.ResponsavelDAO;
import br.com.cantinasjuquinha.dao.JDBCEscolaDAO;
import br.com.cantinasjuquinha.dao.EscolaDAO;

/**
 *
 * @author wendellvalois
 */
public class DAOFactory {
    public static ResponsavelDAO createResponsavelDAO(){
        return new JDBCResponsavelDAO();
        
    }
        public static AlunoDAO createAlunoDAO(){
        return new JDBCAlunoDAO();
        
    }
    
    public static EscolaDAO createEscolaDAO(){
        return new JDBCEscolaDAO();
        
    }
}

