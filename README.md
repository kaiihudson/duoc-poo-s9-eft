# Evaluación Formativa - Semana 9 - Desarrollo Orientado a Objetos I

## Autor del proyecto
- Autor: Sebastian Rodriguez R.
- Sección: 003A
- Carrera: Analista Programador Computacional
- Sede: Online
---
## Descripción general del sistema.
### Problemática a resolver
Actualmente, Salmontt no cuenta con un sistema estructurado que permita organizar su
información de manera eficiente y orientada a objetos. Algunas de las principales dificultades
que enfrenta son:
-  Duplicación de datos: la información de trabajadores, clientes y proveedores se
maneja en hojas separadas, sin una estructura común ni criterios de validación.
- Desorden estructural: los documentos de órdenes de compra, productos y personal
no siguen una lógica uniforme ni están conectados entre sí.
- Pérdida de tiempo en procesos repetitivos: tareas como registrar nuevos
empleados, emitir órdenes o actualizar el stock deben hacerse manualmente, sin
herramientas que permitan reutilizar estructuras o automatizar flujos simples.
- Falta de jerarquías claras: no se distinguen los roles entre distintos tipos de
personas (empleados, clientes, proveedores), lo que genera ambigüedad en los
procesos de registro y seguimiento.
- Ausencia de modularidad: al no contar con un sistema orientado a clases, cualquier
cambio en una parte del sistema afecta el resto, generando errores y retrabajo
La empresa desea contar con una solución flexible, escalable y estructurada, que
represente el dominio real de sus operaciones, utilizando los principios fundamentales de la
programación orientada a objetos: encapsulamiento, visibilidad, composición,
colecciones reutilizables, herencia, polimorfismo e interfaces.

El nuevo sistema debe permitir modelar las entidades claves del dominio (personas,
direcciones, productos, órdenes), organizar la información en paquetes bien estructurados,
cargar datos desde archivos externos, aplicar buenas prácticas de diseño y ofrecer una base
sólida sobre la cual escalar nuevas funcionalidades en versiones futuras.

---
## Estructura de Carpetas
```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───salmontt
│   │   │           ├───app
│   │   │           ├───data
│   │   │           ├───model
│   │   │           │   ├───common
│   │   │           │   ├───OC
│   │   │           │   └───persona
│   │   │           └───utils
│   │   │               ├───common
│   │   │               └───exceptions
│   │   └───resources
```
---
## Clases Principales
### Modelos
Modelos hace referencia a cualquier objeto dentro del sistema, siendo este modelo un plano para la creacion de entidades en el sistema
1. Orden de compra: `Representacion de una Orden de compra en el sistema`
2. Producto: `Representacion de un producto que pueda manejar Salmontt en su planta`
3. Cliente: `Representacion de un cliente dentro del sistema, extiende Persona`
4. Direccion: `Representacion de una direccion para una persona`
5. Empleado: `Representacion de un empleado dentro del sistema, extiende Persona`
6. Persona: `Clase abstracta que genera el contrato de datos para las clases que se extienden desde esta.`
7. Proveedor: `Representacion de un proveedor dentro del sistema, extiende Persona`
8. Rut: `Representador de un Rol Unico Tributario, para fines de identificacion de personas. Incluye validacion de Digito Verificador`
9. Tarjeta: `Representacion de una Tarjeta asociada a un cliente para generar una compra`
### Interfaces
Interfaz hace referencia a cualquier contrato de datos que se pueda generar en el sistema para mejorar su estructura de datos.
1. RegistroContable: `Contrato de datos para la correcta representacion de las entidades dentro de los implementados`
### Controladores
Controladores hace referencia a clases capaces de invocar los modelos para modificarlos o crear nuevas instancias de ellos.
1. GestorOC: `Controlador de Ordenes de Compra`
2. GestorPersonas: `Controlador de Personas`
3. GestorTarjetas: `Controlador de Tarjetas`
4. GestorUI: `Controlador principal que utiliza todas los demas controladores para manejar y presentar informacion`
---
## HOW TO COMPILE / RUN

1. Clonar este repositorio.
2. Abrir este proyecto en un IDE java (JAVA 25)
3. Asegurarse de importar las dependencias del proyecto (pom.xml)
4. Ejecutar el archivo `Main.java` desde el paquete `app`
---
Fecha de entrega: 19/12/2025
