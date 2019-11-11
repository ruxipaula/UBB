% substitute(L:list, X:number, Y:number, R:list)
% flow model: (i,i,i,o)
%
substitute([], _, _, []) :- !.
substitute([H|T], X, Y, R) :- H =\= X, substitute(T, X, Y, R2), R = [H|R2].
substitute([H|T], X, Y, R) :- H =:= X, substitute(T, X, Y, R2), R = [Y|R2].

%sublist(L:list, M:number, N:number, R:list)
%flow model: (i,i,i,o)
%
sublist(_, _, N, []) :- N<0, !.
sublist([_|T], M, N, R) :- M>0,
                           M2 is M-1,
                           N2 is N-1,
                           sublist(T, M2, N2, R).
sublist([H|T], M, N, R) :- M =< 0, N >= 0,
                           M2 is M-1,
                           N2 is N-1,
                           sublist(T, M2, N2, R2),
                           R = [H|R2].
