/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorjflexcup;

import java_cup.runtime.Symbol;

/**
 *
 * @author marcela
 */
public class Identificador {
    private String id;
    
    public Identificador(Object s){

        this.id = s.toString();
    }
    
}
