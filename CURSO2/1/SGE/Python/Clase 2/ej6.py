import math

ancho = float(input('Introduce ancho: '))
largo = float(input('Introduce largo: '))
altura = float(input('Introduce altura: '))
diametro = float(input('Introduce diámetro del agujero: '))

d1 = math.sqrt(ancho**2 + largo**2)
d2 = math.sqrt(ancho**2 + altura**2)
d3 = math.sqrt(altura**2 + largo**2)

if (d1 < diametro or d2 < diametro or d3 < diametro):
    print("SI pasa por el agujero")
else:
    print("NO pasa por el agujero")