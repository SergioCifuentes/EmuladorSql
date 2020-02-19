
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue Feb 18 21:03:31 CST 2020
//----------------------------------------------------

package emuladorsql.cup.Secundario;

import java_cup.runtime.Symbol;
import java.util.ArrayList;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Tue Feb 18 21:03:31 CST 2020
  */
public class AnalizadorSintacticoCSV extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintacticoCSV() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoCSV(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoCSV(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\011\000\002\002\004\000\002\002\003\000\002\003" +
    "\005\000\002\003\003\000\002\003\003\000\002\004\005" +
    "\000\002\004\003\000\002\005\004\000\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\006\004\006\006\011\001\002\000\010\002" +
    "\ufffb\005\016\006\ufffb\001\002\000\004\002\000\001\002" +
    "\000\012\002\ufff9\004\006\005\ufff9\006\ufff9\001\002\000" +
    "\006\002\ufffe\006\013\001\002\000\004\002\012\001\002" +
    "\000\004\002\ufffd\001\002\000\004\002\001\001\002\000" +
    "\006\004\006\006\011\001\002\000\004\002\uffff\001\002" +
    "\000\010\002\ufffa\005\ufffa\006\ufffa\001\002\000\004\004" +
    "\006\001\002\000\006\002\ufffc\006\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\012\002\007\003\004\004\006\005\003\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\005\014" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\010\003\013\004\006\005\003" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\004" +
    "\016\005\003\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintacticoCSV$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintacticoCSV$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintacticoCSV$do_action(act_num, parser, stack, top,this);
  }

    public void setFilas(ArrayList<String[]> filas) {
        this.filas = filas;
    }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public ArrayList<String[]> filas= new ArrayList<>(); 
    public String mensajeError=null;

    public void syntax_error(Symbol s){
         String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        System.out.println("Error Sintactico Recuperado");
        System.out.println("\t \tLexema: "+ lexema);
        System.out.println("\t \tFila: "+ fila);
        System.out.println("\t \tColumna: "+ columna);

    }

    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
         String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        System.out.println("Error Sintactico Recuperado");
        System.out.println("\t \tLexema: "+ lexema);
        System.out.println("\t \tFila: "+ fila);
        System.out.println("\t \tColumna: "+ columna);

    }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintacticoCSV$actions {
  private final AnalizadorSintacticoCSV parser;

  /** Constructor */
  CUP$AnalizadorSintacticoCSV$actions(AnalizadorSintacticoCSV parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoCSV$do_action(
    int                        CUP$AnalizadorSintacticoCSV$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoCSV$parser,
    java.util.Stack            CUP$AnalizadorSintacticoCSV$stack,
    int                        CUP$AnalizadorSintacticoCSV$top,AnalizadorSintacticoCSV ascsv)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintacticoCSV$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintacticoCSV$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // ID ::= TODO 
            {
              Object RESULT =null;
		int TODOleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).left;
		int TODOright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).right;
		Object TODO = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.peek()).value;
		RESULT= TODO;
              CUP$AnalizadorSintacticoCSV$result = parser.getSymbolFactory().newSymbol("ID",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoCSV$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ID ::= TODO ID 
            {
              Object RESULT =null;
		int TODOleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-1)).left;
		int TODOright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-1)).right;
		Object TODO = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-1)).value;
		int IDleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).left;
		int IDright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).right;
		Object ID = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.peek()).value;
		String todo = new String();
                        todo=(String)TODO;
                        todo+=(String)ID;
                        RESULT =todo;
              CUP$AnalizadorSintacticoCSV$result = parser.getSymbolFactory().newSymbol("ID",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoCSV$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Con ::= ID 
            {
              Object RESULT =null;
		int IDleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).left;
		int IDright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).right;
		Object ID = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.peek()).value;
		String[] id = new String[1];
                        id[0]=(String)ID;
                        RESULT=id;
              CUP$AnalizadorSintacticoCSV$result = parser.getSymbolFactory().newSymbol("Con",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoCSV$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Con ::= ID COMA Con 
            {
              Object RESULT =null;
		int IDleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-2)).left;
		int IDright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-2)).right;
		Object ID = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-2)).value;
		int Conleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).left;
		int Conright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).right;
		Object Con = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.peek()).value;
		String[] id = new String[((String[])Con).length+1];
                        id[0]=(String)ID;
                        for(int i=1;i<id.length;i++){
                        id[i]=((String[])Con)[i-1];
                        }
                        RESULT=id;
              CUP$AnalizadorSintacticoCSV$result = parser.getSymbolFactory().newSymbol("Con",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoCSV$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // S ::= Con 
            {
              Object RESULT =null;
		int Conleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).left;
		int Conright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).right;
		Object Con = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.peek()).value;
		ArrayList<String[]> fil = new ArrayList<>();
                            fil.add((String[])Con);
                            RESULT =fil; 
              CUP$AnalizadorSintacticoCSV$result = parser.getSymbolFactory().newSymbol("S",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoCSV$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // S ::= Con ENTER S 
            {
              Object RESULT =null;
		int Conleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-2)).left;
		int Conright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-2)).right;
		Object Con = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-2)).value;
		int Sleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).left;
		int Sright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).right;
		Object S = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.peek()).value;
		ArrayList<String[]> fil = new ArrayList<>();
                            fil.add((String[])Con);
                            for(int i=0;i<((ArrayList<String[]>)S).size();i++){
                        fil.add(((ArrayList<String[]>)S).get(i));
                        }
                            RESULT =fil;
              CUP$AnalizadorSintacticoCSV$result = parser.getSymbolFactory().newSymbol("S",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoCSV$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // Inicio ::= S 
            {
              Object RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.peek()).value;
		ascsv.setFilas((ArrayList<String[]>)s);
              CUP$AnalizadorSintacticoCSV$result = parser.getSymbolFactory().newSymbol("Inicio",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoCSV$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= Inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintacticoCSV$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.elementAt(CUP$AnalizadorSintacticoCSV$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoCSV$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintacticoCSV$parser.done_parsing();
          return CUP$AnalizadorSintacticoCSV$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

