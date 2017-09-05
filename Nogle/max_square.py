import os

def maximalSquare(matrix):
	if matrix == []:
		return 0
	m, n = len(matrix), len(matrix[0])
	#initial 2d array
	dp = [[0] * n for x in range(m)]
	ans = 0
	for x in range(m):
		for y in range(n):
			dp[x][y] = int(matrix[x][y])
			if x and y and dp[x][y]:
				dp[x][y] = min(dp[x - 1][y - 1], dp[x][y - 1], dp[x - 1][y]) + 1
			ans = max(ans, dp[x][y])
	return ans * ans

def main():
    #2d array
    my_list = [[1,1,1,0,0],[1,1,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]
    flatten = [val for sublist in my_list for val in sublist]
    print(maximalSquare(my_list))
    print(flatten) #list of list to list 
	
if __name__ == '__main__':
    main()