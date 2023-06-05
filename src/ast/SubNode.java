package ast;

import java.util.ArrayList;

import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class SubNode implements Node {
    private Node left;
    private Node right;

    public SubNode(Node _left, Node _right) {
        left = _left;
        right = _right;
    }

    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        errors.addAll(left.checkSemantics(ST, _nesting));
        errors.addAll(right.checkSemantics(ST, _nesting));

        return errors;
    }

    public Type typeCheck() {
        if ((left.typeCheck() instanceof IntType) && (right.typeCheck() instanceof IntType))
            return new IntType();
        else {
            System.out.println("Type Error: Non integers in subtraction");
            return new ErrorType();
        }
    }

    public String codeGeneration() {
        return left.codeGeneration() +
                "pushr A0 \n" +
                right.codeGeneration() +
                "popr T1 \n" +
                "sub A0 T1 \n" +
                "popr A0 \n";
    }

    public String toPrint(String s) {
        return s + "Sub\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
    }
}
