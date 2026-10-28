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
public class EstudianteTest {
    
    private Fecha crearFecha(int dia, int mes, int anio) {
        Fecha f = new Fecha();
        f.setDia(dia);
        f.setMes(mes);
        f.setAnio(anio);
        return f;
    }
 
    // ---------- Estado inicial ----------
    @Test
    public void testEstudianteNuevo_CodigoYGradoSinAsignar() {
        Estudiante e = new Estudiante();
        assertNull(e.getCodigo());
        assertNull(e.getGrado());
    }
 
    // ---------- Codigo ----------
    @Test
    public void testSetCodigo_Base() {
        Estudiante e = new Estudiante();
        e.setCodigo("20240001");
        assertEquals("20240001", e.getCodigo());
    }
 
    @Test
    public void testSetCodigo_ReemplazaElValorAnterior() {
        Estudiante e = new Estudiante();
        e.setCodigo("20240001");
        e.setCodigo("20240002");
        assertEquals("20240002", e.getCodigo());
    }
 
    // ---------- Grado ----------
    @Test
    public void testSetGrado_Base() {
        Estudiante e = new Estudiante();
        e.setGrado("10A");
        assertEquals("10A", e.getGrado());
    }
 
    @Test
    public void testSetGrado_ReemplazaElValorAnterior() {
        Estudiante e = new Estudiante();
        e.setGrado("10A");
        e.setGrado("11B");
        assertEquals("11B", e.getGrado());
    }
 
    @Test
    public void testCodigoYGrado_SonIndependientes() {
        Estudiante e = new Estudiante();
        e.setCodigo("20240001");
        e.setGrado("10A");
        e.setGrado("11B");
        assertEquals("20240001", e.getCodigo());
    }
 
    // ---------- Datos heredados de Persona ----------
    @Test
    public void testSetNombre_Heredado() {
        Estudiante e = new Estudiante();
        e.setNombre("Ana Torres");
        assertEquals("Ana Torres", e.getNombre());
    }
 
    @Test
    public void testSetDireccion_Heredado() {
        Estudiante e = new Estudiante();
        e.setDireccion("Carrera 5 #8-12");
        assertEquals("Carrera 5 #8-12", e.getDireccion());
    }
 
    @Test
    public void testSetTelefono_Heredado() {
        Estudiante e = new Estudiante();
        e.setTelefono("3109876543");
        assertEquals("3109876543", e.getTelefono());
    }
 
    @Test
    public void testSetFechaNacimiento_Heredado() {
        Estudiante e = new Estudiante();
        Fecha fecha = crearFecha(15, 3, 2010);
        e.setFechaNacimiento(fecha);
        assertSame(fecha, e.getFechaNacimiento());
        assertEquals("15/3/2010", e.getFechaNacimiento().toString());
    }
 
    // ---------- Herencia y polimorfismo ----------
    @Test
    public void testEstudiante_EsUnaPersona() {
        Estudiante e = new Estudiante();
        assertTrue(e instanceof Persona);
    }
 
    @Test
    public void testEstudianteComoPersona_GuardaLosDatosDePersona() {
        Persona p = new Estudiante();
        p.setNombre("Luis Mora");
        assertEquals("Luis Mora", p.getNombre());
    }
 
    @Test
    public void testEstudianteComoPersona_ConservaSuTipoEstudiante() {
        Persona p = new Estudiante();
        assertTrue(p instanceof Estudiante);
    }
}

