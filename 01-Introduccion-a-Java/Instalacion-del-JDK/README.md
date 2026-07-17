# Instalacion-del-JDK



\## Objetivo



Preparar el entorno de desarrollo para programar en Java instalando un JDK moderno y verificando que todas las herramientas necesarias funcionen correctamente.



\---



\## ¿Qué es el JDK?



El \*\*JDK (Java Development Kit)\*\* es el conjunto de herramientas necesarias para desarrollar aplicaciones en Java.



Incluye:



\- Compilador (`javac`)

\- Máquina Virtual de Java (JVM)

\- Runtime (JRE)

\- Herramientas de desarrollo y depuración



\---



\## ¿Por qué no alcanza con el JRE?



El \*\*JRE (Java Runtime Environment)\*\* solo permite ejecutar aplicaciones Java.



Para escribir y compilar programas se necesita el \*\*JDK\*\*, ya que contiene el compilador `javac`.



\---



\## Versión utilizada



\- Distribución: Eclipse Temurin

\- Versión: OpenJDK 21 LTS



\---



\## Verificación de la instalación



\### Verificar la versión de Java



```bash

java -version

```



Salida esperada:



```text

openjdk version "21.x.x" LTS

```



\### Verificar el compilador



```bash

javac -version

```



Salida esperada:



```text

javac 21.x.x

```



\### Verificar JAVA\_HOME



```bash

echo %JAVA\_HOME%

```



Salida esperada:



```text

C:\\Program Files\\Eclipse Adoptium\\jdk-21...

```



\---



\## Flujo de compilación en Java



```text

Hola.java

&#x20;    │

&#x20;    ▼

&#x20;  javac

&#x20;    │

&#x20;    ▼

Hola.class

&#x20;    │

&#x20;    ▼

&#x20;   java

&#x20;    │

&#x20;    ▼

&#x20;    JVM

&#x20;    │

&#x20;    ▼

Sistema Operativo

```



\---



\## Conceptos aprendidos



\- Diferencia entre JDK y JRE.

\- Función del compilador `javac`.

\- Función del comando `java`.

\- Configuración de `JAVA\_HOME`.

\- Configuración del `PATH`.

\- Importancia de utilizar una versión LTS.



\---



\## Estado



✅ Entorno de desarrollo configurado correctamente.



Siguiente tema:



➡️ Eclipse-IDE

