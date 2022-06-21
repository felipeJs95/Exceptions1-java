package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reserva;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("rom number: ");
        int number = sc.nextInt();
        System.out.print("check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("erro na reserva: Check-out a data deve ser posterior a Check-in ");
        } else {
            Reserva reserva = new Reserva(number, checkIn, checkOut);
            System.out.println("Reserva" + reserva);

            System.out.println();
            System.out.println("Entre com a data atualizada da reserva:");
            System.out.println("check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String error = reserva.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("error na reserva" + error);
            } else {
                System.out.println("Reserva" + reserva);

            }

        }
        sc.close();
    }

}
