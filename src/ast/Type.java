package ast;

import java.util.ArrayList;

import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class Type implements Node {
    public static boolean isEqual(Type A, Type B) {
        if (A.getClass().equals(B.getClass())) return true ;
        else return false ;
    }
    public String toPrint(String s) {
        return s ;
    }

    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        // It is never invoked
        return null;
    }
    @Override
    public Type typeCheck() {
        // It is never invoked
        return null;
    }
    @Override
    public String codeGeneration() {
        // It is never invoked
        return "";
    }

    public static boolean isSubtypeOf(Type typeA, Type typeB) {
        // Verifica se typeA è un sottotipo di typeB
        // Implementa la logica specifica per il controllo dei sottotipi

        if (typeA.getClass().equals(typeB.getClass())) {
            return true;
        }

        // Aggiungi qui ulteriori controlli specifici per i sottotipi, se necessario

        // Altrimenti, typeA non è un sottotipo di typeB
        return false;
    }



}
