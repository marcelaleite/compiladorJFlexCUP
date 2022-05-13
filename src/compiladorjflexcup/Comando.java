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
public class Comando {
    private ExpressaoLogica expressaol;
    private Atribuicao atribuicao;
    private ArrayList<Comando> ListaComandos;
    private Variavel declaracao;
    
    public Comando(ExpressaoLogica expl){
        this.expressaol = expl;
    }
    
    public Comando(Atribuicao att){
        this.atribuicao = att;
    }
    
    public Comando(Comando cmd){
        this.ListaComandos.add(cmd);
    }

        
    public Comando(Variavel dec){
        this.declaracao = dec;
    }
    
    public Atribuicao getAtribuicao(){
        return this.atribuicao;
    }
    
}
