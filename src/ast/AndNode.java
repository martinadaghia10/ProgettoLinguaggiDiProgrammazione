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
        String labelTrue = SimpLanlib.freshLabel();
        String labelEnd = SimpLanlib.freshLabel();

        return left.codeGeneration() + //left in A0
                "storei T1 0 \n" + //metto 0 in A0 --> 0 = false
                "beq A0 T1 \n" + "b " + labelEnd + "\n" + //se è uguale esco
                //se è diverso valuto dx
                right.codeGeneration() +
                "beq A0 T1 \n" + "b " + labelEnd +  "\n" +
                "storei A0 1 \n" + "b " + labelTrue +  "\n" +
                labelEnd + ": \n" +
                "storei A0 0 \n" + labelTrue +  ": \n"
                ;
    }

    @Override
    public String toPrint(String s) {
        return s + "And\n" +
                left.toPrint(s + "  ") +
                right.toPrint(s + "  ");
    }
}
