package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class BodyNode implements Node {
    private ArrayList<DecNode> declarations;
    private ArrayList<Node> statements;
    private Node expression;

    public BodyNode() {
        this.declarations = new ArrayList<>();
        this.statements = new ArrayList<>();
        this.expression = null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable _ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        for (DecNode dec : declarations) {
            errors.addAll(dec.checkSemantics(_ST, _nesting));
        }

        for (Node stm : statements) {
            errors.addAll(stm.checkSemantics(_ST, _nesting));
        }

        if (expression != null) { //può esserci o no perchè nella grammatica c'è il ?
            errors.addAll(expression.checkSemantics(_ST, _nesting));
        }

        return errors;
    }

    @Override
    public Type typeCheck() {
        return expression.typeCheck(); //torna solo il tipo dell'exp
    }

    @Override
    public String codeGeneration() {

        String valutodec = "";
        String valutostm = "";

        for(Node decc: declarations) {
            valutodec += decc.codeGeneration();
        }

        for(Node stmm: statements) {
            valutostm += stmm.codeGeneration();
        }

        return "storei sp maxvalue-n"
        + "store fp maxvalue"
        + valutodec
        + valutostm
        + expression.codeGeneration();

    }

    @Override
    public String toPrint(String s) {

        String decstring = "";
        String stmstring = "";
        String expstring = "";

        for(Node decS: declarations) {
            decstring += decS.toPrint(s+"  ");
        }

        for(Node stmS: statements) {
            stmstring += stmS.toPrint(s+"  ");
        }

        if (expression != null) {
            expstring += expression.toPrint(s+"  ");
        }

        return s+"Body\n" + decstring + stmstring + expstring;
    }
}
