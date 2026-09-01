package cl.automatizacion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    @Test
    void deberiaSumarDosNumeros() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.sumar(5, 3);

        assertEquals(8, resultado);
    }

    @Test
    void deberiaRestarDosNumeros() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.restar(10, 4);

        assertEquals(6, resultado);
    }

    @Test
    void deberiaMultiplicarDosNumeros() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.multiplicar(4, 3);

        assertEquals(12, resultado);
    }
}