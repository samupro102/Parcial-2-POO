/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Windows 11
 */
public class Profesor extends Persona{
    private String cedula;
    private String area;
    private double salarioHora;
    private int horasDictadas;
    
    public Profesor(String nombre, String direccion, String telefono,
            Fecha fechaNacimiento, String cedula, String area,
            double salarioHora, int horasDictadas) {
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
        this.cedula = cedula;
        this.area = area;
        this.salarioHora = salarioHora;
        this.horasDictadas = horasDictadas;
    }
}
