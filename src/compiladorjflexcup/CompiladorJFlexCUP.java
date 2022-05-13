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
import java_cup.runtime.SymbolFactory;
import jflex.Main;
import jflex.exceptions.SilentExit;

/**
 *
 * @author marcela
 */
public class CompiladorJFlexCUP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SilentExit {
        
        // Exemplos
        
        // geração do analisador léxico
        // Main.generate(args);
        
        // pode ser feito dessa forma ou através da interface do JFLex
    
        
        // usar a linha de comando abaixo para geração do parser
        // java -jar java-cup-11b.jar -interface -parser Parser -locations def.cup
        // para depurar acrescentar os argumentos -dump -debug
    
        // exemplo para testar léxico e parser a partir de um arquivo de teste
        try{
            String caminho = "/home/marcela/NetBeansProjects/compiladorJFlexCUP/src/arquivos/teste.txt";
            BufferedReader bf = new BufferedReader(new FileReader(caminho));
            ComplexSymbolFactory csf = new ComplexSymbolFactory();
            Lexico lexico = new Lexico(bf,csf);
            
            Parser p = new Parser(lexico,csf);
            Symbol i = p.parse();
            Programa prog = (Programa)i.value;
            prog.imprime();
            System.out.println("\n---\n");
            System.out.println("Texto Correto. "+sym.terminalNames[i.sym]);
            
            
           // Exemplos para testar somente o léxico
            /*Symbol s = lexico.next_token();
            while (s.sym > 0){
                System.out.println("Token: "+sym.terminalNames[lexico.next_token().sym]);
                s = lexico.next_token();
            }*/
            
            /*Scanner tec = new Scanner(System.in);
            String s = tec.next();
            while (!s.equals("s")){
                    Reader entrada = new StringReader("teste a 12");
                    ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();
                    Lexico lexico = new Lexico(entrada,symbolFactory);
                    System.out.println("Token: "+sym.terminalNames[lexico.next_token().sym]);

                  s = tec.next();
             
            }*/
            }catch(Exception e){
                  System.out.println("Erro na entrada: "+e.getMessage());
            } 

        // Exemplo para testar o parser e léxico
       /*try{
            Scanner tec = new Scanner(System.in);
            String s = tec.next();
            ComplexSymbolFactory csf = new ComplexSymbolFactory();
            Reader entrada = new StringReader(s);
            Lexico lex = new Lexico(entrada,csf);
            Parser p = new Parser(lex,csf);
            Symbol i = p.parse();
            System.out.println("Texto Correto. "+sym.terminalNames[i.sym]);
        }catch(Exception e){
            System.out.println("\nErro: "+e.getMessage());
        }*/
    }
}
