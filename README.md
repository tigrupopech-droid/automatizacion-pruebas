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

---

# Actividad 2 - BDD y Pruebas de Rendimiento

## Objetivo

La segunda actividad amplía el proceso de automatización incorporando prácticas de
Behavior Driven Development (BDD), pruebas de rendimiento y mecanismos de
monitoreo dentro del pipeline de integración continua.

## Three Amigos

Para definir la funcionalidad de inicio de sesión se simuló una reunión Three Amigos,
considerando los puntos de vista de Negocio, Desarrollo y QA.

| Rol | Participación |
|---|---|
| Negocio / Product Owner | Define que un usuario válido debe poder iniciar sesión y que las credenciales incorrectas deben impedir el acceso. |
| Desarrollador | Implementa la lógica necesaria para validar el usuario y la contraseña. |
| QA / Tester | Define escenarios positivos, negativos y datos de prueba utilizando Gherkin y Cucumber. |

### Criterios de aceptación

- El usuario `admin` con contraseña `1234` debe obtener el mensaje `Bienvenido`.
- Una contraseña incorrecta debe mostrar `Credenciales inválidas`.
- Un usuario inexistente debe mostrar `Usuario inexistente`.
- Si los campos están vacíos debe mostrarse `Debe ingresar datos`.

## Escenarios BDD con Gherkin

Los escenarios se encuentran en:

```text
src/test/resources/features/login.feature
```

Se implementó un escenario de inicio de sesión exitoso y un `Scenario Outline`
con diferentes ejemplos de credenciales inválidas.

El Scenario Outline permite reutilizar el mismo escenario con distintos conjuntos
de datos definidos mediante `Examples`.

## Step Definitions

Los pasos definidos en Gherkin fueron implementados mediante Cucumber en:

```text
src/test/java/cl/automatizacion/bdd/LoginSteps.java
```

El runner utilizado para ejecutar Cucumber se encuentra en:

```text
src/test/java/cl/automatizacion/bdd/RunCucumberTest.java
```

Las pruebas BDD se ejecutan junto con las pruebas unitarias mediante Maven:

```bash
mvn clean test
```

La ejecución completa contiene:

```text
Tests run: 7
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

## Reporte BDD

Cucumber genera un reporte HTML navegable en:

```text
target/cucumber-report.html
```

El reporte permite visualizar los escenarios ejecutados y su estado.

En la ejecución realizada se obtuvieron:

```text
Escenarios BDD ejecutados: 4
Aprobados: 4
Porcentaje aprobado: 100%
```

El reporte también es almacenado como artefacto durante la ejecución del pipeline
de GitHub Actions.

## Prueba de rendimiento con Grafana k6

Se implementó una prueba básica de rendimiento utilizando Grafana k6.

El script se encuentra en:

```text
performance/login-performance.js
```

La prueba simula:

```text
Usuarios virtuales: 5
Duración: 10 segundos
```

Para ejecutar la prueba localmente:

```bash
k6 run performance/login-performance.js
```

### Resultados obtenidos

Durante la ejecución local se obtuvieron los siguientes resultados:

| Métrica | Resultado |
|---|---:|
| Solicitudes HTTP | 70 |
| Throughput aproximado | 6,95 solicitudes/segundo |
| Latencia promedio | 96,54 ms |
| Latencia p95 | 294,9 ms |
| Latencia máxima | 337,82 ms |
| Errores HTTP | 0,00 % |
| Iteraciones completadas | 35 |

Los resultados indican que la aplicación utilizada para la prueba respondió
correctamente bajo la carga definida, sin solicitudes HTTP fallidas.

## Umbrales de rendimiento

Se definieron los siguientes criterios en k6:

```javascript
thresholds: {
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<1000'],
}
```

Esto establece que:

- La tasa de errores debe ser inferior al 5 %.
- La latencia p95 debe ser inferior a 1000 ms.

En la ejecución realizada ambos umbrales fueron cumplidos.

## Dashboard de métricas

GitHub Actions se utiliza como un dashboard básico para supervisar el estado
de las pruebas automatizadas.

El pipeline contiene dos procesos principales:

| Job | Función |
|---|---|
| build-and-test | Ejecuta las pruebas unitarias y los escenarios BDD. |
| performance-test | Ejecuta la prueba de rendimiento mediante k6. |

De esta forma se pueden supervisar métricas funcionales y de rendimiento.

Las métricas consideradas son:

- Cantidad de pruebas ejecutadas.
- Pruebas aprobadas y fallidas.
- Latencia promedio.
- Latencia p95.
- Throughput o solicitudes por segundo.
- Porcentaje de errores HTTP.
- Estado de los umbrales de rendimiento.

## Alertas ante fallos o degradación

El pipeline actúa como mecanismo automático de detección de fallos.

Si una prueba unitaria o BDD falla, Maven devuelve un estado de error y el job
`build-and-test` queda marcado como fallido en GitHub Actions.

Para rendimiento, k6 evalúa automáticamente los thresholds definidos.

El job `performance-test` falla cuando:

```text
Latencia p95 >= 1000 ms
o
Tasa de errores >= 5 %
```

Por lo tanto, un cambio que provoque una degradación funcional o de rendimiento
puede ser identificado automáticamente durante el proceso de integración continua.

## Integración continua de la Actividad 2

El workflow se encuentra en:

```text
.github/workflows/ci.yml
```

El pipeline se ejecuta automáticamente ante:

```text
push a main
pull request hacia main
```

Actualmente ejecuta:

1. Descarga del código.
2. Configuración de Java 17 y Maven.
3. Pruebas unitarias.
4. Pruebas BDD con Cucumber.
5. Generación de reportes.
6. Publicación del reporte Cucumber como artefacto.
7. Instalación de Grafana k6.
8. Ejecución de la prueba de rendimiento.
9. Validación automática de los umbrales de rendimiento.

La ejecución final del pipeline completó correctamente los jobs
`build-and-test` y `performance-test`.

## Resultado de la Actividad 2

La solución incorpora pruebas BDD con Cucumber, escenarios escritos en Gherkin,
Step Definitions, reportes HTML navegables, pruebas de rendimiento con Grafana k6,
métricas de rendimiento y detección automática de fallos mediante GitHub Actions.

Las pruebas funcionales, BDD y de rendimiento fueron ejecutadas satisfactoriamente.