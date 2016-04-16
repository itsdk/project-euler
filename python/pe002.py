# Solution to http://projecteuler.net/problem=2 by Matthew Pepers


# returns the sum of the even-valued fibonacci terms whose value does not exceed a limit
def evenfibsum(limit):
    fibsum = 0 #sum of even fibonacci numbers
    fib = [0,1] #starting list of fibonacci numbers
    while fib[-1] + fib[-2] <= limit: #while fibonacci numbers are below limit
        fib.append(fib[-1] + fib[-2]) #add to list of fibonacci numbers
        if fib[-1] % 2 == 0: #check if last fib number is even
            fibsum += fib[-1] #if so, add to fibsum                         
    return fibsum

limit = 4000000 #fibonacci values do not exceed this number
print "The sum of the even-valued fibonacci terms, whose values do not exceed %d, is: %d" % (limit,evenfibsum(limit))
