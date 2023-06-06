package ast;

import java.util.ArrayList;
import java.util.HashMap;

import evaluator.SimpLanlib;
import semanticanalysis.STentry;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class FunNode implements Node {
    private String id;
    private Type returntype;
    private ArrayList<ParamNode> parlist;
    private ArrayList<Node> declist;
    private Node body;
    private ArrowType type;
    private int nesting;
    private String flabel;

    public FunNode(String _id, Type _returntype, ArrayList<ParamNode> _parlist, ArrayList<Node> _declist, Node _body) {
        id = _id;
        returntype = _returntype;
        parlist = _parlist;
        declist = _declist;
        body = _body;
    }

    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        nesting = _nesting;

        if (ST.lookup(id) != null) {
            errors.add(new SemanticError("Identifier " + id + " already declared"));
        } else {
            HashMap<String, STentry> HM = new HashMap<String, STentry>();
            ArrayList<Type> partypes = new ArrayList<Type>();

            ST.add(HM);

            for (ParamNode arg : parlist) {
                partypes.add(arg.getType());
                if (ST.top_lookup(arg.getId())) {
                    errors.add(new SemanticError("Parameter id " + arg.getId() + " already declared"));
                } else {
                    ST.insert(arg.getId(), arg.getType(), nesting + 1, "");
                }
            }

            type = new ArrowType(partypes, returntype);

            ST.increaseoffset();
            for (Node dec : declist) {
                errors.addAll(dec.checkSemantics(ST, nesting + 1));
            }

            errors.addAll(body.checkSemantics(ST, nesting + 1));
            ST.remove();

            flabel = SimpLanlib.freshFunLabel();

            ST.insert(id, type, nesting, flabel);
        }
        return errors;
    }

    public Type typeCheck() {
        if (declist != null) {
            for (Node dec : declist) {
                dec.typeCheck();
            }
        }
        if (Type.isEqual(body.typeCheck(), returntype)) {
            return null;
        } else {
            System.out.println("Wrong return type for function " + id);
            return new ErrorType();
        }
    }

    public String codeGeneration() {
        String declCode = "";
        if (declist.size() != 0) {
            for (Node dec : declist) {
                declCode += dec.codeGeneration();
            }
        }

        SimpLanlib.putCode(flabel + ":\n"
                + "pushr RA \n"
                + declCode
                + body.codeGeneration()
                + "addi SP " + declist.size() + "\n"
                + "popr RA \n"
                + "addi SP " + parlist.size() + "\n"
                + "pop \n"
                + "store FP 0(FP) \n"
                + "move FP AL \n"
                + "subi AL 1 \n"
                + "pop \n"
                + "rsub RA \n");

        return "push " + flabel + "\n";
    }

    public String toPrint(String s) {
        String parlstr = "";
        for (Node par : parlist) {
            parlstr += par.toPrint(s);
        }
        String declstr = "";
        if (declist != null) {
            for (Node dec : declist) {
                declstr += dec.toPrint(s + " ");
            }
        }
        return s + "Fun:" + id + "\n"
                + parlstr
                + declstr
                + "\n"
                + body.toPrint(s + "  ");
    }
}
