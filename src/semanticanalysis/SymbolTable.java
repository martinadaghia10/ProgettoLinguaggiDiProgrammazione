package semanticanalysis;

import java.util.ArrayList;
import java.util.HashMap;
import ast.BoolType ;
import ast.ErrorType;
import ast.IntType;
import ast.Type;

public class SymbolTable {
    private ArrayList<HashMap<String,STentry>>  symbol_table;
    private ArrayList<Integer> offset; //tiene traccia degli offset per ogni scope

    public SymbolTable() {
        symbol_table = new ArrayList<HashMap<String,STentry>>() ;
        offset = new ArrayList<Integer>() ;
    }

    public Integer nesting() {
        return symbol_table.size() -1 ;
    }

    public STentry lookup(String id) {
        int n = symbol_table.size() - 1 ;
        boolean found = false ;
        STentry T = null ;
        while ((n >= 0) && !found) {
            HashMap<String,STentry> H = symbol_table.get(n) ;
            T = H.get(id) ;
            if (T != null) found = true ;
            else n = n-1 ;
        }
        return T ;
    }

    public Integer nslookup(String id) {
        int n = symbol_table.size() - 1 ;
        boolean found = false ;
        while ((n >= 0) && !found) {
            HashMap<String,STentry> H = symbol_table.get(n) ;
            if (H.get(id) != null) found = true ; //trova l'id
            else n = n-1; //se l'id non viene trovato in nessuno degli scope, restituisce -1
        }
        return n; //restituisce l'indice dell'ultimo scope in cui l'id viene trovato
    }

    public void add(HashMap<String,STentry> H) {
        symbol_table.add(H) ;
        offset.add(1) ;		// si inizia da 2 perche` prima ci sonop FP e AL    //incremento ogni volta che aggiungo una nuova voce alla tabella
    }

    public void remove() {
        int x = symbol_table.size() ;
        symbol_table.remove(x-1) ; //rimuovo lo scope
        offset.remove(x-1) ; //rimuovo il suo offset
    }

    public boolean top_lookup(String id) { //ricerco l'id solo nello scope più esterno della tabella
        int n = symbol_table.size() - 1 ;
        STentry T = null ;
        HashMap<String,STentry> H = symbol_table.get(n) ;
        T = H.get(id) ;
        return (T != null) ;
    }

    public void insert(String id, Type type, int _nesting, String _label) { //inserisce un nuovo id nella tabella dei simboli
        int n = symbol_table.size() - 1 ;
        HashMap<String,STentry> H = symbol_table.get(n) ;
        symbol_table.remove(n) ;
        int offs = offset.get(n) ;
        offset.remove(n) ;
        STentry idtype = new STentry(type,offs,_nesting, _label) ;
        H.put(id,idtype) ;
        symbol_table.add(H) ;
        if (type.getClass().equals((new BoolType()).getClass()))
            offs = offs + 1 ; // we always increment the offset by 1 otherwise we need ad-hoc
            // bytecode operations
        else if (type.getClass().equals((new IntType()).getClass()))
            offs = offs + 1 ;
        else offs = offs + 1 ;
        offset.add(offs) ;
    }

    public void increaseoffset() { //incrementa di 1 l'offset dell'ultimo scope
        int n = offset.size() - 1 ;
        int offs = offset.get(n) ;
        offset.remove(n) ;
        offs = offs + 1 ;
        offset.add(offs) ;
    }


    public Type getType(String id, int nesting) { //restituisce il tipo dell'id all'interno che si trova in un determinato livello di annidamento
        int n = nesting;
        boolean found = false;
        while (n >= 0 && !found) {
            HashMap<String, STentry> H = symbol_table.get(n);
            STentry entry = H.get(id);
            if (entry != null) {
                found = true;
                return entry.getType();
            }
            n--;
        }

        // L'identificatore non è stato trovato nella tabella dei simboli
        // Gestisco l'errore o restituisco un tipo di default
        System.out.println("Type Error: Variable " + id + " not found in symbol table");
        return new ErrorType();
    }


}
