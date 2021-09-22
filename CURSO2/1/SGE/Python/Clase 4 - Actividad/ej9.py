from libFunc import *
import random

dado = 0

while (dado < 4):
    dado = int(input("Introduce el número de caras del dado: "))
    
    if (dado < 4):
        print("ERROR! Introduce un dado válido")

n = int(input("Introduce la tirada que deseas obtener: "))
cont = alfin(n, dado)

print("Has necesitado", cont, "tiradas para obtener el resultado elegido")