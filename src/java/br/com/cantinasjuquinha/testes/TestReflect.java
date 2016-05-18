/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cantinasjuquinha.testes;

import br.com.cantinasjuquinha.bean.Pessoa;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 *
 * @author wendellvalois
 */
public class TestReflect {
    public static void main(String[] args) {
        Class classe = Pessoa.class;
        for (Field campo : classe.getDeclaredFields()) {
            System.out.println("NOME: " +campo.getName());
            System.out.println("TIPO: " +campo.getType());
            
            
        }
        for (Method metodo : classe.getDeclaredMethods()) {
            System.out.println("NOME: " +metodo.getName());
            System.out.println("TIPO: " +metodo.getTypeParameters().toString());
            
        }
                
    }
    
}
