package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class NotNode implements Node {
    private Node right;

    public NotNode(Node _right) {
        right = _right;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        errors.addAll(right.checkSemantics(ST, _nesting));

        return errors;
    }

    @Override
    public Type typeCheck() {
        if (right.typeCheck() instanceof IntType)
            return new BoolType();
        else {
            System.out.println("Type Error: Non integers not to comparison");
            return new ErrorType();
        }
    }

    public String codeGeneration() {
        String labelTrue = SimpLanlib.freshLabel();
        String labelEnd = SimpLanlib.freshLabel();

        return right.codeGeneration()
                + "store T1 1 \n"
                + "beq A0 T1 " + labelTrue + "\n"
                + "store A0 0 \n"
                + "b " + labelEnd + "\n"
                + labelTrue + ": \n"
                + "store A0 1 \n"
                + labelEnd + ": \n";
    }

    public String toPrint(String s) {
        return s + "Not\n" + right.toPrint(s + "  ");
    }
}
