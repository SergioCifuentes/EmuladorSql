
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue Feb 18 19:24:30 CST 2020
//----------------------------------------------------

package emuladorsql.cup.Secundario;

import java_cup.runtime.Symbol;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Tue Feb 18 19:24:30 CST 2020
  */
public class AnalizadorSintacticoPuntoyComa extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintacticoPuntoyComa() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoPuntoyComa(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoPuntoyComa(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\006\000\002\002\004\000\002\002\005\000\002\002" +
    "\004\000\002\002\003\000\002\003\004\000\002\003\003" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\011\000\006\004\005\005\007\001\002\000\004\005" +
    "\012\001\002\000\006\004\005\005\ufffc\001\002\000\004" +
    "\002\010\001\002\000\004\002\ufffe\001\002\000\004\002" +
    "\001\001\002\000\004\005\ufffd\001\002\000\010\002\uffff" +
    "\004\005\005\007\001\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\011\000\006\002\005\003\003\001\001\000\002\001" +
    "\001\000\004\003\010\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\002" +
    "\012\003\003\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintacticoPuntoyComa$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintacticoPuntoyComa$actions(this);
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
    return action_obj.CUP$AnalizadorSintacticoPuntoyComa$do_action(act_num, parser, stack, top,this);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public boolean correcto; 

    public void syntax_error(Symbol s){
        correcto=false;

    }

    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
        correcto=false;

    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintacticoPuntoyComa$actions {
  private final AnalizadorSintacticoPuntoyComa parser;

  /** Constructor */
  CUP$AnalizadorSintacticoPuntoyComa$actions(AnalizadorSintacticoPuntoyComa parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoPuntoyComa$do_action(
    int                        CUP$AnalizadorSintacticoPuntoyComa$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoPuntoyComa$parser,
    java.util.Stack            CUP$AnalizadorSintacticoPuntoyComa$stack,
    int                        CUP$AnalizadorSintacticoPuntoyComa$top,AnalizadorSintacticoPuntoyComa aspc)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintacticoPuntoyComa$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintacticoPuntoyComa$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // ID ::= TODO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoPuntoyComa$result = parser.getSymbolFactory().newSymbol("ID",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoPuntoyComa$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // ID ::= TODO ID 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoPuntoyComa$result = parser.getSymbolFactory().newSymbol("ID",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.elementAt(CUP$AnalizadorSintacticoPuntoyComa$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoPuntoyComa$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Inicio ::= PYC 
            {
              Object RESULT =null;
		aspc.setCorrecto(true);
              CUP$AnalizadorSintacticoPuntoyComa$result = parser.getSymbolFactory().newSymbol("Inicio",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoPuntoyComa$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Inicio ::= ID PYC 
            {
              Object RESULT =null;
		aspc.setCorrecto(true);
              CUP$AnalizadorSintacticoPuntoyComa$result = parser.getSymbolFactory().newSymbol("Inicio",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.elementAt(CUP$AnalizadorSintacticoPuntoyComa$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoPuntoyComa$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // Inicio ::= ID PYC Inicio 
            {
              Object RESULT =null;
		aspc.setCorrecto(true);
              CUP$AnalizadorSintacticoPuntoyComa$result = parser.getSymbolFactory().newSymbol("Inicio",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.elementAt(CUP$AnalizadorSintacticoPuntoyComa$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoPuntoyComa$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= Inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.elementAt(CUP$AnalizadorSintacticoPuntoyComa$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.elementAt(CUP$AnalizadorSintacticoPuntoyComa$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoPuntoyComa$stack.elementAt(CUP$AnalizadorSintacticoPuntoyComa$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintacticoPuntoyComa$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.elementAt(CUP$AnalizadorSintacticoPuntoyComa$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoPuntoyComa$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintacticoPuntoyComa$parser.done_parsing();
          return CUP$AnalizadorSintacticoPuntoyComa$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

