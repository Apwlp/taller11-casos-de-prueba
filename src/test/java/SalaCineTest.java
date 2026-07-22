import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Luis Mendoza
 */
class SalaCineTest {

    private SalaCine sala;

    @BeforeEach
    void setUp() {
        sala = new SalaCine("Sala 1", 10);

        sala.agregarAsiento(new Asiento("A1","VIP"));
        sala.agregarAsiento(new Asiento("A2","ESTANDAR"));
        sala.agregarAsiento(new Asiento("A3","4D"));
    }

    //Se verifica que el constructor sea valido
    @Test
    @DisplayName("Constructor crea una sala válida")
    void constructorValido() {
        assertEquals("Sala 1", sala.getNombre());
        assertEquals(10, sala.getCapacidadMaxima());
    }
    

    
    
}
