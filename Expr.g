grammar Expr;

options {
	language = Java;
	output = AST;
	k = 1;
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
	PRINT;
	DECL;
	IND;
	ASSOC;
	CALL_ARGS;
}

fichier
	:decl*;

decl    
	:decl_func
	|decl_struct
	;

decl_struct
	:'struct' IDF '{' (IDF ':' type (',' IDF ':' type)*)? '}' -> ^(STRUCT IDF ^(VAR IDF type)*)
	;

decl_func
	:'fn' IDF '(' args? ')' ( '->' type )? bloc -> ^(FUNC IDF args? (type)? bloc)
	;

args
	:argument(',' argument)* -> ^(FUNC_ARGS argument*)
	;

type
	:IDF
	|'Vec' '<' type '>' -> ^(VEC type)
	|'&' type
	|'i32'
	|'bool'
	;

argument
	:IDF ':' type -> ^(ARGUMENT IDF type)
	;

bloc
	:'{' instruction '}' -> ^(BLOC instruction)
	;

instruction
	:';'! instruction?
	|expr instruction2
	|let instruction2
	|whilepro instruction?
	|returnpro instruction2
	|if_expr1  instruction?
	;

instruction2
	:';'! instruction?
	| 
	;

let
	:'let' ('mut')? expr letbis? -> ^(DECL  ('mut')? expr  letbis?)
	;

letbis
	:'='  expr -> ^(AFFECT expr)
	;

returnpro
	:'return' (expr)? -> ^(RETURN expr?)
	;

whilepro
	:'while' exprif bloc -> ^(WHILE exprif bloc)
	;

if_expr1
	:'if' exprif bloc ('else' if_expr2)? -> ^(IF exprif bloc ^(ELSE if_expr2)?)
	;

if_expr2
	:bloc
	|if_expr1
	;

exprif
	:(expr1if) ('||'^ expr1if)*
	;

expr1if
	:(expr2if) ('&&'^ expr2if)*
	;

expr2if
	:(expr3if) (opt^ expr3if)*
	;

expr3if
	:(expr4if) (ops^ expr4if)*
	;

expr4if
	:(expr5if) (opm^ expr5if)*
	;

expr5if
	:unaire  expr6if -> ^(SPE_UNAIRE unaire expr6if)
	|'vec' '![' (exprif(',' exprif)*)? ']' -> ^(VEC exprif*)
	|'print' '!(' exprif ')' -> ^(PRINT exprif)
	|expr6if
	;

expr6if
	:expr7if expr6bisif -> ^(expr7if expr6bisif?)
	;

expr6bisif
	:
	|'[' exprif ']' expr6bisif -> ^(IND ^(exprif expr6bisif?))
	|'.' expr6bisbisif -> ^(ASSOC expr6bisbisif?)
	;

expr6bisbisif
	:IDF expr6bisif -> ^(IDF expr6bisif?)
	|'len' '('! ')'! expr6bisif
	;

expr7if
	:CST_ENT
	|'true'
	|'false'
	|IDF expr8if -> ^(IDF expr8if?)
	|bloc
	|'(' exprif ')' -> exprif
	;

expr8if
	:
	|'(' exprif?(',' exprif)* ')' -> ^(CALL_ARGS (^(ARGUMENT exprif))*)
	;

expr
	:(expr1) ('||'^ expr1)*
	;

expr1
	:(expr2) ('&&'^ expr2)*
	;

expr2
	:(expr3) (opt^ expr3)*
	;

expr3
	:(expr4) (ops^ expr4)*
	;

expr4
	:(expr5) (opm^ expr5)*
	;

expr5
	:unaire  expr6 -> ^(SPE_UNAIRE unaire expr6)
	|'vec' '![' (expr(',' expr)*)? ']' -> ^(VEC expr*)
	|'print' '!(' expr ')' -> ^(PRINT expr)
	|expr6
	;

expr6
	:expr7 expr6bis -> ^(expr7 expr6bis?)
	;

expr6bis
	:
	|'[' expr ']' expr6bis -> ^(IND ^(expr expr6bis?))
	|'.' expr6bisbis -> ^(ASSOC expr6bisbis?)
	;

expr6bisbis
	:IDF expr6bis -> ^(IDF expr6bis?)
	|'len' '('! ')'! expr6bis
	;

expr7
	:CST_ENT
	|'true'
	|'false'
	|IDF expr8 -> ^(IDF expr8?)
	|bloc
	|'(' expr ')' -> expr
	;

expr8
	:
	|'(' expr?(',' expr)* ')' -> ^(CALL_ARGS (^(ARGUMENT expr))*)
	|'{' (IDF ':' expr(',' IDF ':' expr)*)? '}' -> (^(ARGUMENT IDF expr))*
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

CST_ENT :'0'..'9'+;
IDF :('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '_' | CST_ENT)*;
NEWLINE:'\r'? '\n' {$channel=HIDDEN;};
WS :(' ' | '\t') {$channel=HIDDEN;};
COMMENT:'/*' .* '*/' {$channel=HIDDEN;};
COMMENTLINE:'//' .* ('\n'|'\r') {$channel=HIDDEN;};
