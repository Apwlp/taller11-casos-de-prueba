# Tabla grupo #3
Clase | ID | Metodo | Datos de entrada | Salida esperada
| Clase | ID | Método | Datos de entrada | Salida esperada |
|--------|----|---------|------------------|-----------------|
| AsientoTest | AT-01 | `constructorValido()` | Código = `"A1"`, Tipo = `"VIP"` | Se crea un asiento válido con código **A1**, tipo **VIP** y estado **no ocupado**. |
| AsientoTest | AT-02 | `TestconstructorCodigoInvalido()` | Código = `""`, Tipo = `"ESTANDAR"` | Se lanza `IllegalArgumentException`. |
| AsientoTest | AT-03 | `TestconstructorTipoInvalido()` | Código = `"A1"`, Tipo = `"INVALIDO"` | Se lanza `IllegalArgumentException`. |
| AsientoTest | AT-04 | `testCalcularPrecioBase()` | Asientos de tipo **VIP**, **ESTANDAR** y **4D** | Devuelve el precio base correspondiente al tipo de asiento. |
| AsientoTest | AT-05 | `testOcuparExito()` | Asiento disponible | El asiento cambia al estado **ocupado** (`true`). |
| AsientoTest | AT-06 | `testOcuparYaOcupado()` | Asiento previamente ocupado | Se lanza `IllegalStateException`. |
| AsientoTest | AT-07 | `testLiberar()` | Asiento ocupado | El asiento vuelve al estado **no ocupado** (`false`). |
| ReservaServiceTest | RST-01 | `reservaSinAsientos()` | `null` o lista vacía | Se lanza `IllegalArgumentException`. |
| ReservaServiceTest | RST-02 | `reservaSuperaMaximo()` | Lista con 7 asientos | Se lanza `IllegalArgumentException`. |
| ReservaServiceTest | RST-03 | `reservaSinDescuento()` | Lista: `["A1"]` | Total = **5.00** y el asiento queda ocupado. |
| ReservaServiceTest | RST-04 | `reservaDescuentoCinco()` | Lista: `["A1","A2"]` | Total = **9.50** (5% de descuento) y ambos asientos quedan ocupados. |
| ReservaServiceTest | RST-05 | `reservaDescuentoQuince()` | Lista: `["A1","A2","A3","A4"]` | Total = **17.00** (15% de descuento) y los asientos quedan ocupados. |
| SalaCineTest | SCT-01 | `constructorValido()` | Nombre = `"Sala 1"`, Capacidad = `10` | Se crea una sala válida con el nombre y capacidad especificados. |
| SalaCineTest | SCT-02 | `buscarAsientoInexistente()` | Código = `"Z9"` | Se lanza `NoSuchElementException`. |
| SalaCineTest | SCT-03 | `calcularIngresoTotal()` | A1 (VIP) y A2 (ESTANDAR) ocupados | Retorna un ingreso total de **13.50**. |
| SalaCineTest | SCT-04 | `codigoRepetido()` | Agregar un asiento con código `"A1"` | Se lanza `IllegalArgumentException`. |
| SalaCineTest | SCT-05 | `capacidadMaxima()` | Agregar un tercer asiento a una sala con capacidad 2 | Se lanza `IllegalStateException`. |
