%replace(L:list, X:integer, E:integer, R:list)
%flow model: (i,i,i,o)
%
replace([],_,_,[]).
replace([H|T],X,E,[H|R]) :- H =\= X, !,
                            replace(T,X,E,R).
replace([_|T],X,E,[E|R]) :- replace(T,X,E,R).

%b
%max2(X:integer, Y:integer, R:integer)
%flow model: (i,i,o)
%
max2(X,Y,X) :- X >= Y.
max2(X,Y,Y) :- X < Y.

%max(L:list, R:integer)
%flow model: (i,o)
%

max([],0).
max([H|T],M) :- number(H), !,
                max(T,M2),
                max2(H,M2,M).
max([_|T],M) :- max(T,M).

%heterReplace(L:list, M:integer, R:list)
%flow model: (i,i,o)
%
heterReplace([],_,[]).
heterReplace([H|T],M,[HR|R]) :- is_list(H), !,
                                max(H,HM),
                                replace(H,M,HM,HR),
                                heterReplace(T,M,R).
heterReplace([H|T],M,[H|R]) :- heterReplace(T,M,R).

%b(L:list, R:list)
%flow model: (i,o)
%
b([H|T],R) :- max([H|T],M),
              heterReplace([H|T],M,R).

