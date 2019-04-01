grammar Grammar;

RETURN    : 'return';
LSB       : '[';
RSB       : ']';
LCB       : '{';
RCB       : '}';
PIPE      : '|';
NL        : '\n';
SC        : ';';
COL       : ':';
EQ        : '=';
WS        : [\t\r ]+ -> skip;
IGNORE    : 'IGNORE';

CODE      : '{' (~[{}])*'}';
REGEX     : '"'(~['"']|'\\"')*'"';

VARNAME   : '$'[a-zA-Z0-9_]+;
TOKENNAME : [A-Z]+;
RULENAME  : [a-z][a-zA-Z]*;
VARTYPE   : [A-Z][a-zA-Z<>.,]+;
ANY       : [a-zA-Z0-9_(\\')'"']+;

input
    : ignoreRule NL ruleSeq EOF              # toExprSeq
    ;

ignoreRule
    : IGNORE COL REGEX # AssignIgnore
    ;

ruleSeq
    : setToken NL ruleSeq # ToAssignToken
    | setRule  NL ruleSeq # ToAssignRule
    | NL  ruleSeq         # NewLine
    | /* e */             # EndOfInput
    ;

setToken
    : TOKENNAME COL REGEX # AssignToken
    ;

setRule
    : RULENAME (LSB arguments RSB)? (RETURN CODE)? COL option (PIPE option)* # AssignRule
    ;

option
    : rightPartElem+ CODE? # InOption
    ;

arguments
    : initVar (',' initVar)* # ToInitVar
    ;

initVar
    : VARTYPE VARNAME       # InitializeVar
    ;

retValue
    : VARTYPE (VARNAME|TOKENNAME|RULENAME) (EQ ANY)? # ReturnValue
    ;

rightPart
    : rightPartElem+ # AssignRightPart
    ;

rightPartElem
    : RULENAME (LSB passArguments RSB)? # ToPassArguments
    | TOKENNAME # RightPartElemToken
    | CODE # RightPartElemCode
    ;

passArguments
    : argument (',' argument)* # PassingVariables
    ;

argument
    : ANY | TOKENNAME | RULENAME
    ;

code
    : ANY
    ;