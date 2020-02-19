package emuladorsql.jflex.Secundario;
import java_cup.runtime.Symbol;
%%
%class AnalizadorLexicoPuntoyComa
%cupsym SimbolosPuntoyComa
%cup
%cupdebug
%line
%column

%%//Reglas Lexicas

<YYINITIAL>{

    ";"                     {System.out.println("pyc");return new Symbol(SimboloPuntoyComa.PYC,yycolumn,yyline,yytext());
                            } 
    [ \t\r\n\f]                            {}
        
        .                                            {System.out.println("Todo");return new Symbol(SimboloPuntoyComa.TODO,yycolumn,yyline,yytext();)
                                                        } 
}