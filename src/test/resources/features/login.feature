Feature: Inicio de sesión

  Como usuario del sistema
  Quiero iniciar sesión
  Para acceder a la aplicación

  Background:
    Given que el sistema está disponible

  @login
  Scenario: Inicio de sesión exitoso
    Given que el usuario ingresa "admin" y "1234"
    When presiona el botón iniciar sesión
    Then el sistema muestra "Bienvenido"

  @login
  Scenario Outline: Validación de credenciales inválidas
    Given que el usuario ingresa "<usuario>" y "<clave>"
    When presiona el botón iniciar sesión
    Then el sistema muestra "<mensaje>"

    Examples:
      | usuario | clave | mensaje                 |
      | admin   | 0000  | Credenciales inválidas |
      | pepe    | 1234  | Usuario inexistente    |
      |         |       | Debe ingresar datos    |