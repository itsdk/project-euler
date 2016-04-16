/**
 * run with SWI-Prolog
 **
 * Project Euler problem #10 (https://projecteuler.net/problem=10)
 **
 * Summation of Primes:
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */

% ?- sumPrimesBelow(2000000,Sum).

sumPrimesBelow(N,Sum) :-
  primes(N,List),
  sumList(Sum,List).

primes(X, PS) :- X > 1, range(2, X, R), sieve(X, R, PS).

range(X, X, [X]) :- !.
range(X, Y, [X | R]) :- X < Y, X1 is X + 1, range(X1, Y, R).
 
mult(A, B, C) :- C is A*B.
 
 
sieve(X, [H | T], [H | T]) :- H*H > X, !.
sieve(X, [H | T], [H | S]) :- maplist( mult(H), [H | T], MS), 
                              remove(MS, T, R), sieve(X, R, S).  

remove( _,       [],      []     ) :- !.
remove( [H | X], [H | Y], R      ) :- !, remove(X, Y, R).
remove( X,       [H | Y], [H | R]) :- remove(X, Y, R). 

sumList(0,[]).
sumList(Sum,[H|T]) :-
  sumList(S,T),
  Sum is H+S.

