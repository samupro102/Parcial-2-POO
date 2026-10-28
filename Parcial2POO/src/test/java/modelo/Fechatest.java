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
public class Fechatest {
    
    // ---------- Estado inicial ----------
    @Test
    public void testFechaNueva_ValoresEnCero() {
        Fecha f = new Fecha();
        assertEquals(0, f.getDia());
        assertEquals(0, f.getMes());
        assertEquals(0, f.getAnio());
    }
 
    // ---------- Setters y getters ----------
    @Test
    public void testSetDia_Base() {
        Fecha f = new Fecha();
        f.setDia(15);
        assertEquals(15, f.getDia());
    }
 
    @Test
    public void testSetMes_Base() {
        Fecha f = new Fecha();
        f.setMes(3);
        assertEquals(3, f.getMes());
    }
 
    @Test
    public void testSetAnio_Base() {
        Fecha f = new Fecha();
        f.setAnio(2010);
        assertEquals(2010, f.getAnio());
    }
 
    @Test
    public void testSetters_SonIndependientesEntreSi() {
        Fecha f = new Fecha();
        f.setDia(15);
        f.setMes(3);
        f.setAnio(2010);
        f.setMes(7);
        assertEquals(15, f.getDia());
        assertEquals(7, f.getMes());
        assertEquals(2010, f.getAnio());
    }
 
    @Test
    public void testDosFechas_NoCompartenSusValores() {
        Fecha f1 = new Fecha();
        Fecha f2 = new Fecha();
        f1.setDia(10);
        f2.setDia(20);
        assertEquals(10, f1.getDia());
        assertEquals(20, f2.getDia());
    }
 
    // ---------- toString ----------
    @Test
    public void testToString_FechaNueva() {
        Fecha f = new Fecha();
        assertEquals("0/0/0", f.toString());
    }
 
    @Test
    public void testToString_FormatoDiaMesAnio() {
        Fecha f = new Fecha();
        f.setDia(15);
        f.setMes(3);
        f.setAnio(2010);
        assertEquals("15/3/2010", f.toString());
    }
 
    @Test
    public void testToString_DiaYMesDeDosDigitos() {
        Fecha f = new Fecha();
        f.setDia(25);
        f.setMes(12);
        f.setAnio(2024);
        assertEquals("25/12/2024", f.toString());
    }
 
    @Test
    public void testToString_NoAgregaCerosALaIzquierda() {
        Fecha f = new Fecha();
        f.setDia(1);
        f.setMes(2);
        f.setAnio(2000);
        assertEquals("1/2/2000", f.toString());
    }
 
    @Test
    public void testToString_SeActualizaAlCambiarUnValor() {
        Fecha f = new Fecha();
        f.setDia(15);
        f.setMes(3);
        f.setAnio(2010);
        f.setAnio(2011);
        assertEquals("15/3/2011", f.toString());
    }

}
