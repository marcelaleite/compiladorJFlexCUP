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
    
    public void imprime(){
        if (this.termoE != null)
            System.out.println(this.termoE.getStr());
        if (this.termoD != null)
            System.out.println(this.termoD.getStr());
        if (this.esq != null){
            if (this.esq.getTermoE() != null)
                System.out.println(this.esq.getTermoE().getStr());
            if(this.esq.getEsq() != null){
                if (this.esq.getEsq().getTermoE() != null)
                    System.out.println(this.esq.getEsq().getTermoE().getStr());
                if (this.esq.getEsq().getEsq() != null)
                    if (this.esq.getEsq().getEsq().getTermoE() != null)
                        System.out.println(this.esq.getEsq().getEsq().getTermoE().getStr().getS());

                    
            }

        }

    }

    public Expressao getEsq() {
        return esq;
    }

    public Expressao getDir() {
        return dir;
    }

    public int getOp() {
        return op;
    }

    public Termo getTermoE() {
        return termoE;
    }

    public Termo getTermoD() {
        return termoD;
    }
    
  
    
    
}
