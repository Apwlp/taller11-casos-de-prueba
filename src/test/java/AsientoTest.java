import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {
    Asiento asiento;

    @BeforeEach
    void setUp(){
        asiento=new Asiento("A1","VIP");
    }

    @Test
    @DisplayName("Constructor crea asiento válido")
    void constructorValido(){
        assertFalse(asiento.isOcupado());
        assertEquals("V1",asiento.getTipo());
        assertEquals("A1",asiento.getCodigo());
    }
    @Test
    @DisplayName("Constructor lanza excepcion cuando codigo esta vacio")
    void TestconstructorCodigoInvalido(){
        assertThrows(IllegalArgumentException.class,()-> {
                new Asiento ("", "ESTANDAR");
        });
    }

    @Test
    @DisplayName("Constructor lanza excepcion cuando Tipo no es valido")
    void TestconstructorTipoInvalido(){
        assertThrows(IllegalArgumentException.class,()-> {
                new Asiento ("A1", "INVALIDO");
        });
    }
    

    @Test
    @DisplayName("Constructor Para calcular el PrecioBase")
    void testCalcularPrecioBase(){
    assertEquals(8.5, asiento.calcularPrecioBase(),0.001);
    // caso adicional 
    Asiento estandar = new Asiento("A2","ESTANDAR");
     Asiento cuatroD = new Asiento("A3","4D");
    assertEquals(5.0, estandar.calcularPrecioBase(),0.001);
        assertEquals(5.0, cuatroD.calcularPrecioBase(),0.001);
        assertEquals(5.0, asiento.calcularPrecioBase(),0.001);

}
    @Test
    @DisplayName("Constructor Para Asiento disponible que se va a ocupar")
    void testOcuparExito(){
        asiento.ocupar();
        assertTrue(asiento.isOcupado());

    }
  
    @Test
    @DisplayName("Constructor Para Asiento que ya esta ocupado")
    void testOcuparYaOcupado(){
        asiento.ocupar();
        assertThrows(IllegalStateException.class, ()  ->{
            asiento.ocupar();
        });

}
     @Test
    @DisplayName("Constructor Para Liberar asiento Ocupado")
    void testLiberar(){
        asiento.ocupar();
        assertTrue(asiento.isOcupado());
         asiento.liberar();
        assertFalse(asiento.isOcupado());
        }  






    }
  



    




}
