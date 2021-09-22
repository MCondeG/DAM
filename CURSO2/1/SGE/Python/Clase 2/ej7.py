p = float(input('Introduce peso: '))
t = float(input('Introduce talla: '))

imc = p/(t**2)

if (imc < 18.5):
    estado = 'Desnutrido'
elif (imc >= 18.5 and imc <= 25.5):
    estado = 'Peso normal'
else:
    estado = 'Sobrepeso'
    
print(estado)