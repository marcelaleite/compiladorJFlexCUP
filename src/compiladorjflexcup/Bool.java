/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorjflexcup;

/**
 *
 * @author marcela
 */
public class Bool {
    private boolean valor; 
    public Bool(Object s){
        this.valor = Boolean.parseBoolean(s.toString());
    }
}
