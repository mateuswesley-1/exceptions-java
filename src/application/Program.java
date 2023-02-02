package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;


public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int roomNumber;
        LocalDate checkIn;
        LocalDate checkOut;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("\nRoom Number: ");
            roomNumber = scan.nextInt();

            System.out.print("\nCheck-in date: ");
            checkIn = LocalDate.parse(scan.next(), fmt);

            System.out.print("\nCheck-out date: ");
            checkOut = LocalDate.parse(scan.next(), fmt);

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation.toString());
        }

        catch (DateTimeParseException e){
            System.out.println("Erro na reserva! " + e.getMessage());
        }

        catch(DomainExceptions e){
            System.out.println("\nErro na reserva! " + e.getMessage());
        }

        scan.close();
    }
}
