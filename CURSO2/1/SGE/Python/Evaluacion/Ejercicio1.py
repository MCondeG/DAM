def segundaPosicion(palabra, letra):
    
    palabra = palabra.upper()
    letra = letra.upper()
    pos = -1
    
    if (palabra.count(letra) >= 2):
        pos = palabra.find(letra, palabra.find(letra) + 1, len(palabra))
    
    return pos