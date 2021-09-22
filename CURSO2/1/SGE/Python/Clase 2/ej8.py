cont = 0

print("Asignatura A")
a1 = int(input("Matrícula estudiante 1: "))
a2 = int(input("Matrícula estudiante 2: "))
a3 = int(input("Matrícula estudiante 3: "))

a = [a1, a2, a3]

print()
print("Asignatura B")
b1 = int(input("Matrícula estudiante 1: "))
b2 = int(input("Matrícula estudiante 2: "))
b3 = int(input("Matrícula estudiante 3: "))

b = [b1, b2, b3]

print()

for i in range(3):
    for j in range(3):
        if (a[i] == b[j]):
            cont+=1

print(cont, 'estudiante(s) toman la materia A y B a la vez')