package net.javaguides;
class Paquete {
    private String destino;
    private int dias;
    private String aerolinea;
    private String hotel;
    private int precio;
    private int disponibilidad;
    private int id;

    public Paquete(String destino, int dias, String aerolinea, String hotel, int precio, int disponibilidad, int id) {
        this.destino = destino;
        this.dias = dias;
        this.aerolinea = aerolinea;
        this.hotel = hotel;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public int getDias() {
        return dias;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getHotel() {
        return hotel;
    }

    public int getPrecio() {
        return precio;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public int getId() {
        return id;
    }

    public void reduceDisponibilidad(int cantidad) {
        this.disponibilidad -= cantidad;
    }

    @Override
    public String toString() {
        // Se formatea la salida similar al Python original.
        return String.format("%-18s %-5d %-25s %-28s %-8d %-16d %-2d",
                destino, dias, aerolinea, hotel, precio, disponibilidad, id);
    }
}

