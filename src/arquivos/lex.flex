/*incluir o pacote onde a classe será criada*/
package compiladorjflexcup;
import compiladorjflexcup.sym; /* essa classe será criada pelo CUP */
import java_cup.runtime.Symbol;

%%
%cup
%class Lexico
%full
%line
%column
%char
%ignorecase
%eofval{
    return new Symbol(sym.EOF, new String("Fim de arquivo"));
%eofval}

letras  = [a-zA-Z]
numeros = [0-9]
ws      = [\ \t]
eof     = [\n\r]
id      = {letras}({letras}|{numeros})*
const   = {numeros}+

%% 
/* regras de tradução - tokens */
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
. {return new Symbol(sym.ERRO);}
/* funções auxiliares */