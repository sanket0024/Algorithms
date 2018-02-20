import timeit
def answer(n):
	lambdastring = "2357"
	#if n==0:
	#	lambdastring = str(2)
	i = 11			# check for every number (specifically odd number) for prime
	#count=4		# count of digits of number of prime numbers covered so far

	#generate prime numbers till the digit count is not n
	"""while count < n+5:
		isPrime = True
		for x in range(i-2, 2, -2):
			if i%x == 0:
				isPrime = False
				break
		if isPrime:
			count = count + len(str(i))
		i+=2
		#print(count)

	# resetting the value of count to the length of last prime number
	#if(n > 1):
	i-=2
	lambdastring = lambdastring + str(i)
	i+=2
	#to generate the prime number till the digit count is not 5
	while len(lambdastring) < 5:
		isPrime = True
		for x in range(i-2, 2, -2):
			if i%x == 0:
				isPrime = False
				break
		if isPrime:
			lambdastring = lambdastring + str(i)
			#print(lambdastring)
		#print(lambdastring)
		i+=2
	return lambdastring[0:5]"""

	while len(lambdastring) < n+5:
		isPrime = True
		for x in range(i-2, 2, -2):
			if i%x == 0:
				isPrime = False
				break
		if isPrime:
			lambdastring = lambdastring + str(i)
		i+=2
	return lambdastring[n:n+5]


if __name__ == '__main__':
	a = input("PYTHON: Enter value of n: ")
	start_time = timeit.default_timer()
	print(answer(a))
	elapsed = timeit.default_timer() - start_time
	print("Approx run time: " + str(elapsed * 1000))