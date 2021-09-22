r = float(input('Introduce el radio: '))
h = float(input ('Introduce la altura: '))

PI = 3.1416

areabase = PI*r**2
area = (2*areabase) + (2*PI*r*h)
volumen = areabase*h

if (h > r):
    print(volumen)
else:
    print(area)