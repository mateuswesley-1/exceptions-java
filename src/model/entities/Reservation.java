package model.entities;

import java.time.LocalDate;
import java.time.Period;

import model.exceptions.DomainExceptions;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {

        if(checkIn.isAfter(checkOut)){
            throw new DomainExceptions("A data de check in deve ser menor que a de check out");
        }

        if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())){
            throw new DomainExceptions("A reserva deve ser feita para uma data futura!!");
        }

        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long duration(){
        Period duration = Period.between(checkIn, checkOut);
        
        long days = duration.getDays()
        + duration.getYears()*365
        + duration.getMonths()*30;

        return days;
    }

    @Override
    public String toString(){

        StringBuilder msg = new StringBuilder();
        msg.append("\nQuarto reservado: " + roomNumber);
        msg.append("\nCheck-in: " + checkIn);
        msg.append("\nCheck-out: " + checkOut);
        msg.append("\nDias hospedados: " + duration());

        return msg.toString();
    }
}
