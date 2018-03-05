grammar Expr;

options {
    language = Java;
    output = AST;
    
}

tokens {
    STRUCT;
    FUNC;
    BLOC;
    ARGUMENT;
    AFFECT;
    WHILE;
    IF;
    ELSE;
    RETURN;
    SPE_UNAIRE;
    FUNC_ARGS;
    VAR;
    VEC;
    DECL;
    IND;
    ASSOC;
}


fichier
    :decl*;
    
decl    
    :decl_func
    |decl_struct
    ;

decl_struct
    :'struct' WS* IDF NEWLINE* '{' ( WS* (NEWLINE WS*)* IDF WS* ':' WS* type WS*  (',' WS* (NEWLINE WS*)* IDF WS* ':' WS* type WS* )* )? NEWLINE* '}' -> ^(STRUCT IDF ^(VAR IDF type)*)
    ;

decl_func
    :'fn' WS* IDF '(' args? ')' ( WS* '->' WS* type )? (NEWLINE WS*)* bloc -> ^(FUNC IDF args? (type)? bloc)
    ;

args
    :WS* argument WS* (',' WS* argument WS* )* -> ^(FUNC_ARGS argument*)
    ;

type
    :IDF
    |'Vec' '<' type '>' -> ^(VEC type)
    |'&' type
    |'i32'
    |'bool'
    ;
    
argument
    :IDF WS* ':' WS* type -> ^(ARGUMENT IDF type)
    ;

bloc
    :'{' WS* (NEWLINE WS*)*  instruction '}' -> ^(BLOC instruction)
    ;

instruction
    :';'! WS* (NEWLINE WS*)* instruction?
    |expr instruction2
    |let instruction2
    |whilepro instruction?
    |returnpro instruction2
    |if_expr1 WS* (NEWLINE WS*)* instruction?
    ;

instruction2
    :';'! WS* (NEWLINE WS*)* instruction?
    | (NEWLINE WS*)*
    ;

let
    :'let' WS* ('mut' WS* )? expr letbis? -> ^(DECL  ('mut')? expr  letbis?)
    ;
 
letbis
    :    '=' WS* expr -> ^(AFFECT expr)
    ;
    

returnpro
    :'return' WS*  (expr)? -> ^(RETURN expr?)
    ;
    
whilepro
    :'while' WS* expr (NEWLINE WS*)* bloc WS* (NEWLINE WS*)* -> ^(WHILE expr bloc)
    ;

if_expr1
    : 'if' WS* expr  (NEWLINE WS*)* bloc ('else' WS* if_expr2)? -> ^(IF expr bloc ^(ELSE if_expr2)?)
    ;
    
if_expr2
    :bloc
    |if_expr1
    ;

expr
    : (expr2) ('||'^ WS* expr2)*
    ;
    
expr2
    : (expr3 ) ('&&'^ WS* expr3 )*
    ;

expr3
    : (expr4 ) (WS* opt^ WS* expr4 )*
    ;

expr4
    : (expr5 ) (WS* ops^ WS* expr5 )*
    ;

expr5
    : (expr6 ) (WS* opm^ WS* expr6 )*
    ;

expr6
    :unaire  expr7 -> ^(SPE_UNAIRE unaire expr7)
    |'vec'^ '!['! (expr(','! expr)*)? ']'!
    |'print'^ '!('! expr ')'!
    |expr7
    ;

expr7
    :expr8 expr7b  -> ^(expr8 expr7b?)
    ;
    
expr7b
    :
    | '[' expr ']' expr7b -> ^(IND ^(expr expr7b?))
    |'.' IDF  expr7b -> ^(ASSOC ^(IDF expr7b?))
    ;
    
expr8
    :expr9 expr8b -> ^(expr9 expr8b?)
    ;
    
expr8b
    :'.'! 'len' '('! ')'! 
    |
    ;


expr9
    :CST_ENT
    |'true'
    |'false'
    |IDF  expr9bis -> ^(IDF expr9bis?)
    |bloc
    |'(' expr ')' -> expr
    ;


expr9bis
    :
    |'('! expr9bisbis? ')'!
    |'{' (IDF  WS* ':' expr (','  WS* IDF  WS* ':' expr)*)? '}' -> (^(ARGUMENT IDF expr))*
    ;
    
expr9bisbis
    :WS* expr (',' WS* expr)* -> ^(FUNC_ARGS (^(ARGUMENT expr))*)
    ;

ops
    :'+'
    |'-'
    ;

opm
    :'*'
    |'/'
    ;

opt    
    :'<'
    |'<='
    |'>'
    |'>='
    |'=='
    |'!='
    ;
    
unaire
    :'-'
    |'!'
    |'*'
    |'&'
    ;
    

CST_ENT : '0'..'9'+ ;
IDF : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_' |CST_ENT)* ;
NEWLINE: '\r'? '\n'  {$channel=HIDDEN;};
WS : (' '|'\t') {$channel=HIDDEN;};


