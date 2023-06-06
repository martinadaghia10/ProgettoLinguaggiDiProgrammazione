package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class AndNode implements Node {
    private Node left;
    private Node right;

    public AndNode(Node _left, Node _right) {
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
        if (left.typeCheck() instanceof BoolType && right.typeCheck() instanceof BoolType)
            return new BoolType();
        else {
            System.out.println("Type Error: Non-boolean operands in logical AND");
            return new ErrorType();
        }
    }

    @Override
    public String codeGeneration() {
        String l1 = SimpLanlib.generateLabel();
        String l2 = SimpLanlib.generateLabel();

        return left.codeGeneration() +
                "pushr A0 \n" +
                right.codeGeneration() +
                "popr T1 \n" +
                "and T1 A0 \n" +
                "popr A0 \n" +
                "bz A0 " + l1 + " \n" +
                "pushr true \n" +
                "jmp " + l2 + " \n" +
                l1 + ": pushr false \n" +
                l2 + ":";
    }

    @Override
    public String toPrint(String s) {
        return s + "And\n" +
                left.toPrint(s + "  ") +
                right.toPrint(s + "  ");
    }
}
