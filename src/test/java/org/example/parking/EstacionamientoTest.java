package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        Cliente persona = new Cliente("11122233", "Nico Robin")
        Vehiculo vehi = new Vehiculo("456zxc", "march", Vehiculo.Tipo.AUTO);
        LocalDateTime entrada = LocalDateTime.MIN;
        LocalDateTime salida = LocalDateTime.MAX;

        Ticket tick = new Ticket(persona, vehi, entrada, salida);
        assert true;
        assert tick.canEqual(persona);
        throw new Exception("");
        testRetirarVehiculo();

    }

        /*La verdad profe ni idea de como se hacen los test...
        osea creo q lo inicie pero no estoy segura de como testear*/

    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
        Cliente persona2 = new Cliente("11122233","Nico Robin")
        Vehiculo vehi2 = new Vehiculo("456zxc","march", Vehiculo.Tipo.AUTO);
        LocalDateTime entrada2 = LocalDateTime.MIN;
        LocalDateTime salida2 = LocalDateTime.MAX;

       testCalcularPrecio();
       //Aqui lo mismo.. se que debo usar assert pero hasta ahi

    }

}