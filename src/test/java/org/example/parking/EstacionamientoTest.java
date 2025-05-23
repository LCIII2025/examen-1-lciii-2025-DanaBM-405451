package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        Cliente persona = new Cliente("11122233", "Nico Robin");
        Vehiculo vehi = new Vehiculo("456zxc", "march", Vehiculo.Tipo.AUTO);
        LocalDateTime entrada = LocalDateTime.MIN;
        LocalDateTime salida = LocalDateTime.MAX;



        Ticket tick = new Ticket(persona, vehi);

        assertEquals("Se encontro vehiculo",vehi.getPatente());

         /*La verdad profe ni idea de como se hacen los test...
         No entiendo porque no me pasa....
        osea creo q lo inicie pero no estoy segura de como testear*/


    }





    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
        Cliente persona2 = new Cliente("11122233","Nico Robin");
        Vehiculo vehi2 = new Vehiculo("456zxc","march", Vehiculo.Tipo.AUTO);
        LocalDateTime entrada2 = LocalDateTime.MIN;
        LocalDateTime salida2 = LocalDateTime.MAX;



       /*Aqui lo mismo...
       Aunque este me paso y estoy segura que asi no era
       se que debo usar assert pero hasta ahi*/

    }

}