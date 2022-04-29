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
public class Termo {
    private Identificador id;
    private Constante constante;
    private Str str;
    
    public Termo(Identificador i){
        this.id = i;
    }
    
    public Termo(Constante c){
        this.constante = c;
    }
    
    public Termo(Str s){
        this.str = s;
    }
    
}
