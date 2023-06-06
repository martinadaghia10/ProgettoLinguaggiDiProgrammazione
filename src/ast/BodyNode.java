package ast;

import java.util.ArrayList;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class BodyNode implements Node {
    private ArrayList<DecNode> declarations;
    private ArrayList<StmNode> statements;
    private ExpNode expression;

    public BodyNode(ArrayList<DecNode> decs, ArrayList<StmNode> stms, ExpNode exp) {
        declarations = decs;
        statements = stms;
        expression = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int nestingLevel) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        for (DecNode dec : declarations) {
            errors.addAll(dec.checkSemantics(ST, nestingLevel));
        }

        for (StmNode stm : statements) {
            errors.addAll(stm.checkSemantics(ST, nestingLevel));
        }

        if (expression != null) {
            errors.addAll(expression.checkSemantics(ST, nestingLevel));
        }

        return errors;
    }

    @Override
    public Type typeCheck() {
        // Perform type checking on the expression, if present
        if (expression != null) {
            return expression.typeCheck();
        }

        return null;
    }

    @Override
    public String codeGeneration() {
        StringBuilder code = new StringBuilder();

        // Generate code for declarations
        for (DecNode dec : declarations) {
            code.append(dec.codeGeneration());
        }

        // Generate code for statements
        for (StmNode stm : statements) {
            code.append(stm.codeGeneration());
        }

        // Generate code for expression, if present
        if (expression != null) {
            code.append(expression.codeGeneration());
        }

        return code.toString();
    }

    @Override
    public String toPrint(String indent) {
        StringBuilder output = new StringBuilder(indent + "Body\n");

        // Print declarations
        for (DecNode dec : declarations) {
            output.append(dec.toPrint(indent + "  "));
        }

        // Print statements
        for (StmNode stm : statements) {
            output.append(stm.toPrint(indent + "  "));
        }

        // Print expression, if present
        if (expression != null) {
            output.append(expression.toPrint(indent + "  "));
        }

        return output.toString();
    }
}
