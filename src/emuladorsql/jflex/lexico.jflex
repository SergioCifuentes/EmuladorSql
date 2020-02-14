package emuladorsql.jflex;
import java_cup.runtime.Symbol;
%%
%class AnalizadorLexico
%cupsym Simbolos
%cup
%cupdebug
%line
%column

/*Identifiers*/
Letra = [a-zA-Z]
Signo = [-_@+*#.]
Numero = [0123456789]


%%//Reglas Lexicas

<YYINITIAL>{
        "PROYECTO"                                  {return new Symbol(Simbolos.PRO, yycolumn,yyline,yytext());}
        "CARPETA"                                   {return new Symbol(Simbolos.CAR, yycolumn,yyline,yytext());}
        "ARCHIVO"                                   {return new Symbol(Simbolos.ARC, yycolumn,yyline,yytext());}
        "nombre"                                    {return new Symbol(Simbolos.NOM, yycolumn,yyline,yytext());}
        "ubicacion"                                    {return new Symbol(Simbolos.UBI, yycolumn,yyline,yytext());}
        "<"                                         {return new Symbol(Simbolos.ABR, yycolumn,yyline,yytext());}
        ">"                                         {return new Symbol(Simbolos.CER, yycolumn,yyline,yytext());}
        "</"                                        {return new Symbol(Simbolos.DIAA, yycolumn,yyline,yytext());}
        "/>"                                        {return new Symbol(Simbolos.DIAC, yycolumn,yyline,yytext());}
        "="                                         {return new Symbol(Simbolos.IGU, yycolumn,yyline,yytext());}
        "\""                                         {return new Symbol(Simbolos.COM, yycolumn,yyline,yytext());}
        ({Letra}|{Signo}|{Numero})+                 {return new Symbol(Simbolos.NOMBRE, yycolumn,yyline,yytext());}
        ("/"({Letra}|{Signo}|{Numero}|" ")+)+".csv"     {return new Symbol(Simbolos.PATH, yycolumn,yyline,yytext());}
         
        [ \t\r\n\f]                            {}
        
        .                                            {return new Symbol(Simbolos.ERROR,yycolumn,yyline,yytext());} 
 
}