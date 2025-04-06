# Operadores y Expresiones en Java
### 1. ¿Qué es un operador?
Un operador es un símbolo que realiza una operación sobre uno o más valores llamados operandos.
```
int resultado = 10 + 5;
System.out.println("Resultado: " + resultado);
```
### 2. ¿Qué es una expresión?
Una expresión es cualquier combinación de operadores y operandos que produce un valor.
```
int resultado = 10 + (5 * 2);
System.out.println("Resultado de la expresión: " + resultado);
```
### 3. Operadores aritméticos
<image src="https://github.com/aruipal/Java/blob/main/recursos/aritmeticos.png" alt="aritmeticos" width="890" height="300">
  
```
int a = 15, b = 4;
System.out.println("Suma: " + (a + b));
System.out.println("Resta: " + (a - b));
System.out.println("Producto: " + (a * b));
System.out.println("Cociente: " + (a / b));
System.out.println("Resto: " + (a % b));
```
### 4. Operadores de Asignación
```
int x = 10;
x += 5;
x *= 2;
System.out.println("Valor final de x: " + x);
```
### 5. Operadores de Comparación
<image src="https://github.com/aruipal/Java/blob/main/recursos/comparacion.png" alt="aritmeticos" width="890" height="300">
  
```
int a = 7, b = 5;
System.out.println("¿a == b? " + (a == b));
System.out.println("¿a > b? " + (a > b));
System.out.println("¿a < b? " + (a < b));
```
### 6. Operadores lógicos
```
boolean cond1 = (5 > 3);
boolean cond2 = (10 < 20);
System.out.println("cond1 && cond2: " + (cond1 && cond2));
System.out.println("cond1 || false: " + (cond1 || false));
System.out.println("!cond1: " + (!cond1));
```

