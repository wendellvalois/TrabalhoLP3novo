/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.util;

import br.com.cantinasjuquinha.dao.JDBCResponsavelDAO;
import br.com.cantinasjuquinha.dao.ResponsavelDAO;

/**
 *
 * @author wendellvalois
 */
public class DAOFactory {
    public static ResponsavelDAO createResponsavelDAO(){
        return new JDBCResponsavelDAO();
        
    }
    
}
