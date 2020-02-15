package emuladorsql.jflex;
import java_cup.runtime.Symbol;
%%
%class AnalizadorLexicoSql
%cupsym SimboloSql
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
    "SELECCIONAR"                                  {return new Symbol(SimboloSql.SELECCIONAR, yycolumn,yyline,yytext());}
    "INSERTAR"                                  {return new Symbol(SimboloSql.INSERTAR, yycolumn,yyline,yytext());}
    "ACTUALIZAR"                                  {return new Symbol(SimboloSql.ACTUALIZAR, yycolumn,yyline,yytext());}
    "ELIMINAR"                                  {return new Symbol(SimboloSql.ELIMINAR, yycolumn,yyline,yytext());}
    "EN"                                  {return new Symbol(SimboloSql.EN, yycolumn,yyline,yytext());}
    "FILTRAR"                                  {return new Symbol(SimboloSql.FILTRAR, yycolumn,yyline,yytext());}
    "ASIGNAR"                                  {return new Symbol(SimboloSql.ASIGNAR, yycolumn,yyline,yytext());}
    "VALORES"                                  {return new Symbol(SimboloSql.VALORES, yycolumn,yyline,yytext());}
 "nombre"                                  {return new Symbol(SimboloSql.NOM, yycolumn,yyline,yytext());}
   
    ";"                                  {return new Symbol(SimboloSql.PC, yycolumn,yyline,yytext());}
    "("                                  {return new Symbol(SimboloSql.PARA, yycolumn,yyline,yytext());}
    ")"                                  {return new Symbol(SimboloSql.PARC, yycolumn,yyline,yytext());}
    "="                                         {return new Symbol(SimboloSql.IGU, yycolumn,yyline,yytext());}
    ","                                  {return new Symbol(SimboloSql.COMA, yycolumn,yyline,yytext());}
    "\""                                         {return new Symbol(SimboloSql.COM, yycolumn,yyline,yytext());}
    "*"                                  {return new Symbol(SimboloSql.POR, yycolumn,yyline,yytext());}
    "."                                  {return new Symbol(SimboloSql.PUNTO, yycolumn,yyline,yytext());}
    "AND"                                  {return new Symbol(SimboloSql.AND, yycolumn,yyline,yytext());}
    "OR"                                  {return new Symbol(SimboloSql.OR, yycolumn,yyline,yytext());}

        "<="                                         {return new Symbol(SimboloSql.ABRIG, yycolumn,yyline,yytext());}
        ">="                                         {return new Symbol(SimboloSql.CERIG, yycolumn,yyline,yytext());}
        "<>"                                         {return new Symbol(SimboloSql.DIF, yycolumn,yyline,yytext());}

        "<"                                         {return new Symbol(SimboloSql.ABR, yycolumn,yyline,yytext());}
        ">"                                         {return new Symbol(SimboloSql.CER, yycolumn,yyline,yytext());}
        ({Letra}|{Signo}|{Numero})+                 {return new Symbol(SimboloSql.NOMBRE, yycolumn,yyline,yytext());}
        ({Numero})+                 {return new Symbol(SimboloSql.NUM, yycolumn,yyline,yytext());}
        (({Letra}|{Signo}|{Numero}|" ")".")*({Letra}|{Signo}|{Numero}|" ")     {return new Symbol(Simbolos.PATH, yycolumn,yyline,yytext());}
        [ \t\r\n\f]                            {}
        
        .                                            {return new Symbol(Simbolos.ERROR,yycolumn,yyline,yytext());} 
}