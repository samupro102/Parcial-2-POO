/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcial2poo;
import controlador.Controlador;
import modelo.Colegio;
import vista.VentanaPrincipal;
/**
 *
 * @author Windows 11
 */
public class Parcial2POO {

    public static void main(String[] args) {
         Colegio colegio = new Colegio();

        Controlador controlador = new Controlador();
        controlador.setColegio(colegio);

        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setControlador(controlador);
        ventana.setVisible(true);
    }    
}

