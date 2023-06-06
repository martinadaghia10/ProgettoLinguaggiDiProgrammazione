package ast;

import java.util.ArrayList;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class StmNode implements Node {
    private String id;
    private Node expression;

    public StmNode(String _id, Node _expression) {
        id = _id;
        expression = _expression;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int nesting) {
        // Esegui l'analisi semantica per lo statement
        ArrayList<SemanticError> errors = new ArrayList<>();
        // Esegui l'analisi semantica per l'espressione
        errors.addAll(expression.checkSemantics(ST, nesting));
        return errors;
    }

    @Override
    public Type typeCheck() {
        // Esegui il controllo del tipo per lo statement
        // Restituisci il tipo dell'espressione
        return expression.typeCheck();
    }

    @Override
    public String codeGeneration() {
        // Genera il codice per lo statement
        // Restituisci il codice generato
        return expression.codeGeneration();
    }

    @Override
    public String toPrint(String indent) {
        // Restituisci una rappresentazione in forma di stringa dello statement
        return indent + "Stm: " + id + " = " + expression.toPrint("");
    }
}