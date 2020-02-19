package emuladorsql.jflex.Secundario;
import java_cup.runtime.Symbol;
%%
%class AnalizadorLexicoCSV
%cupsym SimbolosCSV
%cup
%cupdebug
%line
%column

%%//Reglas Lexicas

<YYINITIAL>{

    ","                     {System.out.println("COMA");return new Symbol(SimbolosCSV.COMA,yycolumn,yyline,yytext());} 
    "\n"                    {System.out.println("enter");return new Symbol(SimbolosCSV.ENTER,yycolumn,yyline,yytext());} 
[ \t\r\f]                            {}
        .                   {System.out.println("TODO");return new Symbol(SimboloPuntoyComa.TODO,yycolumn,yyline,yytext();)} 
}
