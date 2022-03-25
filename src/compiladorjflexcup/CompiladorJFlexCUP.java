/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorjflexcup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ScannerBuffer;
import java_cup.runtime.Symbol;

/**
 *
 * @author marcela
 */
public class CompiladorJFlexCUP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        /*
        geração do léxico
       
        String arquivo = "/home/marcela/NetBeansProjects/compiladorJFlexCUP/src/arquivos/lex.flex";
        File arq = new File(arquivo);
        jflex.Main.generate(arq);
    
    
        /*
        para geração do parser
        java -jar java-cup-11b.jar -interface -parser Parser def.cup
        */
    
        // para testar o léxico
/*
        try{
               Scanner tec = new Scanner(System.in);
               String s = tec.next();
               while (!s.equals("s")){
                    Reader entrada = new StringReader(s);
                    Lexico lexico = new Lexico(entrada);
                    System.out.println("Token: "+sym.terminalNames[lexico.next_token().sym]);
                    s = tec.next();

              }
           }catch(Exception e){
               System.out.println("Erro na entrada");
           }    
*/    
        try{
            FileReader arquivo = new FileReader("/home/marcela/NetBeansProjects/compiladorJFlexCUP/src/arquivos/teste.txt");
            ComplexSymbolFactory csf = new ComplexSymbolFactory();
            Lexico lex = new Lexico(arquivo);
            Parser p = new Parser(lex);
            p.parse();   
            System.out.println("Texto Correto");
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
}
