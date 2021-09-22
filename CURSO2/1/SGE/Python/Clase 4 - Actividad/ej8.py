from libFunc import *
import random

n = 10

while (not(sim(n))):
    n = random.randint(1, 10000)
    
print("Número capicúa encontrado! --->", n)