grammar Expr;

options {
    // antlr will generate java lexer and parser
    language = Java;
    // generated parser should create abstract syntax tree
    output = AST;
}

@lexer::header {
package Compilation2k18;
}

@parser::header {
package Compilation2k18;
}

fichier	
	:	decl*	;
decl	
	:	decl_func
	|	decl_struct
	;
decl_struct
	:	'struct' IDF '{'( IDF ':' type1 (',' IDF ':' type1)* )? '}';
decl_func
	:	 'fn' IDF ( ( argument (',' argument)* )? ) ( '->' type1 )? bloc;	
	
type1	
	:IDF type2
	|'&' type1
	|'i32'
	|'bool'
	|'vec'
	;
type2
	:
	|'<'type1'>'
	;
argument
	:IDF ':' type1;
bloc
	:'{' instruction* (expr1)? '}';
instruction
	:';'
	|'let' ('mut')? IDF '=' expr1 ';'
	|'let' ('mut')? IDF '=' IDF '{' ( IDF':' expr1 (',' IDF ':' expr1)* )? '}'
	|'while' expr1 bloc
	|'return' (expr1)? ';'							
	|if_expr1
	;
if_expr1
	:'if' expr1 bloc ('else' if_expr2)?;
if_expr2
	:bloc
	|if_expr1
	;
expr1
	:CST_ENT expr2
	|'true' expr2
	|'false' expr2
	|IDF expr3
	|UNAIRE expr1 expr2
	|'vec !' '['(expr1(','expr1)*)?']'expr2
	|'print !' '(' expr1 ')'expr2
	|bloc expr2
	|'('expr1')'expr2
	;
expr2
	:BINAIRE expr1 expr2
	|'.'expr4
	|(expr1)? expr2
	|
	;
expr3
	:expr2
	|((expr1(','expr1)*)?)expr2
	;
expr4
	:IDF expr2
	|'len ( )'expr2
	;
		
BINAIRE :	
	|'+'
	|'-'
	|'*'
	|'/'
	|'&&'
	|'||'
	|'<'
	|'<='
	|'>'
	|'>='
	|'=='
	|'!='
	;
	
UNAIRE
	:'-'
	|'!'
	|'*'
	|'&'
	;
	
IDF : ('a'..'z'|'A'..'Z')+ ;
CST_ENT : '0'..'9'+ ;	