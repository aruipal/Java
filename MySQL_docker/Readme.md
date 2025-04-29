# MySQL en contenedor Docker.
**1. Instalar Docker, descargalo de aqui:** https://www.docker.com/get-started/

**2. Inicia Docker Desktop: Abre la aplicación y asegúrate de que el servicio Docker esté corriendo.**
- Desde CMD:
```
docker info
```
**3. Descarga la imagen de MySQL:**
- Busca mysql en el Docker Hub.
- Descarga la versión deseada, haciendo click en Pull.

**4. Crear y ejecutar un contenedor MySQL:**
- Ve a "Containers" y haz clic en "Run".
- Selecciona la imagen de MySQL.
- Configura los parámetros, como el nombre del contenedor y las variables de entorno (MYSQL_ROOT_PASSWORD).
- Asigna volúmenes si deseas persistencia de datos.
- Presiona "Start".

**5. Administrar el contenedor:**
- Desde Docker Desktop, puedes ver el estado del contenedor, detenerlo, reiniciarlo o eliminarlo.
___
**✅ Paso 1: Crear el archivo docker-compose.yml**
- En tu proyecto (o una carpeta vacía), crea un archivo llamado docker-compose.yml con este contenido:
```
version: '3.8'

services:
  mysql-pruebas:
    image: mysql:8
    container_name: mysql-pruebas
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: rootpass
      MYSQL_DATABASE: escuela
      MYSQL_USER: SuPeRuSeR
      MYSQL_PASSWORD: SuPeR2024Us3R
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql
    networks:
      - red-pruebas

volumes:
  mysql_data:

networks:
  red-pruebas:
    driver: bridge
```
**Este archivo hace lo siguiente:**
- Levanta un contenedor con la imagen oficial de MySQL 8.
- Crea automáticamente la base de datos escuela.
- Crea el usuario SuPeRuSeR con su contraseña.
- Expone el puerto 3306 a tu máquina (localhost:3306).
- Usa una red y volumen personalizados.

**✅ Paso 2: Levantar el contenedor**
- Desde la misma carpeta donde guardaste el archivo, abre una terminal y ejecuta:
```
docker ps
```
- Deberías ver el contenedor mysql-pruebas corriendo. Luego, ya puedes conectar tu código Java usando esta URL:
```
"jdbc:mysql://localhost:3306/escuela"
```

**✅ Para crear la tabla alumno dentro de la base de datos escuela, sigue estos pasos:**
- Entra al contenedor:
```
docker exec -it mysql-pruebas bash
```
- Accede al cliente de MySQL como root:
```
mysql -u root -p
# Ingresa la contraseña: rootpass (según el docker-compose)
```
- Crea la tabla alumno:
```
CREATE TABLE alumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    curso VARCHAR(50)
);
```
- Sal del cliente:
```
EXIT;
```

**✅ Insertar un alumno en la tabla alumno.**
- Entra al contenedor:
```
docker exec -it mysql-pruebas bash
```
- Abre el cliente MySQL:
```
mysql -u root -p
# (Contraseña: rootpass)
```
- Usa la base de datos:
```
USE escuela;
```
- Inserta un alumno:
```
INSERT INTO alumno (nombre, edad, curso) VALUES ('Juan Pérez', 20, 'Matemáticas');
```
- Verifica:
```
SELECT * FROM alumno;
```
- Sal:
```
EXIT;
exit
```




