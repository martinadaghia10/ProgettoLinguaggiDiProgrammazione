package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;
import semanticanalysis.VoidType;

/*QUESTA è CORRETTA*/
public class IfStmNode implements Node {
    private Node guard ;
    private ArrayList<Node> thenbranch ;
    private ArrayList<Node> elsebranch ;

    public IfStmNode(Node _guard, ArrayList<Node> _thenbranch, ArrayList<Node> _elsebranch) {
        guard = _guard ;
        thenbranch = _thenbranch ;
        elsebranch = _elsebranch ;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        errors.addAll(guard.checkSemantics(ST, _nesting));

        for(Node thenB: thenbranch) {
            errors.addAll(thenB.checkSemantics(ST, _nesting));
        }

        for(Node elseB: elsebranch) {
            errors.addAll(elseB.checkSemantics(ST, _nesting));
        }

        return errors;
    }

    public Type typeCheck() {
        if (guard.typeCheck() instanceof BoolType) {
            for(Node thenB: thenbranch) {
                thenB.typeCheck() ;
            }

            for(Node elseB: elsebranch) {
                elseB.typeCheck() ;
            }

            return new VoidType();

        } else {
            System.out.println("Type Error: non boolean condition in if");
            return new ErrorType() ;
        }
    }

    public String codeGeneration() {
        String labelthen = SimpLanlib.freshLabel();
        String labelend = SimpLanlib.freshLabel();
        String thencode = "";
        String elsecode = "";

        for(Node thenC: thenbranch) {
            thencode += thenC.codeGeneration();
        }

        for(Node elseC: elsebranch) {
            elsecode += elseC.codeGeneration();
        }

        return guard.codeGeneration() +
                "storei T1 1 \n" +
                "beq A0 T1 "+ labelthen + "\n" +
                elsecode +
                "b " + labelend + "\n" +
                labelthen + ":\n" +
                thencode +
                labelend + ":\n" ;
    }

    public String toPrint(String s) {
        String thenstring = "";
        String elsestring = "";

        for(Node thenS: thenbranch) {
            thenstring += thenS.toPrint(s+"  ");
        }

        for(Node elseS: elsebranch) {
            elsestring += elseS.toPrint(s+"  ");
        }

        return s+"If\n" + guard.toPrint(s+"  ") + thenstring + elsestring;
    }

}