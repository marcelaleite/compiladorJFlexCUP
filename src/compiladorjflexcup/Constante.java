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
public class Constante {
    private int valor;
    
    public Constante(Object c){
        this.valor = Integer.parseInt(c.toString());
    }
    
    public int getValor(){  return this.valor;  }
    
}
