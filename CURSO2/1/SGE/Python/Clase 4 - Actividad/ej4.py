from libFunc import *
import random

max = 0

for x in range(10):
    n = random.randint(1, 100)
    print(n)
    
    if (sumad(n) > sumad(max)):
        max = n
        
print()
print("El número cuyas cifras suman la mayor cantidad (", sumad(max), ") es:", max)