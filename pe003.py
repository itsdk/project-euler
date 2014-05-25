# Solution to http://projecteuler.net/problem=3 by Matthew Pepers


# returns set of factors of n
def factors(n):    
    return set(reduce(list.__add__, 
                ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))

# determines if n is a prime number
def isPrime(n): 
    if n == 2: return True #2 is prime
    if n < 2 or n % 2 == 0: return False #not primes if less than 2 or an even number
    return not any(n % i == 0 for i in xrange(3, int(n**0.5) + 1, 2))

# returns the greatest (or largest) prime factor of n
def gpf(n):
    factor_list = list(factors(n)) #creates list from the set of factors
    factor_list.sort() #sorts list of factors
    for i in reversed(factor_list): #goes through list in reverse
        if isPrime(i) == True: return i #returns largest factor in list that is also a prime number 

# testing:
n = 600851475143 #given number
print "The greatest prime factor of %d is: %r" % (n, gpf(n))
