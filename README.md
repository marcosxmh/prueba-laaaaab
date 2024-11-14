# Snake Game - Proyecto de Programación Orientada a Objetos

Este es un proyecto de escritorio del famoso juego Snake desarrollado para la asignatura de Programación Orientada a Objetos. El juego ha sido implementado en Java, utilizando Maven para la gestión de dependencias y construcción del proyecto.

## Sobre el Proyecto

El Snake Game es un clásico juego de arcade en el que el jugador controla una serpiente que crece al consumir elementos en el escenario. El objetivo del juego es guiar a la serpiente para que se alimente de frutas como manzanas y piñas, evitando chocar con los bordes de la pantalla o con su propio cuerpo.

## Conceptos de Programación Orientada a Objetos (POO)

El proyecto utiliza los conceptos fundamentales de Programación Orientada a Objetos:

### Clases y Objetos

Las entidades del juego, como la serpiente, las frutas y el escenario, están representadas por clases. Los objetos son instancias de estas clases.

### Herencia

La jerarquía de clases se utiliza para reutilizar código común y establecer relaciones de especialización entre las entidades del juego. Por ejemplo, la clase `Food` puede ser heredada por las clases `Apple` y `Pineapple`.

### Encapsulamiento

Los detalles de implementación de cada clase están encapsulados, definiendo clases públicas, privadas y protegidas. Esto promueve la modularidad y facilita el mantenimiento del código.

### Abstracción

El código está organizado en clases y métodos que representan conceptos abstractos del juego, como la serpiente, las frutas y el escenario. Esto simplifica la implementación y hace que el código sea más comprensible.

### Polimorfismo

El juego utiliza polimorfismo para manejar objetos de clases con diferentes comportamientos en función del contexto. Esto contribuye a la flexibilidad del código.

## Cómo Ejecutar el Proyecto

### Requisitos Previos

- Tener instalado el JDK (Java Development Kit).
- Tener Maven instalado.
- Tener una IDE para Java (por ejemplo, Eclipse, IntelliJ IDEA, VSCode).

### Iniciar el Proyecto

1. Clona el repositorio del proyecto en tu entorno local.
2. Abre el terminal en la carpeta raíz del proyecto.
3. Ejecuta el comando para instalar las dependencias de Maven:

```
mvn install
```

- A continuación, ejecuta el comando para compilar y ejecutar el proyecto.

```
mvn compile javafx:run
```

- Después de seguir estos pasos, el Snake Game se iniciará y podrás comenzar a jugar.

## Entorno de Desarrollo:

Este proyecto fue desarrollado utilizando el editor de código Visual Studio Code (VSCode), pero puede ejecutarse en cualquier IDE Java compatible con Maven.


## SonarQube :

* [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=PedroHdez18_Proyecto-LAB_&metric=alert_status)]
    (https://sonarcloud.io/summary/new_code?id=PedroHdez18_Proyecto-LAB_)
