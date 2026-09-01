# Automatización de Pruebas

Proyecto desarrollado para implementar y demostrar un proceso básico de automatización de pruebas utilizando Java, Maven, JUnit 5, Git y GitHub Actions.

## Objetivos

- Implementar pruebas unitarias automatizadas.
- Utilizar Maven para gestionar el proyecto y sus dependencias.
- Aplicar control de versiones mediante Git.
- Trabajar con ramas para separar los cambios realizados.
- Implementar integración continua mediante GitHub Actions.
- Ejecutar automáticamente las pruebas ante cambios en el repositorio.
- Generar y almacenar los resultados de las pruebas.

## Tecnologías utilizadas

- Java 17
- Maven
- JUnit 5
- Git
- GitHub
- GitHub Actions
- IntelliJ IDEA

## Estructura del proyecto

```text
automatizacion-pruebas/
├── .github/
│   └── workflows/
│       └── ci.yml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── cl/automatizacion/
│   │   │       └── Calculadora.java
│   │   └── resources/
│   └── test/
│       └── java/
│           └── cl/automatizacion/
│               └── CalculadoraTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## Funcionalidades implementadas

La clase `Calculadora` contiene operaciones matemáticas simples utilizadas para demostrar la ejecución de pruebas unitarias:

- Suma de dos números.
- Resta de dos números.
- Multiplicación de dos números.

## Pruebas unitarias

Las pruebas se encuentran en:

```text
src/test/java/cl/automatizacion/CalculadoraTest.java
```

Actualmente se implementan tres pruebas unitarias independientes:

1. Validación de suma.
2. Validación de resta.
3. Validación de multiplicación.

Las pruebas utilizan JUnit 5.

## Ejecutar las pruebas

Las pruebas automatizadas pueden ejecutarse mediante Maven con:

```bash
mvn clean test
```

Una ejecución correcta debe finalizar con un resultado similar a:

```text
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

También pueden ejecutarse desde el panel Maven de IntelliJ IDEA utilizando la fase `test`.

## Control de versiones

El proyecto utiliza Git como sistema de control de versiones.

Durante el desarrollo se utilizaron ramas independientes, entre ellas:

```text
main
feature/pruebas-unitarias
feature/ci-pipeline
```

Los cambios son registrados mediante commits con mensajes descriptivos y posteriormente integrados a la rama principal.

## Integración continua

El proyecto utiliza GitHub Actions para ejecutar automáticamente las pruebas.

La configuración se encuentra en:

```text
.github/workflows/ci.yml
```

El pipeline se ejecuta cuando:

- Se realiza un `push` hacia `main`.
- Se crea o actualiza un `pull request` hacia `main`.

El proceso de integración continua realiza las siguientes tareas:

1. Descarga el código del repositorio.
2. Configura Java 17.
3. Configura el entorno Maven.
4. Compila el proyecto.
5. Ejecuta las pruebas automatizadas.
6. Guarda los resultados de las pruebas como artefacto.

## Reportes de pruebas

Maven Surefire genera los resultados de las pruebas en:

```text
target/surefire-reports/
```

Durante la ejecución del pipeline, GitHub Actions almacena estos resultados en un artefacto denominado:

```text
reporte-pruebas
```

Esto permite acceder posteriormente a los resultados generados durante la ejecución del CI.

## Resultado actual

La ejecución automatizada actual contiene:

```text
Tests run: 3
Failures: 0
Errors: 0
Skipped: 0
```

Resultado:

```text
BUILD SUCCESS
```

Por lo tanto, las pruebas unitarias implementadas se ejecutan correctamente tanto en el entorno local como en GitHub Actions.

## Autor

Lizardo