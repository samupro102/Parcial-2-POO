/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Windows 11
 */
public class ProfesorTest {
     private static final double DELTA = 0.001;
 
    private Fecha crearFecha(int dia, int mes, int anio) {
        Fecha f = new Fecha();
        f.setDia(dia);
        f.setMes(mes);
        f.setAnio(anio);
        return f;
    }
 
    private Profesor crearProfesor(double salarioHora, int horasDictadas) {
        return new Profesor("Carlos Perez", "Calle 10 #5-20", "3001234567",
                crearFecha(10, 5, 1985), "123456789", "Matematicas",
                salarioHora, horasDictadas);
    }
 
    // ---------- Constructor ----------
    @Test
    public void testConstructor_AsignaDatosDePersona() {
        Profesor p = crearProfesor(10000, 100);
        assertEquals("Carlos Perez", p.getNombre());
        assertEquals("Calle 10 #5-20", p.getDireccion());
        assertEquals("3001234567", p.getTelefono());
        assertEquals("10/5/1985", p.getFechaNacimiento().toString());
    }
 
    @Test
    public void testConstructor_AsignaDatosPropiosDelProfesor() {
        Profesor p = crearProfesor(10000, 100);
        assertEquals("123456789", p.getCedula());
        assertEquals("Matematicas", p.getArea());
        assertEquals(10000, p.getSalarioHora(), DELTA);
        assertEquals(100, p.getHorasDictadas());
    }
 
    @Test
    public void testProfesor_EsUnaPersona() {
        Profesor p = crearProfesor(10000, 100);
        assertTrue(p instanceof Persona);
    }
 
    // ---------- Setters ----------
    @Test
    public void testSetCedula_Base() {
        Profesor p = crearProfesor(10000, 100);
        p.setCedula("987654321");
        assertEquals("987654321", p.getCedula());
    }
 
    @Test
    public void testSetArea_Base() {
        Profesor p = crearProfesor(10000, 100);
        p.setArea("Fisica");
        assertEquals("Fisica", p.getArea());
    }
 
    // ---------- Pago ----------
    @Test
    public void testCalcularPago_Base_IncluyeRecargoDel30Porciento() {
        // 10000 * 100 = 1.000.000 y con el 30% queda 1.300.000
        Profesor p = crearProfesor(10000, 100);
        assertEquals(1300000.0, p.calcularPago(), DELTA);
    }
 
    @Test
    public void testCalcularPago_CeroHoras_EsCero() {
        Profesor p = crearProfesor(10000, 0);
        assertEquals(0.0, p.calcularPago(), DELTA);
    }
 
    @Test
    public void testCalcularPago_SalarioCero_EsCero() {
        Profesor p = crearProfesor(0, 100);
        assertEquals(0.0, p.calcularPago(), DELTA);
    }
 
    @Test
    public void testCalcularPago_UnaHora() {
        Profesor p = crearProfesor(20000, 1);
        assertEquals(26000.0, p.calcularPago(), DELTA);
    }
 
    @Test
    public void testCalcularPago_SalarioConDecimales() {
        // 12500.50 * 10 = 125005 y con el 30% queda 162506.5
        Profesor p = crearProfesor(12500.50, 10);
        assertEquals(162506.5, p.calcularPago(), DELTA);
    }
 
    @Test
    public void testCalcularPago_SeActualizaAlCambiarSalarioHora() {
        Profesor p = crearProfesor(10000, 100);
        p.setSalarioHora(20000);
        assertEquals(2600000.0, p.calcularPago(), DELTA);
    }
 
    @Test
    public void testCalcularPago_SeActualizaAlCambiarHorasDictadas() {
        Profesor p = crearProfesor(10000, 100);
        p.setHorasDictadas(50);
        assertEquals(650000.0, p.calcularPago(), DELTA);
    }
 
    // ---------- Prestaciones ----------
    @Test
    public void testCalcularPrestaciones_Base_Es19PorcientoDelPago() {
        // 1.300.000 * 0.19 = 247.000
        Profesor p = crearProfesor(10000, 100);
        assertEquals(247000.0, p.calcularPrestaciones(), DELTA);
    }
 
    @Test
    public void testCalcularPrestaciones_CeroHoras_EsCero() {
        Profesor p = crearProfesor(10000, 0);
        assertEquals(0.0, p.calcularPrestaciones(), DELTA);
    }
 
    @Test
    public void testCalcularPrestaciones_RelacionConElPago() {
        Profesor p = crearProfesor(15000, 40);
        assertEquals(p.calcularPago() * 0.19, p.calcularPrestaciones(), DELTA);
    }
}
 

