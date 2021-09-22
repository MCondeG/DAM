from libFunc import *

n = int(input("Introduce un entero para verificar que n^2 = sumatorio(n primeros impares): "))

if (cuad(n)):
    print("Se cumple la propiedad!!")
else:
    print("No se cumple la propiedad :(")