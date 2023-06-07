package ast;

import java.util.ArrayList;

import semanticanalysis.SemanticError ;
import semanticanalysis.SymbolTable ;

public class ProgNode implements Node {
    private ArrayList<Node> decList;
    private ArrayList<Node> stmList;
    private Node exp;

    public ProgNode(ArrayList<Node> _decList, ArrayList<Node> _stmList, Node _exp) {
        decList = _decList;
        stmList = _stmList;
        exp = _exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        for (Node dec : decList) {
            errors.addAll(dec.checkSemantics(ST, _nesting));
        }

        for (Node stm : stmList) {
            errors.addAll(stm.checkSemantics(ST, _nesting));
        }

        if (exp != null) {
            errors.addAll(exp.checkSemantics(ST, _nesting));
        }

        return errors;
    }

    @Override
    public Type typeCheck() {
        Type expType = null;
        for (Node dec : decList) {
            dec.typeCheck();
        }

        for (Node stm : stmList) {
            stm.typeCheck();
        }

        if (exp != null) {
            expType = exp.typeCheck();
        }

        return expType;
    }

    @Override
    public String codeGeneration() {
        StringBuilder code = new StringBuilder();

        for (Node dec : decList) {
            code.append(dec.codeGeneration());
        }

        for (Node stm : stmList) {
            code.append(stm.codeGeneration());
        }

        if (exp != null) {
            code.append(exp.codeGeneration());
        }

        code.append("halt\n");

        return code.toString();
    }

    @Override
    public String toPrint(String s) {
        StringBuilder result = new StringBuilder("Prog\n");

        for (Node dec : decList) {
            result.append(dec.toPrint(s + "  "));
        }

        for (Node stm : stmList) {
            result.append(stm.toPrint(s + "  "));
        }

        if (exp != null) {
            result.append(exp.toPrint(s + "  "));
        }

        return result.toString();
    }
}
