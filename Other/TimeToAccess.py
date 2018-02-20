import timeit
if __name__ == '__main__':
	arr = [None] * 1000000
	start_time = timeit.default_timer()
	print(arr[999999])
	elapsed = timeit.default_timer() - start_time
	print(elapsed * 1000)