import os

def solution(S, G):
	A = 0
	B = 0
	A_check = []
	secret = list(S)
	guess = list(G)
	
	for i in range(0,len(secret)):	
		if secret[i] == guess[i]:
			A = A + 1
			A_check.append(i)
	
	#print(A_check)
	count = 0
	for i in range(0, len(A_check)):
		del secret[A_check[i]-count]
		del guess[A_check[i]-count]
		count += 1
		print(secret)
		print(guess)

	
	for i in range(0, len(guess)):
		for j in range(0, len(secret)):
			if guess[i] == secret[j]:
				del secret[j]
				B = B + 1
				break
				
	print(str(A) + "A" + str(B) + "B")	
	
def main():
	secret = "7807"
	guess = "7810"
	solution(secret, guess)

if __name__ == '__main__':
	main()