lexer grammar DecafLexer;

CLASS : 'class';
FOR : 'for';
BOOLEAN : 'boolean';
BREAK : 'break';
IF : 'if';
CALLOUT : 'callout';
INT : 'int';
RETURN : 'return';
CONTINUE : 'continue';
TRUE : 'true';
ELSE : 'else';
VOID : 'void';
FALSE : 'false';

LCURLY : '{';
RCURLY : '}';
LSQUARE: '[';
RSQUARE: ']';
LPAREN: '(';
RPAREN: ')';
SEMICOLON: ';';
COMMA: ',';
EQUALITY : '==';
NEQUAL: '!=';
GTHANEQUAL: '>=';
LTHANEQUAL: '<=';
LTHAN: '<';
GTHAN: '>';
AND: '&&';
OR: '||';
ASSIGNMENT: '=';
INCREMENT: '+=';
DECREMENT: '-=';
ADD: '+';
SUBTRACT: '-';
MULTIPLY: '*';
DIVIDE: '/';
MOD: '%';
NOT: '!';

ID : (ALPHA)(ALPHA | DIGIT)*;

fragment
ALPHA: [a-zA-Z_];
fragment
DIGIT: [0-9];

INT_LITERAL: (STDNUMBER | HEXADECIMALNUMBER);

fragment
STDNUMBER: (DIGIT)+;
fragment
HEXADECIMALNUMBER: '0x'(HEXDIGIT)+;
fragment
HEXDIGIT: (DIGIT | [a-fA-F]);

WS_ : (' ' | '\n' | '\t') -> skip;

SL_COMMENT : '//' (~'\n')* '\n' -> skip;

fragment
ESC :  '\\' ('n' | '"' | 't' | '\\' | '\'');
fragment
NOTESC: ~('\n' | '"' | '\t' | '\\' | '\'');
fragment
CHAR : (ESC | NOTESC);

CHAR_LITERAL: '\''CHAR'\'';
STRING_LITERAL : '"' (CHAR)* '"';