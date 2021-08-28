# SysInv
Inventario de Sistemas

# Descripcion
Es una herramienta de gestion de activos, particularmente sistemas del departamento de tecnologias de la informacion de la empresa. Esta herramienta sera de apoyo en la elaboracion de reportes de inventario que servira para la toma de desiciones del departamento asi como para brindar un soporte mas agil al tener localizados los activos.

# Problema Identificado
El problema identificado fue la desorganizacion en cuanto a dispositivos a causa de la falta de una base de datos que sirviera como un inventario centralizado para tener el historial de las adquisiciones y mantener localizadas e identificadas las computadoras (activos) en todo momento.

# Solucion
La solucion que se planteo fue el implementar un programa que sirviera como lugar de referencia para la localizacion de computadoras y donde se pudiera mantener la informacion organizada y que en un momento dado pudiera ser util a la hora de la planeacion del presupuesto anual para el departamento de TI al tomar en cuenta los activos con los que se cuenta y las futuras adquisiciones.

# Tabla de Contenidos
- [Interfaz de usuario.](https://github.com/s-valles/SysInv/wiki#welcome-to-the-sysinv-wiki)
- [Tablas de informacion.](https://github.com/s-valles/SysInv/wiki#tablas-de-informacion)
  -  ID
  -  Nombre
  -  Numero de Serie
  -  Locacion
- [Caracteristicas](https://github.com/s-valles/SysInv/wiki#caracteristicas)
- Botones de editar y eliminar.
- Listado de sistemas totales.
- Forma de ingreso de datos de los sistemas.
- Edicion de datos de los sistemas.
- Eliminar sistemas.
- Mostrar datos del sistema.

# Requerimientos
- IDE - STS / Eclipse Neon.3.3
- JDK - 16
- Apache Tomcat - 10.6
- JSTL - 1.2.1
- Servlet API - 4.0
- JSP - 2.2 +
- MySQL - mysql-connector-java.jar

# Instalacion
- Descargar el proyecto.
- Descomprimir archivo .zip.
- Obtener la carpeta del proyecto.
- Abrir el proyecto.
- Correr el proyecto en servidor local.

# Configuracion
- Configuracion del producto.
  - Los archivos de configuracion deberan ser agregados a la carpeta lib.
   - jsp-api.2.3.1.jar
   - servlet-api.4.0.0.jar
   - mysql-connector-java.jar
   - jstl-1.2.jar 

# Uso
El software será para uso interno del departamento de tecnologias de la informacion. En un inicio solamente sera administrado por un usuario para ingresar al programa todos los datos que vayan siendo recopilados durante los inventarios de los activos del departamento.

## Usuario Administrador
El usuario administrador sera el encargado de ingresar la informacion al sistema, resultado del inventario, mediante el la forma de para ingreso de datos. Esto se puede lograr llendo a la pagina principal y dando click en el boton Add New System (Agregar Nuevo Sistema).
Despues de haber llenado todos los datos en la forma se procede a guardarlos para seguir agregando mas datos.

# Contribucion
## Guia de Contribucion
Se invita a los usuarios de este programa a contribuir directamente a este. Los pasos para realizarlo son los siguientes:

- Clonar Repositorio
  -  En el lado derecho de la pantalla, debajo de la pestaña "Contributors", se apreciara un boton verde que dice "Clonar o Descargar". Se debe hacer click en este y en la ventana que aparece debajo seleccionar el icono de "Copiar" para copiar la URL del repositorio y agregarlo con el comando $ git clone <repo-url>. 
- Crear Nuevo Branch
  - Se debe de ir a la página principal del repositorio de GitHub y localizar el boton del branch principal. Estando ahi, para crear un nuevo branch daremos click en el menú de seleccion de branches y comenzaremos a escribir el nombre del nuevo branch en el cuadro de texto y dar click en crear branch. 
- Enviar Pull Request
  Despues de haber generado al menos otro branch podremos continuar colaborando al generar Pull Requests, esto se puede hacer llendo a la pagina principal en el menu superior y dando click en Pull Requests. En la pagina siguiente se localiza del lado derecho el boton verde New Pull Request y seleccionar los branches a comparar para finalmente crearlo al tener los resultados.
- Espera Antes de  Hacer Merge
  Es necesario esperar antes de hacer merge, permitiendose tener claros los cambios que se veran publicados en la version principal.



# Roadmap
Al ir trabajando con el programa dentro de la empresa y con la experiencia de los usuarios del area de sistemas, podremos identificar errores y mejoras para poder is mejorando el software de acuerdo a las necesidades del departamento. Se planea lanzar actualizaciones de acuerdo al sistema agile de manera continua para mantener el sistema en movimiento.

# Diagrama de la Solucion
![image](https://user-images.githubusercontent.com/82923981/131185564-df7f5ec9-34d5-404d-a1fd-9f0be9c6964d.png)


# Créditos
<b>Desarrollado por:</b>

Sergio Valles
