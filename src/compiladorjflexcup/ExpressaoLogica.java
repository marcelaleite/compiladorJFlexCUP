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
public class ExpressaoLogica {
    private Termo esq, dir;
    private int op;
    
    public ExpressaoLogica(Termo t1, Object op, Termo t2){
        this.esq = t1;
        this.dir = t2;
        this.op = Integer.parseInt(op.toString());
    }
    
}
