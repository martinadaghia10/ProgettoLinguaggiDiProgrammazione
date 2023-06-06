package ast;

import java.util.ArrayList;

import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class AssegnamentoNode implements Node {
    private String id;
    private Node expr;

    //id = exp
    public AssegnamentoNode(String _id, Node _expr) {
        id = _id;
        expr = _expr;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        // Controllo la correttezza del tipo dell'espressione
        Type exprType = expr.typeCheck();
        Type idType = ST.getType(id, _nesting);
        if (!(Type.isEqual(exprType, idType))) {
            errors.add(new SemanticError("Type Error: Incompatible types in assignment for variable " + id));
        }

        return errors;
    }

    @Override
    public Type typeCheck() {
        return null; // Non utilizzato
    }

    @Override
    public String codeGeneration() {
        return expr.codeGeneration() +
                "pushr A0 \n" +
                "push " + id + " \n" +
                "store \n";
    }

    @Override
    public String toPrint(String s) {
        return s + "Ass " + id + ":\n" +
                expr.toPrint(s + "  ");
    }
}
