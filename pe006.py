# Solution to http://projecteuler.net/problem=6 by Matthew Pepers


#returns the sum of the squares of the first n natural numbers
def sum_of_squares(n):
    numbers = 0
    for i in range(1, n+1):
        numbers += i**2
    return numbers

#returns the square of the sum of the first n natural numbers   
def square_of_sum(n):
    numbers = 0
    for i in range(1, n+1):
        numbers += i
    return numbers**2


#Test:
#prints the difference between the sum of the squares and the square of the sum of the first 100 natural numbers
n = 100
print square_of_sum(n) - sum_of_squares(n)
