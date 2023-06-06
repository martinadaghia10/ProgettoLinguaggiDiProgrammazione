grammar SimpLanPlus ; //definisco la mia grammatica (regole che definiscono la struttura sintattica di un linguaggio)

/*** di seguito si presentano le definizioni delle regole sintattiche del linguaggio ***/

/* DEFINIZIONE DEL PROGRAMMA */
prog   : exp  //singola espressone
       | (dec)+ (stm)* (exp)? //1 o + dichiarazioni, 0 o + assegnamenti, nessuna o 1 espressione
       ;

/* STRUTTURA DI UNA DICHIARAZIONE */
dec    : type ID ';' //dichiarazione variabile (no inizializzazione)
       | type ID '(' ( param ( ',' param)* )? ')' '{' body '}' //dichiarazione di una funzione (lista di parametri) {corpo della funzione}
       ;

/* STRUTTURA DI UN PARAMETRO */
param  : type ID ;

/* STRUTTURA DEL CORPO DELLA FUNZIONE */
body   : (dec)* (stm)* (exp)? //0 o + dichiarazioni, 0 o + istruzioni, può esserci oppure no un'espressione (è opzionale)
	   ;

/* DEFINISCE I TIPI DEI DATI: interi, booleani o void */
type   : 'int'
       | 'bool'
       | 'void'
       ;

/* STRUTTURA DI DIVERSI ASSEGNAMENTI/ISTRUZIONI */
stm    : ID '=' exp ';' //assegnazione di un valore a una variabile
       | ID '(' (exp (',' exp)* )? ')' ';' //chiamata di funzione senza valore di ritorno
       | 'if' '(' exp ')' '{' (stm)+ '}' ('else' '{' (stm)+ '}')? //if-else, l'else può essere assente
	   ;

/* STRUTTURA DELLE ESPRESSIONI */
exp    :  INTEGER | 'true' | 'false' //intero o valori booleani
       | ID //identificatore che può far riferimento a una variabile o una funzione
       | '!' exp //negazione logica di un'espressione booleana
       | exp ('*' | '/') exp //espressioni di moltiplicazione o divisione
       | exp ('+' | '-') exp //espressioni di somma o sottrazione
       | exp ('>' | '<' | '>=' | '<=' | '==') exp //espressioni per confronto
       | exp ('&&' | '||') exp //espressioni con operatore logico and o or
       | 'if' '(' exp ')' '{' (stm)* exp '}' 'else' '{' (stm)* exp '}' //if-else: {0 o + stm, espressione}
       | '(' exp ')' //espressione
       | ID '(' (exp (',' exp)* )? ')' //chiamata di funzione: una espressione inizia con un identificatore seguita da 0 o + espressioni
       ;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

//Numbers
fragment DIGIT  : '0'..'9'; //cifra numerica da 0 a 9
INTEGER         : DIGIT+; //sequenza di 0 o + cifre numeriche

//IDs
fragment CHAR   : 'a'..'z' |'A'..'Z' ; //singolo carattere
ID              : CHAR (CHAR | DIGIT)* ; //id = sequenze di caratteri seguiti da 0 o + caratteri alfanumerici

//ESCAPE SEQUENCES: definizione spazi bianchi, commenti su una riga,  commenti su più righe ed eventuali errori
WS              : (' '|'\t'|'\n'|'\r')-> skip; //spazi bianchi = spazio, tabulatore, carattere di nuova linea o un carattere di ritorno a capo. -> skip = spazi bianchi non devono essere inclusi come token nel risultato dell'analisi => ignorati
LINECOMENTS     : '//' (~('\n'|'\r'))* -> skip; //commenti di linea. (~('\n'|'\r'))* = carattere diverso da un carattere di nuova linea o di a capo ripetuto 0 o + volte. -> skip =  commenti ignorati e non inclusi come token nell'output dell'analisi
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip; //commenti multi-linea. (~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* = carattere diverso da / o *, o a una sequenza che inizia con / seguito da un carattere diverso da *, oppure a una sequenza che inizia con * seguito da un carattere diverso da /, oppure a un altro commento multi-linea. -> skip = commenti devono essere ignorati e non inclusi come token nell'output dell'analisi

ERR             : .  -> channel(HIDDEN); //regola per gli errori. "." = carattere che non è stato riconosciuto dalle altre regole. -> channel(HIDDEN) = caratteri che corrispondono a questa regola devono essere inseriti in un canale nascosto e non inclusi come token nell'output dell'analisi