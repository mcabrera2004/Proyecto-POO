package net.javaguides;
import java.util.ArrayList;

class Reserva {
    private int numeroReserva;
    private Paquete paquete;
    private ArrayList<Cliente> clientes;
    private int cantidadPersonas;
    private String fechaViaje;

    public Reserva(int numeroReserva, Paquete paquete, ArrayList<Cliente> clientes, int cantidadPersonas, String fechaViaje) {
        this.numeroReserva = numeroReserva;
        this.paquete = paquete;
        this.clientes = clientes;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaViaje = fechaViaje;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void imprimirFactura() {
        System.out.println();
        System.out.println("-".repeat(90));
        // Para centrar el título se utiliza un formateo básico.
        String titulo = "Agencia de Viajes 'Destinos Splinter'";
        int padding = (90 - titulo.length()) / 2;
        System.out.println(" ".repeat(padding) + titulo);
        System.out.println();
        System.out.printf("Numero de reserva: %08d\n\n", numeroReserva);
        System.out.printf("%-30s %60s\n", "Destino: " + paquete.getDestino(), "Fecha del viaje: " + fechaViaje);
        System.out.printf("%-50s %40s\n", "Aerolinea: " + paquete.getAerolinea(), "Dias: " + paquete.getDias());
        System.out.printf("%-50s %40s\n", "Hotel: " + paquete.getHotel(), "Precio por persona: " + paquete.getPrecio() + "$");
        System.out.printf("%-50s %40s\n", "Cantidad de personas: " + cantidadPersonas, "Total: " + (paquete.getPrecio() * cantidadPersonas) + "$");
        System.out.println();
        System.out.println("Pasajeros:");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println("Pasajero " + (i + 1) + ": " + cliente.getNombre() + ", DNI: " + cliente.getDni());
        }
        System.out.println("-".repeat(90));
    }
}
