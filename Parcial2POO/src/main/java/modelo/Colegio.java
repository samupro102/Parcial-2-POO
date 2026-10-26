/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Windows 11
 */
public class Colegio {
    private String nombre;
    private Estudiante[] estudiantes = new Estudiante[50];
    private Profesor[] profesores = new Profesor[50];
    private int totalEstudiantes = 0;
    private int totalProfesores = 0;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Profesor[] getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesor[] profesores) {
        this.profesores = profesores;
    }
        public int getTotalEstudiantes() {
        return totalEstudiantes;
    }

    public void setTotalEstudiantes(int totalEstudiantes) {
        this.totalEstudiantes = totalEstudiantes;
    }

    public int getTotalProfesores() {
        return totalProfesores;
    }

    public void setTotalProfesores(int totalProfesores) {
        this.totalProfesores = totalProfesores;
    }
    public boolean registrarEstudiante(Estudiante e) {
        if (totalEstudiantes < estudiantes.length) {
            estudiantes[totalEstudiantes] = e;
            totalEstudiantes++;
            return true;
        }
        return false;
    }
    public boolean registrarProfesor(Profesor p) {
        if (totalProfesores < profesores.length) {
            profesores[totalProfesores] = p;
            totalProfesores++;
            return true;
        }
        return false;
    }
    public String reporteEstudiantes() {
        String reporte = "LISTA DE ESTUDIANTES\n";
        reporte += "----------------------------------------\n";
        for (int i = 0; i < totalEstudiantes; i++) {
            Estudiante e = estudiantes[i];
            reporte += (i + 1) + ". " + e.getNombre()
                    + " | Codigo: " + e.getCodigo()
                    + " | Grado: " + e.getGrado()
                    + " | Telefono: " + e.getTelefono()
                    + " | Direccion: " + e.getDireccion()
                    + " | Nacimiento: " + e.getFechaNacimiento() + "\n";
        }
        return reporte;
    }
    public String reporteProfesoresPorSalario() {
        Profesor[] ordenados = new Profesor[totalProfesores];
        for (int i = 0; i < totalProfesores; i++) {
            ordenados[i] = profesores[i];
        }

        for (int i = 0; i < ordenados.length - 1; i++) {
            for (int j = 0; j < ordenados.length - 1 - i; j++) {
                if (ordenados[j].calcularPago() < ordenados[j + 1].calcularPago()) {
                    Profesor temporal = ordenados[j];
                    ordenados[j] = ordenados[j + 1];
                    ordenados[j + 1] = temporal;
                }
            }
        }

        String reporte = "PROFESORES POR SALARIO TOTAL (MAYOR A MENOR)\n";
        reporte += "----------------------------------------\n";
        for (int i = 0; i < ordenados.length; i++) {
            Profesor p = ordenados[i];
            reporte += (i + 1) + ". " + p.getNombre()
                    + " | Cedula: " + p.getCedula()
                    + " | Area: " + p.getArea()
                    + " | Pago total: " + p.calcularPago()
                    + " | Prestaciones: " + p.calcularPrestaciones() + "\n";
        }
        return reporte;
    } 
}
