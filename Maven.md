# ✅ Cómo usar Maven en VS Code
**1. Instala las extensiones necesarias**
- Asegúrate de tener estas extensiones instaladas:
✅ Java Extension Pack (incluye Maven for Java)
✅ Maven for Java

**2. Crea un nuevo proyecto Maven**
Abre la paleta de comandos (Ctrl+Shift+P) y escribe:
```
Maven: Create Maven Project
```
- Selecciona:
1. Un arquetipo (elige maven-archetype-quickstart si no estás seguro).
2. La versión del arquetipo.
3. Define:
- groupId: como com.miempresa
- artifactId: como mi-proyecto

4. Elige una carpeta donde crear el proyecto.
- Maven generará una estructura como esta:
```
mi-proyecto/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── miempresa/
│   │               └── App.java
│   └── test/
│       └── java/...
```
**3. Agrega dependencias (como MySQL)**
- Abre el archivo pom.xml y agrega una dependencia como esta dentro de <dependencies>:
```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.3.0</version>
</dependency>
```
- Guarda el archivo. VS Code descargará la dependencia automáticamente.

**4. Escribe tu código**
- Edita el archivo App.java o crea nuevos archivos dentro de src/main/java.
- Por ejemplo, puedes copiar ahí tu clase Persona y una clase Main que use la base de datos.

**5. Compila y ejecuta tu proyecto**
- Abre la terminal y escribe dentro del proyecto:
```
mvn compile       # Compila el proyecto
mvn exec:java -Dexec.mainClass="com.miempresa.App"  # Ejecuta la clase principal
Asegúrate de que App.java tenga el paquete correcto: package com.miempresa;
```
### 💡 Tip
Puedes instalar el plugin de ejecución Maven si no está ya en tu pom.xml:
```
<build>
  <plugins>
    <plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>exec-maven-plugin</artifactId>
      <version>3.1.0</version>
    </plugin>
  </plugins>
</build>
```
