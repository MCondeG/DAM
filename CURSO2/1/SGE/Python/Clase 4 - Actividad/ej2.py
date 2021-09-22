from libFunc import *
import random

n = random.randint(1, 99)
m = random.randint(1, 99)

while not(primo(n+m)):
    n = random.randint(1, 99)
    m = random.randint(1, 99)

print(n, "+", m, "=", (n+m), "---> PRIMO")