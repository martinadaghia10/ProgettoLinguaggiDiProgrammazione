package ast;

import java.util.ArrayList;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class ExpNode implements Node {
    private String value;

    public ExpNode(String _value) {
        value = _value;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int nesting) {
        // Esegui l'analisi semantica per l'espressione
        return new ArrayList<>();
    }

    @Override
    public Type typeCheck() {
        // Esegui il controllo del tipo per l'espressione
        // Restituisci il tipo corrispondente al valore dell'espressione
        if (value.equals("true") || value.equals("false")) {
            return new BoolType();
        } else {
            return new IntType();
        }
    }

    @Override
    public String codeGeneration() {
        // Genera il codice per l'espressione
        // Restituisci il codice generato
        return value;
    }

    @Override
    public String toPrint(String indent) {
        // Restituisci una rappresentazione in forma di stringa dell'espressione
        return indent + "Exp: " + value;
    }
}