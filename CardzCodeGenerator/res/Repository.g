grammar Repository;

file : (card | opponent)+ EOF;

row : card ENDLINE WHITESPACE?;

card : 'Card' SPACE name '{' cardData '}';

cardData :  dataFaction dataHealth dataDamage dataCost;

dataFaction : 'faction' POINTS faction ENDLINE;

dataHealth : 'health' POINTS value ENDLINE;

dataDamage : 'damage' POINTS value ENDLINE;

dataCost : 'cost' POINTS value ENDLINE;

dataBehavior : 'behavior' POINTS BEHAVIOR ENDLINE;

value : NUMBER+;

name : CHAR+;

faction : FACTION;

opponent : 'Opponent' SPACE name '{' opponentData '}';

opponentData : dataFaction dataBehavior deck;

deck : 'Cards' '{' (deckCard SEPARATOR WHITESPACE?)+ '}';

deckCard : name; 


ENDLINE : ';' ;

SPACE : ' ';

SEPARATOR : (',');

POINTS : (':');

BEHAVIOR : ('aggressive'|'passive');

FACTION : ('Shark' | 'Raptor');

NUMBER : ('0'..'9');

CHAR : ('a'..'z') | ('A'..'Z');

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;