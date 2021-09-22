from libFunc import *
import random

n = random.randint(1, 1000)

cont = conteo2(n)

print("Se han necesitado sumar", cont, "términos para exceder la cantidad de", n)