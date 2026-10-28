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
public class ColegioTest {
    
    private static final String ENCABEZADO_ESTUDIANTES
            = "LISTA DE ESTUDIANTES\n----------------------------------------\n";
    private static final String ENCABEZADO_PROFESORES
            = "PROFESORES POR SALARIO TOTAL (MAYOR A MENOR)\n----------------------------------------\n";
 
    private Fecha crearFecha(int dia, int mes, int anio) {
        Fecha f = new Fecha();
        f.setDia(dia);
        f.setMes(mes);
        f.setAnio(anio);
        return f;
    }
 
    private Estudiante crearEstudiante(String nombre, String codigo, String grado) {
        Estudiante e = new Estudiante();
        e.setNombre(nombre);
        e.setDireccion("Carrera 5 #8-12");
        e.setTelefono("3109876543");
        e.setFechaNacimiento(crearFecha(15, 3, 2010));
        e.setCodigo(codigo);
        e.setGrado(grado);
        return e;
    }
 
    private Profesor crearProfesor(String nombre, String cedula, double salarioHora, int horas) {
        return new Profesor(nombre, "Calle 10 #5-20", "3001234567",
                crearFecha(10, 5, 1985), cedula, "Matematicas", salarioHora, horas);
    }
 
    // ---------- Estado inicial ----------
    @Test
    public void testColegioNuevo_TotalesEnCero() {
        Colegio c = new Colegio();
        assertEquals(0, c.getTotalEstudiantes());
        assertEquals(0, c.getTotalProfesores());
    }
 
    @Test
    public void testColegioNuevo_CapacidadDe50Registros() {
        Colegio c = new Colegio();
        assertEquals(50, c.getEstudiantes().length);
        assertEquals(50, c.getProfesores().length);
    }
 
    @Test
    public void testColegioNuevo_NombreSinAsignar() {
        Colegio c = new Colegio();
        assertNull(c.getNombre());
    }
 
    @Test
    public void testSetNombre_Base() {
        Colegio c = new Colegio();
        c.setNombre("Colegio San Jose");
        assertEquals("Colegio San Jose", c.getNombre());
    }
 
    // ---------- Registrar estudiante ----------
    @Test
    public void testRegistrarEstudiante_Base() {
        Colegio c = new Colegio();
        Estudiante e = crearEstudiante("Ana Torres", "20240001", "10A");
        assertTrue(c.registrarEstudiante(e));
        assertEquals(1, c.getTotalEstudiantes());
        assertSame(e, c.getEstudiantes()[0]);
    }
 
    @Test
    public void testRegistrarVariosEstudiantes_SeGuardanEnOrden() {
        Colegio c = new Colegio();
        Estudiante e1 = crearEstudiante("Ana Torres", "20240001", "10A");
        Estudiante e2 = crearEstudiante("Luis Mora", "20240002", "10B");
        c.registrarEstudiante(e1);
        c.registrarEstudiante(e2);
        assertEquals(2, c.getTotalEstudiantes());
        assertSame(e1, c.getEstudiantes()[0]);
        assertSame(e2, c.getEstudiantes()[1]);
    }
 
    @Test
    public void testRegistrarEstudiante_ElRegistro50EsValido() {
        Colegio c = new Colegio();
        for (int i = 0; i < 49; i++) {
            c.registrarEstudiante(crearEstudiante("Estudiante", "E" + i, "10A"));
        }
        assertTrue(c.registrarEstudiante(crearEstudiante("Ultimo", "E49", "10A")));
        assertEquals(50, c.getTotalEstudiantes());
    }
 
    @Test
    public void testRegistrarEstudiante_ElRegistro51RetornaFalse() {
        Colegio c = new Colegio();
        for (int i = 0; i < 50; i++) {
            c.registrarEstudiante(crearEstudiante("Estudiante", "E" + i, "10A"));
        }
        assertFalse(c.registrarEstudiante(crearEstudiante("Sobrante", "E50", "10A")));
    }
 
    @Test
    public void testRegistrarEstudiante_CuandoEstaLlenoNoCambiaElTotal() {
        Colegio c = new Colegio();
        for (int i = 0; i < 50; i++) {
            c.registrarEstudiante(crearEstudiante("Estudiante", "E" + i, "10A"));
        }
        c.registrarEstudiante(crearEstudiante("Sobrante", "E50", "10A"));
        assertEquals(50, c.getTotalEstudiantes());
    }
 
    @Test
    public void testRegistrarEstudiantes_NoAfectaElTotalDeProfesores() {
        Colegio c = new Colegio();
        c.registrarEstudiante(crearEstudiante("Ana Torres", "20240001", "10A"));
        assertEquals(0, c.getTotalProfesores());
    }
 
    // ---------- Registrar profesor ----------
    @Test
    public void testRegistrarProfesor_Base() {
        Colegio c = new Colegio();
        Profesor p = crearProfesor("Carlos Perez", "123456789", 10000, 100);
        assertTrue(c.registrarProfesor(p));
        assertEquals(1, c.getTotalProfesores());
        assertSame(p, c.getProfesores()[0]);
    }
 
    @Test
    public void testRegistrarVariosProfesores_SeGuardanEnOrden() {
        Colegio c = new Colegio();
        Profesor p1 = crearProfesor("Carlos Perez", "123456789", 10000, 100);
        Profesor p2 = crearProfesor("Laura Gomez", "987654321", 12000, 80);
        c.registrarProfesor(p1);
        c.registrarProfesor(p2);
        assertEquals(2, c.getTotalProfesores());
        assertSame(p1, c.getProfesores()[0]);
        assertSame(p2, c.getProfesores()[1]);
    }
 
    @Test
    public void testRegistrarProfesor_ElRegistro50EsValido() {
        Colegio c = new Colegio();
        for (int i = 0; i < 49; i++) {
            c.registrarProfesor(crearProfesor("Profesor", "P" + i, 10000, 10));
        }
        assertTrue(c.registrarProfesor(crearProfesor("Ultimo", "P49", 10000, 10)));
        assertEquals(50, c.getTotalProfesores());
    }
 
    @Test
    public void testRegistrarProfesor_ElRegistro51RetornaFalse() {
        Colegio c = new Colegio();
        for (int i = 0; i < 50; i++) {
            c.registrarProfesor(crearProfesor("Profesor", "P" + i, 10000, 10));
        }
        assertFalse(c.registrarProfesor(crearProfesor("Sobrante", "P50", 10000, 10)));
    }
 
    @Test
    public void testRegistrarProfesor_CuandoEstaLlenoNoCambiaElTotal() {
        Colegio c = new Colegio();
        for (int i = 0; i < 50; i++) {
            c.registrarProfesor(crearProfesor("Profesor", "P" + i, 10000, 10));
        }
        c.registrarProfesor(crearProfesor("Sobrante", "P50", 10000, 10));
        assertEquals(50, c.getTotalProfesores());
    }
 
    @Test
    public void testRegistrarProfesores_NoAfectaElTotalDeEstudiantes() {
        Colegio c = new Colegio();
        c.registrarProfesor(crearProfesor("Carlos Perez", "123456789", 10000, 100));
        assertEquals(0, c.getTotalEstudiantes());
    }
 
    // ---------- Reporte de estudiantes ----------
    @Test
    public void testReporteEstudiantes_SinEstudiantes_SoloEncabezado() {
        Colegio c = new Colegio();
        assertEquals(ENCABEZADO_ESTUDIANTES, c.reporteEstudiantes());
    }
 
    @Test
    public void testReporteEstudiantes_UnEstudiante_FormatoCompleto() {
        Colegio c = new Colegio();
        c.registrarEstudiante(crearEstudiante("Ana Torres", "20240001", "10A"));
        String esperado = ENCABEZADO_ESTUDIANTES
                + "1. Ana Torres | Codigo: 20240001 | Grado: 10A | Telefono: 3109876543"
                + " | Direccion: Carrera 5 #8-12 | Nacimiento: 15/3/2010\n";
        assertEquals(esperado, c.reporteEstudiantes());
    }
 
    @Test
    public void testReporteEstudiantes_VariosEstudiantes_NumeradosYEnOrdenDeRegistro() {
        Colegio c = new Colegio();
        c.registrarEstudiante(crearEstudiante("Ana Torres", "20240001", "10A"));
        c.registrarEstudiante(crearEstudiante("Luis Mora", "20240002", "10B"));
        String reporte = c.reporteEstudiantes();
        int posAna = reporte.indexOf("1. Ana Torres");
        int posLuis = reporte.indexOf("2. Luis Mora");
        assertTrue(posAna >= 0);
        assertTrue(posLuis > posAna);
    }
 
    @Test
    public void testReporteEstudiantes_NoIncluyeEspaciosSinRegistrar() {
        Colegio c = new Colegio();
        c.registrarEstudiante(crearEstudiante("Ana Torres", "20240001", "10A"));
        assertFalse(c.reporteEstudiantes().contains("2. "));
    }
 
    // ---------- Reporte de profesores por salario ----------
    @Test
    public void testReporteProfesores_SinProfesores_SoloEncabezado() {
        Colegio c = new Colegio();
        assertEquals(ENCABEZADO_PROFESORES, c.reporteProfesoresPorSalario());
    }
 
    @Test
    public void testReporteProfesores_UnProfesor_IncluyeSusDatos() {
        Colegio c = new Colegio();
        Profesor p = crearProfesor("Carlos Perez", "123456789", 10000, 100);
        c.registrarProfesor(p);
        String reporte = c.reporteProfesoresPorSalario();
        assertTrue(reporte.startsWith(ENCABEZADO_PROFESORES));
        assertTrue(reporte.contains("1. Carlos Perez | Cedula: 123456789 | Area: Matematicas"));
        assertTrue(reporte.contains("Pago total: " + p.calcularPago()));
        assertTrue(reporte.contains("Prestaciones: " + p.calcularPrestaciones()));
    }
 
    @Test
    public void testReporteProfesores_OrdenaDeMayorAMenorPago() {
        Colegio c = new Colegio();
        c.registrarProfesor(crearProfesor("Bajo Salario", "111", 5000, 10));
        c.registrarProfesor(crearProfesor("Alto Salario", "222", 20000, 100));
        c.registrarProfesor(crearProfesor("Medio Salario", "333", 10000, 50));
        String reporte = c.reporteProfesoresPorSalario();
        int posAlto = reporte.indexOf("1. Alto Salario");
        int posMedio = reporte.indexOf("2. Medio Salario");
        int posBajo = reporte.indexOf("3. Bajo Salario");
        assertTrue(posAlto >= 0);
        assertTrue(posMedio > posAlto);
        assertTrue(posBajo > posMedio);
    }
 
    @Test
    public void testReporteProfesores_ElOrdenSeBasaEnElPagoTotal_NoSoloEnElSalarioPorHora() {
        // Mayor salario por hora pero muy pocas horas: su pago total es menor
        Colegio c = new Colegio();
        c.registrarProfesor(crearProfesor("Pocas Horas", "111", 50000, 1));
        c.registrarProfesor(crearProfesor("Muchas Horas", "222", 10000, 100));
        String reporte = c.reporteProfesoresPorSalario();
        assertTrue(reporte.indexOf("1. Muchas Horas") >= 0);
        assertTrue(reporte.indexOf("2. Pocas Horas") > reporte.indexOf("1. Muchas Horas"));
    }
 
    @Test
    public void testReporteProfesores_ConPagoIgual_ConservaElOrdenDeRegistro() {
        Colegio c = new Colegio();
        c.registrarProfesor(crearProfesor("Primero", "111", 10000, 100));
        c.registrarProfesor(crearProfesor("Segundo", "222", 10000, 100));
        String reporte = c.reporteProfesoresPorSalario();
        assertTrue(reporte.indexOf("1. Primero") >= 0);
        assertTrue(reporte.indexOf("2. Segundo") > reporte.indexOf("1. Primero"));
    }
 
    @Test
    public void testReporteProfesores_NoCambiaElOrdenOriginalDelColegio() {
        Colegio c = new Colegio();
        Profesor bajo = crearProfesor("Bajo Salario", "111", 5000, 10);
        Profesor alto = crearProfesor("Alto Salario", "222", 20000, 100);
        c.registrarProfesor(bajo);
        c.registrarProfesor(alto);
        c.reporteProfesoresPorSalario();
        assertSame(bajo, c.getProfesores()[0]);
        assertSame(alto, c.getProfesores()[1]);
    }
 
    // ---------- Setters ----------
    @Test
    public void testSetTotalEstudiantes_Base() {
        Colegio c = new Colegio();
        c.setTotalEstudiantes(5);
        assertEquals(5, c.getTotalEstudiantes());
    }
 
    @Test
    public void testSetTotalProfesores_Base() {
        Colegio c = new Colegio();
        c.setTotalProfesores(3);
        assertEquals(3, c.getTotalProfesores());
    }
 
    @Test
    public void testSetEstudiantes_ReemplazaElArreglo() {
        Colegio c = new Colegio();
        Estudiante[] nuevo = new Estudiante[10];
        c.setEstudiantes(nuevo);
        assertSame(nuevo, c.getEstudiantes());
    }
 
    @Test
    public void testSetProfesores_ReemplazaElArreglo() {
        Colegio c = new Colegio();
        Profesor[] nuevo = new Profesor[10];
        c.setProfesores(nuevo);
        assertSame(nuevo, c.getProfesores());
    }
}

