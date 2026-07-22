import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReservaServiceTest {
    SalaCine salaCine;
    ReservaService reservaService;

    @BeforeEach
    void setUp() {
        salaCine = new SalaCine("SalaPrueba", 10);

        salaCine.agregarAsiento(new Asiento("A1", "ESTANDAR"));
        salaCine.agregarAsiento(new Asiento("A2", "ESTANDAR"));
        salaCine.agregarAsiento(new Asiento("A3", "ESTANDAR"));
        salaCine.agregarAsiento(new Asiento("A4", "ESTANDAR"));
        salaCine.agregarAsiento(new Asiento("A5", "ESTANDAR"));
        salaCine.agregarAsiento(new Asiento("A6", "ESTANDAR"));
        salaCine.agregarAsiento(new Asiento("A7", "ESTANDAR"));

        reservaService = new ReservaService(salaCine);
    }

    @Test
    @DisplayName("Reserva sin asientos")
    void reservaSinAsientos() {
        assertThrows(IllegalArgumentException.class, () -> reservaService.reservarAsientos(null));
        assertThrows(IllegalArgumentException.class, () -> reservaService.reservarAsientos(Collections.emptyList()));
    }

    @Test
    @DisplayName("Reserva supera maximo permitido")
    void reservaSuperaMaximo() {
        List<String> asientos = Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7");
        assertThrows(IllegalArgumentException.class, () ->  reservaService.reservarAsientos(asientos));
    }

    @Test
    @DisplayName("Reserva sin Descuento")
    void reservaSinDescuento() {
        double total = reservaService.reservarAsientos(Arrays.asList("A1"));
        // 1 asiento Estandar: $5.00
        assertEquals(5, total);
        assertTrue(salaCine.buscarAsiento("A1").isOcupado());
    }

    @Test
    @DisplayName("Reserva con Descuento 5%")
    void reservaDescuentoCinco() {
        double total = reservaService.reservarAsientos(Arrays.asList("A1", "A2"));
        assertEquals(9.5, total);
        assertTrue(salaCine.buscarAsiento("A1").isOcupado());
        assertTrue(salaCine.buscarAsiento("A2").isOcupado());
    }

    @Test
    @DisplayName("Reserva con Descuento 15%")
    void reservaDescuentoQuince() {
        double total = reservaService.reservarAsientos(Arrays.asList("A1", "A2", "A3", "A4"));
        assertEquals(17, total);
        assertTrue(salaCine.buscarAsiento("A1").isOcupado());
        assertTrue(salaCine.buscarAsiento("A2").isOcupado());
    }

    
}
