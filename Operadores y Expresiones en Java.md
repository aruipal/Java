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
<image src="https://github.com/aruipal/Java/blob/main/recursos/aritmeticos.png" alt="aritmeticos" width="650" height="200">
  
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
<image src="https://github.com/aruipal/Java/blob/main/recursos/comparacion.png" alt="aritmeticos" width="650" height="200">
  
```
int a = 7, b = 5;
System.out.println("¿a == b? " + (a == b));
System.out.println("¿a > b? " + (a > b));
System.out.println("¿a < b? " + (a < b));
```
### 6. Operadores lógicos
+ Hay tres operadores lógicos en Java: **AND (&&), OR (||) y NOT (!).**
<image src="https://github.com/aruipal/Java/blob/main/recursos/logico.JPG" alt="logicos" width="650" height="150">

```
boolean cond1 = (5 > 3);
boolean cond2 = (10 < 20);
System.out.println("cond1 && cond2: " + (cond1 && cond2));
System.out.println("cond1 || false: " + (cond1 || false));
System.out.println("!cond1: " + (!cond1));
```
### 7. Operadores unarios
- Son aquellos que solo requieren un operando para funcionar.
<image src="https://github.com/aruipal/Java/blob/main/recursos/unarios.jpg" alt="unarios" width="600" height="250">

```
int c = 5;
c++;
c--;
System.out.println("Valor de c: " + c);
boolean esVerdadero = true;
System.out.println("Negación: " + !esVerdadero);
```
### 8. Operadores Bit a Bit
```
- Permiten manipular datos a nivel de bits. Son muy útiles en programación de bajo nivel, optimización y manejo de banderas.


int num1 = 5; // 0101
int num2 = 3; // 0011
int resultado = num1 & num2;
System.out.println("AND bit a bit: " + resultado);
```
### 9. Precedencia de Operadores
```
int res1 = 10 + 5 * 2;
int res2 = (10 + 5) * 2;
System.out.println("Sin paréntesis: " + res1);
System.out.println("Con paréntesis: " + res2);
```
## RESUMEN
<image src="https://github.com/aruipal/Java/blob/main/recursos/ResumenOperadores.png" alt="resumen" width="630" height="320">
