Programa para hacer Login y registrarse versión 02/12/20
========================================================

NOTAS GENERALES
---------------

Se trata de un programa basado en línea de comandos que, leyendo documentos de texto, realiza varias operaciones.

El programa cubre los siguientes puntos:
- Diseña la clase Usuario para mapear cada línea del fichero con los datos de los usuarios.

- Si el usuario introduce las credenciales correctamente, el sistema informará con un mensaje "Hola <usuario>", siendo <usuario>
 el nombre del usuario utilizado para acceder.

- En caso contrario, si el usuario existe pero la contraseña no coincide, se pedirá de nuevo la clave, con un número máximo de
 intentos por usuario registrado. 

- Si se sobrepasa ese número máximo de intentos, se bloqueará a dicho usuario (no podrá logarse más), pero dejará acceder al resto de
 usuarios no bloqueados registrados en el fichero.

- Si el usuario no se encuentra en el fichero se realizará el alta del mismo. Se pedirán los datos del nuevo usuario (user y pass) y 
se almacenarán en el fichero de acceso, estando así disponible para poder entrar en el sistema con el nuevo usuario.

- Al darse de alta se realizará un doble check de la contraseña introducida, es decir, deben de coincidir las dos veces que se solicite, 
en caso contrario, se volverá a solicitar la contraseña al usuario de manera indefinida, pudiendo salir mediante una opción concreta.

- Cada vez que se realice un login o intento del mismo, se almacenará en un fichero login.log con la fecha y hora de dicho intento, 
registrando si el intento ha sido correcto o no junto con el nombre de usuario que lo ha intentado (una línea por intento).

- Si el usuario se loga como administrador (admin), además del saludo correspondiente, podrá desbloquear a los usuario bloqueados, 
pudiendo estos volver a intentar logarse.

NOTAS ESPECIFICAS
-----------------

Los documentos en los que se apoya el programa para su funcionamiento, se encuentran situados en una carpeta llamada ficheros, 
alojada en la raíz del proyecto.

El usuario del programa introduce el usuario y la contraseña, cuando el programa tiene los datos, lee el documento de forma secuencial (acceso.txt), 
esto es, línea por línea en busca de los datos introduccidos, se encarga de alamacenarlos en un array dividiendo por símbolo, en este caso ":",
en la situación 0 del array se encontraría el usuario y en la posición 1 la contraseña.

El programa es capaz de bloquear usuarios que hayan intentado logearse y hayan introducido la contreseña mal por 3 intentos.
Para realizar el bloqueo, estos usuarios son añadidos a un nuevo documento llamado bloqueados, el programa, para que pueda realizarse el logeo de
forma existosa además de leer el documento de acceso, lee el documento de bloqueados de forma que si no se encuentra en ese documento, el usuario
recibirá un mensaje de éxisto con su nombre.

El administrador, tiene un trato diferente, este usuario cuando se logea recibe la lista de usuarios bloqueados y tiene el poder de desbloquearlos,
para ello el administrador, mediante un diálogo, puede abrir el documento bloqueados.txt y borrar el usuario o usuarios que considere oportunos.

El programa es capaz de registrar todo y cada uno de los intentos, exitosos e incorrectos que se producen, en un fichero llamado login.log.

Todos los documentos (acceso.txt, login.log, bloqueados.txt) se alojan en la carpeta ficheros.

OTRAS CONSIDERACIONES
---------------------

El programa no es capaz de volver al menú, se incluirá en futuras versiones.
También se incluirá en futuras versiones la posibilidad de desbloquear usuarios mediante la linea de comandos.