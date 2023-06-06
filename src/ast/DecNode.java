package ast;

import java.util.ArrayList;

import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class DecNode implements Node {
    private TypeNode type;
    private String id;
    private ArrayList<ParamNode> parameters;
    private BodyNode body;

    public DecNode(TypeNode _type, String _id) {
        type = _type;
        id = _id;
        parameters = new ArrayList<>();
        body = null;
    }

    public DecNode(TypeNode _type, String _id, ArrayList<ParamNode> _parameters, BodyNode _body) {
        type = _type;
        id = _id;
        parameters = _parameters;
        body = _body;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        if (body != null) {
            // Dichiarazione di una funzione
            if (ST.contains(id, _nesting)) {
                errors.add(new SemanticError("Function name " + id + " already declared in the current scope"));
            }

            // Aggiungo la funzione alla tabella dei simboli
            ArrowType functionType = new ArrowType(type.getType(), getParameterTypes(), body.getReturnType());
            ST.addFunction(id, functionType, _nesting);

            // Creo una nuova tabella dei simboli per il corpo della funzione
            SymbolTable functionST = new SymbolTable(ST);
            ST.addNestedTable(functionST);

            // Controllo la correttezza dei parametri
            for (ParamNode param : parameters) {
                errors.addAll(param.checkSemantics(functionST, _nesting + 1));
            }

            // Controllo la correttezza del corpo della funzione
            errors.addAll(body.checkSemantics(functionST, _nesting + 1));

            // Rimuovo la tabella dei simboli interna alla funzione
            ST.removeNestedTable();
        } else {
            // Dichiarazione di una variabile
            if (ST.containsInCurrentScope(id)) {
                errors.add(new SemanticError("Variable name " + id + " already declared in the current scope"));
            } else {
                ST.addVariable(id, type.getType(), _nesting);
            }
        }

        return errors;
    }

    @Override
    public Type typeCheck() {
        return null; // Non utilizzato
    }

    private ArrayList<Type> getParameterTypes() {
        ArrayList<Type> parameterTypes = new ArrayList<>();
        for (ParamNode param : parameters) {
            parameterTypes.add(param.getTypeNode().getType());
        }
        return parameterTypes;
    }
}
