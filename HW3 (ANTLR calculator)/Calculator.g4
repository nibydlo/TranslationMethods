grammar Calculator;

NUM   : [0-9]+;
NAME  : [a-zA-Z][a-zA-Z0-9]*;

NL    : '\n';
WS    : [\t\r ]+ -> skip;

PLUS  : '+';
MINUS : '-';
MULT  : '*';
POW   : '^';
EQ    : '=';
LPAR  : '(';
RPAR  : ')';
DAC   : ';';

input
    : exprSeq EOF              # toExprSeq
    ;

exprSeq
    : assign DAC NL exprSeq    # ToAssign
    | plusMinus DAC NL exprSeq # ToPlusMinus
    | /*e*/                    # EndOfInput
    ;

assign : NAME EQ plusMinus # Assignment;

plusMinus
    : plusMinus PLUS mult  # Plus
    | plusMinus MINUS mult # Minus
    | mult                 # ToMult
    ;

mult
    : mult MULT power       # Multip
    | power                 # ToPow
    ;

power
    : atom POW power        # Pow
    | atom                  # ToAtom
    ;

atom
    : MINUS atom           # ChangeSign
    | LPAR plusMinus RPAR  # Brackets
    | NAME                 # Variable
    | NUM                  # Number
    ;