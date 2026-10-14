/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Colegio;
import modelo.Estudiante;
import modelo.Fecha;
import modelo.Profesor;
/**
 *
 * @author Windows 11
 */
public class Controlador {
     private Colegio colegio;
    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public boolean registrarEstudiante(String nombre, String direccion,
            String telefono, int dia, int mes, int anio,
            String codigo, String grado) {
        Fecha f = new Fecha();
        f.setDia(dia);
        f.setMes(mes);
        f.setAnio(anio);

        Estudiante e = new Estudiante();
        e.setNombre(nombre);
        e.setDireccion(direccion);
        e.setTelefono(telefono);
        e.setFechaNacimiento(f);
        e.setCodigo(codigo);
        e.setGrado(grado);

        return colegio.registrarEstudiante(e);
    }
public boolean registrarProfesor(String nombre, String direccion,
            String telefono, int dia, int mes, int anio,
            String cedula, String area, double salarioHora, int horasDictadas) {
        Fecha f = new Fecha();
        f.setDia(dia);
        f.setMes(mes);
        f.setAnio(anio);

        Profesor p = new Profesor(nombre, direccion, telefono, f,
                cedula, area, salarioHora, horasDictadas);

        return colegio.registrarProfesor(p);
}




}