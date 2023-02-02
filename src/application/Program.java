package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.Reservation;


public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate checkIn = LocalDate.parse("15/12/2012", fmt);
        LocalDate checkOut = LocalDate.parse("19/12/2012", fmt);

        Reservation reservation = new Reservation(10, checkIn, checkOut);

        System.out.println(reservation.toString());
    }




}
