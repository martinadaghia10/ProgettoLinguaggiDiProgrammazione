package ast;

import java.util.ArrayList;

import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class DecNode implements Node {
    private String id;
    private Type type;
    private ArrayList<ParamNode> parameters;
    private ArrayList<Node> body;
    private int nesting;

    public DecNode(String id, Type type) {
        this.id = id;
        this.type = type;
        this.parameters = new ArrayList<>();
        this.body = new ArrayList<>();
    }

    public DecNode(String id, Type type, ArrayList<ParamNode> parameters, ArrayList<Node> body) {
        this.id = id;
        this.type = type;
        this.parameters = parameters;
        this.body = body;
    }

    public void addParameter(ParamNode parameter) {
        parameters.add(parameter);
    }

    public void addStatement(Node statement) {
        body.add(statement);
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        nesting = _nesting;
        // Check the type of the declaration
        if (type instanceof Type) {
            // Perform type checking for the type
            Type declaredType = (Type) type;
            Type actualType = ST.getType(id, nesting);
            if (!Type.isEqual(declaredType, actualType)) {
                errors.add(new SemanticError("Type mismatch in declaration: " + id));
            }
        } else {
            errors.add(new SemanticError("Invalid type in declaration: " + id));
        }

        // Check the semantics of the parameters
        for (ParamNode parameter : parameters) {
            errors.addAll(parameter.checkSemantics(ST, nesting));
        }

        // Check the semantics of the body statements
        for (Node statement : body) {
            errors.addAll(statement.checkSemantics(ST, nesting));
        }

        return errors;
    }

    @Override
    public Type typeCheck() {
        // Perform type checking for the body statements
        for (Node statement : body) {
            statement.typeCheck();
        }
        return null;
    }

    @Override
    public String codeGeneration() {
        StringBuilder sb = new StringBuilder();
        // Generate code for the body statements
        for (Node statement : body) {
            sb.append(statement.codeGeneration());
        }
        return sb.toString();
    }

    @Override
    public String toPrint(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("DecNode: ").append(id).append("\n");
        sb.append(indent).append("  Type: ").append(type.toPrint("")).append("\n");
        sb.append(indent).append("  Parameters:\n");
        for (ParamNode parameter : parameters) {
            sb.append(parameter.toPrint(indent + "    "));
        }
        sb.append(indent).append("  Body:\n");
        for (Node statement : body) {
            sb.append(statement.toPrint(indent + "    "));
        }
        return sb.toString();
    }
}
