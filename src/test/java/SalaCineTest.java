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
    
    //Probar el lanzamiento de excepcion por asiento inexistente
    @Test
    @DisplayName("Buscar asiento inexistente")
    void buscarAsientoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
        sala.buscarAsiento("Z9");
        });
    }
    
    
    //Calculo de ingreso total dado 2 asiento ocupados
    @Test
    @DisplayName("Calcular ingreso total")
    void calcularIngresoTotal() {

        sala.buscarAsiento("A1").ocupar(); // VIP = 8.5
        sala.buscarAsiento("A2").ocupar(); // ESTANDAR = 5.0

        assertEquals(13.5, sala.calcularIngresoTotal());
        }

    
    
}
