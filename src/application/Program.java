package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("rom number: ");
            int number = sc.nextInt();
            System.out.print("check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(number, checkIn, checkOut);
            System.out.println("Reserva" + reserva);

            System.out.println();
            System.out.println("Entre com a data atualizada da reserva:");
            System.out.println("check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.updateDates(checkIn, checkOut);
            System.out.println("Reserva" + reserva);
        } catch (ParseException e) {
            System.out.println("formato de data invalida");
        } catch (DomainException e) {
            System.out.println("erro na reserva" + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("erro inesperado");
        }

        sc.close();
    }

}
