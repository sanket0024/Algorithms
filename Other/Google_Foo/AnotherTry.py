import timeit
def answer(n):
	lambdaStr = "2"
	primeArr = [True] * 20232
	initialPrime = 2
	while (initialPrime * initialPrime <= len(primeArr)):
		if(primeArr[initialPrime] == True):
			for i in range(initialPrime * 2, len(primeArr), initialPrime):
				primeArr[i] = False
		initialPrime += 1
	i=3
	while len(lambdaStr) < n+5:
		if primeArr[i]:
			lambdaStr = lambdaStr + str(i)
		i += 2
	return lambdaStr[n:n+5]

if __name__ == '__main__':
	a = input("PYTHON: Enter value of n: ")
	start_time = timeit.default_timer()
	print(answer(a))
	elapsed = timeit.default_timer() - start_time
	print("Approx run time: " + str(elapsed * 1000))