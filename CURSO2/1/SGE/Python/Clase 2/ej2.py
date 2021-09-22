n = int(input('Introduce un entero de 2 cifras: '))

unidad = int(n%10)
decena = int(n/10)

if ((unidad+decena)%2 == 0):
    print('par')
else:
    print('impar')