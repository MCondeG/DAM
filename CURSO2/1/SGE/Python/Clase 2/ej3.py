try:
    n = int(input("Introduce un número: "))
    
    if (n%7 == 0):
        print('SI es entero múltiplo de 7')
    else:
        print('SI es entero pero NO es múltiplo de 7')

except:
    print('NO es entero')