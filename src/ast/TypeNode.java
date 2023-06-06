package ast;

import semanticanalysis.SymbolTable;

public abstract class TypeNode implements Node {
    protected String type;

    public TypeNode(String _type) {
        type = _type;
    }

    public String getType() {
        return type;
    }

    @Override
    public abstract void checkSemantics(SymbolTable ST, int nesting);

    @Override
    public abstract Type typeCheck();

    @Override
    public abstract String codeGeneration();

    @Override
    public abstract String toPrint(String indent);
}

