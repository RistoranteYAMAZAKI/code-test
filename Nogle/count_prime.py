import os   

def count_prime(number):
    list = [0] * number
    ans = 0
    for i in range(2,number):
	    if list[i] == False:
		    ans += 1
		    for j in range(2,number):
			    if j*i >= number:
				    break
			    else:
				    list[j*i] = True
	
    return ans
	
def main():
    n = 14
    print(count_prime(n))
	
if __name__ == '__main__':
    main()