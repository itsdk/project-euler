# Solution to http://projecteuler.net/problem=1 by Matthew Pepers


def main():
    first = int(raw_input("Please enter the first multiple: "))
    second = int(raw_input("Please enter the second multiple: "))
    below = int(raw_input("Please enter a number larger than the multiples chosen: "))
    total = 0
    multi = multiples(first,second,below)
    for i in range(0,len(multi)):
        total += multi[i]
    print "If we list all the natural numbers below %d that are multiples of %d or %d, we get %r.  The sum of these multiples is %d." % (below,first,second,multi,total)
    
# prints a list of natural numbers that are multiples of one number or another, below a third number, and then prints the sum of those multiples
# eg: If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
def multiples(first, second, below):
    multi = []
    for i in range(1,below):
        if (i % first == 0) or (i % second == 0):
            multi.append(i)
    return multi

main()
