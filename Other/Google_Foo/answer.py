import timeit
def answer(n):
	lambdastring = "23"
	i = 5
	while len(lambdastring) <= 10004:
		isPrime = True
		for j in range(i-2, 2, -2):
			if i%j == 0:
				isPrime = False
				break
		if isPrime:
			lambdastring = lambdastring + str(i)
		i += 2
	return lambdastring[n:n+5]

if __name__ == '__main__':
	start_time = timeit.default_timer()
	print(answer(944))
	elapsed = timeit.default_timer() - start_time
	print(elapsed * 1000)