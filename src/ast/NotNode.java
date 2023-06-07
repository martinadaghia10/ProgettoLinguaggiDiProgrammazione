package ast;

import java.util.ArrayList;

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
        return new BoolType();
    }

    public String codeGeneration() {
        return right.codeGeneration() + "not\n";
    }

    public String toPrint(String s) {
        return s + "Not\n" + right.toPrint(s + "  ");
    }
}
