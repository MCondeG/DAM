import random

class Biblioteca:
    
    __nombre = []
    __estado = []
    __prestado = []
    __TAMAÑOMAX = 5
    __tamañoActual = 0
    
    
    def iniciar(self, tamaño):
        
        self.__tamañoActual = tamaño
        
        self.__nombre.append("El Señor de los Anillos")
        self.__nombre.append("Harry Potter y la Piedra Filosofal")
        self.__nombre.append("Los Pilares de la Tierra")
        self.__nombre.append("")
        self.__nombre.append("")
        
        for i in range(0, self.__tamañoActual):
            self.__estado.append(int(random.randint(0, 1)))
            self.__prestado.append(int(random.randint(0, 10)))
            
        self.__estado.append(int(-1))
        self.__estado.append(int(-1))
        self.__prestado.append(int(0))
        self.__prestado.append(int(0))
        
    
    def getNombre(self, pos):
        return (self.__nombre[int(pos)])
    
    def getEstado(self, pos):
        return (self.__estado[int(pos)])
    
    def getPrestado(self, pos):
        return (self.__prestado[int(pos)])
    
    
    def muestraBiblioteca(self):
        
        for i in range(0, self.__TAMAÑOMAX):
            print(self.__nombre[i], ", Estado actual:", self.__estado[i], ", Prestado", self.__prestado[i], "veces")
    
    
    def buscaLibro(self, Nombre):
        
        pos = -1
        
        for i in range(0, self.__TAMAÑOMAX):
            if ((self.__estado[i] != -1) and (Nombre == self.__nombre[i])):
                pos = i
                    
        return pos
                
    
    def compraLibro(self, Nombre):
        
        if (self.__tamañoActual < self.__TAMAÑOMAX):
            for i in range(0, self.__TAMAÑOMAX):
                if (self.__nombre[i] == ""):
                    self.__nombre[i] = Nombre
                    self.__estado[i] = 0
                    self.__prestado[i] = 0
                    self.__tamañoActual += 1
                    print(Nombre,": Libro comprado con éxito")
                    break
        else:
            print("ERROR. Biblioteca completa")
            
            
    def tiraLibro(self, Nombre):
        
        pos = int(self.buscaLibro(Nombre))
        
        if (pos != -1):
            print(self.__nombre[pos],": Libro tirado")
            self.__nombre[pos] = ""
            self.__estado[pos] = -1
            self.__prestado[pos] = 0
            self.__tamañoActual -= 1
        else:
            print("ERROR. Nombre de libro incorrecto")
        
        
    def sacaLibro(self, Nombre):
        
        pos = int(self.buscaLibro(Nombre))
        
        if (pos != -1):
            if (self.__estado[pos] == 0):
                self.__estado[pos] = 1
                print(self.__nombre[pos],": Libro prestado con éxito")
            else:
                print("ERROR. Libro actualmente en préstamo")
        else:
            print("ERROR. Nombre de libro incorrecto")
        
        
    def devuelveLibro(self, Nombre):
        
        pos = int(self.buscaLibro(Nombre))
        
        if (pos != -1):
            if (self.__estado[pos] == 1):
                self.__estado[pos] = 0
                self.__prestado[pos] += 1
                print(self.__nombre[pos],": Libro devuelto con éxito")
            else:
                print("ERROR. El libro YA está en la biblioteca")
        else:
            print("ERROR. Nombre de libro incorrecto")
        
        
    def libroMasPrestado(self):
        
        max = 0
        pos = 0
        
        for i in range(0, self.__TAMAÑOMAX):
            if (self.__prestado[i] >= max):
                max = self.__prestado[i]
                pos = i
        
        return int(pos)