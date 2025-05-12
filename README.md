FravegaTech - API REST Test (Java)

Este proyecto fue desarrollado como parte de un challenge técnico. Utiliza Java para consumir y testear la API pública de GoRest. 

El flujo de ejecución incluye tres operaciones como:
1. Obtener la lista de usuarios existentes desde el endpoint correspondiente.
2. Crear un nuevo usuario con datos generados dinámicamente (incluyendo un email que se genera a base de la hora en la que se ejecuta la peticion).
3. Obtener el detalle del usuario recién creado utilizando su `id`.

Para ejecutar este proyecto se requiere Java 17 instalado en el sistema y acceso a internet. No se utilizan librerías externas, por lo que la ejecución se realiza directamente desde consola con los siguientes comandos:

javac GoRestTest/GoRestApiTest.java
java GoRestTest.GoRestApiTest

El token de acceso para consumir la API está declarado como una constante en el código fuente. Puede ser reemplazado por un nuevo token personal obtenido.

La salida del programa incluye:
- JSON con la lista de usuarios
- JSON con la respuesta de creación del nuevo usuario
- JSON con el detalle del usuario recién creado

Comandos para compilar y ejecutar el proyecto:
1-Abrir una terminal y ubicarse en la raíz del proyecto
cd fravegaTech-API-REST

2-Compilar el archivo Java (asegúrate de tener Java 17+)
javac GoRestTest/GoRestApiTest.java

3-Ejecutar el programa
java GoRestTest.GoRestApiTest
