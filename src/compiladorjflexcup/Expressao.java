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
public class Expressao implements sym{
    private Expressao esq, dir;
    private int op;
    private Termo termoE, termoD;
    
    public Expressao(Expressao e1, Object op, Termo e2){
        this.esq = e1;
        this.termoD = e2;
        this.op = Integer.parseInt(op.toString());
    }

    public Expressao(Expressao e1, Object op, Expressao e2){
        this.esq = e1;
        this.dir = e2;
        this.op = Integer.parseInt(op.toString());
    }    
     
    public Expressao(Termo e1, Object op, Termo e2){
        this.termoE = e1;
        this.termoD = e2;
        this.op = Integer.parseInt(op.toString());
    }
    
    public Expressao(Expressao e){
        this.esq = e;
    }
    
    public Expressao(Termo t){
        this.termoE = t;     
    }
    
  
    
    
}
