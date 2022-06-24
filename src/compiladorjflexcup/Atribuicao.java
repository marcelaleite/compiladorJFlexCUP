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
public class Atribuicao {
    private Identificador id;
    private Expressao expressao;
    
    public Atribuicao(Identificador i, Expressao e){
        this.id = i;
        this.expressao = e;
    }
    
    public Identificador getId(){
        return this.id;
    }
    
    public Expressao getExpressao(){ return this.expressao;}

}
