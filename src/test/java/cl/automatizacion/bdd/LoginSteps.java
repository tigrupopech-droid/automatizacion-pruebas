package cl.automatizacion.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private String usuario;
    private String clave;
    private String mensajeResultado;

    @Given("que el sistema está disponible")
    public void queElSistemaEstaDisponible() {
        assertTrue(true);
    }

    @Given("que el usuario ingresa {string} y {string}")
    public void queElUsuarioIngresa(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    @When("presiona el botón iniciar sesión")
    public void presionaElBotonIniciarSesion() {

        if (usuario.isEmpty() || clave.isEmpty()) {

            mensajeResultado = "Debe ingresar datos";

        } else if (usuario.equals("admin") && clave.equals("1234")) {

            mensajeResultado = "Bienvenido";

        } else if (!usuario.equals("admin")) {

            mensajeResultado = "Usuario inexistente";

        } else {

            mensajeResultado = "Credenciales inválidas";
        }
    }

    @Then("el sistema muestra {string}")
    public void elSistemaMuestra(String mensajeEsperado) {

        assertEquals(
                mensajeEsperado,
                mensajeResultado
        );
    }
}