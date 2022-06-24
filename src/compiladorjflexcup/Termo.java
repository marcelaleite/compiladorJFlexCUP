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
    private Bool bool; 
    
    public Termo(Identificador i){
        this.id = i;
    }
    
    public Termo(Constante c){
        this.constante = c;
    }
    
    public Termo(Str s){
        this.str = s;
    }
    
    public Termo(Bool bool){
        this.bool = bool;
    }

    public Identificador getId() {
        return id;
    }

    public Constante getConstante() {
        return constante;
    }

    public Str getStr() {
        return str;
    }

    public Bool getBool() {
        return bool;
    }
    
}
