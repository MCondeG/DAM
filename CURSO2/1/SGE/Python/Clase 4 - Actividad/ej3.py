from libFunc import *

perf = []

for x in range(1, 1001):
    if (perfecto(x)):
        perf.append(x)
        
print("Números perfectos entre 1 y 1000:", perf)