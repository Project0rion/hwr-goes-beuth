grammar EntityModel;


entities : (entity WHITESPACE?)+ ;

entity : NAME BEGIN (property)* END ;

property : NAME (LIST)? WHITESPACE NAME ENDLINE ;


NAME : (('A'..'Z') | ('a'..'z'))+ ;

BEGIN : '{' ;

END : '}' ;

LIST : '[]' ;

ENDLINE : ';' ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;