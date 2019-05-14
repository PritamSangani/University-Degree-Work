/*
 * A VERY minimal skeleton for your parser, provided by Emma Norling.
 *
 * Your parser should use the tokens provided by your lexer in rules.
 * Even if your lexer appeared to be working perfectly for stage 1,
 * you might need to adjust some of those rules when you implement
 * your parser.
 *
 * Remember to provide documentation too (including replacing this
 * documentation).
 *
 */
parser grammar DecafParser;
options { tokenVocab = DecafLexer; }

program: CLASS ID LCURLY field_decl* method_decl* RCURLY EOF;
field_decl: type field_name (COMMA field_name)* SEMICOLON;
field_name: ID | (ID LSQUARE INT_LITERAL RSQUARE);
type: INT | BOOLEAN;
method_decl: method_header block;
method_header: (type | VOID) ID (LPAREN params? RPAREN);
params: param (COMMA param)*;
param: type param_name;
param_name: ID;
block: LCURLY var_decl* statement* RCURLY;
var_decl: type param_name (COMMA param_name)* SEMICOLON;
statement: location assign_op expr SEMICOLON
    | method_call SEMICOLON
    | IF LPAREN expr RPAREN block (ELSE block)?
    | FOR ID ASSIGNMENT expr COMMA expr block
    | RETURN (expr)? SEMICOLON
    | BREAK SEMICOLON
    | CONTINUE SEMICOLON
    | block
;
assign_op: ASSIGNMENT
    | INCREMENT
    | DECREMENT
;
method_call: method_name LPAREN (expr (COMMA expr)*)? RPAREN
    | CALLOUT LPAREN STRING_LITERAL (COMMA callout_arg (COMMA callout_arg)*)? RPAREN
;
method_name: ID;
location: ID
    | ID LSQUARE expr RSQUARE
;
expr: location
    | method_call
    | literal
    | SUBTRACT expr
    | NOT expr
    | expr mul_div_mod_op expr
    | expr add_sub_op expr
    | expr rel_op expr
    | expr eq_op expr
    | expr cond_op expr
    | LPAREN expr RPAREN
;
callout_arg: expr | STRING_LITERAL;
mul_div_mod_op: MULTIPLY | DIVIDE | MOD;
add_sub_op: ADD | SUBTRACT;
rel_op: LTHAN | GTHAN | LTHANEQUAL | GTHANEQUAL;
eq_op: EQUALITY | NEQUAL;
cond_op: (AND) | OR;
literal: INT_LITERAL | CHAR_LITERAL | bool_literal;
bool_literal: TRUE | FALSE;

