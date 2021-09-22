from Biblioteca import *

x = Biblioteca()

x.iniciar(3)
x.muestraBiblioteca()

print()

x.compraLibro("Canción de Hielo y Fuego")
x.compraLibro("El Quijote")
x.compraLibro("El Hobbit")

print()

x.sacaLibro("Harry Potter y la Piedra Filosofal")
x.sacaLibro("El Quijote")

print()

x.devuelveLibro("Los Pilares de la Tierra")

print()

x.tiraLibro("Los Pilares de la Tierra")

print()

x.muestraBiblioteca()

print()

pos = x.libroMasPrestado()
print("El libro más prestado es:", x.getNombre(pos), ", con un total de", x.getPrestado(pos), "préstamos")