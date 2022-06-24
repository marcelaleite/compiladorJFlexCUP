/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorjflexcup;

import java.util.ArrayList;

/**
 *
 * @author marcela
 */
public class Programa {
    private ArrayList<Comando> lista;
    
    public void setLista(ArrayList<Comando> lst){
        this.lista = lst;
    }
    
    public void imprime(){
        Comando c = this.lista.get(0);
        System.out.println(c.getAtribuicao().getId().getId());
        
        
    
    }
    
    public ArrayList<Comando> getLista(){ return this.lista; }
 
    
    
    
}
