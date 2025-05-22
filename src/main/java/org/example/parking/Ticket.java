package org.example.parking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
public class Ticket {
    private final Cliente cliente;
    private final Vehiculo vehiculo;
    private final LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Ticket(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
    }

    public void marcarSalida() {
        Random random = new Random();
        this.horaSalida = LocalDateTime.now().plusMinutes(random.nextInt(200)+1);
    }

    public long calcularMinutos() {
        return Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    public double calcularPrecio() {
        // TODO implementar el metodo para calcular el importe a abonar segun el tipo de vehiculo
        // AUTO -> 100, SUV -> 130, PICKUP -> 180
        // el importe es por hora redondeando el tiempo hacia arriba,
        // por ejemplo si estuvo 45 minutos se le tarifa por 60, si estuvo 80 minutos se le tarifa por 120 minutos, etc...
        // retornar el importe final

//Esto es 100 % fe que el switch funciona y sobretodo qu emi super metodo de precio funciona bien :)

        double tarifaxHora = 0;
        switch (this.vehiculo.getTipo()){
            case AUTO -> tarifaxHora= 100.00;

            case SUV -> tarifaxHora=130.00;

            case PICKUP -> tarifaxHora=180.00;

            default -> System.out.println("No se encontro el tipo de vehiculo");
        }
        long tiempoEstacionado = calcularMinutos();

        double tiempoExacto = (double) tiempoEstacionado/60.00;

        double tarifaPagar = Math.ceil(tiempoExacto);

        if (tiempoEstacionado==0){
            return 0.0;
        } else if (tarifaPagar == 0 && tiempoEstacionado >0) {
            tarifaPagar =1;

        } else if (tiempoEstacionado > 1) {
            tarifaPagar =2;

        }

        double tarifaFinal = tarifaPagar * tarifaxHora;

        return tarifaFinal;
    }

}