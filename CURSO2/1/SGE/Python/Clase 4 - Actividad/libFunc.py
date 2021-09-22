import math
import random

# encuentra los divisores de un entero y los guarda en un array
def divisores(n):
    
    m = 1
    div = []
    
    while (m <= n/2):
        if (n%m == 0):
            div.append(m)
        m += 1
    
    div.append(n)
    
    return div


# cuenta los divisores de un entero
def conteo1(n):
    
    div = divisores(n)
    num = len(div)
    
    return num


# determina si un entero es primo
def primo(n):
    
    if (conteo1(n) == 2):
        return True
    else:
        return False
    

# determina si un entero es un número perfecto
def perfecto(n):
    
    div = divisores(n)
    suma = sum(div) - n
    
    if (suma == n):
        return True
    else:
        return False
    

# descompone un entero en sus cifras
def cifras(n):
    
    m = n
    cif = []
    
    while (m >= 1):
        m = int(m/10)
        m = m * 10
        cif.append(int(n-m))
        m = m/10
        n = m
        
    cif.reverse()
        
    return cif


# suma las cifras de un número entero
def sumad(n):
    
    cif = cifras(n)   
    suma = sum(cif)
    
    return suma


# comprueba la propiedad de que n^2 = sumatorio de los n primeros impares
def cuad(n):
    
    suma = 0
    
    for x in range(1, n*2, 2):
        suma += x
        
    if (n**2 == suma):
        return True
    else:
        return False


# calcula el n-ésimo término de la sucesión de Fibonacci usando el número áureo
def secuencia1(n):
    
    PHI = (1 + math.sqrt(5))/2
    
    fn = ((PHI**n) - ((1 - PHI)**n))/(math.sqrt(5))
    
    return fn


# calcula el n-ésimo término de la sucesión con los 3 primeros términos siendo 1 y a partir de ahí sumando los 3 anteriores
def secuencia2(n):
    
    n1 = 1
    n2 = 1
    n3 = 1
    s = 1
    
    for x in range(n):
        
        if (x < 3):
            s = 1
        else:
            s = n1 + n2 + n3
            n1 = n2
            n2 = n3
            n3 = s
    
    return s


# determina si un entero es capicúa
def sim(n):
    
    cif = cifras(n)
    aux = cif.copy()
    aux.reverse()
    
    if (cif == aux):
        return True
    else:
        return False


# simula la tirada de un dado
def alfin(n, dado):
    
    cont = 0
    result = 0
    
    while (n != result):
        
        result = random.randint(1, dado)
        cont += 1
    
    return cont


# calcula la cantidad de términos que deben sumarse de la serie (1*2*3 + 2*3*4 + 3*4*5 + 4*5*6+...) hasta que se exceda de una cantidad dada
def conteo2(n):
    
    suma = 0
    mult = 1
    cont = 0
    
    while (suma <= n):
        
        for x in range(1+cont, 4+cont):
            mult *= x
        
        suma += mult
        mult = 1
        cont += 1
    
    return cont