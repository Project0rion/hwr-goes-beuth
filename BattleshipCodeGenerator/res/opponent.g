grammar Opponent;


instructions : (shootSentence WHITESPACE?)+ ;

shootSentence : SHOOT coordinate PERIOD ;

coordinate : COLUMN ROW ;


SHOOT : 'Shoot at' ;

COLUMN : ('A'..'Z') | ('a'..'z') ;

ROW : ('1'..'9') ;

PERIOD : '.' ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;