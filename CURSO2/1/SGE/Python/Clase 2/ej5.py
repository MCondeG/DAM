cant = int(input('Introduce la cantidad a comprar: '))
precio = float(input('Introduce el precio unitario: '))

if (cant <= 5):
    precio = precio
elif (cant > 5 and cant < 10):
    precio = precio*95/100
else:
    precio = precio*92/100

total = precio*cant

print('Precio total = ', total)