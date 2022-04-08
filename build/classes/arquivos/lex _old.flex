/*incluir o pacote onde a classe será criada*/
package compiladorjflexcup;
import compiladorjflexcup.sym; /* essa classe será criada pelo CUP */
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;

%%
%cup
%class Lexico
%implements sym
%full
%line
%column
%char
%ignorecase

/* as funções abaixo sobrescrevem o construtor da classe Symbol para suporte de mais argumentos */
/* mais detalhes em: http://www2.cs.tum.edu/projects/cup/examples.php */
%{
    StringBuffer string = new StringBuffer();
    public Lexico(java.io.Reader in, ComplexSymbolFactory sf){
	this(in);
	symbolFactory = sf;
    }
    ComplexSymbolFactory symbolFactory;

    private Symbol symbol(String name, int sym) {
        return symbolFactory.newSymbol(name, sym, new Location(yyline+1,yycolumn+1,yychar), new Location(yyline+1,yycolumn+yylength(),yychar+yylength()));
    }

    private Symbol symbol(String name, int sym, Object val) {
        Location left = new Location(yyline+1,yycolumn+1,yychar);
        Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
        return symbolFactory.newSymbol(name, sym, left, right,val);
    }
    private Symbol symbol(String name, int sym, Object val,int buflength) {
        Location left = new Location(yyline+1,yycolumn+yylength()-buflength,yychar+yylength()-buflength);
        Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
        return symbolFactory.newSymbol(name, sym, left, right,val);
    }
    private void error(String message) {
      System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
    }
%}

%eofval{
     return symbolFactory.newSymbol("EOF", EOF, new Location(yyline+1,yycolumn+1,yychar), new Location(yyline+1,yycolumn+1,yychar+1));
%eofval}


letras  = [a-zA-Z]
numeros = [0-9]
ws      = [\ \t]
eof     = [\n\r]
id      = {letras}({letras}|{numeros})*
const   = {numeros}+

%%
 
/* regras de tradução - tokens */
<YYINITIAL>{ /* esse parâmetros para que o flex reconheça as palavras reservadas */
"//".*      {/* ignorar comentários */}
"true"      {return new Symbol (sym.TRUE,yychar,yyline,yytext());}
"false"     {return new Symbol (sym.FALSE,yychar,yyline,yytext());}
"if"        {return new Symbol (sym.IF,yychar,yyline,yytext());}
"while"     {return new Symbol (sym.WHILE,yychar,yyline,yytext());}
{id}        {return new Symbol (sym.ID,yychar,yyline,yytext());} 
{const}     {return new Symbol (sym.CONST,yychar,yyline,yytext());} 
{ws}        {/* nenhuma ação */}
"+"         {return new Symbol (sym.SOMA,yychar,yyline,yytext());}  
"-"         {return new Symbol (sym.SUB,yychar,yyline,yytext());}  
"*"         {return new Symbol (sym.MULT,yychar,yyline,yytext());} 
"/"         {return new Symbol (sym.DIV,yychar,yyline,yytext());}
"="         {return new Symbol (sym.ATRIB,yychar,yyline,yytext());} 
"=="        {return new Symbol (sym.IGUAL,yychar,yyline,yytext());} 
"!="        {return new Symbol (sym.DIF,yychar,yyline,yytext());}
">"         {return new Symbol (sym.MAIORQ,yychar,yyline,yytext());} 
"<"         {return new Symbol (sym.MENORQ,yychar,yyline,yytext());}
">="        {return new Symbol (sym.MAIORI,yychar,yyline,yytext());}
"<="        {return new Symbol (sym.MENORI,yychar,yyline,yytext());}
"!"         {return new Symbol (sym.NAO,yychar,yyline,yytext());}
"&"         {return new Symbol (sym.E,yychar,yyline,yytext());}
"|"         {return new Symbol (sym.OU,yychar,yyline,yytext());}
}

. {return new Symbol(sym.ERRO);}
/* funções auxiliares */