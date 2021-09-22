from libFunc import *

n = int(input("Introduce un entero positivo: "))
n2 = 0
div = conteo1(n)
max = 0

print(n, "tiene", div, "divisores")

for x in range(1, 101):
    div = conteo1(x)
    if (div > max):
        max = div
        n2 = x

print()
print("El número", n2, "es el que tiene más divisores en el rango [1, 100], con un total de:", max)