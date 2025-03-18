package net.javaguides;
import java.time.LocalDate;

class Utils {
    // Convierte un número a palabras (aplica para números menores de 100 tal como en el código Python)
    public static String numeroAPalabras(int numero) {
        String[] unidades = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] decenas = {"", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        String[] especiales = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve"};

        if (numero >= 0 && numero < 10) {
            return unidades[numero];
        } else if (numero >= 10 && numero < 20) {
            return especiales[numero - 10];
        } else if (numero >= 20 && numero < 100) {
            if (numero % 10 == 0) {
                return decenas[numero / 10];
            } else {
                return decenas[numero / 10] + " y " + unidades[numero % 10];
            }
        } else {
            return String.valueOf(numero);
        }
    }

    public static boolean esBisiesto(int anio) {
        return (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0));
    }

    // Valida la fecha de viaje. Devuelve true si la fecha es inválida (similar al comportamiento del código Python).
    public static boolean fechaInvalida(int viajeAnio, int viajeMes, int viajeDia, LocalDate currentDate) {
        if (viajeMes < 1 || viajeMes > 12) {
            System.out.println("Mes no valido. Por favor, intente nuevamente.");
            return true;
        }
        if (viajeDia < 1) {
            System.out.println("Dia no valido. Por favor, intente nuevamente.");
            return true;
        }
        if ((viajeMes == 4 || viajeMes == 6 || viajeMes == 9 || viajeMes == 11) && viajeDia > 30) {
            System.out.println("Dia no valido para el mes dado. Por favor, intente nuevamente.");
            return true;
        }
        if (viajeMes == 2) {
            if (esBisiesto(viajeAnio) && viajeDia > 29) {
                System.out.println("Dia no valido para febrero en un año bisiesto. Por favor, intente nuevamente.");
                return true;
            } else if (!esBisiesto(viajeAnio) && viajeDia > 28) {
                System.out.println("Dia no valido para febrero en un año no bisiesto. Por favor, intente nuevamente.");
                return true;
            }
        }
        if (viajeDia > 31) {
            System.out.println("Dia no valido. Por favor, intente nuevamente.");
            return true;
        }
        LocalDate viajeDate;
        try {
            viajeDate = LocalDate.of(viajeAnio, viajeMes, viajeDia);
        } catch (Exception e) {
            System.out.println("Fecha no valida. Por favor, intente nuevamente.");
            return true;
        }
        if (viajeDate.isBefore(currentDate)) {
            System.out.println("Fecha no valida. Por favor, intente nuevamente.");
            return true;
        }
        return false;
    }

    // Nombres de los meses en español.
    public static String[] nombresMeses = {
        "enero", "febrero", "marzo", "abril", "mayo", "junio",
        "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
    };
}

