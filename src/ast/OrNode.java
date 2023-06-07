package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class OrNode implements Node {
    private Node left;
    private Node right;

    public OrNode(Node _left, Node _right) {
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
            System.out.println("Type Error: Non-boolean operands in logical OR");
            return new ErrorType();
        }
    }

    @Override
    public String codeGeneration() {
        String labelFalse = SimpLanlib.freshLabel();
        String labelEnd = SimpLanlib.freshLabel();


        return left.codeGeneration() +
                "storei T1 1 \n" + //metto 0 in A0 --> 0 = false
                "beq A0 T1 \n" + "b " + labelEnd + "\n" + //se è uguale esco
                //se è diverso valuto dx
                right.codeGeneration() +
                "beq A0 T1 \n" + "b " + labelEnd +  "\n" +
                "storei A0 0 \n" + "b " + labelFalse +  "\n" +
                labelEnd + ": \n" +
                "storei A0 1 \n" + labelFalse +  ": \n"
                ;
    }

    @Override
    public String toPrint(String s) {
        return s + "Or\n" +
                left.toPrint(s + "  ") +
                right.toPrint(s + "  ");
    }
}
