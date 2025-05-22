package org.example.parking;

import java.util.*;

public class Estacionamiento {
    private final int capacidadMaxima = 50;
    private final Map<String, Ticket> vehiculosEstacionados = new HashMap<>();
    private final Map<String, Cliente> clientesRegistrados = new HashMap<>();

    public boolean ingresarVehiculo(String dni, String nombre, Vehiculo vehiculo) {
        // TODO implementar la logica para registrar el ingreso de un nuevo vehiculo en el parking
        // la capacidad maxima del estacionamiento es de 50 vehiculos, si supera esta capacidad retornar FALSE
        // validar que no exista otro vehiculo con la misma patente, es un caso de error, retornar FALSE
        // validar si existe el cliente registrado, agregar el nuevo vehiculo en la lista del cliente existente, caso contrario crear un nuevo registro
        // si el proceso es exitoso retornar TRUE

        Cliente cliente = new Cliente(dni, nombre);

        Ticket ticket = new Ticket(cliente, vehiculo);
        vehiculosEstacionados.put(vehiculo.getPatente(),ticket);

        if(vehiculosEstacionados.size()>= capacidadMaxima){
            System.out.println("Estacionamiento lleno");
            System.out.println("No se puede ingresar mas VEHICULO");
            System.out.println("Intente mas tarde o espere a que se desocupe un lugar");
            return false;
        } else if (vehiculosEstacionados.equals(vehiculo.getPatente())) {
            /*else if (vehiculosEstacionados.equals(vehiculo.getPatente())) o
            vehiculosEstacionados.containsKey(vehiculo.getPatente()))
            Pruebo uno sino funca el otro... segun yo debria dar lo mismo, la unica diferencia es que uno es mas
            eficiente para cuando se trata de map que el otro... si es que no me equivopo, ante la duda
            ambos codigos guiño guiño eso y porque me aparecio primero, debe ser una señal
            */
            System.out.println("El VEHICULO con la patente: " + vehiculo.getPatente() + " ya se encuntra registrado");
            return false;
        } else if (clientesRegistrados == null) {
            cliente = new Cliente(dni, nombre);
            cliente.agregarVehiculo(vehiculo);

            System.out.println("Gracias por registrarte");
            System.out.println("Nombre " + cliente.getNombre());

        } else {
            System.out.println("El cliente ya esta registrado");
            cliente.agregarVehiculo(vehiculo);
            System.out.println("El vehiculo: " + vehiculo.getModelo() + " Con la patente: " + vehiculo.getPatente());
            System.out.println("Fue registrado con exito al cliente: " + cliente.getNombre());

        }


        return true;
    }

    public Ticket retirarVehiculo(String patente) throws Exception {
        // TODO implementar la lógica para retirar un vehiculo del parking
        // validar que exista la patente, caso contrario arrojar la exception "Vehiculo no encontrado"
        // calcular y retornar el ticket del vehiculoEstacionado (ver Ticket.marcarSalida())

        Ticket ticket = vehiculosEstacionados.get(patente);
        if (ticket==null){
            throw new Exception("No se enontro el vehiculo");
            //System.out.println();
        } else {
            ticket.marcarSalida();
            double costo = ticket.calcularPrecio();
            System.out.println("Vehiculo retirado " + ticket.getVehiculo());
            System.out.println("El tiempo que permanecio fue " + ticket.calcularMinutos() + " minutos");
            System.out.println("El costo es " + ticket.calcularPrecio());
        }



        return ticket;
    }

    public List<Ticket> listarVehiculosEstacionados() {
        return new ArrayList<>(vehiculosEstacionados.values());
    }
}
