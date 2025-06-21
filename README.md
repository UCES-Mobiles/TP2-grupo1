# **Mobiles I**
 
## **Trabajo Práctico N°2** 

### **Integrantes**
- Barbieri, Mariano  
- Gatti, Gaspar 
- Zamora, Damian Pablo

---

## **Contexto de la aplicación**

Es una aplicación generada para poder utilizar de recordatorio o repositorio de canciones favoritas.
La misma nos permite guardar los datos que conocemos de ella como el nombre de la canción, el artista, su genero y podremos también
otorgarle una puntuación según consideración.
Una vez dentro, se podrá utilizar la lista para recordar esos temas que a uno le gustan pero eventualmente se olvida de ellos.
En el caso de un error al momento de la creación de la misma, podremos editar los campos guardados desde la pestaña de canciones.
En el caso de que con el paso del tiempo, una canción pierda su encanto, podremos eliminarla en la misma lista.

El usuario deberá ingresar los siguientes datos para una canción:
- **Nombre de la canción**
- **Autor**
- **Género**
- **Puntuación**

### **Capturas del proyecto**

#### **Lista de canciones**

![image](https://github.com/user-attachments/assets/efcb1256-5faa-455d-97bb-b2a9656418a4)

#### **Lista de canciones**

![image](https://github.com/user-attachments/assets/ae2d4523-120c-49cf-bdf7-cfab3b87140f)

---

## **Evolucion del proyecto**

19/06

Puesta en comun sobre el enfoque del proyecto en cuanto a la temática y alcance del mismo. 

20/06

Generacion base del proyecto.
- Se setea viewBinding en buildGradle
- Se crea la clase Song con sus atributos
- Se crean 2 Activitys ( AddSongActivity , SongListActivity ) 
- Generamos 3 layout ( activity_add_song , activity_song_list, item_song)
- Se crean los viewModel

21/06

- Se genera pestaña de edición.
- Se crea la carpeta menú que incluye un menú de inclusión de acciones de edición y eliminación.
- Se agrega un ViewModel llamado SongViewModel.
- Cambios en estética sobre las primeras versiones, inclusión de nuevos logos y grabación de funcionamiento.

https://github.com/user-attachments/assets/513a3180-999f-49a3-b79b-db75560bf49a

Distribución de tareas:
Durante el desarrollo del proyecto nos reunimos varias veces de forma virtual para pensar ideas, buscar soluciones a los problemas que iban surgiendo y tomar decisiones en conjunto. Cada uno fue aportando desde su lugar, ya sea con ideas, pruebas o ayudando a resolver errores.
Las tareas de testing no fueron dejadas de lado, buscando la posibilidad de llegar a errores debido a falta de limitaciones o buscando introducir valores erroneos.
No obstante, el lineamiento de trabajo enfocado a las siguientes tareas fué el siguiente:

*Damian Zamora:* Validación de los distintos datos a ingresar por el usuario al momento del registro del evento. Desarrollo de pantalla de listado de canciones. Creación del proyecto base y primer versión general.

*Mariano Barbieri:* Desarrollo de pantalla main (registro de elementos) con ingreso de datos y el manejo de los mismos. Gestión de Datos con ViewModel, manejo de memoria y edición/eliminación de los mismos. Desarrollo de activity de edición/eliminación de los elementos seleccionados

*Gaspar Gatti:* Desarrollo de Testing, Interfaz visual dentro de la app y el menú android y agregados solicitados al ReadMe.

