package ast;

import java.util.ArrayList;

import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class GreaterNode implements Node {
    private Node left;
    private Node right;

    public GreaterNode(Node _left, Node _right) {
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
        return new BoolType();
    }

    @Override
    public String codeGeneration() {
        String labelTrue = FreshLabelGenerator.generateLabel("true");
        String labelEnd = FreshLabelGenerator.generateLabel("end");

        return left.codeGeneration() +
                "pushr A0 \n" +
                right.codeGeneration() +
                "popr T1 \n" +
                "gt A0 T1 " + labelTrue + " \n" +
                "push 0 \n" +
                "b " + labelEnd + " \n" +
                labelTrue + ": \n" +
                "push 1 \n" +
                labelEnd + ": \n";
    }

    @Override
    public String toPrint(String s) {
        return s + "Great\n" +
                left.toPrint(s + "  ") +
                right.toPrint(s + "  ");
    }
}
