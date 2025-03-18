package net.javaguides;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelAgency {
    private ArrayList<Paquete> paquetes;
    private ArrayList<Reserva> reservas;
    private int identificador; // Para asignar ID a los paquetes nuevos

    public TravelAgency() {
        paquetes = new ArrayList<>();
        reservas = new ArrayList<>();
        identificador = 22;

        // Paquetes hardcodeados (matriz de paquetes)
        paquetes.add(new Paquete("Barcelona", 6, "Iberia", "Hotel NH Barcelona", 1450, 12, 1));
        paquetes.add(new Paquete("Berlin", 6, "Lufthansa", "Berlin Plaza Hotel", 1500, 10, 2));
        paquetes.add(new Paquete("Berlin", 8, "Delta Airlines", "Berlin Central Hotel", 1600, 8, 3));
        paquetes.add(new Paquete("Ciudad de Mexico", 9, "Aeromexico", "Hotel CDMX", 1350, 4, 4));
        paquetes.add(new Paquete("Londres", 4, "British Airways", "The London Inn", 1500, 5, 5));
        paquetes.add(new Paquete("Londres", 5, "Aerolineas Argentinas", "The London Inn", 1550, 8, 6));
        paquetes.add(new Paquete("Londres", 5, "British Airways", "The London Inn", 1450, 2, 7));
        paquetes.add(new Paquete("Londres", 6, "Lufthansa", "The London Inn", 1600, 2, 8));
        paquetes.add(new Paquete("Madrid", 7, "Iberia", "Hotel Madrid Centro", 1550, 9, 9));
        paquetes.add(new Paquete("Madrid", 5, "Air Europa", "Hotel Madrid Centro", 1500, 3, 10));
        paquetes.add(new Paquete("Nueva Delhi", 8, "British Airways", "Delhi Palace Hotel", 2100, 10, 11));
        paquetes.add(new Paquete("Nueva York", 10, "Aerolineas Splinter", "NYC Plaza", 1800, 8, 12));
        paquetes.add(new Paquete("Nueva York", 12, "Delta Airlines", "NYC Plaza", 1900, 12, 13));
        paquetes.add(new Paquete("Nueva York", 8, "Delta Airlines", "The Central Park North", 1600, 2, 14));
        paquetes.add(new Paquete("Rio de Janeiro", 7, "LATAM Airlines", "Hotel Atlantico Copacabana", 1050, 10, 15));
        paquetes.add(new Paquete("Rio de Janeiro", 5, "Aerolinas Argentinas", "Hotel Atlantico Copacabana", 900, 5, 16));
        paquetes.add(new Paquete("Rio de Janeiro", 10, "LATAM Airlines", "Hotel Atlantico Copacabana", 1250, 20, 17));
        paquetes.add(new Paquete("Seul", 5, "Delta Airlines", "Seoul Central Hotel", 1450, 15, 18));
        paquetes.add(new Paquete("Sidney", 8, "Delta Airlines", "Sydney Harbour Hotel", 2200, 4, 19));
        paquetes.add(new Paquete("Tokyo", 7, "Delta Airlines", "Tokyo Grand Hotel", 2000, 5, 20));
        paquetes.add(new Paquete("Paris", 7, "Air France", "Hotel Parisien", 1700, 8, 21));
        paquetes.add(new Paquete("Paris", 5, "Air France", "Hotel Parisien", 1400, 9, 22));
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n1. Agregar paquete");
            System.out.println("2. Busqueda y reserva de paquete");
            System.out.println("3. Mostrar todos los paquetes disponibles");
            System.out.println("4. Mostrar reservas");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opcion: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida. Por favor, intente nuevamente.");
                continue;
            }
            System.out.println("");

            switch (opcion) {
                case 1:
                    agregarPaquete(sc);
                    break;
                case 2:
                    buscarYReservarPaquete(sc);
                    break;
                case 3:
                    mostrarPaquetes(paquetes);
                    break;
                case 4:
                    mostrarReservas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, intente nuevamente.");
            }
        }
        sc.close();
    }

    private void agregarPaquete(Scanner sc) {
        System.out.print("Ingrese el destino: ");
        String destino = sc.nextLine();
        System.out.print("Ingrese la cantidad de dias: ");
        int dias = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese la aerolinea: ");
        String aerolinea = sc.nextLine();
        System.out.print("Ingrese el nombre del hotel: ");
        String hotel = sc.nextLine();
        System.out.print("Ingrese el precio: ");
        int precio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese cuanta disponibilidad hay para el paquete: ");
        int disponibilidad = Integer.parseInt(sc.nextLine());
        identificador++;
        paquetes.add(new Paquete(destino, dias, aerolinea, hotel, precio, disponibilidad, identificador));
        System.out.println("Paquete agregado con exito.");
    }

    private void mostrarPaquetes(List<Paquete> listaPaquetes) {
        if (listaPaquetes.isEmpty()) {
            System.out.println("No se encontraron paquetes disponibles.");
        } else {
            System.out.println("\nPaquetes disponibles:\n");
            System.out.printf("%-18s | %-5s | %-25s | %-28s | %-8s | %-16s | %-2s\n",
                    "Destino", "Dias", "Aerolinea", "Hotel", "Precio", "Disponibilidad", "ID");
            System.out.println("-".repeat(120));
            for (Paquete p : listaPaquetes) {
                System.out.println(p.toString());
            }
        }
    }

    private void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas realizadas.");
        } else {
            System.out.println("Reservas realizadas:\n");
            System.out.println("-".repeat(50));
            for (Reserva r : reservas) {
                System.out.println("Numero de reserva: " + r.getNumeroReserva());
                System.out.println("Destino: " + r.getPaquete().getDestino());
                System.out.println("Fecha del viaje: " + r.getFechaViaje());
                System.out.println("Cantidad de pasajeros: " + r.getCantidadPersonas());
                System.out.println("Clientes:");
                for (Cliente c : r.getClientes()) {
                    System.out.println("  Nombre: " + c.getNombre() + ", DNI: " + c.getDni());
                }
                System.out.println("-".repeat(50));
            }
        }
    }

    private void buscarYReservarPaquete(Scanner sc) {
        System.out.print("¿Cuantas personas van a viajar? (Hasta 30 personas): ");
        int cantidadPersonas = Integer.parseInt(sc.nextLine());
        while (cantidadPersonas <= 0 || cantidadPersonas > 30) {
            System.out.println("Numero de personas no valido, ingrese de nuevo.");
            System.out.print("¿Cuantas personas van a viajar?: ");
            cantidadPersonas = Integer.parseInt(sc.nextLine());
        }
        // Filtrar paquetes que tengan disponibilidad suficiente.
        List<Paquete> paquetesBuscados = new ArrayList<>();
        for (Paquete p : paquetes) {
            if (p.getDisponibilidad() >= cantidadPersonas) {
                paquetesBuscados.add(p);
            }
        }
        if (paquetesBuscados.isEmpty()) {
            System.out.println("No hay paquetes disponibles con una disponibilidad para " + cantidadPersonas + " personas.");
            return;
        } else {
            // Inicio de la búsqueda por criterios.
            paquetesBuscados = filtrarPaquetesPorCriterio(sc, paquetesBuscados);
        }
        // Mientras hayan varios paquetes se solicita refinar la búsqueda.
        while (paquetesBuscados.size() > 1) {
            System.out.println("\nAun hay varios paquetes disponibles. Refine su busqueda");
            paquetesBuscados = filtrarPaquetesPorCriterio(sc, paquetesBuscados);
        }
        if (paquetesBuscados.size() == 1) {
            System.out.println("\n--- Reserva de Paquete ---");
            System.out.print("¿Desea reservar este paquete? (si/no): ");
            String reservar = sc.nextLine();
            if (reservar.equalsIgnoreCase("si")) {
                LocalDate currentDate = LocalDate.now();
                boolean fechaInvalida;
                int viajeAnio = 0, viajeMes = 0, viajeDia = 0;
                String fechaViajeInput;
                do {
                    System.out.print("Ingrese la fecha del viaje (yyyy-mm-dd): ");
                    fechaViajeInput = sc.nextLine();
                    String[] parts = fechaViajeInput.split("-");
                    try {
                        viajeAnio = Integer.parseInt(parts[0]);
                        viajeMes = Integer.parseInt(parts[1]);
                        viajeDia = Integer.parseInt(parts[2]);
                    } catch (Exception e) {
                        System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
                        fechaInvalida = true;
                        continue;
                    }
                    fechaInvalida = Utils.fechaInvalida(viajeAnio, viajeMes, viajeDia, currentDate);
                } while (fechaInvalida);
                // Convertir la fecha a un formato con palabras.
                String fechaViaje = Utils.numeroAPalabras(viajeDia) + " de " + Utils.nombresMeses[viajeMes - 1] + " de " + viajeAnio;
                ArrayList<Cliente> clientes = new ArrayList<>();
                for (int i = 0; i < cantidadPersonas; i++) {
                    System.out.println("Cliente " + (i + 1) + ":");
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese el DNI del cliente: ");
                    int dni = Integer.parseInt(sc.nextLine());
                    clientes.add(new Cliente(nombre, dni));
                }
                int numeroReserva = reservas.size() + 1;
                Reserva reserva = new Reserva(numeroReserva, paquetesBuscados.get(0), clientes, cantidadPersonas, fechaViaje);
                reservas.add(reserva);
                System.out.println("Paquete reservado con exito. Generando factura...");
                reserva.imprimirFactura();
                // Actualizar la disponibilidad del paquete.
                paquetesBuscados.get(0).reduceDisponibilidad(cantidadPersonas);
            } else {
                System.out.println("No se realizo la reserva.");
            }
        }
    }

    private List<Paquete> filtrarPaquetesPorCriterio(Scanner sc, List<Paquete> lista) {
        System.out.println("Seleccione el criterio de busqueda: ");
        System.out.println("1. Por destino");
        System.out.println("2. Por dias");
        System.out.println("3. Por precio");
        System.out.println("4. Por hotel");
        System.out.println("5. Por aerolinea");
        System.out.println("6. Por ID");
        System.out.print("Ingrese el numero de criterio de busqueda: ");
        String criterio = sc.nextLine();
        System.out.print("Ingrese el valor a buscar: ");
        String valor = sc.nextLine();

        List<Paquete> resultado = new ArrayList<>();
        switch (criterio) {
            case "1": // destino
                for (Paquete p : lista) {
                    if (p.getDestino().equalsIgnoreCase(valor)) {
                        resultado.add(p);
                    }
                }
                break;
            case "2": // dias
                try {
                    int dias = Integer.parseInt(valor);
                    for (Paquete p : lista) {
                        if (p.getDias() == dias) {
                            resultado.add(p);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido para dias.");
                }
                break;
            case "3": // precio
                try {
                    int precio = Integer.parseInt(valor);
                    for (Paquete p : lista) {
                        if (p.getPrecio() <= precio) {
                            resultado.add(p);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido para precio.");
                }
                break;
            case "4": // hotel
                for (Paquete p : lista) {
                    if (p.getHotel().equalsIgnoreCase(valor)) {
                        resultado.add(p);
                    }
                }
                break;
            case "5": // aerolinea
                for (Paquete p : lista) {
                    if (p.getAerolinea().equalsIgnoreCase(valor)) {
                        resultado.add(p);
                    }
                }
                break;
            case "6": // ID
                try {
                    int id = Integer.parseInt(valor);
                    for (Paquete p : lista) {
                        if (p.getId() == id) {
                            resultado.add(p);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Valor invalido para ID.");
                }
                break;
            default:
                System.out.println("Opcion no valida. Intente de nuevo.");
                resultado = lista;
        }
        mostrarPaquetes(resultado);
        return resultado;
    }

    public static void main(String[] args) {
        TravelAgency agency = new TravelAgency();
        agency.iniciar();
    }
}

