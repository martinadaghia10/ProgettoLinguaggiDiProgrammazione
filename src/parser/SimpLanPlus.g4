grammar SimpLanPlus ;

prog   : exp                    #singleExp
       | (dec)+ (stm)* (exp)?   #multiDec
       ;


dec    : type ID ';'            #varDec
       | type ID '(' ( param ( ',' param)* )? ')' '{' body '}'      #funDec
       ;

param  : type ID #para
       ;

body   : (dec)* (stm)* (exp)? #body1
	   ;

type   : 'int'
       | 'bool'
       | 'void'
       ;

stm    : ID '=' exp ';'     #assignExp //assegnamento
       | ID '(' (exp (',' exp)* )? ')' ';'       #funExp
       | 'if' '(' cond=exp ')' '{' thenBranch '}' ('else' '{' elseBranch '}')?         #ifStm
	   ;
	   thenBranch: (stm)+ ;
	   elseBranch: (stm)+ ;


exp    :  INTEGER           #intVal
       | ('true' | 'false') #boolVal
       | ID                 #varExp
       | not='!' right=exp  #not
       | left=exp (mul='*' | div='/') right=exp     #muldiv
       | left=exp (plus='+' | sub='-') right=exp    #plussub
       | left=exp (great='>' | less='<' | greateq='>=' | lesseq='<=' | equal='==') right=exp    #gle
       | left=exp (and='&&' | or='||') right=exp    #andor
       | 'if' '(' cond=exp ')' '{' thenBranch2 '}' 'else' '{' elseBranch2 '}'       #ifStmExp
       | '(' exp ')'        #baseExp
       | ID '(' (exp (',' exp)* )? ')'       #funExp2
       ;
       thenBranch2: (stm)* exp ;
       elseBranch2: (stm)* exp ;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

//Numbers
fragment DIGIT  : '0'..'9';
INTEGER         : DIGIT+;

//IDs
fragment CHAR   : 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | DIGIT)* ;

//ESCAPE SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS     : '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;

ERR             : .  -> channel(HIDDEN);