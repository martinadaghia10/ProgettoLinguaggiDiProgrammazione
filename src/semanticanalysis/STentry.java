package semanticanalysis;

import ast.Type;

/* STentry rappresenta una voce nella tabella dei simboli durante l'analisi semantica */
public class STentry {

    private Type type ; //tipo associato all'id
    private int offset ; //offset associato all'id. offset = posizione dell'identificatore nella memoria
    private int nesting ; //= a quale livello di blocco/scope l'id appartiene
    private String label ; //etichetta associata all'id

    public STentry(Type _type, int _offset, int _nesting) {
        type = _type ;
        offset = _offset ;
        nesting = _nesting ;
    }

    public STentry(Type _type, int _offset, int _nesting, String  _label) {
        type = _type ;
        offset = _offset ;
        nesting = _nesting ;
        label = _label ;
    }

    public Type gettype() {
        return type ;
    }

    public int getoffset() {
        return offset ;
    }

    public int getnesting() {
        return nesting ;
    }

    public String getlabel() {
        return label ;
    }

}
