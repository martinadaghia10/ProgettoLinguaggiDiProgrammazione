package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class LessNode implements Node {
    private Node left;
    private Node right;

    public LessNode(Node _left, Node _right) {
        left = _left;
        right = _right;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        errors.addAll(left.checkSemantics(ST, _nesting));
        errors.addAll(right.checkSemantics(ST, _nesting));

        return errors;
    }

    @Override
    public Type typeCheck() {
        if (left.typeCheck() instanceof IntType && right.typeCheck() instanceof IntType)
            return new BoolType();
        else {
            System.out.println("Type Error: Non integers in less than to comparison");
            return new ErrorType();
        }
    }

    @Override
    public String codeGeneration() {
        String labelTrue = SimpLanlib.freshLabel();
        String labelEnd = SimpLanlib.freshLabel();

        return left.codeGeneration() +
                "pushr A0 \n" +
                right.codeGeneration() +
                "popr T1 \n" +
                "blt T1 A0 " + labelTrue + " \n" + //branch on less than T1 < A0
                "push 0 \n" +
                "b " + labelEnd + " \n" +
                labelTrue + ": \n" +
                "push 1 \n" +
                labelEnd + ": \n";
    }

    @Override
    public String toPrint(String s) {
        return s + "Minor\n" +
                left.toPrint(s + "  ") +
                right.toPrint(s + "  ");
    }
}
