l1 = float(input('Introduce lado 1: '))
l2 = float(input('Introduce lado 2: '))
l3 = float(input('Introduce lado 3: '))

if ((l1 + l2 > l3) or (l2 + l3 > l1) or (l1 + l3 > l2)):
    if (l1 == l2 or l1 == l3 or l2 == l3):
        if (l1 == l2 and l2 == l3):
            print('Equilátero')
        else:
            print ('Isósceles')
    else:
        print('Escaleno')
else:
    print('NO es un triángulo')