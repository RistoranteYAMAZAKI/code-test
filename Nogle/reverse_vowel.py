import os

def rev_vowel(s):
	vowel = "aeiouAEIOU"
	i = 0
	j = len(s)-1
	#print(j)
	LIST = list(s)
	
	while i < j:
		#print str(i) + str(j)	
		while LIST[i] not in vowel and i < j:
			i = i + 1		
		while LIST[j] not in vowel and i < j:
			j = j - 1		
		tmp = LIST[i]
		LIST[i] = LIST[j]
		LIST[j] = tmp
		i = i + 1
		j = j - 1
		
	print(LIST)
	
def main():
	s = "leetcode"
	rev_vowel(s)

if __name__ == '__main__':
	main()