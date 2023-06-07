package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;
import semanticanalysis.VoidType;

public class IfStmExpNode implements Node {
    private Node guard ;
    private ArrayList<Node> thenbranch ;
    private ArrayList<Node> elsebranch ;
    private Node thenExpbranch;
    private Node elseExpbranch;

    public IfStmExpNode(Node guard, ArrayList<Node> thenbranch, Node thenExpbranch, ArrayList<Node> elsebranch, Node elseExpbranch) {
        this.guard = guard;
        this.thenbranch = thenbranch;
        this.thenExpbranch = thenExpbranch;
        this.elsebranch = elsebranch;
        this.elseExpbranch = elseExpbranch;
    }


    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        errors.addAll(guard.checkSemantics(ST, _nesting));

        for(Node thenB: thenbranch) {
            errors.addAll(thenB.checkSemantics(ST, _nesting));
        }
        errors.addAll(thenExpbranch.checkSemantics(ST, _nesting));

        for(Node elseB: elsebranch) {
            errors.addAll(elseB.checkSemantics(ST, _nesting));
        }
        errors.addAll(elseExpbranch.checkSemantics(ST, _nesting));
        return errors;
    }

    public Type typeCheck() {
        if (guard.typeCheck() instanceof BoolType) {
            if (thenbranch != null) {
                for (Node thenB : thenbranch) {
                    thenB.typeCheck();
                }
            }
            if (elsebranch != null) {
                for (Node elseB : elsebranch) {
                    elseB.typeCheck();
                }
            }

            Type thenExpType= thenExpbranch.typeCheck();
            Type elseExpType= elseExpbranch.typeCheck();
            if (thenExpType.getClass().equals(elseExpType.getClass()))
                return thenExpType;
            else {
                System.out.println("Type Error: incompatible types in then and else branches");
                return new ErrorType();
            }
        } else {
            System.out.println("Type Error: non boolean condition in if");
            return new ErrorType() ;
        }
    }

    public String codeGeneration() {
        String labelthen = SimpLanlib.freshLabel();
        String labelend = SimpLanlib.freshLabel();
        String thencode = "";
        String elsecode = "";

        for(Node thenC: thenbranch) {
            thencode += thenC.codeGeneration();
        }

        for(Node elseC: elsebranch) {
            elsecode += elseC.codeGeneration();
        }

        return guard.codeGeneration() +
                "storei T1 1 \n" +
                "beq A0 T1 "+ labelthen + "\n" +
                elsecode + elseExpbranch.codeGeneration()+
                "b " + labelend + "\n" +
                labelthen + ":\n" +
                thencode + thenExpbranch.codeGeneration()+
                labelend + ":\n" ;
    }

    public String toPrint(String s) {
        String thenstring = "";
        String elsestring = "";

        for(Node thenS: thenbranch) {
            thenstring += thenS.toPrint(s+"  ");
        }

        for(Node elseS: elsebranch) {
            elsestring += elseS.toPrint(s+"  ");
        }

        return s+"If\n" + guard.toPrint(s+"  ") + thenstring +thenExpbranch.toPrint(s+"  ")+ elsestring+elseExpbranch.toPrint(s+"  ");
    }
}